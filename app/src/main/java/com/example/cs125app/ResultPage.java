package com.example.cs125app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ResultPage extends AppCompatActivity {
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //initial GUI interface is the home
        setContentView(R.layout.result);

//        Text input to encrypt or Encrypted input to decrypt
//        TextView inputBox = findViewById(R.id.text);
//        final String textInput = inputBox.getText().toString();
//
//        //key used for decryption/encryption
//        TextView key = findViewById(R.id.number);
//        String keyAsString = key.getText().toString();
//        final int keyAsInt = Integer.parseInt(keyAsString);
//
        Button back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(ResultPage.this, MainActivity.class));
            }
        });


        Button share = findViewById(R.id.share);
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
    }
}
