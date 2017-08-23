package com.haysarodrigues.sqliteexemplo;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

        Cursor cursor = controller.carregaDados();
        String[] nomeCampos = new String[] {"_id", "titulo"};
        int[] idViews = new int[] {R.id.idLivro, R.id.nomeLivro};

        // esse cara é a grande sacada, ele pega os campos que vc quer montar e recuperar (array de dados que vc quer recuperar)
        // depois voce cria um array de contantes do R para onde vc quer mostrar esses dados
        // e vc monta dentro do SIMPLE CURSOR ADAPTER
        SimpleCursorAdapter adaptador = new SimpleCursorAdapter(getBaseContext(),
                R.layout.livros_layout,cursor,nomeCampos,idViews, 0);

        lista = (ListView)findViewById(R.id.listView);
        lista.setAdapter(adaptador);

    }
}
