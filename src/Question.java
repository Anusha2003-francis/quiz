public class Question {
    private String questionText;
    private String[] options;
    private String correctAnswer;

    public Question(String questionText, String[] options, String correctAnswer) {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    // Getters
    public String getQuestionText() { return questionText; }
    public String[] getOptions() { return options; }
    public String getCorrectAnswer() { return correctAnswer; }
}
