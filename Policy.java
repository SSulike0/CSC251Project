public class Policy {
    // Attributes
    private int policyNumber;
    private String providerName;
    private String firstName;
    private String lastName;
    private int age;
    private String smokingStatus;
    private double heightInInches;
    private double weightInPounds;

    // Constructors
    public Policy() {
        // Default constructor with default values
        this.policyNumber = 0;
        this.providerName = "";
        this.firstName = "";
        this.lastName = "";
        this.age = 0;
        this.smokingStatus = "";
        this.heightInInches = 0.0;
        this.weightInPounds = 0.0;
    }

    public Policy(int policyNumber, String providerName, String firstName, String lastName,
                  int age, String smokingStatus, double heightInInches, double weightInPounds) {
        this.policyNumber = policyNumber;
        this.providerName = providerName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.smokingStatus = smokingStatus;
        this.heightInInches = heightInInches;
        this.weightInPounds = weightInPounds;
    }

    // Getters and Setters
    public int getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(int policyNumber) {
        this.policyNumber = policyNumber;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSmokingStatus() {
        return smokingStatus;
    }

    public void setSmokingStatus(String smokingStatus) {
        this.smokingStatus = smokingStatus;
    }

    public double getHeightInInches() {
        return heightInInches;
    }

    public void setHeightInInches(double heightInInches) {
        this.heightInInches = heightInInches;
    }

    public double getWeightInPounds() {
        return weightInPounds;
    }

    public void setWeightInPounds(double weightInPounds) {
        this.weightInPounds = weightInPounds;
    }

    // Calculate and return BMI
    public double calculateBMI() {
        return (weightInPounds * 703) / (heightInInches * heightInInches);
    }

    // Calculate and return policy price
    public double calculatePolicyPrice() {
        double baseFee = 600.0;
        double additionalFee = 0.0;

        if (age > 50) {
            additionalFee += 75.0;
        }
        
        if (smokingStatus.equalsIgnoreCase("smoker")) {
            additionalFee += 100.0;
        }
        
        if (calculateBMI() > 35) {
            additionalFee += (calculateBMI() - 35) * 20;
        }

        return baseFee + additionalFee;
    }
}