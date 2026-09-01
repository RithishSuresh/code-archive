import java.util.*;

class Room {
    private String roomNumber;
    private String roomType;
    private double pricePerNight;
    private boolean isAvailable;
    private int maxOccupancy;

    public Room(String roomNumber, String roomType, double pricePerNight, int maxOccupancy) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.pricePerNight = pricePerNight;
        this.isAvailable = true;
        this.maxOccupancy = maxOccupancy;
    }

    public String getRoomNumber() { return roomNumber; }
    public String getRoomType() { return roomType; }
    public double getPricePerNight() { return pricePerNight; }
    public boolean isAvailable() { return isAvailable; }
    public int getMaxOccupancy() { return maxOccupancy; }
    public void setAvailable(boolean available) { this.isAvailable = available; }

    public void displayRoomInfo() {
        System.out.println("Room " + roomNumber + " [" + roomType +
                "] Price: " + pricePerNight + " Available: " + isAvailable);
    }
}

class Guest {
    private String guestId;
    private String guestName;
    private String phoneNumber;
    private String email;
    private List<String> bookingHistory;

    public Guest(String guestId, String guestName, String phoneNumber, String email) {
        this.guestId = guestId;
        this.guestName = guestName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.bookingHistory = new ArrayList<>();
    }

    public String getGuestId() { return guestId; }
    public String getGuestName() { return guestName; }
    public void addBookingHistory(String bookingId) { bookingHistory.add(bookingId); }

    public void displayGuestInfo() {
        System.out.println("Guest: " + guestName + " (ID: " + guestId + ")");
        System.out.println("Phone: " + phoneNumber + ", Email: " + email);
        System.out.println("Bookings: " + bookingHistory);
    }
}

class Booking {
    private String bookingId;
    private Guest guest;
    private Room room;
    private String checkInDate;
    private String checkOutDate;
    private double totalAmount;

    private static int bookingCounter = 0;
    private static int totalBookings = 0;
    private static double hotelRevenue = 0;
    private static String hotelName = "Grand Palace Hotel";

    public Booking(Guest guest, Room room, String checkInDate, String checkOutDate, int nights) {
        this.bookingId = "BKG" + (++bookingCounter);
        this.guest = guest;
        this.room = room;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.totalAmount = nights * room.getPricePerNight();
        room.setAvailable(false);
        guest.addBookingHistory(bookingId);
        totalBookings++;
        hotelRevenue += totalAmount;
    }

    public String getBookingId() { return bookingId; }
    public Guest getGuest() { return guest; }
    public Room getRoom() { return room; }
    public double getTotalAmount() { return totalAmount; }
    public static int getTotalBookings() { return totalBookings; }
    public static double getHotelRevenue() { return hotelRevenue; }
    public static String getHotelName() { return hotelName; }

    public static double getOccupancyRate(Room[] rooms) {
        int total = rooms.length;
        int booked = 0;
        for (Room r : rooms) {
            if (!r.isAvailable()) booked++;
        }
        return (booked * 100.0) / total;
    }

    public static String getMostPopularRoomType(List<Booking> bookings) {
        Map<String, Integer> freq = new HashMap<>();
        for (Booking b : bookings) {
            String type = b.getRoom().getRoomType();
            freq.put(type, freq.getOrDefault(type, 0) + 1);
        }
        return Collections.max(freq.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    public void displayBookingInfo() {
        System.out.println("Booking ID: " + bookingId);
        System.out.println("Guest: " + guest.getGuestName());
        System.out.println("Room: " + room.getRoomNumber() + " (" + room.getRoomType() + ")");
        System.out.println("Check-In: " + checkInDate + ", Check-Out: " + checkOutDate);
        System.out.println("Total Amount: $" + totalAmount);
    }
}

public class HotelApp {
    public static void main(String[] args) {
        Room[] rooms = {
                new Room("101", "Single", 100, 1),
                new Room("102", "Double", 180, 2),
                new Room("201", "Suite", 300, 4),
                new Room("202", "Double", 180, 2),
        };

        Guest g1 = new Guest("G001", "Alice Johnson", "9876543210", "alice@mail.com");
        Guest g2 = new Guest("G002", "Bob Smith", "9123456780", "bob@mail.com");

        List<Booking> allBookings = new ArrayList<>();
        Booking b1 = new Booking(g1, rooms[0], "2025-09-05", "2025-09-07", 2);
        Booking b2 = new Booking(g2, rooms[1], "2025-09-10", "2025-09-12", 2);
        allBookings.add(b1);
        allBookings.add(b2);

        System.out.println("=== Hotel Reservation System ===");
        System.out.println("Hotel: " + Booking.getHotelName());
        System.out.println();

        b1.displayBookingInfo();
        System.out.println();
        b2.displayBookingInfo();
        System.out.println();

        g1.displayGuestInfo();
        System.out.println();
        g2.displayGuestInfo();
        System.out.println();

        System.out.println("Total Bookings: " + Booking.getTotalBookings());
        System.out.println("Hotel Revenue: $" + Booking.getHotelRevenue());
        System.out.println("Occupancy Rate: " + Booking.getOccupancyRate(rooms) + "%");
        System.out.println("Most Popular Room Type: " + Booking.getMostPopularRoomType(allBookings));
    }
}

