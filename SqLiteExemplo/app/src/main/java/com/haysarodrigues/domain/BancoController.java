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


    public Cursor listaDados(){

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

    public Cursor carregaDadoById(int id){

        Cursor cursor;
        String[] campos =  {"_id","titulo","autor","editora"};
        String where = "_id" + " = " + id;
        db = banco.getReadableDatabase();
        cursor = db.query(CriaBanco.TABELA,campos,where, null, null, null, null, null);

        if(cursor != null){
            cursor.moveToFirst();
        }

        db.close();


        return cursor;
    }

    public void alteraRegistro(int id, String titulo, String autor, String editora){

        ContentValues valores;
        String where;

        db = banco.getWritableDatabase();
        where = "_id" + " = " + id;

        valores = new ContentValues();

        valores.put("titulo", titulo);
        valores.put("autor", autor);
        valores.put("editora", editora);

        // String table, ContentValues values, String whereClause
        db.update(CriaBanco.TABELA,valores,where,null);
        db.close();

    }

    public void deletaRegistro(int id){
        String where = "_id" + " = " + id;
        db = banco.getReadableDatabase();
        db.delete(CriaBanco.TABELA,where,null);
        db.close();
    }
}


