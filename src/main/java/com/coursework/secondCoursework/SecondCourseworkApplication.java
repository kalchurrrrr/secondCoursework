package com.coursework.secondCoursework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SecondCourseworkApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecondCourseworkApplication.class, args);
	}

	@Bean
	public QuestionService questionService() {
		return new JavaQuestionService();
	}
}
