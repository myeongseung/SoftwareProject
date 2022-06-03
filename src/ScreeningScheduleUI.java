import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

/*
 * Created by JFormDesigner on Fri May 27 20:16:20 KST 2022
 */



/**
 * @author unknown
 */

public class ScreeningScheduleUI extends JFrame {
    private Movie selectedMoive;//앞에서 선택된 영화
    private JButton[] ScheduleButton;
    private List<Schedule> ScheduleList = new ArrayList<>();//스케줄 목록
    private Schedule selectedSchedule;// 선택할 스케쥴
    private ScheduleSelectionSystem scheduleSystem = new ScheduleSelectionSystem();//UI에서 컨트롤 객체보유
    public ScreeningScheduleUI(Movie selectedMoive){
        ScheduleList = scheduleSystem.getScheduleList(selectedMoive.getName());/** 여기서 가져오는것 **/
        initComponents();
        this.selectedMoive = selectedMoive;
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - sangbaek kim
    private JLabel movieTitle;
    private JButton mainMenu;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - sangbaek kim
        movieTitle = new JLabel();
        mainMenu = new JButton();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- movieTitle ----
        movieTitle.setHorizontalAlignment(SwingConstants.CENTER);
        movieTitle.setPreferredSize(new Dimension(48, 13));
        contentPane.add(movieTitle);
        movieTitle.setBounds(0, 0, 330, 50);

        //---- mainMenu ----
        mainMenu.setMinimumSize(new Dimension(50, 50));
        mainMenu.setPreferredSize(new Dimension(50, 50));
        mainMenu.setBackground(new Color(0, 0, 0, 0));
        mainMenu.setIcon(new ImageIcon("C:\\Users\\mmk27\\IdeaProjects\\untitled\\image\\free-icon-house-802283.png"));
        mainMenu.setMaximumSize(new Dimension(50, 50));
        mainMenu.addActionListener(e -> mainMenu(e));
        contentPane.add(mainMenu);
        mainMenu.setBounds(310, 0, 70, 65);

        contentPane.setPreferredSize(new Dimension(380, 590));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents

        this.setBounds(50,50,400, 600);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        movieTitle.setText(ScheduleList.get(0).getName());


        showList();
    }

    public void actionPerformed(ActionEvent e){
        JButton b = (JButton)e.getSource();

        for(int i = 0; i < ScheduleList.size(); i++){
            String text = "<HTML>" + ScheduleList.get(i).getTime().substring(0, 5) + "<br>" + ScheduleList.get(i).getHall() + "관 </HTML>";
            if(b.getText().equals(text)){
                selectedSchedule = ScheduleList.get(i);
                break;
            }
        }
        scheduleSystem.setSelectSchedule(selectedSchedule);
        this.dispose();
        scheduleSystem.setSeat(selectedMoive);

    }

    private void mainMenu(ActionEvent e) {
        this.dispose();
        new MainUI();
    }

    private void showList(){
        int x = 50;
        int y = 100;
        int count = 0;
        for(int i = 0; i < ScheduleList.size(); i++){
            ScheduleButton = new JButton[ScheduleList.size()];

            ScheduleButton[i] = new JButton("<HTML>" + ScheduleList.get(i).getTime().substring(0, 5) + "<br>" + ScheduleList.get(i).getHall() + "관 </HTML>");
            add(ScheduleButton[i]);
            ScheduleButton[i].setBounds(x, y, 80, 60);
            ScheduleButton[i].addActionListener(this::actionPerformed);
            x += 100;
            count++;
            if(count == 3){
                x = 50;
                y += 80;
                count = 0;
            }
        }
    }
}
