public class Bus {
    private int busCapacity;
    private String busLicensePlateNumber;
    private String busMake;
    private String busModel;
    private String busColour;
    private Person busDriver;
    private Person[] passengers;
    private int numPassengers;

    public Bus(int busCapacity, String busLicensePlateNumber, String busMake, String busModel, String busColour) {
        this.busCapacity = busCapacity;
        this.busLicensePlateNumber = busLicensePlateNumber;
        this.busMake = busMake;
        this.busModel = busModel;
        this.busColour = busColour;
        this.busDriver = null;
        this.passengers = new Person[busCapacity];
        this.numPassengers = 0;
    }

    public int getCapacity() {
        return busCapacity;
    }

    public String getLicensePlateNumber() {
        return busLicensePlateNumber;
    }

    public String getMake() {
        return busMake;
    }

    public String getModel() {
        return busModel;
    }

    public String getColour() {
        return busColour;
    }
    /*public boolean canDrive(Person busDriver){
        i( busDriver.getAge()>=18); {
            return true;
        }
        return false;
    }*/

    public boolean setDriver(Person busDriver) {
        if (busDriver.canDrive()) {
            this.busDriver = busDriver;
            return true;
        } else {
            return false;
        }
    }

    public boolean hasDriver() {
        return busDriver != null;
    }

    public boolean addPassenger(Person passenger) {
        for (int i = 0; i < busCapacity; i++) {
            if (passengers[i] == null) {
                passengers[i] = passenger;
                numPassengers++;
                return true;
            }
        }
        return false;
    }

    public boolean removePassenger(Person passenger) {
        for (int i = 0; i < busCapacity; i++) {
            if (passengers[i] != null && passengers[i].equals(passenger)) {
                passengers[i] = null;
                numPassengers--;
                return true;
            }
        }
        return false;
    }

    public int getNumPassengers() {
        return numPassengers;
    }

    public int getNumOccupants() {
        if (hasDriver()) {
            return numPassengers + 1;
        } else {
            return numPassengers;
        }
    }

    public boolean hasPassengers() {
        return numPassengers > 0;
    }

    public boolean isEmpty() {
        return !hasDriver() && !hasPassengers();
    }

    public boolean isFull() {
        return numPassengers == busCapacity;
    }

    public void listRiders() {
        System.out.println("Driver: " + busDriver);
        for (int i = 0; i < busCapacity; i++) {
            if (passengers[i] != null) {
                System.out.println("Passenger " + (i + 1) + ": " + passengers[i]);
            }
        }
    }

    public int[] getEmptySeats() {
        int[] emptySeats = new int[busCapacity - numPassengers];
        int index = 0;
        
        for (int i = 0; i < busCapacity; i++) {
            if (passengers[i] == null) {
                emptySeats[index] = i;
                index++;
    
            }
        }
        return count;
    }
}

