package com.coursework.secondCoursework;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {
    private final Collection<Question> questions;

    public JavaQuestionService() {
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
    public Question getRandomQuestion() {
        int max = questions.size();
        List<Question> questionsList = new ArrayList<>(questions);
        return questionsList.get((int) (Math.random() * max));
    }


    @Override
    public Collection<Question> getAllQuestions() {
        return questions;
    }

}
