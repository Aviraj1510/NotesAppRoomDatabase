package com.example.notesapproomdatabase.Interface;

import androidx.cardview.widget.CardView;

import com.example.notesapproomdatabase.Model.Notes;

public interface NotesClickListener {

    void onClick(Notes notes);
    void onLongClickListener(Notes notes, CardView cardView);
}

