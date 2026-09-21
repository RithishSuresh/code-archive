import java.util.*;

public class SpaceStationSystem {
    public static void main(String[] args) {
        CrewRank cadet = CrewRank.createCadet();
        CrewRank officer = CrewRank.createOfficer();
        SecurityClearance clearance1 = new SecurityClearance("C001","Level1", new String[]{"Hangar","Lab"}, System.currentTimeMillis()+10000000);
        SecurityClearance clearance2 = new SecurityClearance("C002","Level2", new String[]{"Hangar","Lab","Bridge"}, System.currentTimeMillis()+10000000);

        SpaceCrew crew1 = new SpaceCrew("SC001","Earth",cadet,6,120,clearance1);
        SpaceCrew crew2 = new SpaceCrew("SC002","Mars",officer,3,80,clearance2);

        CommandCrew commandCrew = new CommandCrew(Set.of("Command1","Command2"));
        PilotCrew pilotCrew = new PilotCrew(Set.of("Flight1","Flight2"));
        ScienceCrew scienceCrew = new ScienceCrew("Astrophysics");
        EngineerCrew engineerCrew = new EngineerCrew("Mechanical");

        SpaceStationRegistry.registerCrew(crew1);
        SpaceStationRegistry.registerCrew(crew2);
        SpaceStationRegistry.registerCrew(commandCrew);
        SpaceStationRegistry.registerCrew(pilotCrew);
        SpaceStationRegistry.registerCrew(scienceCrew);
        SpaceStationRegistry.registerCrew(engineerCrew);

        for(Object crew : SpaceStationRegistry.getCrewByType("SpaceCrew")) {
            SpaceCrew sc = (SpaceCrew)crew;
            System.out.println("ID: "+sc.getCrewIdentification()+", Access Hangar: "+sc.canAccessSection("Hangar")+", Can be promoted: "+sc.canBePromoted());
        }

        for(Object crew : SpaceStationRegistry.getCrewByType("CommandCrew")) {
            CommandCrew cc = (CommandCrew) crew;
            System.out.println("Type: "+cc.getClass().getSimpleName()+", Certifications: "+cc.getCommandCertifications());
        }

        for(Object crew : SpaceStationRegistry.getCrewByType("PilotCrew")) {
            PilotCrew pc = (PilotCrew) crew;
            System.out.println("Type: "+pc.getClass().getSimpleName()+", Certifications: "+pc.getFlightCertifications());
        }

        for(Object crew : SpaceStationRegistry.getCrewByType("ScienceCrew")) {
            ScienceCrew scn = (ScienceCrew) crew;
            System.out.println("Type: "+scn.getClass().getSimpleName()+", Specialty: "+scn.getResearchSpecialty());
        }

        for(Object crew : SpaceStationRegistry.getCrewByType("EngineerCrew")) {
            EngineerCrew ec = (EngineerCrew) crew;
            System.out.println("Type: "+ec.getClass().getSimpleName()+", Engineering Type: "+ec.getEngineeringType());
        }
    }

    public static final class SecurityClearance {
        private final String clearanceId;
        private final String level;
        private final String[] authorizedSections;
        private final long expirationDate;

        public SecurityClearance(String clearanceId, String level, String[] authorizedSections, long expirationDate) {
            if(clearanceId==null||level==null||authorizedSections==null) throw new IllegalArgumentException();
            this.clearanceId=clearanceId;
            this.level=level;
            this.authorizedSections=Arrays.copyOf(authorizedSections,authorizedSections.length);
            this.expirationDate=expirationDate;
        }

        public final boolean canAccess(String section) {
            for(String s:authorizedSections) if(s.equals(section)) return true;
            return false;
        }

        public final boolean isExpired() {
            return System.currentTimeMillis()>expirationDate;
        }

        public final int getAccessHash() {
            return Arrays.hashCode(authorizedSections)+clearanceId.hashCode()+level.hashCode();
        }

        public String getClearanceId(){return clearanceId;}
        public String getLevel(){return level;}
        public String[] getAuthorizedSections(){return Arrays.copyOf(authorizedSections,authorizedSections.length);}
        public long getExpirationDate(){return expirationDate;}
    }

    public static final class CrewRank {
        private final String rankName;
        private final int level;
        private final String[] permissions;

        private CrewRank(String rankName,int level,String[] permissions){
            this.rankName=rankName;
            this.level=level;
            this.permissions=Arrays.copyOf(permissions,permissions.length);
        }

        public static CrewRank createCadet(){return new CrewRank("Cadet",1,new String[]{"Basic Access"});}
        public static CrewRank createOfficer(){return new CrewRank("Officer",2,new String[]{"Basic Access","Operations"});}
        public static CrewRank createCommander(){return new CrewRank("Commander",3,new String[]{"Full Access"});}
        public static CrewRank createCaptain(){return new CrewRank("Captain",4,new String[]{"Full Access","Command"});}
        public static CrewRank createAdmiral(){return new CrewRank("Admiral",5,new String[]{"Full Access","Command","Strategic"});}

        public String getRankName(){return rankName;}
        public int getLevel(){return level;}
        public String[] getPermissions(){return Arrays.copyOf(permissions,permissions.length);}
    }

    public static class SpaceCrew {
        public static final String STATION_NAME="Stellar Odyssey";
        public static final int MAX_CREW_CAPACITY=50;

        private final String crewId;
        private final String homeplanet;
        private final SecurityClearance clearance;
        private final CrewRank initialRank;

        private CrewRank currentRank;
        private int missionCount;
        private double spaceHours;

        public SpaceCrew(String crewId,CrewRank initialRank){
            this(crewId,"Unknown",initialRank,0,0,null);
        }

        public SpaceCrew(String crewId,String homeplanet,CrewRank initialRank){
            this(crewId,homeplanet,initialRank,0,0,null);
        }

        public SpaceCrew(String crewId,String homeplanet,CrewRank initialRank,int missionCount,double spaceHours){
            this(crewId,homeplanet,initialRank,missionCount,spaceHours,null);
        }

        public SpaceCrew(String crewId,String homeplanet,CrewRank initialRank,int missionCount,double spaceHours,SecurityClearance clearance){
            this.crewId=crewId;
            this.homeplanet=homeplanet;
            this.initialRank=initialRank;
            this.currentRank=initialRank;
            this.missionCount=Math.max(0,missionCount);
            this.spaceHours=Math.max(0.0,spaceHours);
            this.clearance=clearance;
        }

        private final boolean validateClearanceLevel(){return clearance!=null&&!clearance.isExpired();}
        public final boolean canAccessSection(String section){return clearance!=null&&clearance.canAccess(section);}
        public final String getCrewIdentification(){return crewId+"-"+initialRank.getRankName();}
        public final boolean canBePromoted(){return missionCount>5&&currentRank.getLevel()<5;}
        public final int calculateSecurityRating(){return clearance==null?0:clearance.getAccessHash()+currentRank.getLevel();}
        public void incrementMissionCount(){missionCount++;}
        public void addSpaceHours(double hours){if(hours>0) spaceHours+=hours;}
        public CrewRank getCurrentRank(){return currentRank;}
        public void setCurrentRank(CrewRank currentRank){this.currentRank=currentRank;}
    }

    public static final class CommandCrew{
        private final Set<String> commandCertifications;
        public CommandCrew(Set<String> certifications){this.commandCertifications=Collections.unmodifiableSet(certifications);}
        public Set<String> getCommandCertifications(){return commandCertifications;}
    }

    public static final class PilotCrew{
        private final Set<String> flightCertifications;
        public PilotCrew(Set<String> certifications){this.flightCertifications=Collections.unmodifiableSet(certifications);}
        public Set<String> getFlightCertifications(){return flightCertifications;}
    }

    public static final class ScienceCrew{
        private final String researchSpecialty;
        public ScienceCrew(String specialty){this.researchSpecialty=specialty;}
        public String getResearchSpecialty(){return researchSpecialty;}
    }

    public static final class EngineerCrew{
        private final String engineeringType;
        public EngineerCrew(String type){this.engineeringType=type;}
        public String getEngineeringType(){return engineeringType;}
    }

    public static final class SpaceStationRegistry{
        private static final Map<String,Object> crewRegistry=new HashMap<>();
        public static boolean registerCrew(Object crew){
            if(crew==null) return false;
            String id="";
            if(crew instanceof SpaceCrew) {
                SpaceCrew sc = (SpaceCrew) crew;
                id = sc.getCrewIdentification();
            } else if(crew instanceof CommandCrew) {
                CommandCrew cc = (CommandCrew) crew;
                id = "Command-" + cc.hashCode();
            } else if(crew instanceof PilotCrew) {
                PilotCrew pc = (PilotCrew) crew;
                id = "Pilot-" + pc.hashCode();
            } else if(crew instanceof ScienceCrew) {
                ScienceCrew scn = (ScienceCrew) crew;
                id = "Science-" + scn.hashCode();
            } else if(crew instanceof EngineerCrew) {
                EngineerCrew ec = (EngineerCrew) crew;
                id = "Engineer-" + ec.hashCode();
            } else return false;
            crewRegistry.put(id,crew);
            return true;
        }
        public static List<Object> getCrewByType(String type){
            List<Object> result=new ArrayList<>();
            for(Object crew:crewRegistry.values())
                if(crew.getClass().getSimpleName().equalsIgnoreCase(type))
                    result.add(crew);
            return result;
        }
    }
}
