package com.example.preparacao_exame_2epoca;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.LinkedList;
import java.util.zip.Inflater;

public class Exame extends AppCompatActivity {
    private static final int USER_PASS_REQUEST = 1;
    private final LinkedList<Aluno> listStudent = new LinkedList<>();
    private RecyclerView mRecyclerView;
    private StudentAdapter mAdapter;


    Button novo, desistiu, faltou, presentes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exame);
        novo = findViewById(R.id.novo);
        desistiu = findViewById(R.id.desistiu);
        faltou = findViewById(R.id.faltou);
        presentes = findViewById(R.id.presentes);

        mRecyclerView = findViewById(R.id.recyclerview_presentes);



        novo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddStudent();

            }
        });

        desistiu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent desistiu = new Intent(getApplicationContext(), Desistiu.class);
                startActivity(desistiu);
            }
        });

        faltou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent faltou = new Intent(getApplicationContext(), Faltou.class);
                startActivity(faltou);
            }
        });
        presentes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent presentes = new Intent(getApplicationContext(), StudentList.class);
                startActivity(presentes);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.definicoes:
                Intent intent = new Intent(Settings.ACTION_SETTINGS);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            case R.id.sair:
                finish();
                return true;
            default:

        }
        return super.onOptionsItemSelected(item);

    }

    public void AddStudent() {
        Intent addStudent = new Intent(this, Novo.class);
        startActivityForResult(addStudent, USER_PASS_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == USER_PASS_REQUEST){
            if (resultCode == RESULT_OK){

                String nome = data.getStringExtra("nome1");
                String pc = data.getStringExtra("pc1");
                String numero = data.getStringExtra("numero1");

                //criar contacto
                Aluno newAluno = new Aluno(nome,numero,pc);
                //Adicionar contacto
                listStudent.add(newAluno);
                // Get a handle to the RecyclerView.
                // Create an adapter and supply the data to be displayed.
                 /*if (newContact.isFavorite()==true)
                     favoriteContact.add(newContact);*/

                mAdapter = new StudentAdapter(this, listStudent);
                //   mAdapterF = new FavoriteListAdapter(this, favoriteContact);
                // Connect the adapter with the RecyclerView.
                mRecyclerView.setAdapter(mAdapter);
                // mRecyclerViewF.setAdapter(mAdapterF);
                // Give the RecyclerView a default layout manager.
                mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
                //    mRecyclerViewF.setLayoutManager(new LinearLayoutManager(this));

            }
        }
    }



}
