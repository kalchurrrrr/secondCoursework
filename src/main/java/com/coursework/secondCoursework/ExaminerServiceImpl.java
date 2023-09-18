package com.coursework.secondCoursework;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final QuestionService questionService;

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
            selectedQuestions.add(questionService.getRandomQuestion());
        }

        return new HashSet<>(selectedQuestions);
    }

}
