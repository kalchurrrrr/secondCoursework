package com.coursework.secondCoursework;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;

import java.util.ArrayList;
import java.util.Collection;

public class JavaQuestionService implements QuestionService {
    private final Collection<Question> questions;

    public JavaQuestionService() {
        this.questions = new ArrayList<>();
    }

    @Autowired(required = false)
    public JavaQuestionService(@Nullable QuestionService ignoredQuestionService) {
        this.questions = new ArrayList<>();
    }

    @Override
    public void addQuestion(Question question) {
        questions.add(question);
    }

    @Override
    public void removeQuestion(Question question) {
        questions.remove(question);
    }

    @Override
    public Collection<Question> getAllQuestions() {
        return questions;
    }
}
