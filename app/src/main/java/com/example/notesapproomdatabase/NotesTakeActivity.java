package com.example.notesapproomdatabase;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.notesapproomdatabase.Model.Notes;

import java.text.SimpleDateFormat;
import java.util.Date;

public class NotesTakeActivity extends AppCompatActivity {

    EditText titleED, notesEd;

    Notes notes;
    ImageView saveBtn;

    boolean isOldNotes = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes_take);

        titleED = findViewById(R.id.titleEdt);
        notesEd = findViewById(R.id.noteEdt);
        saveBtn = findViewById(R.id.savebtn);

        notes = new Notes();

        try {
            notes = (Notes) getIntent().getSerializableExtra("old_notes");
            titleED.setText(notes.getTitle());
            notesEd.setText(notes.getNotes());
            isOldNotes = true;
        } catch (Exception e) {
            e.printStackTrace();
        }


        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String title = titleED.getText().toString();
                String description = notesEd.getText().toString();

                if (description.isEmpty()){
                    Toast.makeText(NotesTakeActivity.this, "Please Enter The Description.", Toast.LENGTH_SHORT).show();
                    return;
                }
                SimpleDateFormat format = new SimpleDateFormat("EEE, d MMM YYYY HH:mm a");
                Date date = new Date();

                if (!isOldNotes){
                    notes = new Notes();

                }

                notes.setTitle(title);
                notes.setNotes(description);
                notes.setDate(format.format(date));

                Intent intent = new Intent();
                intent.putExtra("note", notes);
                setResult(Activity.RESULT_OK, intent);
                finish();
            }
        });
    }
}