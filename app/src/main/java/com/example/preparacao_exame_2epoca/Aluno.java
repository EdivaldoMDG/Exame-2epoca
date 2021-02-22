package com.example.preparacao_exame_2epoca;

public class Aluno {
    private String nome;
    private String numero;
    private String pc;

    public Aluno(String nome, String numero, String pc) {
        this.nome = nome;
        this.numero = numero;
        this.pc = pc;
    }



    public String getNome() {
        return nome;
    }
    public String getNumero(){
        return  numero;
    }

    public String getPc(){
        return  pc;
    }


}
