package com.example.cs125app;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.EditText;

import java.util.HashMap;
import java.util.Map;


public class Encrypt extends AppCompatActivity {
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.encrypter);

        Button smallEncrypt = findViewById(R.id.smallEncrypt);
        Button safeEncrypt = findViewById(R.id.safeEncrypt);
        EditText decryptInput = findViewById(R.id.encryptInput);

        smallEncrypt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // get key and text

                // encrypte it using encrypter();

                Intent intent = new Intent(Encrypt.this, ResultPage.class);

                startActivity(intent);
            }
        });

        safeEncrypt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Encrypt.this, ResultPage.class));
            }
        });
    }

    protected Map encrypter(int key, String[] charList, String[] numList, String[] puncList) {
        Map result = new HashMap();

        // english letter mapping
        for (int j = 0; j < 26; j++) {
            result.put(charList[j], charList[(key + j) % charList.length]);
        }
        // number mapping
        for (int k = 0; k < 10; k++) {
            result.put(numList[k], numList[(key + k) % numList.length]);
        }
        // punctuation mapping
        for (int l = 0; l < 4; l++) {
            result.put(puncList[l], puncList[(key + l) % puncList.length]);
        }

        return result;
    }

    protected Map encrypter(int key, int subkey, String[] charList, String[] numList, String[] puncList) {
        Map result = new HashMap();

        // english letter mapping
        for (int j = 0; j < 26; j++) {
            result.put(charList[j], charList[(key + j) % charList.length] + charList[(subkey + j) % charList.length]);
        }
        // number mapping
        for (int k = 0; k < 10; k++) {
            result.put(numList[k], numList[(key + k) % numList.length] + charList[(subkey + k) % charList.length]);
        }
        // punctuation mapping
        for (int l = 0; l < 4; l++) {
            result.put(puncList[l], puncList[(key + l) % puncList.length] + puncList[(subkey + l) % puncList.length]);
        }

        return result;
    }
}