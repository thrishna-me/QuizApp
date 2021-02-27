package com.example.quizapp.model;

public class QuizQuestion {
    private String textQuestion;
    private boolean trueAnswer;

    public QuizQuestion(String textQuestion, boolean trueAnswer) {
        this.textQuestion = textQuestion;
        this.trueAnswer = trueAnswer;
    }

    public String getTextQuestion() {
        return textQuestion;
    }

    public void setTextQuestion(String textQuestion) {
        this.textQuestion = textQuestion;
    }

    public boolean isTrueAnswer() {
        return trueAnswer;
    }

    public void setTrueAnswer(boolean trueAnswer) {
        this.trueAnswer = trueAnswer;
    }
}
