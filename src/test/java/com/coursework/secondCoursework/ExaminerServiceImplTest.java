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

class ExaminerServiceImplTest {
    @Mock
    private QuestionService questionService;

    private ExaminerServiceImpl examinerService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        examinerService = new ExaminerServiceImpl(questionService);
    }

    @Test
    void testGetQuestions() {
        Collection<Question> availableQuestions = new ArrayList<>();
        availableQuestions.add(new Question("Что такое Java?", "Java это язык программирования."));
        availableQuestions.add(new Question("Что такое ООП?", "ООП это объектно-ориентированное программирование."));
        when(questionService.getAllQuestions()).thenReturn(availableQuestions);

        Collection<Question> questions = examinerService.getQuestions(2);

        assertEquals(2, questions.size());
        verify(questionService, times(2)).getAllQuestions();
    }
}
