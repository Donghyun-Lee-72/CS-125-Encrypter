package com.example.cs125app;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;

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
                try {
                    int key = Integer.parseInt(keyInput.getText().toString());

                    // get key and text
                    char[] input = encryptInput.getText().toString().toLowerCase().toCharArray();
                    // encrypte it using encrypter();
                    Map keyMap = encrypter(key);
                    String result = "";

                    for (char letter : input) {
                        String value = (String) keyMap.get(String.valueOf(letter));
                        if (value == null) {
                            throw new IllegalArgumentException();
                        }

                        result += value;
                    }

                    Intent intent = new Intent(Encrypt.this, ResultPage.class);
                    intent.putExtra("result", result);
                    intent.putExtra("mode", "encryption");
                    intent.putExtra("key", key);

                    startActivity(intent);

                } catch (NumberFormatException e) {
                    WarningEnd(2);
                } catch (IllegalArgumentException e) {
                    WarningEnd(1);
                }
            }
        });

        safeEncrypt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    int key = Integer.parseInt(keyInput.getText().toString());
                    int keyOne = key / 100;
                    int keyTwo = key % 100;

                    char[] input = encryptInput.getText().toString().toLowerCase().toCharArray();
                    // encrypte it using encrypter();
                    Map keyMap = encrypter(keyOne, keyTwo);
                    String result = "";

                    for (char letter : input) {
                        String value = (String) keyMap.get(String.valueOf(letter));
                        if (value == null) {
                            throw new IllegalArgumentException();
                        }

                        result += value;
                    }

                    Intent intent = new Intent(Encrypt.this, ResultPage.class);
                    intent.putExtra("result", result);
                    intent.putExtra("mode", "advancedEncryption");
                    intent.putExtra("key", key);

                    startActivity(intent);
                } catch (NumberFormatException e) {
                    WarningEnd(2);
                } catch (IllegalArgumentException e) {
                    WarningEnd(1);
                } catch (Error e) {
                    System.out.println("error: " + e);
                }
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

//    private Map encrypter(int key, int subkey) {
//        Map result = new HashMap();
//        String[] charList = Arrays.charList;
//        String[] numList = Arrays.numList;
//        String[] puncList = Arrays.puncList;
//
//        // english letter mapping
//        for (int j = 0; j < Numbers.numOfChar; j++) {
//            result.put(charList[j], charList[(key + j) % charList.length] + charList[(subkey + j) % charList.length]);
//        }
//        // number mapping
//        for (int k = 0; k < Numbers.numOfNum; k++) {
//            result.put(numList[k], numList[(key + k) % numList.length] + numList[(subkey + k) % numList.length]);
//        }
//        // punctuation mapping
//        for (int l = 0; l < Numbers.numOfPunc; l++) {
//            result.put(puncList[l], puncList[(key + l) % puncList.length] + puncList[(subkey + l) % puncList.length]);
//        }
//
//        return result;
//    }

    private Map encrypter(int key, int subkey) {
        Map result = new HashMap();
        String[] charList = Arrays.charList;
        String[] numList = Arrays.numList;
        String[] puncList = Arrays.puncList;

        // english letter mapping
        for (int j = 0; j < Numbers.numOfChar; j++) {
            result.put(charList[j], charList[(key + j) % charList.length] + charList[(subkey + j) % charList.length]);
        }
        // number mapping
        for (int k = 0; k < Numbers.numOfNum; k++) {
            result.put(numList[k], numList[(key + k) % numList.length] + charList[(subkey + k) % charList.length]);
        }
        // punctuation mapping
        for (int l = 0; l < Numbers.numOfPunc; l++) {
            result.put(puncList[l], puncList[(key + l) % puncList.length] + puncList[(subkey + l) % puncList.length]);
        }

        return result;
    }

    private void WarningEnd(int type) {
        switch(type) {
            case 1 :        // wrong letters
                new AlertDialog.Builder(Encrypt.this)
                        .setTitle("WARNING!")
                        .setMessage("You should use English letters, arabic numbers, and punctuations")
                        .setPositiveButton("Try again!", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    }).show();
                break;

            case 2 :        // no key input
                new AlertDialog.Builder(Encrypt.this)
                        .setTitle("WARNING!")
                        .setMessage("You should insert a key code of 1-4 digit positive number")
                        .setPositiveButton("Try again!", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        }).show();

                break;
        }
    }
}