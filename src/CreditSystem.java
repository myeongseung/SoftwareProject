public class CreditSystem {
    private Movie reservationMovie;
    private Schedule reservationSchedule;
    private Seat reservationSeat;
    private int price;

    CreditSystem(Movie m, Schedule sd, Seat s, int p) {
        this.reservationMovie = m;
        this.reservationSchedule = sd;
        this.reservationSeat = s;
        this.price = p;
    }
}
