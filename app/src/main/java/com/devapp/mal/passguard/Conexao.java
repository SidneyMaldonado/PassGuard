package com.devapp.mal.passguard;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Conexao extends SQLiteOpenHelper {


    public static final String name = "DadosAcesso";
    public static final int version = 1;

    public Conexao(Context context) {
        super(context, name, null, version);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(" create table DadosAcesso( id integer primary key autoincrement," +
                "local varchar(50), descricao varchar(50))");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" create table DadosAcesso( id integer primary key autoincrement," +
                "local varchar(50), descricao varchar(50))");



    }

}
