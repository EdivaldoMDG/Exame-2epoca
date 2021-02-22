package com.example.preparacao_exame_2epoca;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.LinkedList;

public class Novo extends AppCompatActivity {



    EditText nome, pc, numero;
    RadioButton desistiu,faltou,presente;
    Button salvar,cancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo);

       nome = findViewById(R.id.nome_et);
       pc = findViewById(R.id.computador_et);
       numero = findViewById(R.id.numero_et);

       desistiu = findViewById(R.id.desistiu);
       faltou = findViewById(R.id.faltou);
       presente = findViewById(R.id.present);

        salvar = findViewById(R.id.salvar);
        cancelar = findViewById(R.id.cancelar);

        salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome1 = nome.getText().toString().trim();
                String pc1 = pc.getText().toString().trim();
                String numero1 = numero.getText().toString().trim();

                if(TextUtils.isEmpty(nome1)) { nome.setError("Este campo não pode estar vazio");
                    return;
                }
                // add a check to name just because is a good way to to things
                if(TextUtils.isEmpty(pc1)) { pc.setError("Este campo não pode estar vazio");
                    return;
                }
                if(TextUtils.isEmpty(numero1)) { numero.setError("Este campo não pode estar vazio");
                    return;
                }

                Intent returnIntent = new Intent();
                returnIntent.putExtra("nome1",nome1);
                returnIntent.putExtra("pc1",pc1);
                returnIntent.putExtra("numero1",numero1);
                setResult(RESULT_OK,returnIntent);
                finish();



            }
        });

        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder myAlertBuilder = new AlertDialog.Builder(Novo.this);
                myAlertBuilder.setTitle("Alerta");
                myAlertBuilder.setMessage("Click Ok para Continuar ou Cancel para sair:");

                //Criar botoes de dialog

                myAlertBuilder.setPositiveButton("CONTINUAR", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(),"Continuar",Toast.LENGTH_SHORT).show();
                    }
                });

                myAlertBuilder.setNegativeButton("CANCELAR", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
                //Criar e mostra um show AlertDialog
                myAlertBuilder.show();
            }
        });
}


}