import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/*
 * Created by JFormDesigner on Tue May 31 15:29:24 KST 2022
 */

/** 텍스트필드 배열로 하고 for문으로 빈 곳 있으면 경고창 띄우기 **/

/**
 * @author unknown
 */
public class CardCreditUI extends JFrame {
    private Movie movie;
    private Schedule schedule;
    private Seat seat;
    private int price;
    public CardCreditUI(Movie m, Schedule sc, Seat s) {
        movie = m;
        schedule = sc;
        seat = s;
        initComponents();
        comboBox1.addItem("월");
        for(int i = 1; i <13; i++){
            comboBox1.addItem(i+"월");
        }
        comboBox2.addItem("년");
        for(int i = 2022; i <= 2040; i++) {
            comboBox2.addItem(i+"년");
        }
    }

    private void button1(ActionEvent e) {

        if (textField1.getText().length() != 4 || textField2.getText().length() != 4 || textField3.getText().length() != 4 || textField4.getText().length() != 4)
            JOptionPane.showMessageDialog(null, "카드 번호가 입력되지 않았습니다", "경고", JOptionPane.ERROR_MESSAGE);
        else if (textField5.getText().length() != 3)
            JOptionPane.showMessageDialog(null, "CVC가 입력되지 않았습니다", "경고", JOptionPane.ERROR_MESSAGE);
        else if (textField6.getText().length() == 0 || textField7.getText().length() == 0)
            JOptionPane.showMessageDialog(null, "이름이 입력되지 않았습니다", "경고", JOptionPane.ERROR_MESSAGE);
        else if (comboBox1.getSelectedItem() == "월" || comboBox2.getSelectedItem() == "년")
            JOptionPane.showMessageDialog(null, "날짜가 선택되지 않았습니다", "경고", JOptionPane.ERROR_MESSAGE);
        else if (textField1.getText().matches("[+-]?\\d*(\\.\\d+)?") == false || textField2.getText().matches("[+-]?\\d*(\\.\\d+)?") == false || textField3.getText().matches("[+-]?\\d*(\\.\\d+)?") == false || textField4.getText().matches("[+-]?\\d*(\\.\\d+)?") == false)
            JOptionPane.showMessageDialog(null, "유효하지 않은 카드 번호입니다", "경고", JOptionPane.ERROR_MESSAGE);
        else {
            Dialog d = new Dialog(this, true);
            d.setSize(300, 200);
            JLabel l = new JLabel("결제중입니다");
            l.setHorizontalAlignment(JLabel.CENTER);
            l.setFont(new Font("맑은 고딕", Font.BOLD, 30));
            d.add(l);
            d.setLocationRelativeTo(null);
            DB db = new DB();
            db.DB_Insert_Ticket(movie, schedule, seat);
            new Thread() {
                public void run() {
                    for (int i = 0; i <= 3; i++) {
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {

                        }
                        d.dispose();
                    }
                }
            }.start();
            d.setVisible(true);

            JOptionPane.showMessageDialog(null, "결제가 완료되었습니다", null, JOptionPane.INFORMATION_MESSAGE);
            CreditSystem cs = new CreditSystem(movie, schedule, seat, price);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException r) {
            }
            this.dispose();
            new MainUI();
        }
    }

    private void comboBox1(ActionEvent e) {

    }

    private void button2(ActionEvent e) {
        int result = JOptionPane.showConfirmDialog(null, "결제를 취소하시겠습니까?", "결제 취소 확인", JOptionPane.YES_NO_OPTION);

        if(result == JOptionPane.YES_OPTION){
            JOptionPane.showMessageDialog(null, "예매가 취소되었습니다. 메인 화면으로 돌아갑니다.", "예매 취소", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
            new MainUI();

        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        label2 = new JLabel();
        textField1 = new JTextField();
        label3 = new JLabel();
        textField2 = new JTextField();
        label4 = new JLabel();
        textField3 = new JTextField();
        label5 = new JLabel();
        textField4 = new JTextField();
        label6 = new JLabel();
        comboBox1 = new JComboBox();
        comboBox2 = new JComboBox();
        label7 = new JLabel();
        label8 = new JLabel();
        label9 = new JLabel();
        textField5 = new JTextField();
        label10 = new JLabel();
        textField6 = new JTextField();
        label11 = new JLabel();
        textField7 = new JTextField();
        button1 = new JButton();
        button2 = new JButton();

        //======== this ========
        setVisible(true);
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("\uce74\ub4dc \uc815\ubcf4\ub97c \uc785\ub825\ud558\uc138\uc694");
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(label1);
        label1.setBounds(0, 0, 380, 65);

        //---- label2 ----
        label2.setText("\uce74\ub4dc\ubc88\ud638");
        contentPane.add(label2);
        label2.setBounds(new Rectangle(new Point(25, 140), label2.getPreferredSize()));
        contentPane.add(textField1);
        textField1.setBounds(85, 135, 55, textField1.getPreferredSize().height);

        //---- label3 ----
        label3.setText("-");
        contentPane.add(label3);
        label3.setBounds(new Rectangle(new Point(145, 140), label3.getPreferredSize()));
        contentPane.add(textField2);
        textField2.setBounds(155, 135, 55, 25);

        //---- label4 ----
        label4.setText("-");
        contentPane.add(label4);
        label4.setBounds(215, 140, 5, 17);
        contentPane.add(textField3);
        textField3.setBounds(225, 135, 55, 25);

        //---- label5 ----
        label5.setText("-");
        contentPane.add(label5);
        label5.setBounds(285, 140, 5, 17);
        contentPane.add(textField4);
        textField4.setBounds(295, 135, 55, 25);

        //---- label6 ----
        label6.setText("\uc720\ud6a8\uae30\uac04");
        contentPane.add(label6);
        label6.setBounds(25, 200, 48, 17);
        contentPane.add(comboBox1);
        comboBox1.setBounds(85, 195, 90, comboBox1.getPreferredSize().height);
        contentPane.add(comboBox2);
        comboBox2.setBounds(215, 195, 90, 30);

        //---- label7 ----
        label7.setText("\uc6d4");
        contentPane.add(label7);
        label7.setBounds(125, 180, label7.getPreferredSize().width, 15);

        //---- label8 ----
        label8.setText("\ub144");
        contentPane.add(label8);
        label8.setBounds(new Rectangle(new Point(245, 180), label8.getPreferredSize()));

        //---- label9 ----
        label9.setText("CVC");
        contentPane.add(label9);
        label9.setBounds(new Rectangle(new Point(25, 260), label9.getPreferredSize()));
        contentPane.add(textField5);
        textField5.setBounds(85, 255, 65, textField5.getPreferredSize().height);

        //---- label10 ----
        label10.setText("\uc774\ub984");
        contentPane.add(label10);
        label10.setBounds(new Rectangle(new Point(25, 325), label10.getPreferredSize()));
        contentPane.add(textField6);
        textField6.setBounds(85, 320, 65, textField6.getPreferredSize().height);

        //---- label11 ----
        label11.setText("\uc131");
        contentPane.add(label11);
        label11.setBounds(190, 325, 24, 17);
        contentPane.add(textField7);
        textField7.setBounds(250, 320, 65, 30);

        //---- button1 ----
        button1.setText("\uacb0\uc81c");
        button1.addActionListener(e -> button1(e));
        contentPane.add(button1);
        button1.setBounds(75, 460, 95, 40);

        //---- button2 ----
        button2.setText("\ucde8\uc18c");
        button2.addActionListener(e -> button2(e));
        contentPane.add(button2);
        button2.setBounds(215, 460, 95, 40);

        {
            // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < contentPane.getComponentCount(); i++) {
                Rectangle bounds = contentPane.getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = contentPane.getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            contentPane.setMinimumSize(preferredSize);
            contentPane.setPreferredSize(preferredSize);
        }
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JLabel label2;
    private JTextField textField1;
    private JLabel label3;
    private JTextField textField2;
    private JLabel label4;
    private JTextField textField3;
    private JLabel label5;
    private JTextField textField4;
    private JLabel label6;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JLabel label7;
    private JLabel label8;
    private JLabel label9;
    private JTextField textField5;
    private JLabel label10;
    private JTextField textField6;
    private JLabel label11;
    private JTextField textField7;
    private JButton button1;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
