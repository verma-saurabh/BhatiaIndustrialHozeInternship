package com.example.BhatiaIndustrialHozeInternship.Questions.response;


import com.example.BhatiaIndustrialHozeInternship.Questions.Entity.Question;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GetAllQuestionsResponse {
    private int statusCode;
    private String message;
    private List<Question> questions;
}
