import java.time.LocalDate;
import java.util.*;

public class HospitalManagementSystem {
    public static void main(String[] args) {
        MedicalRecord record1 = new MedicalRecord("R001","DNA123", new String[]{"Peanuts"}, new String[]{"Flu"}, LocalDate.of(1990,5,20),"A+");
        MedicalRecord record2 = new MedicalRecord("R002","DNA456", new String[]{"Penicillin"}, new String[]{"Asthma"}, LocalDate.of(1985,3,15),"O-");

        Patient patient1 = new Patient("P001",record1,"Alice","Bob","InsuranceA",101,"Dr. Smith");
        Patient patient2 = new Patient("P002",record2,"John","Mary","InsuranceB",102,"Dr. Adams");

        Doctor doc = new Doctor("D001","Cardiology",Set.of("Cert1","Cert2"));
        Nurse nurse = new Nurse("N001","Night",List.of("Qual1","Qual2"));
        Administrator admin = new Administrator("A001",List.of("ViewAll","EditBasic"));

        HospitalSystem.admitPatient(patient1,doc);
        HospitalSystem.admitPatient(patient2,nurse);
        HospitalSystem.admitPatient(patient1,admin);

        System.out.println(patient1.getPublicInfo());
        System.out.println(patient2.getPublicInfo());

        System.out.println("Allergies:");
        System.out.println("Alice allergic to Peanuts: "+patient1.getMedicalRecord().isAllergicTo("Peanuts"));
        System.out.println("John allergic to Penicillin: "+patient2.getMedicalRecord().isAllergicTo("Penicillin"));
    }

    public static final class MedicalRecord {
        private final String recordId;
        private final String patientDNA;
        private final String[] allergies;
        private final String[] medicalHistory;
        private final LocalDate birthDate;
        private final String bloodType;

        public MedicalRecord(String recordId, String patientDNA, String[] allergies, String[] medicalHistory, LocalDate birthDate, String bloodType){
            if(recordId==null || patientDNA==null || allergies==null || medicalHistory==null || birthDate==null || bloodType==null)
                throw new IllegalArgumentException("Invalid medical record");
            this.recordId=recordId;
            this.patientDNA=patientDNA;
            this.allergies=Arrays.copyOf(allergies,allergies.length);
            this.medicalHistory=Arrays.copyOf(medicalHistory,medicalHistory.length);
            this.birthDate=birthDate;
            this.bloodType=bloodType;
        }

        public String getRecordId(){return recordId;}
        public String getPatientDNA(){return patientDNA;}
        public String[] getAllergies(){return Arrays.copyOf(allergies,allergies.length);}
        public String[] getMedicalHistory(){return Arrays.copyOf(medicalHistory,medicalHistory.length);}
        public LocalDate getBirthDate(){return birthDate;}
        public String getBloodType(){return bloodType;}

        public final boolean isAllergicTo(String substance){
            for(String s:allergies) if(s.equalsIgnoreCase(substance)) return true;
            return false;
        }

        public String toString(){
            return "RecordID:"+recordId+", BloodType:"+bloodType+", BirthDate:"+birthDate;
        }
    }

    public static class Patient {
        private final String patientId;
        private final MedicalRecord medicalRecord;
        private String currentName;
        private String emergencyContact;
        private String insuranceInfo;
        private int roomNumber;
        private String attendingPhysician;

        public Patient(String patientId, MedicalRecord medicalRecord, String currentName, String emergencyContact, String insuranceInfo, int roomNumber, String attendingPhysician){
            this.patientId=patientId;
            this.medicalRecord=medicalRecord;
            this.currentName=currentName;
            this.emergencyContact=emergencyContact;
            this.insuranceInfo=insuranceInfo;
            this.roomNumber=roomNumber;
            this.attendingPhysician=attendingPhysician;
        }

        String getBasicInfo(){
            return "ID:"+patientId+", Name:"+currentName+", Room:"+roomNumber;
        }

        public String getPublicInfo(){
            return "Name:"+currentName+", Room:"+roomNumber;
        }

        public String getCurrentName(){return currentName;}
        public void setCurrentName(String currentName){this.currentName=currentName;}
        public String getEmergencyContact(){return emergencyContact;}
        public void setEmergencyContact(String emergencyContact){this.emergencyContact=emergencyContact;}
        public String getInsuranceInfo(){return insuranceInfo;}
        public void setInsuranceInfo(String insuranceInfo){this.insuranceInfo=insuranceInfo;}
        public int getRoomNumber(){return roomNumber;}
        public void setRoomNumber(int roomNumber){this.roomNumber=roomNumber;}
        public String getAttendingPhysician(){return attendingPhysician;}
        public void setAttendingPhysician(String attendingPhysician){this.attendingPhysician=attendingPhysician;}
        public MedicalRecord getMedicalRecord(){return medicalRecord;}
    }

    public static final class Doctor {
        private final String licenseNumber;
        private final String specialty;
        private final Set<String> certifications;

        public Doctor(String licenseNumber, String specialty, Set<String> certifications){
            this.licenseNumber=licenseNumber;
            this.specialty=specialty;
            this.certifications=Collections.unmodifiableSet(certifications);
        }
        public String getLicenseNumber(){return licenseNumber;}
        public String getSpecialty(){return specialty;}
        public Set<String> getCertifications(){return certifications;}
    }

    public static final class Nurse {
        private final String nurseId;
        private final String shift;
        private final List<String> qualifications;

        public Nurse(String nurseId, String shift, List<String> qualifications){
            this.nurseId=nurseId;
            this.shift=shift;
            this.qualifications=Collections.unmodifiableList(qualifications);
        }
        public String getNurseId(){return nurseId;}
        public String getShift(){return shift;}
        public List<String> getQualifications(){return qualifications;}
    }

    public static final class Administrator {
        private final String adminId;
        private final List<String> accessPermissions;

        public Administrator(String adminId, List<String> accessPermissions){
            this.adminId=adminId;
            this.accessPermissions=Collections.unmodifiableList(accessPermissions);
        }
        public String getAdminId(){return adminId;}
        public List<String> getAccessPermissions(){return accessPermissions;}
    }

    public static final class HospitalSystem {
        private static final Map<String,Object> patientRegistry=new HashMap<>();
        public static boolean admitPatient(Object patient, Object staff){
            if(patient==null || staff==null) return false;
            if(!validateStaffAccess(staff,patient)) return false;
            String id = "";
            if(patient instanceof Patient) {
                Patient p = (Patient)patient;
                id = p.getCurrentName()+"-"+p.getRoomNumber();
            }
            patientRegistry.put(id,patient);
            return true;
        }

        private static boolean validateStaffAccess(Object staff, Object patient){
            if(staff instanceof Doctor) return true;
            if(staff instanceof Nurse) return true;
            if(staff instanceof Administrator) return true;
            return false;
        }
    }
}
