package com.example.texttospeech;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.*;
import android.speech.tts.*;
import android.os.Bundle;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,TextToSpeech.OnInitListener {


    private EditText editText;
    private Button buttonSpeak;
    TextToSpeech textToSpeech;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        buttonSpeak = findViewById(R.id.buttonSpeak);
        buttonSpeak.setOnClickListener(this);

        textToSpeech=new TextToSpeech(getBaseContext(),this);
        textToSpeech.setLanguage(Locale.ENGLISH);


    }

    @Override
    public void onInit(int i) {
        if(i!=TextToSpeech.ERROR){
            Toast.makeText(getBaseContext(),"erros is not there",Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onClick(View view) {
        String data=editText.getText().toString();
        textToSpeech.speak(data,TextToSpeech.QUEUE_FLUSH,null);


    }
}