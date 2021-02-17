package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.quizapp.controller.CardStackAdapter;
import com.yuyakaido.android.cardstackview.CardStackLayoutManager;
import com.yuyakaido.android.cardstackview.CardStackView;

import org.json.JSONObject;

import java.util.ArrayList;

import static android.widget.Toast.makeText;

public class MainActivity extends AppCompatActivity {
    private RequestQueue requestQueue;
    private String quizUrl;
    private CardStackView cardStackView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cardStackView = findViewById(R.id.cardStackView);
        cardStackView.setLayoutManager(new CardStackLayoutManager(this));

        ArrayList<String> csQuiz = new ArrayList<>();
        csQuiz.add("Computer_1_Science");
        csQuiz.add("Computer_2_Science");
        csQuiz.add("Computer_3_Science");
        csQuiz.add("Computer_4_Science");
        csQuiz.add("Computer_5_Science");
        csQuiz.add("Computer_6_Science");

        cardStackView.setAdapter(new CardStackAdapter(this, csQuiz));

        requestQueue = VolleySingleton.getInstance().getRequestQueue();
        quizUrl = "https://opentdb.com/api.php?amount=10&category=18&type=boolean";


        // to access json objects we need to create json object
        JsonObjectRequest compSciJsonObject =
                new JsonObjectRequest(Request.Method.GET, quizUrl,
                        null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.i("COMPUTER SCIENCE", response + "");
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });
        requestQueue.add(compSciJsonObject);
    }
}