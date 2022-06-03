import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DB {
    public Movie[] getMovieData(String query){
        //ArrayList<Movie> movies;
        //Movie movie = new Movie();
        Movie[] movieList = new Movie[0];
        
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try{
            conn = DBConnection.getConnection();
            pstm = conn.prepareStatement(query);
            rs = pstm.executeQuery();

            int count=0;
            while (rs.next()) {
                count++;
            }
            movieList = new Movie[count];
            rs=pstm.executeQuery();

            int i=0;
            while (rs.next()) {
                movieList[i] = new Movie();
                movieList[i].setName(rs.getString(9));
                movieList[i].setActor(rs.getString(4));
                movieList[i].setDirector(rs.getString(3));
                movieList[i].setGenre(rs.getString(8));
                movieList[i].setPoaster(rs.getString(6));
                //movieList[i].setRelease(rs.getInt(10));
                movieList[i].setSummary(rs.getString(2));
                i++;
            }
        }catch (SQLException sqlE){
            System.out.println("예외발생");
            sqlE.printStackTrace();
        }finally {
            try{
                if(rs != null){rs.close();}
                if(pstm != null){pstm.close();}
                if(conn != null){conn.close();}
            }catch(Exception e){
                throw new RuntimeException(e.getMessage());
            }
        }
        return movieList;
    }

    public static List<Schedule> GetScheduleData(String query) {
        List<Schedule> schedules = new ArrayList<>();

        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            conn = DBConnection.getConnection();
            pstm = conn.prepareStatement(query);
            rs = pstm.executeQuery();

            if (rs.next()) {
                do {

                    int Schedule_NUM = rs.getInt("NUM");
                    String time = String.valueOf(rs.getTime("DAY"));
                    int hall = rs.getInt("HALL");
                    String movie_name = rs.getString("NAME");

                    schedules.add(new Schedule(movie_name, time, hall, Schedule_NUM));
                } while (rs.next());
            } else {
                System.out.println("FAILED");
            }
        } catch (SQLException sqlE) {
            System.out.println("실패");
            sqlE.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }
        }
        return schedules;
    }

    public Seat[] getSeatData(String query1, String query2, Schedule s){
        Seat[] seatList = new Seat[20];

        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try{
            conn = DBConnection.getConnection();
            pstm = conn.prepareStatement(query1);
            rs = pstm.executeQuery();

            int i=0;
            while (rs.next()) {
                seatList[i] = new Seat();
                seatList[i].setSeat(rs.getInt("SEAT_LOW"), rs.getInt("SEAT_COLUMN"));
                seatList[i].setPrice(rs.getInt("SEAT_PRICE"));
                seatList[i].setEmpty(true);
                i++;
            }

            pstm = conn.prepareStatement(query2);
            rs = pstm.executeQuery();

            while (rs.next()) {
                if(s.getSchedule_Num() == rs.getInt("SHOWING_NUMBER")) {
                    seatList[rs.getInt("SEAT_NUMBER")-1].setEmpty(false);
                }
            }
        }catch (SQLException sqlE){
            System.out.println("예외발생");
            sqlE.printStackTrace();
        }finally {
            try{
                if(rs != null){rs.close();}
                if(pstm != null){pstm.close();}
                if(conn != null){conn.close();}
            }catch(Exception e){
                throw new RuntimeException(e.getMessage());
            }
        }
        return seatList;
    }

    public static void DB_Insert_Ticket(Movie m, Schedule sd, Seat s) {
        int max_ticket_num = 0;
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            conn = DBConnection.getConnection();
            pstm = conn.prepareStatement("SELECT MAX(TICKET_NUMBER) FROM TICKET");
            rs = pstm.executeQuery();

            if (rs.next()) {
                max_ticket_num = rs.getInt(1);
            } else {
                System.out.println("FAILED");
            }
            max_ticket_num++;

            int returnCnt = 0;
            pstm = conn.prepareStatement("insert into TICKET VALUES (?,?,?,?,?,?)");
            Timestamp ts = new Timestamp(System.currentTimeMillis());


            pstm.setInt(1, max_ticket_num);
            pstm.setInt(2, s.getPrice());
            pstm.setInt(3, sd.getSchedule_Num());
            pstm.setInt(4, (s.getLow()-1) * 4 + s.getColumn());
            pstm.setInt(5, sd.getHall());
            pstm.setTimestamp(6, ts);

            returnCnt = pstm.executeUpdate();
        } catch (SQLException sqlE) {
            System.out.println("실패");
            sqlE.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }
        }
    }
}