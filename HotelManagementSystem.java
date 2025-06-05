import java.util.*;

// Room class
class Room 
{
    int roomNumber;
    boolean isOccupied;
    String customerName;

    Room(int roomNumber) 
    {
        this.roomNumber = roomNumber;
        this.isOccupied = false;
        this.customerName = "";
    }

    void checkIn(String customerName)
    {
        this.isOccupied = true;
        this.customerName = customerName;
    }

    void checkOut() 
    {
        this.isOccupied = false;
        this.customerName = "";
    }

    String getStatus() 
    {
        return isOccupied ? "Occupied by " + customerName : "Available";
    }
}

// Hotel class
class Hotel 
{
    List<Room> rooms;

    Hotel(int numRooms) 
    {
        rooms = new ArrayList<>();
        for (int i = 1; i <= numRooms; i++)
        {
            rooms.add(new Room(i));
        }
    }

    void displayRooms()
    {
        System.out.println("\nRoom Status:");
        for (Room room : rooms) 
        {
            System.out.println("Room " + room.roomNumber + ": " + room.getStatus());
        }
    }

    void checkIn(int roomNumber, String customerName) 
     {
        if (roomNumber <= 0 || roomNumber > rooms.size()) 
         {
            System.out.println("Invalid room number.");
            return;
         }
        Room room = rooms.get(roomNumber - 1);
        if (!room.isOccupied) 
         {
            room.checkIn(customerName);
            System.out.println("Checked in successfully!");
         } 
        else 
         {
            System.out.println("Room already occupied.");
         }
     }
    void checkOut(int roomNumber) 
     {
        if (roomNumber <= 0 || roomNumber > rooms.size()) 
         {
            System.out.println("Invalid room number.");
            return;
         }
        Room room = rooms.get(roomNumber - 1);
        if (room.isOccupied) 
         {
            room.checkOut();
            System.out.println("Checked out successfully!");
         } 
        else 
         {
            System.out.println("Room is already vacant.");
         }
     }
} 

// Main class
class HotelManagementSystem
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        Hotel hotel = new Hotel(5); // 5 rooms for example

        while (true) 
        {
            System.out.println("\n--- Hotel Management System ---");
            System.out.println("1. View Room Status");
            System.out.println("2. Check-In");
            System.out.println("3. Check-Out");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // clear buffer

            switch (choice) 
            {
                case 1:
                    hotel.displayRooms();
                    break;

                case 2:
                    System.out.print("Enter Room Number: ");
                    int roomNoIn = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Customer Name: ");
                    String name = scanner.nextLine();
                    hotel.checkIn(roomNoIn, name);
                    break;

                case 3:
                    System.out.print("Enter Room Number to Check-Out: ");
                    int roomNoOut = scanner.nextInt();
                    hotel.checkOut(roomNoOut);
                    break;

                case 4:
                    System.out.println("Thank you for using the Hotel Management System!");
                    return;

                default:
                    System.out.println("Invalid option.");
             }
        }
    }
}
