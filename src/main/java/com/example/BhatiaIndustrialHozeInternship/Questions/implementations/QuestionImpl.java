package com.example.BhatiaIndustrialHozeInternship.Questions.implementations;

import com.example.BhatiaIndustrialHozeInternship.Questions.Entity.Question;
import com.example.BhatiaIndustrialHozeInternship.Questions.Repositories.QuestionRepository;
import com.example.BhatiaIndustrialHozeInternship.Questions.response.GetAllQuestionsResponse;
import com.example.BhatiaIndustrialHozeInternship.Questions.response.SaveQuestionResponse;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class QuestionImpl {

    @Autowired
    QuestionRepository questionRepository;

    public SaveQuestionResponse saveQuestions(String request) {

        SaveQuestionResponse response = null;
        int count = 0;
        try {
            response = new SaveQuestionResponse();

            JSONObject quiz = new JSONObject(request).getJSONObject("quiz");
            for (String key : quiz.keySet()) {
                JSONObject quizTag = quiz.getJSONObject(key);
                for (String quesNumber : quizTag.keySet()) {
                    JSONObject question = quizTag.getJSONObject(quesNumber);
                    Question ques = new Question();
                    ques.setQuestion(question.getString("question"));
                    ques.setAnswer(question.getString("answer"));
                    ques.setOpt(question.getJSONArray("options").toString());
                    ques.setTag(key);
                    questionRepository.save(ques);
                    count++;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        response.setStatusCode(200);
        response.setNumberOfQuestions(count);
        response.setMessage("Success");
        return response;

    }

    public GetAllQuestionsResponse getAllQuestions() {
        GetAllQuestionsResponse response = null;
        List<Question> questions = null;

        try {
            questions = questionRepository.findAll();
            response = new GetAllQuestionsResponse();
            int count = questions.size();
            response.setStatusCode(200);
            response.setMessage("found " + count + " questions");
            response.setQuestions(questions);

        } catch (Exception e) {
            e.printStackTrace();
            response.setStatusCode(500);
            response.setMessage("Internal Server Error");
            response.setQuestions(null);
            return response;
        }

        return response;
    }

    public GetAllQuestionsResponse getAllQuestionsWithTag(String tag) {
        GetAllQuestionsResponse response = null;
        List<Question> questions = null;

        try {
            questions = questionRepository.findByTag(tag);
            response = new GetAllQuestionsResponse();
            int count = questions.size();
            response.setStatusCode(200);
            response.setMessage("found " + count + " questions");
            response.setQuestions(questions);

        } catch (Exception e) {
            e.printStackTrace();
            response.setStatusCode(500);
            response.setMessage("Internal Server Error");
            response.setQuestions(null);
            return response;
        }

        return response;
    }
}
