package com.example.cs125app;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.TextView;


public class Encrypt extends AppCompatActivity {

    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.encrypter);
//
//        TextView keyNumber = findViewById(R.id.number);
//        String keyAsString = keyNumber.getText().toString();
//        int keyAsInt = Integer.parseInt(keyAsString);


        Button encrypt = findViewById(R.id.smallEncrypt);

        encrypt.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(Encrypt.this, ResultPage.class));
            }
        });
    }

    private void copyText(String output) {
        //copy the result on the clipboard.
        //notification (alert dialogue) indicating that the results are copied to the clipboard.
    }
}