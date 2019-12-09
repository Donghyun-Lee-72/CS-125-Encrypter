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
                finish();
            }
        });

        decryptionMode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Decrypt.class));
                finish();
            }
        });
    }

//    private void startEncrypt() {
//        //turn to the results page and show the result
//        Intent intent = new Intent(this, Encrypt.class);
//        //make an intent of the other resultActivity
//
//    }
//
//    private String encryptText(String input, int key) {
//        //encryption algorithm
//        return "Hello, World!";
//    }
//    private void startDecrypt() {
//        //turn to the results page and show the result
//        Intent intent = new Intent(this, Encrypt.class);
//        //make an intent of the other resultActivity
//
//    }
//
//    private String decryptText(String input, int key) {
//        //decryption algorithm
//        return "Hello, World!";
//    }
}

