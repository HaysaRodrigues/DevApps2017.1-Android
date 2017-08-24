package com.haysarodrigues.sqliteexemplo;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.haysarodrigues.domain.BancoController;

public class AlterarActivity extends AppCompatActivity {

    EditText livro;
    EditText autor;
    EditText editora;
    Button alterar;
    Button deletar;
    Cursor cursor;
    BancoController crud;
    String codigo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alterar);

        codigo = this.getIntent().getStringExtra("codigo");

        crud = new BancoController(getBaseContext());

        livro = (EditText)findViewById(R.id.editText4);
        autor = (EditText)findViewById(R.id.editText5);
        editora = (EditText)findViewById(R.id.editText6);

        alterar = (Button)findViewById(R.id.button2);
        deletar = (Button) findViewById(R.id.button3);

        cursor = crud.carregaDadoById(Integer.parseInt(codigo));
        livro.setText(cursor.getString(cursor.getColumnIndexOrThrow("titulo")));
        autor.setText(cursor.getString(cursor.getColumnIndexOrThrow("autor")));
        editora.setText(cursor.getString(cursor.getColumnIndexOrThrow("editora")));

        alterar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                crud.alteraRegistro(Integer.parseInt(codigo),
                                    livro.getText().toString(),
                                    autor.getText().toString(),
                                    editora.getText().toString());

                Intent intent = new Intent(AlterarActivity.this, ConsultaActivity.class);
                startActivity(intent);
                finish();

                Toast.makeText(getApplicationContext(), "alterado com sucesso", Toast.LENGTH_LONG).show();
            }
        });

        deletar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                crud.deletaRegistro(Integer.parseInt(codigo));
                Intent intent = new Intent(AlterarActivity.this, ConsultaActivity.class);
                startActivity(intent);
                finish();

            }
        });



    }
}
