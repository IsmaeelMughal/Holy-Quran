package com.example.holy_quran;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    QuranIndexes indexes;
    QuranArabicText arabicText;

    EditText surahNumberText;
    EditText verseNumberText;
    Button displayBtn;
    TextView verseText;


    int surah;
    int verse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        surahNumberText = findViewById(R.id.surahNumber);
        verseNumberText = findViewById(R.id.verseNumberTextview);
        displayBtn = findViewById(R.id.verseDisplayBtn);
        verseText = findViewById(R.id.verseTextview);

        displayBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }
}