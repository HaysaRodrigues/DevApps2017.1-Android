package com.haysarodrigues.domain;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Haysa on 22/08/17.
 */

public class JogoDB extends SQLiteOpenHelper {

    private static final String TAG = "sql";
    //nome do banco
    public static final String NOME_BANCO = "mysqlite_banco";
    private static final int VERSAO_BANCO = 1;

    public JogoDB(Context context){
        super(context, NOME_BANCO, null, VERSAO_BANCO);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        Log.d(TAG, "Criando tabela....................");
        sqLiteDatabase.execSQL("create table if not exists jogos " +
                "(_id integer primary key autoincrement,nome text,tipo text,nota text);");

        Log.d(TAG, "Tabela de carro criada...........................");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
