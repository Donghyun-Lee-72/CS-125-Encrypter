package com.example.cs125app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    protected void onCreate(final Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.home);

        //Text input to encrypt or Encrypted input to decrypt
        TextView inputBox = findViewById(R.id.text);
        final String textInput = inputBox.getText().toString();

        //key used for decryption/encryption
        TextView key = findViewById(R.id.number);
        String keyAsString = key.getText().toString();
        final int keyAsInt = Integer.parseInt(keyAsString);

        Button encrypt = findViewById(R.id.encrypt);
        encrypt.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ResultActivity.class));
                encryptText(textInput, keyAsInt);
            }
        });

        Button decrypt = findViewById(R.id.decrypt);
        decrypt.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ResultActivity.class));
                decryptText(textInput, keyAsInt);
            }
        });

    }

    private void startEncrypt() {
        //turn to the results page and show the result
        Intent intent = new Intent(this, ResultActivity.class);
        //make an intent of the other resultActivity

    }

    private String encryptText(String input, int key) {
        //encryption algorithm
        return "Hello, World!";
    }
    private void startDecrypt() {
        //turn to the results page and show the result
        Intent intent = new Intent(this, ResultActivity.class);
        //make an intent of the other resultActivity

    }

    private String decryptText(String input, int key) {
        //decryption algorithm
        return "Hello, World!";
    }
}

