class Reservation {
    boolean available = true;

    public void book() throws RoomNotAvailableException {
        if (!available)
            throw new RoomNotAvailableException("Room already booked");
        available = false;
    }
}