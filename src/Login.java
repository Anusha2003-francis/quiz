import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener {

    JButton rulesButton, backButton;
    JTextField tfname;

    Login() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        Dimension ScreenSize=Toolkit.getDefaultToolkit().getScreenSize();
        setSize(ScreenSize.width,ScreenSize.height);
        setExtendedState(JFrame.MAXIMIZED_BOTH);


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/quiz.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0,800,800);
        add(image);

        JLabel heading = new JLabel("Simple Minds");
        heading.setBounds(1020, 60, 300, 45);
        heading.setFont(new Font("Times new roman", Font.BOLD, 40));
        heading.setForeground(new Color(0,0,0));
        add(heading);

        JLabel nameLabel = new JLabel("Enter your name");
        nameLabel.setBounds(1020, 150, 300, 20);
        nameLabel.setFont(new Font("Mongolian Baiti", Font.BOLD, 18));
        nameLabel.setForeground(new Color(0,0,0));
        add(nameLabel);

        tfname = new JTextField();
        tfname.setBounds(1020, 200, 300, 25);
        tfname.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(tfname);

        rulesButton = new JButton("Rules");
        rulesButton.setBounds(1020, 270, 120, 25);
        rulesButton.setBackground(new Color(0,0,0));
        rulesButton.setForeground(Color.WHITE);
        rulesButton.addActionListener(this);
        add(rulesButton);

        backButton = new JButton("Back");
        backButton.setBounds(1200, 270, 120, 25);
        backButton.setBackground(new Color(0,0,0));
        backButton.setForeground(Color.WHITE);
        backButton.addActionListener(this);
        add(backButton);

        setSize(1200, 500);
        setLocation(200, 150);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == rulesButton) {
            String name = tfname.getText();
            setVisible(false);
            new Rules(name);  // Make sure you have this class implemented
        } else if (ae.getSource() == backButton) {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
