package com.example.chamada;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static android.content.pm.PackageManager.PERMISSION_GRANTED;

public class MainActivity extends AppCompatActivity {
    EditText telefone;
    Button btnLimpar, btnTelefonar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        telefone = findViewById(R.id.etTelefone);
        btnTelefonar = findViewById(R.id.btnTelefonar);
        btnLimpar = findViewById(R.id.btnLimpar);

        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                telefone.setText("");
            }
        });


        btnTelefonar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            String numero = telefone.getText().toString();
            Uri uri = Uri.parse("tel:" + numero);

            Intent intent = new Intent(Intent.ACTION_CALL, uri);
            if (ActivityCompat.checkSelfPermission(MainActivity.this,Manifest.permission.CALL_PHONE) != PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(MainActivity.this, new  String[]{Manifest.permission.CALL_PHONE},1);
                return;
            }
            startActivity(intent);
            }
        });
    }
}