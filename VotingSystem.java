import java.util.HashMap;
import java.util.Scanner;

public class VotingSystem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Step 1: Add candidates
        System.out.println("Enter the number of candidates:");
        int numCandidates = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        String[] candidates = new String[numCandidates];
        System.out.println("Enter the names of the candidates:");
        for (int i = 0; i < numCandidates; i++) {
            candidates[i] = scanner.nextLine();
        }

        // Step 2: Initialize the vote counter (HashMap)
        HashMap<String, Integer> voteCount = new HashMap<>();
        for (String candidate : candidates) {
            voteCount.put(candidate, 0);
        }

        // Step 3: Cast votes
        System.out.println("Enter the number of voters:");
        int numVoters = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.println("Voters, please cast your votes (Enter candidate names):");
        for (int i = 0; i < numVoters; i++) {
            String vote = scanner.nextLine();
            if (voteCount.containsKey(vote)) {
                voteCount.put(vote, voteCount.get(vote) + 1);
            } else {
                System.out.println("Invalid candidate. Vote not counted.");
            }
        }

        // Step 4: Display vote count for each candidate
        System.out.println("\nVote counts:");
        for (String candidate : candidates) {
            System.out.println(candidate + ": " + voteCount.get(candidate));
        }

        // Step 5: Find the winner(s)
        int maxVotes = 0;
        for (int votes : voteCount.values()) {
            maxVotes = Math.max(maxVotes, votes);
        }

        System.out.println("\nWinner(s):");
        for (String candidate : candidates) {
            if (voteCount.get(candidate) == maxVotes) {
                System.out.println(candidate);
            }
        }

        scanner.close();
    }
}
