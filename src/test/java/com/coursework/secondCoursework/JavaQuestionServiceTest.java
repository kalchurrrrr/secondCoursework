package com.coursework.secondCoursework;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class JavaQuestionServiceTest {
    @Mock
    private QuestionService questionService;
    private JavaQuestionService javaQuestionService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        javaQuestionService = new JavaQuestionService(questionService);
    }

    @Test
    void testAddQuestion() {
        Question question = new Question("What is Java?", "Java is a programming language.");
        javaQuestionService.addQuestion(question);
        verify(questionService).addQuestion(question);
    }

    @Test
    void testRemoveQuestion() {
        Question question = new Question("Что такое Java?", "Java язык программирования.");
        javaQuestionService.removeQuestion(question);
        verify(questionService).removeQuestion(question);
    }

    @Test
    void testGetAllQuestions() {
        List<Question> expectedQuestions = new ArrayList<>();
        expectedQuestions.add(new Question("Что такое Java?", "Java это язык программирования."));
        expectedQuestions.add(new Question("Что такое ООП?", "ООП это объектно ориентированное программирование."));
        when(questionService.getAllQuestions()).thenReturn(expectedQuestions);
        Collection<Question> actualQuestions = javaQuestionService.getAllQuestions();
        assertEquals(expectedQuestions, actualQuestions);
    }
}




