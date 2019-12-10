package com.example.cs125app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    protected void onCreate(final Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        //initial GUI interface is the home
        setContentView(R.layout.home);

        Button encryptionMode = (Button) findViewById(R.id.encryptionMode);
        Button decryptionMode = (Button) findViewById(R.id.decryptionMode);

        encryptionMode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Encrypt.class));
            }
        });

        decryptionMode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Decrypt.class));
            }
        });
    }
}

