import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PolicyDemo {
    public static void main(String[] args) {
        // Declare a list to store Policy objects
        List<Policy> policies = new ArrayList<>();

        try {
            // Read data from the text file "PolicyInformation.txt"
            BufferedReader reader = new BufferedReader(new FileReader("PolicyInformation.txt"));
            String line;

            while ((line = reader.readLine()) != null) {
                // Split the line into individual data elements
                String policyNumber = line;
                String providerName = reader.readLine();
                String firstName = reader.readLine();
                String lastName = reader.readLine();
                int age = Integer.parseInt(reader.readLine());
                String smokingStatus = reader.readLine();
                double height = Double.parseDouble(reader.readLine());
                double weight = Double.parseDouble(reader.readLine());

                // Create a Policy object and add it to the list
                Policy policy = new Policy(policyNumber, providerName, firstName, lastName, age, smokingStatus, height, weight);
                policies.add(policy);

                // Read an empty line to separate policies
                reader.readLine();
            }

            reader.close();
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
            return;
        }

        // Iterate through the list of policies and display information
        for (Policy policy : policies) {
            System.out.println("Policy Number: " + policy.getPolicyNumber());
            System.out.println("Provider Name: " + policy.getProviderName());
            System.out.println("Policyholder's First Name: " + policy.getFirstName());
            System.out.println("Policyholder's Last Name: " + policy.getLastName());
            System.out.println("Policyholder's Age: " + policy.getAge());
            System.out.println("Policyholder's Smoking Status: " + policy.getSmokingStatus());
            System.out.println("Policyholder's Height: " + policy.getHeight() + " inches");
            System.out.println("Policyholder's Weight: " + policy.getWeight() + " pounds");
            System.out.printf("Policyholder's BMI: %.2f\n", policy.getBMI());
            System.out.printf("Policy Price: $%.2f\n", policy.getPrice());
            System.out.println();
        }

        // Count the number of smokers and non-smokers
        int smokers = 0;
        int nonSmokers = 0;

        for (Policy policy : policies) {
            if (policy.getSmokingStatus().equalsIgnoreCase("smoker")) {
                smokers++;
            } else {
                nonSmokers++;
            }
        }

        System.out.println("The number of policies with a smoker is: " + smokers);
        System.out.println("The number of policies with a non-smoker is: " + nonSmokers);
    }
}
