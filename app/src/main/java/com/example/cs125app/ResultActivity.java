package com.example.cs125app;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.TextView;


public class ResultActivity extends AppCompatActivity {

    protected void onCreate(final Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.encrypter);

        Button back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(ResultActivity.this, MainActivity.class));
            }
        });

        TextView result = findViewById(R.id.result);
        final String resultAsString = result.getText().toString();

        Button copy = findViewById(R.id.share);
        copy.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(ResultActivity.this, MainActivity.class));
                copyText(resultAsString);
            }
        });
    }

//    private void goBackHome() {
//        //turn to home and wait for a new input
//        Intent intent = new Intent(this, MainActivity.class);
//    }

    private void copyText(String output) {
        //copy the result on the clipboard.
        //notification (alert dialogue) indicating that the results are copied to the clipboard.
    }
}