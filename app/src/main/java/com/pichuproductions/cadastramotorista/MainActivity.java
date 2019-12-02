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
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    FirebaseAuth mAuth = FirebaseAuth.getInstance();
    EditText editTextLogin;
    EditText editTextSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void login(View view){

        String login = editTextLogin.getText().toString();
        String senha = editTextSenha.getText().toString();

        if (!login.trim().equals("")){

            mAuth.signInWithEmailAndPassword(login,senha)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()){

                                Toast.makeText(getApplicationContext(),"Acesso Permitido",Toast.LENGTH_LONG).show();
                                Intent intentLogin = new Intent(getApplicationContext(),PrincipalActivity.class);
                                startActivity(intentLogin);

                            }else {

                                Toast.makeText(getApplicationContext(),"Acesso Negado",Toast.LENGTH_LONG).show();

                            }
                        }
                    });

        }

    }

    public void vaicadastrar(View view) {

        Intent intentCadastrar = new Intent(getApplicationContext(),CadastrarActivity.class);
        startActivity(intentCadastrar);

    }

    public void recuperar(View view) {

        Intent intentRecuperar = new Intent(getApplicationContext(),RecuperarActivity.class);
        startActivity(intentRecuperar);

    }
}
