import java.util.Scanner;

/**
 * The HostelMain program implements an application consisting of various menus:
 * display available rooms, book rooms, vacate rooms,
 * find a guest room, display information about room,
 * and move room.
 * @author I Nyoman Surya Pradipta
 * Student ID: E1900344
 * Date: 9 December 2020
 * Java version: 14.0.2
 * IDE : IntelliJ IDEA
 */

public class HostelMain {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Welcome to Affirvat Hostel\nHow many rooms are available today: ");
        int size = input.nextInt();
        Hostel Affirvat = new Hostel(size);
        int menu = 0;
        while (menu != 7) {
            System.out.println("\nAffirvat Hostel Menu:\n1. Display available rooms");
            System.out.println("2. Book a room");
            System.out.println("3. Vacate a room");
            System.out.println("4. Find a guest room");
            System.out.println("5. Display information about room");
            System.out.println("6. Move room");
            System.out.println("7. Quit the program.");
            System.out.print("Menu of choices: ");
            menu = input.nextInt();
            input.nextLine();
            switch (menu) {
                case 1 -> {
                    System.out.print("Enters the number of guests needing accommodation: ");
                    int numOfGuest = input.nextInt();
                    System.out.println(Affirvat.getAvailableRooms(numOfGuest));
                }
                case 2 -> {
                    System.out.print("Enters name of the guest: ");
                    String guestName = input.nextLine();
                    System.out.print("Enter the available room number to book: ");
                    int numOfBookRoom = input.nextInt();
                    Affirvat.getRoom(numOfBookRoom).bookRoom(guestName);
                }
                case 3 -> {
                    System.out.print("Enters the number of the room to be vacated: ");
                    int numOfVacateRoom = input.nextInt();
                    if (Affirvat.getRoom(numOfVacateRoom).isBooked()) {
                        Affirvat.getRoom(numOfVacateRoom).vacateRoom();
                    } else {
                        System.out.println("\nInvalid data, room not booked yet");
                    }
                }
                case 4 -> {
                    System.out.print("Enters a guest's name: ");
                    String guestName = input.nextLine();
                    if (Affirvat.findGuestRoomNumber(guestName) != -1) {
                        System.out.print("\nGuests are in the room number ");
                        System.out.println(Affirvat.findGuestRoomNumber(guestName));
                    }
                    else
                        System.out.println("\nInvalid data, name not found");
                }
                case 5 -> {
                    System.out.println("\nThe number of booked rooms: " + Affirvat.numOfBookedRooms());
                    System.out.println("The number of empty rooms:  " + Affirvat.numOfVacantRooms());
                    System.out.printf("The total tariff of all booked rooms $%.2f \n", Affirvat.totalTariff());
                }
                case 6 -> {
                    System.out.print("Enter the room number: ");
                    int roomNumber = input.nextInt();
                    if (Affirvat.getRoom(roomNumber).isBooked()) {
                        Affirvat.getRoom(roomNumber).vacateRoom();
                        System.out.println("The room has been vacated");
                        System.out.print("Enter the room number where the guest wants to move: ");
                        int roomMoved = input.nextInt();
                        input.nextLine();
                        while (Affirvat.getRoom(roomMoved).isBooked()) {
                            System.out.print("Room has booked, enter another room: ");
                            roomMoved = input.nextInt();
                            input.nextLine();
                        }
                        System.out.print("Enters a guest's name: ");
                        String guestName = input.nextLine();
                        Affirvat.getRoom(roomMoved).bookRoom(guestName);
                        System.out.println("Room successfully moved");
                    }
                    else {
                        System.out.println("\nInvalid data, room is not booked");
                    }
                }
                case 7 -> System.out.println("\nThank you");
            }
        }
    }
}