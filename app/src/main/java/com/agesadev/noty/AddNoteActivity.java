package com.agesadev.noty;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;

import com.agesadev.noty.db.NoteDatabase;
import com.agesadev.noty.model.Note;
import com.google.android.material.textfield.TextInputEditText;

import java.lang.ref.WeakReference;

public class AddNoteActivity extends AppCompatActivity {

    private TextInputEditText et_title, et_content;
    private NoteDatabase noteDatabase;
    private Note note;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);
        et_title = findViewById(R.id.et_title);
        et_content = findViewById(R.id.et_content);

        noteDatabase = NoteDatabase.getInstance(AddNoteActivity.this);
        Button addNote = findViewById(R.id.but_save);

        addNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                note = new Note(et_content.getText().toString(), et_title.getText().toString());
                new InsertTask(AddNoteActivity.this,note).execute();
            }
        });

    }

    private void setResult(Note note, int flag) {
        setResult(flag, new Intent().putExtra("note", (Parcelable) note));
        finish();
    }

    private static class InsertTask extends AsyncTask<Void, Void, Boolean> {

        private WeakReference<AddNoteActivity> activityWeakReference;
        private Note note;

        InsertTask(AddNoteActivity context, Note note) {
            activityWeakReference = new WeakReference<>(context);
            this.note = note;
        }


        @Override
        protected Boolean doInBackground(Void... voids) {
            activityWeakReference.get().noteDatabase.getNoteDao().insert(note);
            return true;
        }

        @Override
        protected void onPostExecute(Boolean bool) {
            if (bool) {
                activityWeakReference.get().setResult(note, 1);
            }
        }
    }


}