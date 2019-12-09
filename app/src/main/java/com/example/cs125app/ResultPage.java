package com.example.cs125app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultPage extends AppCompatActivity {
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //The result page
        setContentView(R.layout.result);

        Button back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(new Intent(ResultPage.this, MainActivity.class));
            }
        });


        Button share = findViewById(R.id.share);

        //share button code source from https://stackoverflow.com/questions/17167701/how-to-activate-share-button-in-android-app

        share.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                String shareBody = "Here is the share content body";
                sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject Here");
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
                startActivity(Intent.createChooser(sharingIntent, "Share via"));
            }
        });

        //The result(ciphertext, decoded text) is shown
//        TextView resultOutput = findViewById(R.id.result);
//        String result = getIntent().getStringExtra("result");
//        resultOutput.setText(result);
//
//        TextView keyOutput = findViewById(R.id.usedKey);
//        int key = getIntent().getIntExtra("key", 0);
//        keyOutput.setText(key);
    }
}
