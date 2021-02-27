package com.example.quizapp.model;

import android.app.Activity;
import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.quizapp.R;
import com.example.quizapp.VolleySingleton;
import com.example.quizapp.controller.CardStackAdapter;
import com.yuyakaido.android.cardstackview.CardStackLayoutManager;
import com.yuyakaido.android.cardstackview.CardStackView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class QuizManager {
    private RequestQueue requestQueue;
    private String quizUrl;
    Context mContext;

    public QuizManager(Context context) {
        mContext = context;
        requestQueue = VolleySingleton.getInstance().getRequestQueue();
        quizUrl = "https://opentdb.com/api.php?amount=10&category=18&type=boolean";

    }

    public void getQuizQuestion(Activity activity) {
        List<QuizQuestion> quizQuestions = new ArrayList<>();

        // to access json objects we need to create json object
        JsonObjectRequest compSciJsonObject =
                new JsonObjectRequest(Request.Method.GET, quizUrl,
                        null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.i("COMPUTER SCIENCE", response + "");
                        try {
                            JSONArray results = response.getJSONArray("results");

                            for (int index = 0; index < results.length(); index++) {
                                JSONObject questionJSONObject = results.getJSONObject(index);
                                String questionStringText = questionJSONObject.getString("question");
                                boolean questionBooleanAnswer = questionJSONObject.getBoolean("correct_answer");
                                QuizQuestion myQuestion = new QuizQuestion(questionStringText, questionBooleanAnswer);
                                quizQuestions.add(myQuestion);
                            }
                            CardStackView cardStackView = activity.findViewById(R.id.cardStackView);
                            cardStackView.setLayoutManager(new CardStackLayoutManager(mContext));
                            cardStackView.setAdapter(new CardStackAdapter(mContext, quizQuestions));


                        }catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }

                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });
        requestQueue.add(compSciJsonObject);
    }
}
