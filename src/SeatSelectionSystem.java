public class SeatSelectionSystem {
    private Seat[] SeatList;
    private Seat selectedSeat;

    public void setSelectedSeat(Seat seat){
        this.selectedSeat = seat;
    }
    public Seat[] getSeatList(Schedule selectSchedule){
        DB db = new DB();
        SeatList = db.getSeatData("SELECT SEAT_LOW, SEAT_COLUMN, SEAT_PRICE FROM SEAT",
                "SELECT SEAT_NUMBER, SHOWING_NUMBER FROM TICKET", selectSchedule);
        return SeatList;
    }

    public void credit(Movie selectedMovie, Schedule selectSchedule) {
        new CreditUI(selectedMovie, selectSchedule, selectedSeat);
    }
}
