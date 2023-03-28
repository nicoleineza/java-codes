
/**
 * A class to model a person, who has a name and an age.
 **/
public class Person {

    private String name;
    private int age;
    private String gender;

    private static int votingAge;
    private static int drivingAge;
    private static int marriageAge;

    private static final int INFANT_MIN = 0;
    private static final int INFANT_MAX = 1;
    private static final int TODDLER_MIN = 1;
    private static final int TODDLER_MAX = 3;
    private static final int TEENAGER_MIN = 13;
    private static final int TEENAGER_MAX = 19;
    private static final int CHILD_MIN = 0;
    private static final int CHILD_MAX = 15;
    private static final int YOUTH_MIN = 15;
    private static final int YOUTH_MAX = 24;

    // default constructor
    public Person() {
        this("No name yet", 0, "female");
    }

    // constructor that takes a name and an age
    public Person(String n, int a, String g) {
        setPerson(n, a);
        gender = g;
    }

    /**
     * Create a person with the minimum age required to be an adult.
     * 
     * @param name The name of the person
     * @param gender "male" or "female"
     * @return A new "adult" Person object with the name, and gender specified.
     */
    public static Person createAdult(String name, String gender) {
        int minimumAdultAge = Math.max(votingAge, Math.max(drivingAge, marriageAge));
        return new Person(name, minimumAdultAge, gender);
    }

    /**
     * Get the current voting age of the {@code Person} class
     * 
     * @return The voting age
     */
    public static int getVotingAge() {
        return votingAge;
    }

    /**
     * Get the minimum age for driving
     * 
     * @return The minimum age for driving
     */
    public static int getDrivingAge() {
        return drivingAge;
    }

    /**
     * Get the minimum age for marrying
     * 
     * @return The minimum age for marrying
     */
    public static int getMarriageAge() {
        return marriageAge;
    }

    // accessor method for name
    public String getName() {
        return name;
    }

    // accessor method for age
    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getGenderAsString() {
        return this.gender;
    }

    /**
     * Set the voting age of the {@code Person} class
     * 
     * @param votingAge the votingAge to set
     */
    public static void setVotingAge(int votingAge) {
        Person.votingAge = votingAge;
    }

    /**
     * Set the minimum age for driving
     * 
     * @param drivingAge The new driving age
     */
    public static void setDrivingAge(int drivingAge) {
        Person.drivingAge = drivingAge;
    }

    /**
     * Set the minimum age for marrying
     * 
     * @param marriageAge The new marriage age
     */
    public static void setMarriageAge(int marriageAge) {
        Person.marriageAge = marriageAge;
    }

    // mutator method for name
    public void setName(String n) {
        name = n;
    }

    // mutator method for age
    public void setAge(int a) {
        if (a < 0) {
            System.out.println("Age cannot be negative.");
            System.exit(0);
        } else
            age = a;
    }

    // method to set both the name and the age
    public void setPerson(String n, int a) {
        setName(n);
        setAge(a);
    }

    // tests whether this person is equal to another
    public boolean equals(Person otherP) {
        return (name.equals(otherP.name) && age == otherP.age);
    }

    // tests whether this person has the same name as another
    public boolean hasSameNameAs(Person otherP) {
        return name.equals(otherP.name);
    }

    // tests whether this person has the same age as another
    public boolean hasSameAgeAs(Person otherP) {
        return age == otherP.age;
    }

    // tests whether this person is older than another
    public boolean isOlderThan(Person otherP) {
        return age > otherP.age;
    }

    // tests whether this person is younger than another
    public boolean isYoungerThan(Person otherP) {
        return age < otherP.age;
    }

    /**
     * If you can vote, drive, and marry, then you're an adult.
     * 
     * @return {@code true} if person is an adult, {@code false} otherwise.
     */
    public boolean isAdult() {
        return canVote() && canDrive() && canMarry();
    }

    /**
    * Return whether or not the calling person is an infant
    * 
    * @return {@code true} if the person is an infant, {@code false} otherwise
    */
    public boolean isInfant() {
        return age >= INFANT_MIN && age <= INFANT_MAX;
    }

    /**
     * Return whether or not the calling person is a toddler
     * 
     * @return {@code true} if the person is a toddler, {@code false} otherwise
     */
    public boolean isToddler() {
        return age >= TODDLER_MIN && age <= TODDLER_MAX;
    }

    /**
     * Return whether or not the calling person is a child
     * 
     * @return {@code true} if the person is a child, {@code false} otherwise
     */
    public boolean isChild() {
        return age >= CHILD_MIN && age <= CHILD_MAX;
    }

    /**
     * Return whether or not the calling person is a teenager
     * 
     * @return {@code true} if the person is a teenager, {@code false} otherwise
     */
    public boolean isTeenager() {
        return age >= TEENAGER_MIN && age <= TEENAGER_MAX;
    }

    /**
     * Return whether or not the calling person is a young person
     * 
     * @return {@code true} if the person is a young person, {@code false} otherwise
     */
    public boolean isYouth() {
        return age >= YOUTH_MIN && age <= YOUTH_MAX;
    }

    /**
    * Return whether or not a person is eligible to vote
    * 
    * @return {@code true} if person can vote, {@code false} otherwise.
    */
    public boolean canVote() {
        return age >= votingAge;
    }

    /**
     * Return whether or not a person is eligible to drive
     * 
     * @return {@code true} if person can drive, {@code false} otherwise.
     */
    public boolean canDrive() {
        return age >= drivingAge;
    }

    /**
     * Return whether or not a person is eligible to marry
     * 
     * @return {@code true} if person can marry, {@code false} otherwise.
     */
    public boolean canMarry() {
        return age >= marriageAge;
    }

}