package com.coursework.secondCoursework;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class JavaQuestionServiceTest {

    private JavaQuestionService javaQuestionService;

    @BeforeEach
    void setUp() {
        javaQuestionService = new JavaQuestionService();
    }

    @Test
    void testAddQuestion() {
        Question question = new Question("Что такое Java?", "Java это язык программирования.");
        javaQuestionService.addQuestion(question);
        Collection<Question> questions = javaQuestionService.getAllQuestions();
        assertEquals(1, questions.size());
        assertEquals(question, questions.iterator().next());
    }

    @Test
    void testRemoveQuestion() {
        Question question = new Question("Что такое Java?", "Java язык программирования.");
        javaQuestionService.addQuestion(question);
        javaQuestionService.removeQuestion(question);
        Collection<Question> questions = javaQuestionService.getAllQuestions();
        assertEquals(0, questions.size());
    }


    @Test
    void testGetAllQuestions() {
        List<Question> expectedQuestions = new ArrayList<>();
        expectedQuestions.add(new Question("Что такое Java?", "Java это язык программирования."));
        expectedQuestions.add(new Question("Что такое ООП?", "ООП это объектно ориентированное программирование."));
        for (Question question : expectedQuestions) {
            javaQuestionService.addQuestion(question);
        }

        Collection<Question> actualQuestions = javaQuestionService.getAllQuestions();
        assertEquals(expectedQuestions.size(), actualQuestions.size());
        assertEquals(expectedQuestions, actualQuestions);
    }
}




