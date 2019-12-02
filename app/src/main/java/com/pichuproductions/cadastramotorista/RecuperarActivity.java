package com.pichuproductions.cadastramotorista;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;

public class RecuperarActivity extends AppCompatActivity {

    FirebaseAuth mAuth = FirebaseAuth.getInstance();
    EditText editTextLogin = null;

    MainActivity user = new MainActivity();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recuperar);

        editTextLogin = findViewById(R.id.txt_email);

        editTextLogin.setText(user.editTextLogin.getEditableText());

    }

    public void recuperar(View view) {

        if(!editTextLogin.equals("")){
            mAuth.sendPasswordResetEmail(editTextLogin.toString());
        }

    }

}
