package com.example.cs125app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;
import java.util.Map;

public class Decrypt extends AppCompatActivity {
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.decrypter);

        Button smallDecrypt = findViewById(R.id.smallDecrypt);
        Button safeDecrypt = findViewById(R.id.safeDecrypt);

        smallDecrypt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // get key and text

                // decrypt it using decrypt();

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

    protected Map decrypter(int key, String[] charList, String[] numList, String[] puncList) {
        Map result = new HashMap();
        // english letter mapping
        for (int j = 0; j < 26; j++) {
            result.put(charList[(key + j) % charList.length], charList[j]);
        }
        // number mapping
        for (int k = 0; k < 10; k++) {
            result.put(numList[(key + k) % numList.length], numList[k]);
        }
        // punctuation mapping
        for (int l = 0; l < 4; l++) {
            result.put(puncList[(key + l) % puncList.length], puncList[l]);
        }

        return result;
    }

    protected Map decrypter(int key, int subkey, String[] charList, String[] numList, String[] puncList) {
        Map result = new HashMap();

        // english letter mapping
        for (int j = 0; j < 26; j++) {
            result.put(charList[(key + j) % charList.length] + charList[(subkey + j) % charList.length], charList[j]);
        }
        // number mapping
        for (int k = 0; k < 10; k++) {
            result.put(numList[(key + k) % numList.length] + charList[(subkey + k) % charList.length], numList[k]);
        }
        // punctuation mapping
        for (int l = 0; l < 4; l++) {
            result.put(puncList[(key + l) % puncList.length] + puncList[(subkey + l) % puncList.length], puncList[l]);
        }

        return result;
    }
}
