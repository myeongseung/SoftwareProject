public class MoviePayment {
    private Schedule schedule;
    private int ticketNum;
    private int phone;

    public int getPhone() {
        return phone;
    }
    public Schedule getSchdule() {
        return schedule;
    }
    public int getTicketNum() {
        return ticketNum;
    }

    public void setPayment(Schedule schdule, int phone, int ticketNum){
        this.schedule = schdule;
        this.phone = phone;
        this.ticketNum = ticketNum;
    }
}
