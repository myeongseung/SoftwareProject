public class Schedule {
    private String name;
    private String time;
    private int hall;
    private int schedule_Num;

    public String getName() {
        return name;
    }
    public String getTime() {
        return time;
    }
    public int getHall() {
        return hall;
    }
    public int getSchedule_Num() {return schedule_Num;}

    public void setName(String name) {
        this.name = name;
    }
    public void setTime(String time) {
        this.time = time;
    }
    public void setHall(int hall) {
        this.hall = hall;
    }
    public void setSchedule_Num(int num) {this.schedule_Num = num;}

    public Schedule(String name, String time, int hall, int num) {
        this.name = name;
        this.time = time;
        this.hall = hall;
        this.schedule_Num = num;
    }
    public Schedule(){

    }
}
