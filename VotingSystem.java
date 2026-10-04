public class VotingSystem {
    public void processVote(String voterId, String candidate) {
        class VoteValidator {
            public boolean validate() {
                return voterId != null && voterId.startsWith("VOTER") && voterId.length() > 6;
            }
        }

        VoteValidator validator = new VoteValidator();
        if (validator.validate())
            System.out.println("Vote accepted from " + voterId + " for " + candidate);
        else
            System.out.println("Invalid voter ID: " + voterId);
    }

    public static void main(String[] args) {
        VotingSystem system = new VotingSystem();
        system.processVote("VOTER123", "Alice");
        system.processVote("12345", "Bob");
        system.processVote("VOTER999", "Charlie");
    }
}

