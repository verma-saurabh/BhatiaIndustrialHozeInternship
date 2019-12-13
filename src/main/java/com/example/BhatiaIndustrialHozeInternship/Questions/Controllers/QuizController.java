package com.example.BhatiaIndustrialHozeInternship.Questions.Controllers;

import com.example.BhatiaIndustrialHozeInternship.Questions.Entity.Question;
import com.example.BhatiaIndustrialHozeInternship.Questions.Repositories.QuestionRepository;
import com.example.BhatiaIndustrialHozeInternship.Questions.implementations.QuestionImpl;
import com.example.BhatiaIndustrialHozeInternship.Questions.response.GetAllQuestionsResponse;
import com.example.BhatiaIndustrialHozeInternship.Questions.response.SaveQuestionResponse;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/Quiz/")
public class QuizController {


    @Autowired
    QuestionImpl questionImpl;


    @PostMapping(value = "/SaveQuestions")
    public ResponseEntity<?> saveQuestions(@RequestBody(required = true) String request) {

        SaveQuestionResponse response = null;
        try {
            response = questionImpl.saveQuestions(request);
            if (response != null) {
                return ResponseEntity.status(response.getStatusCode()).body(response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).contentType(MediaType.APPLICATION_JSON).body(null);

    }

    @GetMapping(value = "/Admin/SeeAllQuestions")
    public ResponseEntity<?> getAllQuestions(@RequestHeader(value = "x-apikey") String secret
            , @RequestParam(required = false) String tag) {

        GetAllQuestionsResponse response = null;
        if (secret == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).contentType(MediaType.APPLICATION_JSON).body(null);
        }

        if (!secret.equals("SecretAuthKey")) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).contentType(MediaType.APPLICATION_JSON).body(null);
        }

        if (tag != null && !tag.isEmpty()) {
            response = questionImpl.getAllQuestionsWithTag(tag.toString());
        } else {
            response = questionImpl.getAllQuestions();
        }


        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON)
                .body(response);

    }
}
