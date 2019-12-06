package com.example.cs125app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Button encrypt = findViewById(R.id.encrypt);

        setContentView(R.layout.encrypted);

        Button back = findViewById(R.id.back);
        encrypt.setOnClickListener(goBackHome());

        Button copy = findViewById(R.id.copy);

        TextView result = (TextView) findViewById(R.id.result);
        String resultAsString = result.getText().toString();

        encrypt.setOnClickListener(copyText(resultAsString));
    }

    private void goBackHome() {
        //turn to home and wait for a new input
        Intent intent = new Intent(this, LaunchActivity.class);
    }

    private void copyText(String output) {
        //copy the result on the clipboard.
        //notification (alert dialogue) indicating that the results are copied to the clipboard.
    }
}

