import java.util.ArrayList;
import java.util.List;

public class ScheduleSelectionSystem {
    private static List<Schedule> schedules = new ArrayList<>();
    private Schedule selectSchedule;

    public ScheduleSelectionSystem() {}

    public void setSelectSchedule(Schedule selectSchedule) {
        this.selectSchedule = selectSchedule;
    }

    public static List<Schedule> getScheduleList(String name){// DB데이터 받아오는 함수
        schedules = DB.GetScheduleData("SELECT SHOWING.SHOWING_NUMBER AS NUM, SHOWING.SHOWING_DAY AS DAY, HALL_NUMBER AS HALL, MOVIE.MOVIE_NAME AS NAME FROM SHOWING, MOVIE WHERE SHOWING.MOVIE_NUMBER = MOVIE.MOVIE_NUMBER");
        List<Schedule> S = new ArrayList<>();

        for(int i = 0; i < schedules.size(); i++){
            if(schedules.get(i).getName().equals(name)) {
                S.add(schedules.get(i));
            }
        }

        return S;
    }
    public void setSeat(Movie selectedMoive){
        new SeatSelectionUI(selectSchedule, selectedMoive);
    }

}
