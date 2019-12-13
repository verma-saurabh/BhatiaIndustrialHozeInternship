package com.example.BhatiaIndustrialHozeInternship.Questions.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SaveQuestionResponse {
    private int numberOfQuestions;
    private int statusCode;
    private String message;
}
