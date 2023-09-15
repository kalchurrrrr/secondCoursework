package com.coursework.secondCoursework;


import java.util.Collection;

public interface QuestionService {
    void addQuestion(Question question);

    void removeQuestion(Question question);

    Collection<Question> getAllQuestions();
}
