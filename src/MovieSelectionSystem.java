import java.sql.ResultSet;
import java.sql.SQLException;

public class MovieSelectionSystem {
    private Movie[] movieList;
    // 출력 영화 목록
    private Movie selectedMovie;
    // 선택된 영화

    public Movie[] getMovieList() {
        DB db = new DB();
        movieList = db.getMovieData("SELECT * FROM MOVIE");

        return movieList;
    }// 화면 출력 영화목록 호출

    public void setMovie(Movie movie) {
        this.selectedMovie = movie;
    }// 선택된 영화 함수

    public void setSchedule() {
        new ScreeningScheduleUI(selectedMovie);
    }// 상영시간표 설정 함수
}
