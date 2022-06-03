import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.*;
/*
 * Created by JFormDesigner on Sat May 21 20:24:12 KST 2022
 */



/**
 * @author sangbaek kim
 */
public class MovieSelectionUI extends JFrame {
    public MovieSelectionUI() {
        initComponents();
    }

    private void mainMenu(ActionEvent e) {
        this.dispose();;
        new MainUI();
    }

    private MovieSelectionSystem movieSystem = new MovieSelectionSystem();
    private JButton[] movieButton;
    private JPanel[] moviePanel;
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        reservationPanel = new JPanel();
        titlePanel = new JPanel();
        reservationTitle = new JLabel();
        mainMenu = new JButton();
        scrollPane1 = new JScrollPane();
        movieListPanel = new JPanel();

        //======== this ========
        setVisible(true);
        setTitle("Movie Reservation");
        setMinimumSize(new Dimension(350, 600));
        setResizable(false);
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== reservationPanel ========
        {
            reservationPanel.setLayout(new BorderLayout());

            //======== titlePanel ========
            {
                titlePanel.setLayout(new BorderLayout());

                //---- reservationTitle ----
                reservationTitle.setText("\uc601\ud654\uc120\ud0dd");
                reservationTitle.setHorizontalAlignment(SwingConstants.CENTER);
                titlePanel.add(reservationTitle, BorderLayout.CENTER);

                //---- mainMenu ----
                mainMenu.setMinimumSize(new Dimension(50, 50));
                mainMenu.setPreferredSize(new Dimension(50, 50));
                mainMenu.setIcon(new ImageIcon("C:\\Users\\mmk27\\IdeaProjects\\untitled\\image\\free-icon-house-802283.png"));
                mainMenu.addActionListener(e -> mainMenu(e));
                titlePanel.add(mainMenu, BorderLayout.EAST);
            }
            reservationPanel.add(titlePanel, BorderLayout.NORTH);

            //======== scrollPane1 ========
            {

                //======== movieListPanel ========
                {
                    movieListPanel.setMaximumSize(new Dimension(350, 32767));
                    movieListPanel.setMinimumSize(null);
                    movieListPanel.setPreferredSize(null);
                    movieListPanel.setLayout(new GridLayout(0, 1));
                }
                scrollPane1.setViewportView(movieListPanel);
            }
            reservationPanel.add(scrollPane1, BorderLayout.CENTER);
        }
        contentPane.add(reservationPanel, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
        this.setBounds(50,50,400, 600);
        showList();
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel reservationPanel;
    private JPanel titlePanel;
    private JLabel reservationTitle;
    private JButton mainMenu;
    private JScrollPane scrollPane1;
    private JPanel movieListPanel;
    private Movie[] movie;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    public void actionPerformed(ActionEvent e){
        for(int i=0; i<movieButton.length; i++) {
            if (e.getSource() == movieButton[i]) {
                movieSystem.setMovie(movie[i]);
                this.dispose();
                movieSystem.setSchedule();
            }
        }
    }// 이벤트 함수

    private void showList(){
        movie = movieSystem.getMovieList();
        movieButton = new JButton[movie.length];
        moviePanel = new JPanel[movie.length];

        for(int i=0; i<movie.length; i++) {
            moviePanel[i] = new JPanel();
            moviePanel[i].setLayout(new BoxLayout(moviePanel[i], BoxLayout.Y_AXIS));

            movieButton[i] = new JButton();
            movieButton[i].addActionListener(this::actionPerformed);
            BufferedImage image;
            try {
                //URL을 사용하는 경우
                URL url = new URL(movie[i].getPoaster());
                image = ImageIO.read(url);

            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Image resizeImage = image.getScaledInstance(270, 350, 4);
            ImageIcon icon = new ImageIcon(resizeImage);
            movieButton[i].setIcon(icon);

            JLabel name = new JLabel(movie[i].getName());
            name.setAlignmentX(Component.LEFT_ALIGNMENT);

            moviePanel[i].add(movieButton[i]);
            moviePanel[i].add(name);
            movieListPanel.add(moviePanel[i]);
        }
    }// 영화목록 출력함수
}
