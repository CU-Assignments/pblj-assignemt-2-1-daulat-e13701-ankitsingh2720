class TicketBooking extends Thread {
    static int availableSeats = 10;
    static boolean isVIP = false;

    @Override
    public synchronized void run() {
        if (availableSeats > 0) {
            availableSeats--;
            System.out.println(Thread.currentThread().getName() + " booked a seat. Seats remaining: " + availableSeats);
        } else {
            System.out.println(Thread.currentThread().getName() + " failed to book a seat. No seats left.");
        }
    }

    public static void main(String[] args) {
        TicketBooking regularBooking1 = new TicketBooking();
        TicketBooking regularBooking2 = new TicketBooking();
        TicketBooking vipBooking1 = new TicketBooking() {
            @Override
            public synchronized void run() {
                if (availableSeats > 0) {
                    availableSeats--;
                    System.out.println(Thread.currentThread().getName() + " (VIP) booked a seat. Seats remaining: " + availableSeats);
                } else {
                    System.out.println(Thread.currentThread().getName() + " (VIP) failed to book a seat. No seats left.");
                }
            }
        };

        // Setting thread priorities: VIP bookings have higher priority
        vipBooking1.setPriority(Thread.MAX_PRIORITY);
        regularBooking1.setPriority(Thread.NORM_PRIORITY);
        regularBooking2.setPriority(Thread.NORM_PRIORITY);

        // Start the threads
        regularBooking1.start();
        vipBooking1.start();
        regularBooking2.start();
    }
}
