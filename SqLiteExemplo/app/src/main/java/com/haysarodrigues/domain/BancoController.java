package com.haysarodrigues.domain;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Haysa on 22/08/17.
 */

public class BancoController {

    private SQLiteDatabase db;
    private CriaBanco banco;

    public BancoController(Context context){
        banco = new CriaBanco(context);
    }

    public String insereDado(String titulo, String autor, String editora){

        ContentValues valores;
        long resultado;

        db = banco.getWritableDatabase();
        valores = new ContentValues();
        valores.put("titulo", titulo);
        valores.put("autor", autor);
        valores.put("editora", editora);



        resultado = db.insert("livros_haysa", "", valores);
        db.close();

        // retorna a quantidade de linhas

        if (resultado == -1) {
            return "Erro ao inserir registro";

        } else {
            return "Registro Inserido com sucesso";
        }
    }


    public Cursor carregaDados(){

        Cursor cursor;
        String[] campos =  {"_id","titulo"};
        db = banco.getReadableDatabase();
        cursor = db.query(banco.TABELA, campos, null, null, null, null, null, null);

        if(cursor != null){
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }
}


