package com.example.cs125app;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
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
                int key = Integer.parseInt(keyInput.getText().toString());

                // get key and text
                String[] input = encryptInput.getText().toString().toLowerCase().split("");
                // encrypte it using encrypter();
                Map keyMap = encrypter(key);
                String result = "";

                for (String letter : input) {
                    String value = (String) keyMap.get(letter);
                    System.out.println(value);
                    if (value == null) {
                        WarningEnd();
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
                int key = Integer.parseInt(keyInput.getText().toString());
                int keyOne = key / 100;
                int keyTwo = key % 100;

                String[] input = encryptInput.getText().toString().toLowerCase().split("");
                // encrypte it using encrypter();
                Map keyMap = encrypter(keyOne, keyTwo);
                String result = "";

                for (String letter : input) {
                    String value = (String) keyMap.get(letter);
                    if (value == null) {
                        WarningEnd();
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

    private Map encrypter(int key) {
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

    private Map encrypter(int key, int subkey) {
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

    private void WarningEnd() {
        new AlertDialog.Builder(Encrypt.this)
                .setTitle("WARNING!")
                .setMessage("You should use English letters, arabic numbers, and designated punctuation(! ? , .)")
                .setPositiveButton("Go Home", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent goHome = new Intent(Encrypt.this, MainActivity.class);
                        startActivity(goHome);
                        finish();
                    }
                });
    }
}