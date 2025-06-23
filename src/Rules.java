/*import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Rules extends JFrame implements ActionListener {

    String name;
    JButton start, back;

    Rules(String name) {
        this.name = name;
        
        Dimension ScreenSize=Toolkit.getDefaultToolkit().getScreenSize();
        setSize(ScreenSize.width,ScreenSize.height);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        JLabel heading = new JLabel("Welcome " + name + " to Simple Minds");
        heading.setBounds(50, 20, 700, 30);
        heading.setFont(new Font("times new roman", Font.BOLD, 28));
        heading.setForeground(new Color(255,255,255));
        add(heading);

        JLabel rulesLabel = new JLabel();
        rulesLabel.setBounds(20, 90, 700, 350);
        rulesLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        rulesLabel.setForeground(new Color(255,255,255));
        rulesLabel.setText(
            "<html>" +
                "1. Participants must not use mobile phones, tablets, or any other electronic devices to search for answers during the quiz. .<br><br>" +
                "2. Answers should be submitted within the specified time limit for each question. For instance, some quizzes allow 15 seconds per question, and answers must be submitted within this timeframe to earn points.<br><br>" +
                "3. Each question should have only one correct answer. This ensures that participants can confidently choose the right option without ambiguity.<br><br>" +
                "4. The question and options should be straightforward and free from unnecessary complexity. This ensures that participants understand what's being asked without misinterpretation.<br><br>" +
                
            "</html>"
        );
        add(rulesLabel);

        back = new JButton("Back");
        back.setBounds(250, 500, 100, 30);
        back.setBackground(new Color(255, 255, 255));
        back.setForeground(Color.BLACK);
        back.addActionListener(this);
        add(back);

        start = new JButton("Start");
        start.setBounds(400, 500, 100, 30);
        start.setBackground(new Color(255, 255, 255));
        start.setForeground(Color.BLACK);
        start.addActionListener(this);
        add(start);
        
 ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/rules.jpg"));
        Image i2 = i1.getImage().getScaledInstance(ScreenSize.width,ScreenSize.height ,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,ScreenSize.width,ScreenSize.height);
        add(image);
        
        setSize(800, 650);
        setLocation(350, 100);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == start) {
            setVisible(false);
            new topic().setVisible(true); // Make sure Quiz class exists
        } else {
            setVisible(false);
            new Login(); // Make sure Login class exists
        }
    }

    public static void main(String[] args) {
        new Rules("User");
    }
}

*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Rules extends JFrame implements ActionListener {

    String name;
    JButton start, back;

    Rules(String name) {
        this.name = name;
        getContentPane().setBackground(Color.BLACK);
        setLayout(null);

        JLabel heading = new JLabel("Welcome " + name + " to Simple Minds");
        heading.setBounds(50, 20, 700, 30);
        heading.setFont(new Font("times new roman", Font.BOLD, 28));
        heading.setForeground(new Color(255,255,255));
        add(heading);

        JLabel rulesLabel = new JLabel();
        rulesLabel.setBounds(20, 90, 700, 350);
        rulesLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        rulesLabel.setForeground(new Color(255,255,255));
        rulesLabel.setText(
            "<html>" +
                "1. Participants must not use mobile phones, tablets, or any other electronic devices to search for answers during the quiz. .<br><br>" +
                "2. Answers should be submitted within the specified time limit for each question. For instance, some quizzes allow 15 seconds per question, and answers must be submitted within this timeframe to earn points.<br><br>" +
                "3. Each question should have only one correct answer. This ensures that participants can confidently choose the right option without ambiguity.<br><br>" +
                "4. The question and options should be straightforward and free from unnecessary complexity. This ensures that participants understand what's being asked without misinterpretation.<br><br>" +
                
            "</html>"
        );
        add(rulesLabel);

        back = new JButton("Back");
        back.setBounds(250, 500, 100, 30);
        back.setBackground(new Color(255, 255, 255));
        back.setForeground(Color.BLACK);
        back.addActionListener(this);
        add(back);

        start = new JButton("Start");
        start.setBounds(400, 500, 100, 30);
        start.setBackground(new Color(255, 255, 255));
        start.setForeground(Color.BLACK);
        start.addActionListener(this);
        add(start);

        setSize(800, 650);
        setLocation(350, 100);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == start) {
            setVisible(false);
            new topic().setVisible(true); 
        } else {
            setVisible(false);
            new Login(); 
        }
    }

    public static void main(String[] args) {
        new Rules("User");
    }
}
