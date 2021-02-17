package com.example.quizapp.view;

import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quizapp.R;

public class CSViewHolder extends RecyclerView.ViewHolder {

    private TextView csTextQuestion;
    private ImageButton trueButton;
    private ImageButton falseButton;

    public CSViewHolder(@NonNull View itemView) {
        super(itemView);

        csTextQuestion = itemView.findViewById(R.id.csTextQuestion);
        trueButton = itemView.findViewById(R.id.trueImage);
        falseButton = itemView.findViewById(R.id.falseImage);
    }

    public TextView getCsTextQuestion() {
        return csTextQuestion;
    }

    public ImageButton getTrueButton() {
        return trueButton;
    }

    public ImageButton getFalseButton() {
        return falseButton;
    }

}
