
public class TestPerson {

    public static void main(String[] args) {

        Person kofi = new Person("Kofi", 18, "male");
        Person mansah = new Person("Mansah", 20, "female");
        Person bob = new Person("Bob", 16, "male");

        // test setVotingAge and canVote
        Person.setVotingAge(16);
        System.out.println("Bob can vote: " + bob.canVote()); // expect true
        Person.setVotingAge(18);
        System.out.println("Bob can vote: " + bob.canVote()); // expect false
        System.out.println();

        // test setMarriageAge and canMarry
        Person.setMarriageAge(18);
        System.out.println("Kofi can marry: " + kofi.canMarry()); // expect true
        Person.setMarriageAge(20);
        System.out.println("Kofi can marry: " + kofi.canMarry()); // expect false
        System.out.println();

        // test setDrivingAge and canDrive
        Person.setDrivingAge(21);
        System.out.println("Mansah can drive: " + mansah.canDrive()); // expect false
        Person.setDrivingAge(18);
        System.out.println("Mansah can drive: " + mansah.canDrive()); // expect true
        System.out.println();
        
        System.out.println("Kofi is an adult: " + kofi.isAdult());
        System.out.println("Mansah is an adult: " + mansah.isAdult());
        System.out.println("Bob is an adult: " + bob.isAdult());
        System.out.println();

        Person[] people = {
                new Person("Googa", 1, "female"),
                new Person("Toddie", 2, "male"),
                new Person("Roxanne", 14, "female"),
                bob, mansah
        };

        for (Person p : people) {
            System.out.println(p.getName() + " (" + p.getAge() + ") is an infant: " + p.isInfant());
            System.out.println(p.getName() + " (" + p.getAge() + ") is a toddler: " + p.isToddler());
            System.out.println(p.getName() + " (" + p.getAge() + ") is a child: " + p.isChild());
            System.out.println(p.getName() + " (" + p.getAge() + ") is a teenager: " + p.isTeenager());
            System.out.println(p.getName() + " (" + p.getAge() + ") is a youth: " + p.isYouth());
            System.out.println();
        }
    }
}