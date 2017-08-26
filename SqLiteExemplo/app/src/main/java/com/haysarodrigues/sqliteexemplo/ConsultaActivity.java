package com.haysarodrigues.sqliteexemplo;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import com.haysarodrigues.domain.BancoController;

public class ConsultaActivity extends AppCompatActivity {

    private ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta);


        // qual a diferença entre base context e get context e get application context?
        BancoController controller = new BancoController(getBaseContext());

        final Cursor cursor = controller.listaDados();
        String[] nomeCampos = new String[] {"_id", "titulo"};
        int[] idViews = new int[] {R.id.idLivro, R.id.nomeLivro};

        // esse cara pega os campos que vc quer montar e recuperar (array de dados que vc quer recuperar)
        // depois voce cria um array de contantes do R para onde vc quer mostrar esses dados
        // e vc monta dentro do SIMPLE CURSOR ADAPTER
        SimpleCursorAdapter adaptador = new SimpleCursorAdapter(getBaseContext(),
                R.layout.livros_layout,cursor,nomeCampos,idViews, 0);

        lista = (ListView)findViewById(R.id.listView);
        lista.setAdapter(adaptador);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                String code;
                cursor.moveToPosition(i);
                code = cursor.getString(cursor.getColumnIndexOrThrow("_id"));
                Intent intent = new Intent(ConsultaActivity.this, AlterarActivity.class);
                intent.putExtra("codigo", code);
                startActivity(intent);
                finish();
            }
        });

    }

}
