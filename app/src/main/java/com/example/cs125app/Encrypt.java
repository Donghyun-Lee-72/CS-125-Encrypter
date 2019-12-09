package com.example.cs125app;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.EditText;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Map;


public class Encrypt extends AppCompatActivity {
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.encrypter);

        Button smallEncrypt = findViewById(R.id.smallEncrypt);
        Button safeEncrypt = findViewById(R.id.safeEncrypt);
        final EditText keyInput = findViewById(R.id.encryptNumber);
        final EditText encryptInput = findViewById(R.id.encryptInput);

        smallEncrypt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // get key and text
                int key = Integer.parseInt(keyInput.getText().toString());
                String[] input = encryptInput.getText().toString().toLowerCase().split("");
                // encrypte it using encrypter();
                Map keyMap = encrypter(key);
                String result = "";

                for (String letter : input) {
                    String value = (String) keyMap.get(letter);
                    if (value == null) {
                        // send warning.
                    }

                    result += value;
                }

                Intent intent = new Intent(Encrypt.this, ResultPage.class);
                intent.putExtra("result", result);
                intent.putExtra("mode", "encryption");
                intent.putExtra("key", key);

                startActivity(intent);
            }
        });

        safeEncrypt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // get key and text
                    // send error if number is not 4-digit
                int key = Integer.parseInt(keyInput.getText().toString());
                int keyOne = Integer.parseInt(keyInput.getText().toString()) / 100;
                int keyTwo = Integer.parseInt(keyInput.getText().toString()) % 100;
                String[] input = encryptInput.getText().toString().toLowerCase().split("");
                // encrypte it using encrypter();
                Map keyMap = encrypter(keyOne, keyTwo);
                String result = "";

                for (String letter : input) {
                    String value = (String) keyMap.get(letter);
                    if (value == null) {
                        // send warning.
                    }

                    result += value;
                }

                Intent intent = new Intent(Encrypt.this, ResultPage.class);
                intent.putExtra("result", result);
                intent.putExtra("mode", "advancedEncryption");
                intent.putExtra("key", key);

                startActivity(intent);
            }
        });
    }

    protected Map encrypter(int key) {
        Map result = new HashMap();
        String[] charList = Arrays.charList;
        String[] numList = Arrays.numList;
        String[] puncList = Arrays.puncList;

        // english letter mapping
        for (int j = 0; j < Numbers.numOfChar; j++) {
            result.put(charList[j], charList[(key + j) % charList.length]);
        }
        // number mapping
        for (int k = 0; k < Numbers.numOfNum; k++) {
            result.put(numList[k], numList[(key + k) % numList.length]);
        }
        // punctuation mapping
        for (int l = 0; l < Numbers.numOfPunc; l++) {
            result.put(puncList[l], puncList[(key + l) % puncList.length]);
        }

        return result;
    }

    protected Map encrypter(int key, int subkey) {
        Map result = new HashMap();
        String[] charList = Arrays.charList;
        String[] numList = Arrays.numList;
        String[] puncList = Arrays.puncList;

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