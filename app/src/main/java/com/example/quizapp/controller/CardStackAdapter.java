package com.example.quizapp.controller;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quizapp.R;
import com.example.quizapp.model.QuizQuestion;
import com.example.quizapp.view.CSViewHolder;

import java.util.List;

public class CardStackAdapter extends RecyclerView.Adapter<CSViewHolder> {

    private Context mContext;
    private List<QuizQuestion> csQuizQuestion;
    private LayoutInflater layoutInflater;

    public CardStackAdapter(Context context, List<QuizQuestion> csquiz) {
        mContext = context;
        csQuizQuestion = csquiz;
        layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public CSViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.cs_view, parent, false);

        return new CSViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull CSViewHolder holder, int position) {
        holder.getCsTextQuestion().setText(csQuizQuestion.get(position).getTextQuestion());

        holder.getTrueButton().setOnClickListener(view -> {
            if (csQuizQuestion.get(position).isTrueAnswer()) {
                Toast.makeText(mContext, "Correct Answer", Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(mContext, "Wrong Answer", Toast.LENGTH_SHORT).show();
            }
        });

        holder.getFalseButton().setOnClickListener(view -> {
            if (csQuizQuestion.get(position).isTrueAnswer()) {
                Toast.makeText(mContext, "Wrong Answer", Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(mContext, "Correct Answer", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return csQuizQuestion.size();
    }
}
