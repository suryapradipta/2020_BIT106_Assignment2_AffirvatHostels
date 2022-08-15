/**
 * The Hostel class defines an object which is
 * the container of the Room object.
 * @author I Nyoman Surya Pradipta
 * Student ID: E1900344
 * Date: 9 December 2020
 * Java version: 14.0.2
 * IDE : IntelliJ IDEA
 */
public class Hostel {
    // declaration constant size of array
    private final Room[] rooms;

    /**
     * A constructor with one argument,
     * which is used to initialise size of the Room array.
     * @param size accepts size array from client.
     */
    public Hostel(int size) {
        if (size < 20 || size > 100) { // invalid size
            size = 50; // default size
        }
        rooms = new Room[size + 1]; // initialise array size
        // invocation of private methods
        addRoom(size);
        setNumOfBed(size);
        setRoomTariff(size);
    }

    /**
     * The addRoom method is used to add new Room object to the Hostel.
     * @param size To get the size of array from constructor.
     * @return void No value to return.
     */
    private void addRoom(int size) {
        for (int i = 0; i <= size; i++) { // traverse array
            // add object to array.
            if (i == 0 ) {
                rooms[i] = new Room();
            }
            if (i > 5 && i < (size - 5)) {
                rooms[i] = new Room();
            }
        }
    }

    /**
     * The setRoomTariff setter method, which is used to set the room tariff
     * room 0 to $1500.00, and all the even-numbered rooms to $150.00
     * @param size To get the size of array from constructor.
     * @return void No value to return.
     */
    private void setRoomTariff(int size) {
        for (int i = 0; i <= size; i++) {
            if ( i % 2 == 0) { // even number
                if (i == 0) { // index 0 or room 0
                    rooms[i].setRoomTariff(1500.00);
                }
                else
                    rooms[i].setRoomTariff(150.00);
            }
        }
    }

    /**
     * The setNumOfBed setter method, which is used to set new value of beds
     * from the last five rooms to 1, and rooms one through five to 4.
     * @param size To get the size of array from constructor.
     * @return void No value to return.
     */
    private void setNumOfBed(int size) {
        for (int i = 0; i <= size; i++) {
            if (i >= 1 && i <= 5) { // rooms one through five
                rooms[i] = new Room(); // add object to array
                rooms[i].setNumOfBeds(4); // set the number of beds
            }
            if (i >= (size - 5) && i <= size) { // the last five rooms
                rooms[i] = new Room(); // add object to array
                rooms[i].setNumOfBeds(1); // set the number of beds
            }
        }
    }

    /**
     * The getNumOfBeds getter method, which is used to get
     * the reference the Room object.
     * @param roomNumber The value representing a room number.
     * @return reference Room object or null.
     */
    public Room getRoom(int roomNumber) {
        for (int i = 0; i < rooms.length; i++) {
            if (roomNumber == i) {
                return rooms[i]; // reference Room object
            }
        }
        return null; // invalid room number
    }

    /**
     * The getNumOfBeds getter method, which is used to
     * get number of rooms which are booked.
     * @return int The number of room which are booked.
     */
    public int numOfBookedRooms() {
        int bookedRoom = 0;
        for (Room room : rooms) { // traverse collection of rooms
            if (room.isBooked()) { // check boolean conditions
                bookedRoom++; // num booked room increased by 1
            }
        }
        return bookedRoom;
    }

    /**
     * The numOfVacantRooms getter method, which is used to get
     * the number of rooms not booked.
     * @return int The number of rooms not booked.
     */
    public int numOfVacantRooms() {
        int vacateRoom = 0;
        for (Room room : rooms) { // traverse collection of rooms
            if (!room.isBooked()) { // check boolean conditions
                vacateRoom++; // num booked room increased by 1
            }
        }
        return vacateRoom;
    }

    /**
     * The totalTariff getter method, which is used to get and calculate
     * total tariff from all the booked rooms.
     * @return double Total tariff from all the booked rooms.
     */
    public double totalTariff() {
        double income = 0.0;
        for (Room room : rooms) { // traverse collection of rooms
            if(room.isBooked()) // check boolean conditions
                income += room.getRoomTariff(); // add room tariff to income
        }
        return income;

    }

    /**
     * The getAvailableRooms getter method, which is used to get a list of
     * all vacant rooms that have sufficient beds for potential guests.
     * @param numOfGuest Representing the number of guests that needed the room.
     * @return String A list of all vacant rooms.
     */
    public String getAvailableRooms(int numOfGuest) {
        StringBuilder vacantRooms = new StringBuilder(); // create StringBuilder object
        for (int i = 0; i < rooms.length; i++) {
            if (numOfGuest == rooms[i].getNumOfBeds()) {
                vacantRooms.append("\n(Room number ").append(i).append(") ").append(rooms[i].toString());
            }
        }
        return vacantRooms.toString();
    }

    /**
     * The findGuestRoomNumber getter method, which is used to
     * search for the name of the first guest in the hostel.
     * @param guestName Representing a guest's name.
     * @return int Room number when found
     */
    public int findGuestRoomNumber(String guestName) {
        int roomNum = -1;
        for (int i = 0; i < rooms.length; i++) {
            if (rooms[i].getGuestName().equalsIgnoreCase(guestName)) {
                return i;
            }
        }
        return roomNum;
    }
}
