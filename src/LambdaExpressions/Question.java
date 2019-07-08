package LambdaExpressions;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Question {

    private Predicate<Question> question;

    public enum Classification {
        JAVA, SECURITY, INTERVIEW
    }

    private String statement;
    private LocalDate dateAdded;
    private Classification questionType;

    public String getStatement() {
        return statement;
    }

    public void setStatement(String statement) {
        this.statement = statement;
    }

    public LocalDate getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(LocalDate dateAdded) {
        this.dateAdded = dateAdded;
    }

    public Classification getQuestionType() {
        return questionType;
    }

    public void setQuestionType(Classification questionType) {
        this.questionType = questionType;
    }

    private static void getSecurityQuestions(List<Question> questions) {
        for (Question question: questions) {
            if (question.getQuestionType() == Classification.SECURITY) {
                System.out.println(question.getStatement());
            }
        }
    }

    private static List<Question> populateSecurityQuestions() {
        List<Question> securityQuestions = new ArrayList<>();
        Question question = new Question();
        question.setDateAdded(LocalDate.now());
        question.setQuestionType(Classification.SECURITY);
        question.setStatement("What are we building?");
        securityQuestions.add(question);

        question = new Question();
        question.setDateAdded(LocalDate.now());
        question.setQuestionType(Classification.SECURITY);
        question.setStatement("What can go wrong?");
        securityQuestions.add(question);

        return securityQuestions;
    }

    private static List<Question> populateJavaQuestions() {
        List<Question> javaQuestions = new ArrayList<>();
        Question question = new Question();
        question.setDateAdded(LocalDate.now());
        question.setQuestionType(Classification.JAVA);
        question.setStatement("What are the features of Java?");
        javaQuestions.add(question);

        question = new Question();
        question.setDateAdded(LocalDate.now());
        question.setQuestionType(Classification.JAVA);
        question.setStatement("What is a Class?");
        javaQuestions.add(question);

        return javaQuestions;
    }

    interface Predicate<T> {
        boolean filter(Question question);
    }

    private static void getSecurityQuestionsWithPredicate(List<Question> questions, Predicate<Question> question) {
        for (Question q: questions) {
            if (question.filter(q)) {
                System.out.println(q.getStatement());
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Hello, Lambda Expression!");
        List<Question> allQuestions = new ArrayList<>();
        allQuestions.addAll(populateJavaQuestions());
        allQuestions.addAll(populateSecurityQuestions());

        getSecurityQuestions(allQuestions);

        getSecurityQuestionsWithPredicate(allQuestions,
                (Question question) -> question.getQuestionType() == Classification.JAVA);
    }
}
