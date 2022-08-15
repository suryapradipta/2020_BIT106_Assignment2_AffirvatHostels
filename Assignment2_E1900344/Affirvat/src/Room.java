/**
 * Room class defines a simple object type that represents a room.
 * @author I Nyoman Surya Pradipta
 * Student ID: E1900344
 * Date: 9 December 2020
 * Java version: 14.0.2
 * IDE : IntelliJ IDEA
 */
public class Room {
    private int numOfBeds;
    private String guestName;
    private boolean bookingStatus;
    private double roomTariff;

    /**
     * The default constructor used to initialise the default value.
     */
    public Room(){
        // initialise default Room object
        numOfBeds = 2;
        guestName = "Nobody";
        bookingStatus = false;
        roomTariff = 100.00;
    }

    /**
     * The setNumOfBeds setter method, which is used to set a new value NumOfBed variable.
     * @param newNumOfBed to assign the parameter value to the numOfBeds variable.
     * @return void No value to return.
     */
    public void setNumOfBeds(int newNumOfBed) {
        if (newNumOfBed >= 1 && newNumOfBed <= 4) { // inclusive 1-4
            numOfBeds = newNumOfBed; // assign new value
        }
    }

    /**
     * The setRoomTariff setter method, which is used to set a new value roomTariff variable.
     * @param newRoomTariff to assign the parameter value to the roomTariff variable.
     * @return void No value to return.
     */
    public void setRoomTariff(double newRoomTariff) {
        if (newRoomTariff > 0) { // value cannot be negative
            roomTariff = newRoomTariff; // assign new value
        }
    }

    /**
     * The bookRoom service method, which is used to set
     * a guestName and bookingStatus variables.
     * @param guestName to assign the parameter value to the guestName variable.
     * @return void No value to return.
     */
    public void bookRoom(String guestName) {
        bookingStatus = true; // room booked
        this.guestName = guestName; // assign new value
    }

    /**
     * The vacateRoom service method, which is used to set
     * a guestName and bookingStatus variables to default value.
     * @return void No value to return.
     */
    public void vacateRoom() {
        bookingStatus = false; // not booked
        guestName = "Nobody"; // assign to default
    }

    /**
     * The getNumOfBeds getter method, which is used to get the numOfBeds value.
     * @return int Value of numOfBeds.
     */
    public int getNumOfBeds() {
        return numOfBeds;
    }

    /**
     * The getRoomTariff getter method, which is used to get the roomTariff value.
     * @return double Value of roomTariff.
     */
    public double getRoomTariff() {
        return roomTariff;
    }

    /**
     * The getGuestName getter method, which is used to get the guestName value.
     * @return String Value of guestName.
     */
    public String getGuestName() {
        return guestName;
    }

    /**
     * The isBooked service method, which is used to get the bookingStatus value.
     * @return boolean Value of bookingStatus.
     */
    public boolean isBooked() {
        return bookingStatus;
    }

    /**
     * The toString query method, which is used to return the details information of the Room object.
     * @return String Details information of the Room object.
     */
    public String toString() {
        return String.format("Room with %d beds, tariff %.2f, and guest named %s.", numOfBeds,roomTariff, guestName);
    }
}

