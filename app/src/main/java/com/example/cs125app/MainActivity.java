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

//        Text input to encrypt or Encrypted input to decrypt
//        TextView inputBox = findViewById(R.id.text);
//        final String textInput = inputBox.getText().toString();
//
//        //key used for decryption/encryption
//        TextView key = findViewById(R.id.number);
//        String keyAsString = key.getText().toString();
//        final int keyAsInt = Integer.parseInt(keyAsString);
//
        Button encryptionMode = findViewById(R.id.encryptionMode);
        encryptionMode.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Encrypt.class));
            }
        });


        Button decryptionMode = findViewById(R.id.decryptionMode);
        decryptionMode.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Decrypt.class));
            }
        });
    }

    private void startEncrypt() {
        //turn to the results page and show the result
        Intent intent = new Intent(this, Encrypt.class);
        //make an intent of the other resultActivity

    }

    private String encryptText(String input, int key) {
        //encryption algorithm
        return "Hello, World!";
    }
    private void startDecrypt() {
        //turn to the results page and show the result
        Intent intent = new Intent(this, Encrypt.class);
        //make an intent of the other resultActivity

    }

    private String decryptText(String input, int key) {
        //decryption algorithm
        return "Hello, World!";
    }
}

