package com.devapp.mal.passguard;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class DadosAcessoDao {

    private Conexao conexao;
    private SQLiteDatabase banco;

    public DadosAcessoDao(Context contexto){
        conexao  = new Conexao(contexto);
        banco = conexao.getWritableDatabase();

    }

    public List<DadosAcesso> buscarRegistros(){

        List<DadosAcesso> dados = new ArrayList<>();
        String[] colunas = {"id", "local","descricao"};

        Cursor cursor = banco.query("DadosAcesso",colunas,"",null, null,null, "local" );

        while(cursor.moveToNext()){
            DadosAcesso da = new DadosAcesso();
            da.setId(cursor.getInt(0));
            da.setLocal(cursor.getString(1));
            da.setDescricao(cursor.getString(2));
            dados.add(da);
        }

        return dados ;

    }

    public long inserir(DadosAcesso da){

        ContentValues values = new ContentValues();
        values.put("local", da.getLocal());
        values.put("descricao", da.getDescricao());
        return banco.insert("DadosAcesso", null, values);
    }

    public void alterar(DadosAcesso da){
        ContentValues values = new ContentValues();
        values.put("id", da.getId());
        values.put("local", da.getLocal());
        values.put("descricao", da.getDescricao());
        banco.update("DadosAcesso", values, "id = ?", new String[]{ da.getId().toString() });
        return;
    }
    public void excluir(DadosAcesso da){
        banco.delete("DadosAcesso", "id = ?", new String[]{ da.getId().toString() });
    }

}
