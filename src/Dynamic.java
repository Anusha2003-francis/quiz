import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class Dynamic extends JFrame implements ActionListener {
    private List<Question> questions;
    private int currentQuestionIndex = 0;
    private int score = 0;

    private JLabel questionLabel;
    private JRadioButton[] optionButtons;
    private ButtonGroup optionsGroup;
    private JButton nextButton;
    private JPanel optionsPanel;

    public Dynamic(List<Question> questions) {
        this.questions = questions;
        setupUI();
        displayQuestion(currentQuestionIndex);
    }

    private void setupUI() {
        setTitle("Dynamic Quiz");
        setSize(600, 400);
        setLayout(new BorderLayout());
        getContentPane().setBackground(new Color(230, 240, 255)); // Light blue background

        questionLabel = new JLabel("Question");
        questionLabel.setFont(new Font("Arial", Font.BOLD, 16));
        questionLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(questionLabel, BorderLayout.NORTH);

        optionsPanel = new JPanel(new GridLayout(4, 1));
        optionsPanel.setBackground(new Color(255, 255, 255)); // White background for options
        optionButtons = new JRadioButton[4];
        optionsGroup = new ButtonGroup();
        for (int i = 0; i < 4; i++) {
            optionButtons[i] = new JRadioButton();
            optionButtons[i].setBackground(new Color(255, 255, 255));
            optionsGroup.add(optionButtons[i]);
            optionsPanel.add(optionButtons[i]);
        }
        add(optionsPanel, BorderLayout.CENTER);

        nextButton = new JButton("Next");
        nextButton.setBackground(new Color(100, 149, 237)); // Cornflower blue
        nextButton.setForeground(Color.WHITE);
        nextButton.setFont(new Font("Arial", Font.BOLD, 14));
        nextButton.addActionListener(this);
        JPanel bottomPanel = new JPanel();
        bottomPanel.setBackground(new Color(230, 240, 255));
        bottomPanel.add(nextButton);
        add(bottomPanel, BorderLayout.SOUTH);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void displayQuestion(int index) {
        if (index < questions.size()) {
            Question q = questions.get(index);
            questionLabel.setText("Q" + (index + 1) + ": " + q.getQuestionText());
            String[] options = q.getOptions();
            for (int i = 0; i < 4; i++) {
                optionButtons[i].setText(options[i]);
                optionButtons[i].setActionCommand(options[i]);
            }
            optionsGroup.clearSelection();
        } else {
            JOptionPane.showMessageDialog(this, "Quiz over! Your score: " + score);
            System.exit(0);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String selectedOption = optionsGroup.getSelection() != null ? optionsGroup.getSelection().getActionCommand() : "";
        if (selectedOption.equals(questions.get(currentQuestionIndex).getCorrectAnswer())) {
            score += 10;
        }
        currentQuestionIndex++;
        displayQuestion(currentQuestionIndex);
    }

    public static void main(String[] args) {
        List<Question> userQuestions = QuizInput.getUserDefinedQuestions();
        new Dynamic(userQuestions);
    }
}
