import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class C extends JFrame implements ActionListener {

    String[][] questions = new String[10][5];
    String[][] answers = new String[10][2];
    String[][] useranswers = new String[10][1];
        
    JLabel qno, question;
    JRadioButton opt1, opt2, opt3, opt4;
    ButtonGroup groupoptions;
    JButton next, submit, lifeline;

    public static int timer = 15;
    public static int ans_given = 0;
    public static int count = 0;
    public static int score = 0;

    String name;

    C(String name) {
        Dimension ScreenSize=Toolkit.getDefaultToolkit().getScreenSize();
        setSize(ScreenSize.width,ScreenSize.height);
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        this.name = name;
        setBounds(0, 0, ScreenSize.width,ScreenSize.height);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        try {
            ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/c++.jpg"));
            JLabel image = new JLabel(i1);
            image.setBounds(0,0, 1420, 392);
            add(image);
        } catch (Exception e) {
            System.out.println("Image not found");
        }

        qno = new JLabel();
        qno.setBounds(100, 450, 50, 30);
        qno.setFont(new Font("Tahoma", Font.PLAIN, 24));
        add(qno);

        question = new JLabel();
        question.setBounds(150, 450, 900, 30);
        question.setFont(new Font("Tahoma", Font.PLAIN, 24));
        add(question);

        setupQuestions();

        opt1 = createOption(170, 520);
        opt2 = createOption(170, 560);
        opt3 = createOption(170, 600);
        opt4 = createOption(170, 640);

        groupoptions = new ButtonGroup();
        groupoptions.add(opt1);
        groupoptions.add(opt2);
        groupoptions.add(opt3);
        groupoptions.add(opt4);

        next = createButton("Next", 1100, 550);
        lifeline = createButton("50-50 Lifeline", 1100, 630);
        submit = createButton("Submit", 1100, 710);
        submit.setEnabled(false);

        add(next);
        add(lifeline);
        add(submit);

        next.addActionListener(this);
        lifeline.addActionListener(this);
        submit.addActionListener(this);

        start(count);
        setVisible(true);
    }

    private void setupQuestions() {
        questions[0][0] = "What does C# stand for?";
        questions[0][1] = "Common Sharp"; questions[0][2] = "Code Sharp"; questions[0][3] = "C Sharp"; questions[0][4] = "Class Sharp";

        questions[1][0] = "Which of the following is the correct file extension for a C# source code file?";
        questions[1][1] = ".cs"; questions[1][2] = ".c"; questions[1][3] = ".cpp"; questions[1][4] = ".java";

        questions[2][0] = "Which keyword is used to define a class in C#?";
        questions[2][1] = "def"; questions[2][2] = "function"; questions[2][3] = "class"; questions[2][4] = "struct";

        questions[3][0] = "Which is the default access modifier for class member in C# ?";
        questions[3][1] = "public"; questions[3][2] = "private"; questions[3][3] = "protected"; questions[3][4] = "internal";

        questions[4][0] = "Which of the following is a value type in C#?";
        questions[4][1] = "String"; questions[4][2] = "Object"; questions[4][3] = "Int"; questions[4][4] = "Array";

        questions[5][0] = "What is used to handle exception in C#?";
        questions[5][1] = "try-catch"; questions[5][2] = "throw-catch"; questions[5][3] = "try-throw"; questions[5][4] = "error-check";

        questions[6][0] = "Which of these is NOT a C# keyword?";
        questions[6][1] = "namespace"; questions[6][2] = "new"; questions[6][3] = "main"; questions[6][4] = "static";

        questions[7][0] = "What is the correct syntax to create an object in C#?";
        questions[7][1] = "Car car= new Car();"; questions[7][2] = "Car= new Car();"; questions[7][3] = "Car Car();"; questions[7][4] = "Car.new() ";

        questions[8][0] = "Which operator is used for conditional expression in C#?";
        questions[8][1] = "&&"; questions[8][2] = "||"; questions[8][3] = "?:"; questions[8][4] = "::";

        questions[9][0] = "Which method is the entry point of a C# console application?";
        questions[9][1] = "Init()"; questions[9][2] = "Start()"; questions[9][3] = "Run()"; questions[9][4] = "Main()";

        answers[0][1] = "C Sharp";
        answers[1][1] = ".cs";
        answers[2][1] = "class";
        answers[3][1] = "private";
        answers[4][1] = "Int";
        answers[5][1] = "try-catch";
        answers[6][1] = "main";
        answers[7][1] = "Car car= new Car();";
        answers[8][1] = "?:";
        answers[9][1] = "Main()";
    }

    private JRadioButton createOption(int x, int y) {
        JRadioButton opt = new JRadioButton();
        opt.setBounds(x, y, 700, 30);
        opt.setBackground(Color.WHITE);
        opt.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt);
        return opt;
    }

    private JButton createButton(String text, int x, int y) {
        JButton btn = new JButton(text);
        btn.setBounds(x, y, 200, 40);
        btn.setFont(new Font("Tahoma", Font.PLAIN, 22));
        btn.setBackground(new Color(30, 144, 255));
        btn.setForeground(Color.WHITE);
        return btn;
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == next) {
            ans_given = 1;
            saveAnswer();

            if (count == 8) {
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            count++;
            start(count);
        } else if (ae.getSource() == lifeline) {
            if (count == 2 || count == 4 || count == 6 || count == 8 || count == 9) {
                opt2.setEnabled(false);
                opt3.setEnabled(false);
            } else {
                opt1.setEnabled(false);
                opt4.setEnabled(false);
            }
            lifeline.setEnabled(false);
        } else if (ae.getSource() == submit) {
            ans_given = 1;
            saveAnswer();
            calculateScore();
            setVisible(false);

            // ✅ REPLACE OR CREATE Score class as needed
            new DatabaseConnection().saveScore(name, score);
            new Score(name,score).setVisible(true);
           // JOptionPane.showMessageDialog(this, name + ", your score is: " + score);
        }
    }

    private void saveAnswer() {
        if (groupoptions.getSelection() == null) {
            useranswers[count][0] = "";
        } else {
            useranswers[count][0] = groupoptions.getSelection().getActionCommand();
        }
    }

    private void calculateScore() {
        for (int i = 0; i < useranswers.length; i++) {
            if (useranswers[i][0] != null && useranswers[i][0].equals(answers[i][1])) {
                score += 10;
            }
        }
    }

    public void paint(Graphics g) {
        super.paint(g);
        String time = "Time left - " + timer + " seconds";
        g.setColor(Color.RED);
        g.setFont(new Font("Tahoma", Font.BOLD, 25));

        if (timer > 0) {
            g.drawString(time, 1100, 500);
        } else {
            g.drawString("Times up!!", 1100, 500);
        }

        timer--;

        try {
            Thread.sleep(1000);
            repaint();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (ans_given == 1) {
            ans_given = 0;
            timer = 15;
        } else if (timer < 0) {
            timer = 15;
            saveAnswer();

            if (count == 8) {
                next.setEnabled(false);
                submit.setEnabled(true);
            }

            if (count == 9) {
                calculateScore();
               new Score(name,score).setVisible(true);
                
                //JOptionPane.showMessageDialog(this, name + ", your score is: " + score);
            } else {
                count++;
                start(count);
            }
        }
    }

    public void start(int count) {
        qno.setText((count + 1) + ". ");
        question.setText(questions[count][0]);

        opt1.setText(questions[count][1]);
        opt1.setActionCommand(questions[count][1]);

        opt2.setText(questions[count][2]);
        opt2.setActionCommand(questions[count][2]);

        opt3.setText(questions[count][3]);
        opt3.setActionCommand(questions[count][3]);

        opt4.setText(questions[count][4]);
        opt4.setActionCommand(questions[count][4]);

        groupoptions.clearSelection();

        opt1.setEnabled(true);
        opt2.setEnabled(true);
        opt3.setEnabled(true);
        opt4.setEnabled(true);
    }

    public static void main(String[] args) {
        new C("User");
    }
}
