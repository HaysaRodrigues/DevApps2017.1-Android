package com.haysarodrigues.domain;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Haysa on 22/08/17.
 */

public class CriaBanco extends SQLiteOpenHelper {


      public static final String NOME_BANCO = "banquinho.db";
      public static final String TABELA = "livros_haysa";
      private static final int VERSAO = 1;


    public CriaBanco(Context context){
        super(context, NOME_BANCO, null, VERSAO);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String sql = "create table if not exists livros_haysa " +
                "(_id integer primary key autoincrement,titulo text,autor text,editora text);";
        sqLiteDatabase.execSQL(sql);

    }


    //responsável por atualizar o banco de dados com alguma informação estrutural que tenha sido alterada.
    // apaga a tabela, se ela existir, e após isso invoca o método onCreate()
    // para que recrie a tabela com as alterações feitas.

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS livros_haysa");
        onCreate(sqLiteDatabase);

    }
}
