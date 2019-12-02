package com.pichuproductions.cadastramotorista;

import android.widget.EditText;

public class Usuario {

    String nome;
    String email;
    String senha;
    String numero;

    public Usuario() {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.numero = numero;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
