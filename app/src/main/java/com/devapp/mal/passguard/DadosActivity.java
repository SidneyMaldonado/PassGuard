package com.devapp.mal.passguard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class DadosActivity extends AppCompatActivity {

    private EditText local;
    private EditText descricao;
    private DadosAcessoDao dao;
    DadosAcesso da;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dados);

        local = findViewById(R.id.txtLocal);
        descricao = findViewById(R.id.txtDescricao);
        da = (DadosAcesso) getIntent().getExtras().get("DadosAcesso");
        local.setText( da.getLocal());
        descricao.setText(da.getDescricao());
        dao = new DadosAcessoDao(this);

    }

    public void salvar(View view){
        da.setLocal(local.getText().toString());
        da.setDescricao(descricao.getText().toString());
        if (da.getId() == 0) {
            long id = dao.inserir(da);
        } else {
            dao.alterar(da);
        }
        Toast.makeText(this, "Dados processados com sucesso", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void excluir(View view){
        dao.excluir(da);
        Toast.makeText(this, "Dados excluidos com sucesso", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void cancelar(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }



}
