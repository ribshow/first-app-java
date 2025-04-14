package br.edu.fatecjahu.loginapp;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


// 1. Activity responsável por imprimir os logs nos métodos do ciclo de vida.
public class DebugActivity extends AppCompatActivity {

    // 2. Criar uma TAG chamada Marca para ser capturada no LogCat.
    protected static final String TAG = "Marca";
    protected static final String TAG2 = "Dado";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, getClassName() + ".onCreate() chamado: " + savedInstanceState);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, getClassName() + ".onStart chamado.");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, getClassName() + ".onRestart chamado.");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, getClassName() + ".onResume chamado.");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i(TAG, getClassName() + ".onSaveInstanceState chamado: " + outState);
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, getClassName() + ".onPause chamado.");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, getClassName() + ".onStop chamado.");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, getClassName() + ".onDestroy chamado.");
    }

    public void onBackPressed() {
        super.onBackPressed();
        Log.i(TAG, getClassName() + ".onBackPressed chamado.");
    }

    // 3. Retorna o nome da classe sem o pacote.
    public String getClassName() {
        // s = "br.edu.fatecjahu.loginapp.MainActivity" ou
        // s = "br.edu.fatecjahu.loginapp.BemVindoActivity"
        String s = getClass().getName();

        // retorna somente s =".MainActivity" ou
        // retorna somente s =".BemVindoActivity"
        return s.substring(s.lastIndexOf("."));
    }
}