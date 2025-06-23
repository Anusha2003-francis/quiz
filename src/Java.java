import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Java extends JFrame implements ActionListener {

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

  
        Java(String name) {
        Dimension ScreenSize=Toolkit.getDefaultToolkit().getScreenSize();
        setSize(ScreenSize.width,ScreenSize.height);
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        this.name = name;
        setBounds(0, 0, ScreenSize.width,ScreenSize.height);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        try {
            ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/java2.jpg"));
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
        questions[0][0] = "Which of the following is a valid keyword in java?";
        questions[0][1] = "interface"; questions[0][2] = "unsigned"; questions[0][3] = "friend"; questions[0][4] = "overload";

        questions[1][0] = "What is the size of an int variable in java?";
        questions[1][1] = "8 bits"; questions[1][2] = "16 bits"; questions[1][3] = "32 bits"; questions[1][4] = "64 bits";

        questions[2][0] = "Which of the following is used to create an object in java?";
        questions[2][1] = "class"; questions[2][2] = "object"; questions[2][3] = "new"; questions[2][4] = "malloc";

        questions[3][0] = "Which method is the entry point of a java program ?";
        questions[3][1] = "start()"; questions[3][2] = "run()"; questions[3][3] = "main()"; questions[3][4] = "init()";

        questions[4][0] = "Which of these is NOT a java access modifier?";
        questions[4][1] = "public"; questions[4][2] = "private"; questions[4][3] = "protected"; questions[4][4] = "internal";

        questions[5][0] = "What is used to handle exception in java?";
        questions[5][1] = "try-catch"; questions[5][2] = "catch-throw"; questions[5][3] = "do-catch"; questions[5][4] = "error-check";

        questions[6][0] = "Which keyword is used to inherit a class in java?";
        questions[6][1] = "implemect"; questions[6][2] = "inherits"; questions[6][3] = "extends"; questions[6][4] = "super";

        questions[7][0] = "What is the default value of a boolean variable in java?";
        questions[7][1] = "true"; questions[7][2] = "false"; questions[7][3] = "0"; questions[7][4] = "null";

        questions[8][0] = "What will System.out.println(10 + 20 + 'java')?";
        questions[8][1] = "30java"; questions[8][2] = "1020java"; questions[8][3] = "java1020"; questions[8][4] = "java30";

        questions[9][0] = "Which of the following is NOT primitive data type in java?";
        questions[9][1] = "int"; questions[9][2] = "boolean"; questions[9][3] = "string"; questions[9][4] = "float";

        answers[0][1] = "interface";
        answers[1][1] = "32 bits";
        answers[2][1] = "class";
        answers[3][1] = "main()";
        answers[4][1] = "internal";
        answers[5][1] = "try-catch";
        answers[6][1] = "extends";
        answers[7][1] = "false";
        answers[8][1] = "30java";
        answers[9][1] = "string";
    
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
        new Java("User");
    }
}
