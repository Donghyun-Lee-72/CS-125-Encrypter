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
        final EditText keyInput = findViewById(R.id.decryptNumber);
        final EditText decryptInput = findViewById(R.id.decryptInput);

        smallDecrypt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // get key and text
                int key = Integer.parseInt(keyInput.getText().toString());
                String[] input = decryptInput.getText().toString().toLowerCase().split("");
                // decrypt it using decrypt();
                Map keyMap = decrypter(key);
                String result = "";

                for (String letter : input) {
                    String value = (String) keyMap.get(letter);
                    if (value == null) {
                        // send warning.
                    }

                    result += value;
                }

                Intent intent = new Intent(Decrypt.this, ResultPage.class);
                intent.putExtra("result", result);
                intent.putExtra("mode", "decryption");

                startActivity(intent);
            }
        });

        safeDecrypt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // get key and text
                int key = Integer.parseInt(keyInput.getText().toString());
                String[] input = decryptInput.getText().toString().toLowerCase().split("");
                // decrypt it using decrypt();
                Map keyMap = decrypter(key);
                String result = "";

                for (int o = 0; o < input.length; o += 2) {
                    String value = (String) keyMap.get(input[o] + input[o + 1]);
                    if (value == null) {
                        // send warning.
                    }

                    result += value;
                }

                Intent intent = new Intent(Decrypt.this, ResultPage.class);
                intent.putExtra("result", result);
                intent.putExtra("mode", "advancedDecryption");

                startActivity(intent);
            }
        });
    }

    protected Map decrypter(int key) {
        Map result = new HashMap();
        String[] charList = Arrays.charList;
        String[] numList = Arrays.numList;
        String[] puncList = Arrays.puncList;
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

    protected Map decrypter(int key, int subkey) {
        Map result = new HashMap();
        String[] charList = Arrays.charList;
        String[] numList = Arrays.numList;
        String[] puncList = Arrays.puncList;

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
