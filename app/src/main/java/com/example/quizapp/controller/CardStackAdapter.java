package com.example.quizapp.controller;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quizapp.R;
import com.example.quizapp.view.CSViewHolder;

import java.util.List;

public class CardStackAdapter extends RecyclerView.Adapter<CSViewHolder> {

    private Context context;
    private List<String> csquiz;
    private LayoutInflater layoutInflater;

    public CardStackAdapter(Context context, List<String> csquiz) {
        context = context;
        csquiz = csquiz;
        layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public CSViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.i("TAG", "OnCreate Viewholder in Card Stack Adapter is invoked");
        View view = layoutInflater.inflate(R.layout.cs_view, parent, false);

        Log.i("TAG", "set view");

        return new CSViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull CSViewHolder holder, int position) {
        holder.getCsTextQuestion().setText(csquiz.get(position));

        holder.getTrueButton().setOnClickListener(view -> {
            Toast.makeText(context, "Correct Answer", Toast.LENGTH_SHORT).show();
        });

        holder.getFalseButton().setOnClickListener(view -> {
            Toast.makeText(context, "Wrong Answer", Toast.LENGTH_SHORT).show();
        });

    }

    @Override
    public int getItemCount() {
        return csquiz.size();
    }
}
