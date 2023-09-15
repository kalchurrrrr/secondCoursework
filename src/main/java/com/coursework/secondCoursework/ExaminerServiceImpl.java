package com.coursework.secondCoursework;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final QuestionService questionService;

    @Autowired
    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        if (amount > questionService.getAllQuestions().size()) {
            throw new IncorrectAmountOfQuestionsException();
        }

        Set<Question> selectedQuestions = new HashSet<>();

        while (selectedQuestions.size() < amount) {
            Question randomQuestion = getRandomQuestion();
            selectedQuestions.add(randomQuestion);
        }

        return new ArrayList<>(selectedQuestions);
    }

    private Question getRandomQuestion() {
        Collection<Question> allQuestions = questionService.getAllQuestions();
        int randomIndex = (int) (Math.random() * allQuestions.size());
        return new ArrayList<>(allQuestions).get(randomIndex);
    }
}
