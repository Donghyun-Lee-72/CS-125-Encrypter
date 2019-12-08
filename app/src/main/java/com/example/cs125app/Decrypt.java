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

        TextView keyNumber = findViewById(R.id.number);
        String keyAsString = keyNumber.getText().toString();
        int keyAsInt = Integer.parseInt(keyAsString);


        decrypt = findViewById(R.id.encrypt);

        decrypt.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(Decrypt.this, MainActivity.class));
            }
        });
    }

}
