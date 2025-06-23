import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class QuizInput {
    public static List<Question> getUserDefinedQuestions() {
        List<Question> questions = new ArrayList<>();
        int numQuestions = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of questions:"));

        for (int i = 0; i < numQuestions; i++) {
            String questionText = JOptionPane.showInputDialog("Enter question " + (i + 1) + ":");
            String[] options = new String[4];
            for (int j = 0; j < 4; j++) {
                options[j] = JOptionPane.showInputDialog("Enter option " + (j + 1) + " for question " + (i + 1) + ":");
            }
            String correctAnswer = JOptionPane.showInputDialog("Enter the correct answer for question " + (i + 1) + ":");
            questions.add(new Question(questionText, options, correctAnswer));
        }
        return questions;
    }

    void setVisible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
