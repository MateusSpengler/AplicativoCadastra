package com.pichuproductions.cadastramotorista;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CadastrarActivity extends AppCompatActivity {

    FirebaseDatabase firebaseDatabase;
    DatabaseReference ref;

    FirebaseAuth mAuth = FirebaseAuth.getInstance();
    EditText editTextLoginCadastrar;
    EditText editTextSenhaCadastrar;
    EditText editTextNomeCadastrar;
    Button cadastrar;

    Intent intentCadastrado;

    private void incializarFireBase() {

        FirebaseApp.initializeApp(CadastrarActivity.this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        ref = firebaseDatabase.getReference();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar);

        editTextLoginCadastrar = findViewById(R.id.txt_loginCadastrar);
        editTextSenhaCadastrar = findViewById(R.id.txt_senhaCadastrar);
        editTextNomeCadastrar = findViewById(R.id.txt_nomeCadastrar);
        cadastrar = findViewById(R.id.btn_cadastrar);

        incializarFireBase();

    }

    public void cadastrar(View view) {

        final Usuario usuario = new Usuario();

        incializarFireBase();
        if (!editTextLoginCadastrar.getText().toString().trim().equals("")){

            usuario.setEmail(editTextLoginCadastrar.getText().toString());
            usuario.setSenha(editTextSenhaCadastrar.getText().toString());
            usuario.setNome(editTextNomeCadastrar.getText().toString());

            mAuth.createUserWithEmailAndPassword(
                    usuario.getEmail(),usuario.getSenha()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {

                    if (task.isSuccessful()){

                        Toast.makeText(getApplicationContext(),"Conta Cadastrado com Sucesso",Toast.LENGTH_LONG).show();

                        FirebaseDatabase.getInstance().getReference("Usuarios").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue(usuario);

                        intentCadastrado = new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(intentCadastrado);

                    }else {

                        Toast.makeText(getApplicationContext(),"Falha ao Cadastrar Conta",Toast.LENGTH_LONG).show();

                    }
                }
            });
        }

    }
}
