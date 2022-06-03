import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/*
 * Created by JFormDesigner on Tue May 31 14:05:07 KST 2022
 */



/**
 * @author unknown
 */
public class CreditUI extends JFrame {
    private Movie selectedMovie;
    private Schedule selectedSchedule;
    private Seat selectedSeat;
    private boolean selectedCredit=true;

    public CreditUI(Movie m, Schedule sd, Seat s) {
        selectedMovie = m;
        selectedSchedule  = sd;
        selectedSeat = s;
        initComponents();
        label1.setText(String.valueOf(s.getPrice())+"원");
    }

    private void button2(ActionEvent e) { //
        if(selectedCredit == false){
            this.dispose();
            new CardCreditUI(selectedMovie, selectedSchedule, selectedSeat);
        }
    }

    private void itemEvent(ItemEvent e) {
        Object obj = e.getItem();
        if(obj == "카드 결제"){
            selectedCredit = false;
        }
    }

    private void button3(ActionEvent e) {
        int result = JOptionPane.showConfirmDialog(null, "결제를 취소하시겠습니까?", "결제 취소 확인", JOptionPane.YES_NO_OPTION);

        if(result == JOptionPane.YES_OPTION){
            JOptionPane.showMessageDialog(null, "예매가 취소되었습니다. 메인 화면으로 돌아갑니다.", "예매 취소", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
            new MainUI();

        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - sangbaek kim
        radioButton1 = new JRadioButton();
        radioButton2 = new JRadioButton();
        checkBox1 = new JCheckBox();
        label2 = new JLabel();
        button1 = new JButton();
        label3 = new JLabel();
        label4 = new JLabel();
        button2 = new JButton();
        button3 = new JButton();
        textField1 = new JTextField();
        label1 = new JLabel();

        //======== this ========
        setVisible(true);
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- radioButton1 ----
        radioButton1.setText("\ud3ec\uc778\ud2b8 \uacb0\uc81c");
        radioButton1.addItemListener(e -> itemEvent(e));
        contentPane.add(radioButton1);
        radioButton1.setBounds(50, 140, radioButton1.getPreferredSize().width, 26);

        //---- radioButton2 ----
        radioButton2.setText("\uce74\ub4dc \uacb0\uc81c");
        radioButton2.addItemListener(e -> itemEvent(e));
        contentPane.add(radioButton2);
        radioButton2.setBounds(250, 140, radioButton2.getPreferredSize().width, 26);

        //---- checkBox1 ----
        checkBox1.setText("\ud3ec\uc778\ud2b8 \uc801\ub9bd");
        contentPane.add(checkBox1);
        checkBox1.setBounds(50, 270, checkBox1.getPreferredSize().width, 27);

        //---- label2 ----
        label2.setText("\ubcf4\uc720 \ud3ec\uc778\ud2b8 :");
        contentPane.add(label2);
        label2.setBounds(175, 325, 75, 30);

        //---- button1 ----
        button1.setText("\ud68c\uc6d0 \ud655\uc778");
        contentPane.add(button1);
        button1.setBounds(175, 270, button1.getPreferredSize().width, 35);

        //---- label3 ----
        label3.setText("\uacb0\uc81c \ubc29\ubc95 \uc120\ud0dd");
        label3.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(label3);
        label3.setBounds(0, 0, 380, 65);

        //---- label4 ----
        label4.setText("\uacb0\uc81c \uae08\uc561 :");
        contentPane.add(label4);
        label4.setBounds(190, 65, 70, 35);

        //---- button2 ----
        button2.setText("\uacb0\uc81c");
        button2.addActionListener(e -> button2(e));
        contentPane.add(button2);
        button2.setBounds(80, 445, 100, 50);

        //---- button3 ----
        button3.setText("\uacb0\uc81c\ucde8\uc18c");
        button3.addActionListener(e -> button3(e));
        contentPane.add(button3);
        button3.setBounds(215, 445, 100, 50);
        contentPane.add(textField1);
        textField1.setBounds(250, 325, 85, 30);
        contentPane.add(label1);
        label1.setBounds(265, 65, 105, 35);

        contentPane.setPreferredSize(new Dimension(380, 590));
        pack();
        setLocationRelativeTo(getOwner());

        //---- buttonGroup1 ----
        var buttonGroup1 = new ButtonGroup();
        buttonGroup1.add(radioButton1);
        buttonGroup1.add(radioButton2);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //radioButton1.setEnabled(false);
        radioButton2.setSelected(true);
        checkBox1.setEnabled(false);
        textField1.setEnabled(false);
        //button1.setEnabled(false);
    }
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - sangbaek kim
    private JRadioButton radioButton1;
    private JRadioButton radioButton2;
    private JCheckBox checkBox1;
    private JLabel label2;
    private JButton button1;
    private JLabel label3;
    private JLabel label4;
    private JButton button2;
    private JButton button3;
    private JTextField textField1;
    private JLabel label1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
