import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/*
 * Created by JFormDesigner on Sat May 21 21:46:24 KST 2022
 */



/**
 * @author unknown
 */
public class MainUI extends JFrame {
    public MainUI() {
        initComponents();
    }

    private void reservation(ActionEvent e) {
        this.dispose();
        new MovieSelectionUI();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - sangbaek kim
        panel1 = new JPanel();
        adminMenu = new JButton();
        reservation = new JButton();
        search = new JButton();
        cancle = new JButton();
        purchase = new JButton();
        customerMenu = new JButton();

        //======== this ========
        setBackground(new Color(51, 51, 51));
        setVisible(true);
        setTitle("Moive Kiosk");
        setMinimumSize(new Dimension(350, 600));
        setResizable(false);
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== panel1 ========
        {
            panel1.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax.
            swing. border. EmptyBorder( 0, 0, 0, 0) , "JFor\u006dDesi\u0067ner \u0045valu\u0061tion", javax. swing. border
            . TitledBorder. CENTER, javax. swing. border. TitledBorder. BOTTOM, new java .awt .Font ("Dia\u006cog"
            ,java .awt .Font .BOLD ,12 ), java. awt. Color. red) ,panel1. getBorder
            ( )) ); panel1. addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java
            .beans .PropertyChangeEvent e) {if ("bord\u0065r" .equals (e .getPropertyName () )) throw new RuntimeException
            ( ); }} );
            panel1.setLayout(null);

            //---- adminMenu ----
            adminMenu.setIcon(new ImageIcon("C:\\Users\\mmk27\\IdeaProjects\\untitled\\image\\free-icon-system-3247987.png"));
            panel1.add(adminMenu);
            adminMenu.setBounds(295, 15, 50, 50);

            //---- reservation ----
            reservation.setIcon(null);
            reservation.setBackground(Color.white);
            reservation.setForeground(Color.black);
            reservation.setText("\uc601\ud654\uc608\ub9e4");
            reservation.addActionListener(e -> reservation(e));
            panel1.add(reservation);
            reservation.setBounds(55, 125, 230, 65);

            //---- search ----
            search.setText("\uc608\ub9e4\uc870\ud68c");
            search.setBackground(Color.white);
            search.setForeground(Color.black);
            panel1.add(search);
            search.setBounds(55, 210, 230, 65);

            //---- cancle ----
            cancle.setText("\uc608\ub9e4\ucde8\uc18c");
            cancle.setBackground(Color.white);
            cancle.setForeground(Color.black);
            panel1.add(cancle);
            cancle.setBounds(55, 295, 230, 65);

            //---- purchase ----
            purchase.setText("\uc2a4\ub0b5\uad6c\ub9e4");
            purchase.setBackground(Color.white);
            purchase.setForeground(Color.black);
            panel1.add(purchase);
            purchase.setBounds(55, 380, 230, 65);

            //---- customerMenu ----
            customerMenu.setText("\uace0\uac1d\uba54\ub274");
            customerMenu.setBackground(Color.white);
            customerMenu.setForeground(Color.black);
            panel1.add(customerMenu);
            customerMenu.setBounds(55, 470, 230, 65);

            {
                // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < panel1.getComponentCount(); i++) {
                    Rectangle bounds = panel1.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = panel1.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                panel1.setMinimumSize(preferredSize);
                panel1.setPreferredSize(preferredSize);
            }
        }
        contentPane.add(panel1, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
        this.setBounds(50,50,400, 600);
    }
    public static void main(String[] args){
        new MainUI();
    }
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - sangbaek kim
    private JPanel panel1;
    private JButton adminMenu;
    private JButton reservation;
    private JButton search;
    private JButton cancle;
    private JButton purchase;
    private JButton customerMenu;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
