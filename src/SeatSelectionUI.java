import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/*
 * Created by JFormDesigner on Tue May 31 16:47:22 KST 2022
 */



/**
 * @author unknown
 */
public class SeatSelectionUI extends JFrame {
    private Movie selectedMovie;
    private Schedule selectSchedule;
    private Seat selectedSeat;
    public SeatSelectionUI(Schedule selectSchedule, Movie selectedMoive) {
        this.selectSchedule = selectSchedule;
        this.selectedMovie = selectedMoive;
        initComponents();
    }
    private Seat[] list;
    private JButton[] seat = new JButton[20];
    private Icon seatImg = new ImageIcon("C:\\Users\\mmk27\\IdeaProjects\\untitled\\image\\seat.png");
    private Icon selectSeatImg = new ImageIcon("C:\\Users\\mmk27\\IdeaProjects\\untitled\\image\\selectSeat.png");
    private Icon selectedSeatImg = new ImageIcon("C:\\Users\\mmk27\\IdeaProjects\\untitled\\image\\selectedSeat.png");
    SeatSelectionSystem SeatSystem = new SeatSelectionSystem();
    private void MenuButton(ActionEvent e) {
        // TODO add your code here
        this.dispose();
        new MainUI();
    }
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - sangbaek kim
        panel2 = new JPanel();
        SeatTitle = new JLabel();
        button1 = new JButton();
        panel1 = new JPanel();
        ScreenLabel = new JLabel();
        No1 = new JLabel();
        No2 = new JLabel();
        No3 = new JLabel();
        No4 = new JLabel();
        NoA = new JLabel();
        NoB = new JLabel();
        NoC = new JLabel();
        NoD = new JLabel();
        NoE = new JLabel();

        //======== this ========
        setTitle("Moive Reservation");
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== panel2 ========
        {
            panel2.setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax
            .swing.border.EmptyBorder(0,0,0,0), "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn",javax.swing
            .border.TitledBorder.CENTER,javax.swing.border.TitledBorder.BOTTOM,new java.awt.
            Font("Dia\u006cog",java.awt.Font.BOLD,12),java.awt.Color.red
            ),panel2. getBorder()));panel2. addPropertyChangeListener(new java.beans.PropertyChangeListener(){@Override
            public void propertyChange(java.beans.PropertyChangeEvent e){if("\u0062ord\u0065r".equals(e.getPropertyName(
            )))throw new RuntimeException();}});
            panel2.setLayout(new BorderLayout());

            //---- SeatTitle ----
            SeatTitle.setText("\uc88c\uc11d \uc120\ud0dd");
            SeatTitle.setHorizontalTextPosition(SwingConstants.CENTER);
            SeatTitle.setHorizontalAlignment(SwingConstants.CENTER);
            panel2.add(SeatTitle, BorderLayout.CENTER);

            //---- button1 ----
            button1.setIcon(new ImageIcon("C:\\Users\\mmk27\\IdeaProjects\\untitled\\image\\free-icon-house-802283.png"));
            button1.setMinimumSize(new Dimension(50, 50));
            button1.setPreferredSize(new Dimension(50, 50));
            button1.addActionListener(e -> MenuButton(e));
            panel2.add(button1, BorderLayout.EAST);
        }
        contentPane.add(panel2, BorderLayout.NORTH);

        //======== panel1 ========
        {
            panel1.setLayout(new GridBagLayout());
            ((GridBagLayout)panel1.getLayout()).columnWidths = new int[] {0, 0, 11, 0, 0};

            //---- ScreenLabel ----
            ScreenLabel.setText("Screen");
            ScreenLabel.setHorizontalAlignment(SwingConstants.CENTER);
            panel1.add(ScreenLabel, new GridBagConstraints(1, 0, 4, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 30, 0), 0, 0));

            //---- No1 ----
            No1.setText("1");
            No1.setHorizontalAlignment(SwingConstants.CENTER);
            panel1.add(No1, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 30, 5), 0, 0));

            //---- No2 ----
            No2.setText("2");
            No2.setHorizontalAlignment(SwingConstants.CENTER);
            panel1.add(No2, new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 30, 5), 0, 0));

            //---- No3 ----
            No3.setText("3");
            No3.setHorizontalAlignment(SwingConstants.CENTER);
            panel1.add(No3, new GridBagConstraints(3, 1, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 30, 5), 0, 0));

            //---- No4 ----
            No4.setText("4");
            No4.setHorizontalAlignment(SwingConstants.CENTER);
            panel1.add(No4, new GridBagConstraints(4, 1, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 30, 0), 0, 0));

            //---- NoA ----
            NoA.setText("A");
            NoA.setHorizontalAlignment(SwingConstants.CENTER);
            panel1.add(NoA, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 30, 5), 0, 0));

            //---- NoB ----
            NoB.setText("B");
            NoB.setHorizontalAlignment(SwingConstants.CENTER);
            panel1.add(NoB, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 30, 5), 0, 0));

            //---- NoC ----
            NoC.setText("C");
            NoC.setHorizontalAlignment(SwingConstants.CENTER);
            panel1.add(NoC, new GridBagConstraints(0, 4, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 30, 5), 0, 0));

            //---- NoD ----
            NoD.setText("D");
            NoD.setHorizontalAlignment(SwingConstants.CENTER);
            panel1.add(NoD, new GridBagConstraints(0, 5, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 30, 5), 0, 0));

            //---- NoE ----
            NoE.setText("E");
            NoE.setHorizontalAlignment(SwingConstants.CENTER);
            panel1.add(NoE, new GridBagConstraints(0, 6, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 5), 0, 0));
        }
        contentPane.add(panel1, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setBounds(50,50,400, 600);

        list = SeatSystem.getSeatList(selectSchedule);

        for(int i=0; i<20; i++){
            seat[i] = new JButton();
            seat[i].setMargin(new Insets(3, 0, 3, 0));
            seat[i].setBorderPainted(false);
            seat[i].setContentAreaFilled(false);
            seat[i].setFocusPainted(false);

            if(list[i].isEmpty() == false){
                seat[i].setEnabled(false);
                seat[i].setIcon(selectedSeatImg);}
            else{
                seat[i].setIcon(seatImg);
                seat[i].setPressedIcon(selectSeatImg);
            }

            seat[i].addActionListener(this::actionPerformed);
            panel1.add(seat[i], new GridBagConstraints(i%4+1, i/4+2, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 5), 0, 0));
        }

    }
    private void actionPerformed(ActionEvent e){
        for(int i=0; i<seat.length; i++){
            if(seat[i] == e.getSource()){
                selectedSeat = list[i];
                SeatSystem.setSelectedSeat(selectedSeat);

                /****/
                //String seat = (char)('A'+i/4)+""+(i%4+1);
                //System.out.println(seat);
                /****/

                this.dispose();
                SeatSystem.credit(selectedMovie, selectSchedule);
            }
        }
    }
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - sangbaek kim
    private JPanel panel2;
    private JLabel SeatTitle;
    private JButton button1;
    private JPanel panel1;
    private JLabel ScreenLabel;
    private JLabel No1;
    private JLabel No2;
    private JLabel No3;
    private JLabel No4;
    private JLabel NoA;
    private JLabel NoB;
    private JLabel NoC;
    private JLabel NoD;
    private JLabel NoE;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
