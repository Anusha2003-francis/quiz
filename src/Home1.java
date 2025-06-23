import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Home1 extends JFrame implements ActionListener {

    JButton  startButton;
    

    Home1() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        Dimension ScreenSize=Toolkit.getDefaultToolkit().getScreenSize();
        setSize(ScreenSize.width,ScreenSize.height);
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/home2.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0,ScreenSize.width,ScreenSize.height);
        add(image);

      
       

        startButton = new JButton("start");
        startButton.setBounds(700, 650, 100, 25);
        startButton.setBackground(new Color(0, 0, 0));
        startButton.setForeground(Color.WHITE);
        startButton.addActionListener(this);
        add(startButton);

        setSize(1200, 500);
        setLocation(200, 150);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == startButton) {
            
            new Login().setVisible(true);
              // Make sure you have this class implemented

        }
    }

    public static void main(String[] args) {
        Home1 ho=new Home1();
    }
}

