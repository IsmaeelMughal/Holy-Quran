package com.example.holy_quran;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    QuranIndexes indexes = new QuranIndexes();
    QuranArabicText arabicText = new QuranArabicText();

    EditText surahNumberText;
    EditText verseNumberText;
    Button displayBtn;
    TextView verseText;

    Button gitBtn;


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
        gitBtn = findViewById(R.id.gitBtn);

        gitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://github.com/IsmaeelMughal/Holy-Quran/commits/master";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

        displayBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (surahNumberText.getText().toString().equals("")
                        || verseNumberText.getText().toString().equals("")){
                    verseText.setText("سورہ یا آیت نمبر خالی نہیں ہو سکتی");
                }
                else{
                    surah = Integer.parseInt(surahNumberText.getText().toString());
                    verse = Integer.parseInt(verseNumberText.getText().toString());

                    if (surah == 0 || verse == 0){
                        verseText.setText("سورہ یا آیت صفر نہیں ہو سکتی");
                    }
                    else{
                        if(surah > 114){
                            verseText.setText("سورہ 114 سے زیادہ نہیں ہو سکتی");
                        }
                        else{
                            if(verse > indexes.getSurahVerses(surah-1)){
                                verseText.setText("سورہ "+ indexes.urduSurahNames[surah-1] +" میں صرف "+ indexes.surahAyatCount[surah-1] +" آیات ہیں۔");
                            }
                            else
                            {
                                String ayat = arabicText.QuranArabicText[indexes.SSP[surah-1] + verse - 1];
                                verseText.setText(ayat);
                            }
                        }
                    }
                }
            }
        });

    }
}