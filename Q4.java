public class MovieBookingSystem {

    // Ticket class
    static class Ticket {
        private int ticketNumber;
        private String customerName;
        private int seatNumber;

        public Ticket(int ticketNumber, String customerName, int seatNumber) {
            this.ticketNumber = ticketNumber;
            this.customerName = customerName;
            this.seatNumber = seatNumber;
        }

        public int getTicketNumber() {
            return ticketNumber;
        }

        public int getSeatNumber() {
            return seatNumber;
        }

        public String toString() {
            return "Ticket #" + ticketNumber + ", Name: " + customerName + ", Seat: " + seatNumber;
        }
    }

    // BookingSystem class
    static class BookingSystem {
        private Ticket[] tickets = new Ticket[10];
        private int count = 0;

        public void bookTicket(Ticket ticket) {
            if (count >= tickets.length) {
                System.out.println("All seats are booked.");
                return;
            }
            for (int i = 0; i < count; i++) {
                if (tickets[i].getSeatNumber() == ticket.getSeatNumber()) {
                    System.out.println("Seat " + ticket.getSeatNumber() + " is already booked.");
                    return;
                }
            }
            tickets[count++] = ticket;
            System.out.println("Booked: " + ticket);
        }

        public void cancelTicket(int ticketNumber) {
            for (int i = 0; i < count; i++) {
                if (tickets[i].getTicketNumber() == ticketNumber) {
                    for (int j = i; j < count - 1; j++) {
                        tickets[j] = tickets[j + 1];
                    }
                    tickets[--count] = null;
                    System.out.println("Canceled ticket #" + ticketNumber);
                    return;
                }
            }
            System.out.println("Ticket #" + ticketNumber + " not found.");
        }

        public void displayTickets() {
            System.out.println("Current Bookings:");
            for (int i = 0; i < count; i++) {
                System.out.println(tickets[i]);
            }
        }
    }

    // Main method
    public static void main(String[] args) {
        BookingSystem system = new BookingSystem();

        system.bookTicket(new Ticket(1, "Alice", 1));
        system.bookTicket(new Ticket(2, "Bob", 2));
        system.bookTicket(new Ticket(3, "Carol", 3));

        system.cancelTicket(2);

        system.bookTicket(new Ticket(4, "David", 2)); // Re-book seat 2

        system.displayTickets();
    }
}
