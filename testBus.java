public class testBus{
    public static void main(String[] args) {
        // create a new bus with a capacity of 5
        Bus bus = new Bus(5, "GA 556", "Hyndai", "Camry", "red");
        
        // test accessor methods
        System.out.println("Capacity: " + bus.getCapacity());
        System.out.println("License plate: " + bus.getLicensePlateNumber());
        System.out.println("Make: " + bus.getMake());
        System.out.println("Model: " + bus.getModel());
        System.out.println("Color: " + bus.getColour());
        
        // create a driver and set them as the driver for the bus
        Person driver = new Person("John",  23, "MALE");
        //driver.setLicense(true); // assume the driver has a license
        bus.setDriver(driver);
        
        // test hasDriver() method
        System.out.println("Has driver: " + bus.hasDriver()); // should be true
        
        // create passengers and add them to the bus
        Person passenger1 = new Person("Nicole", 20, "FEMALE");
        Person passenger2 = new Person("INEZA",  30, "MALE");
        Person passenger3 = new Person("Alice", 40, "FEMALE");
        bus.addPassenger(passenger1);
        bus.addPassenger(passenger2);
        bus.addPassenger(passenger3);
        
        // test getNumPassengers() and getNumOccupants() methods
        System.out.println("Number of passengers: " + bus.getNumPassengers()); // should be 3
        System.out.println("Number of occupants: " + bus.getNumOccupants()); // should be 4 (1 driver + 3 passengers)
        
        // test hasPassengers() and isEmpty() methods
        System.out.println("Has passengers: " + bus.hasPassengers()); // should be true
        System.out.println("Is empty: " + bus.isEmpty()); // should be false
        
        // add one more passenger to fill the bus to capacity
        Person passenger4 = new Person("JOY",  50, "MALE");
        Person passenger5 = new Person("HOZA", 60, "FEMALE");
        boolean success = bus.addPassenger(passenger4);
        System.out.println("Passenger added: " + success); // should be true
        success = bus.addPassenger(passenger5);
        System.out.println("Passenger added: " + success); // should be false (bus is full)
        
       // test isFull() method
        System.out.println("Is full: " + bus.isFull()); // should be true
        
        // test listRiders() method
        bus.listRiders();
        
        // test getEmptySeats() method
        int[] emptySeats = bus.getEmptySeats();
        System.out.print("Empty seats: ");
        for (int i = 0; i < emptySeats.length; i++) {
            System.out.print(emptySeats[i] + " ");
        }
        System.out.println(); // should print "Empty seats: "
        
        // remove a passenger and test removePassenger() method
        success = bus.removePassenger(passenger2);
        System.out.println("Passenger removed: " + success); // should be true
        System.out.println("Number of passengers: " + bus.getNumPassengers()); // should be 4
        
        // test getEmptySeats() method again
        emptySeats = bus.getEmptySeats();
        
        System.out.print("Empty seats"+ emptySeats);
    }
}
