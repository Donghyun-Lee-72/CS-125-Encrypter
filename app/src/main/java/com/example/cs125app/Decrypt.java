package com.example.cs125app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Decrypt extends AppCompatActivity {
    private Button decrypt;
    protected void onCreate(final Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.decrypter);
//
//        TextView keyNumber = findViewById(R.id.number);
//        String keyAsString = keyNumber.getText().toString();
//        int keyAsInt = Integer.parseInt(keyAsString);



        Button smallDecrypt = findViewById(R.id.smallDecrypt);
        Button safeDecrypt = findViewById(R.id.safeDecrypt);

        smallDecrypt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Decrypt.this, ResultPage.class));
            }
        });

        safeDecrypt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Decrypt.this, ResultPage.class));
            }
        });
    }
//    public String smallDecrypt(String input) {
//
//    }
}
