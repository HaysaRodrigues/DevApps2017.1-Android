package com.haysarodrigues.myprojecthttp;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import Utils.Util;
import model.Article;

public class MainActivity extends AppCompatActivity {


    public static final String pURL =
            "https://newsapi.org/v1/articles?source=the-verge&sortBy=top&apiKey=220f0186b217493291490cc084ca2185";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if(Util.isConnected(getApplicationContext())){
            MinhaAsyncTask minhaAsyncTask = new MinhaAsyncTask();
            minhaAsyncTask.execute(pURL);

        }

    }

    public void okhttp(View view){
        Intent intent = new Intent(getApplicationContext(), OkHttpActivity.class);
        startActivity(intent);
    }


    //entender essa possibilidade de criar duas classes (generica)

    public class MinhaAsyncTask extends AsyncTask<String, Void, List<Article>>{


        //
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        // quando implementa uma asynctask, esse é o obrigatório
        @Override
        protected List<Article> doInBackground(String... strings) {

            List<Article> articleList = new ArrayList<>();

            String url = strings[0];

            // conect com a internet e faz o request
            InputStream inputStream = Util.getStream(url);

            // faz o parse de stream para string
            Util.streamToString(inputStream);

            // faz o parse de string para json
            String body = Util.streamToString(inputStream);
            Util.parse(body);

            return articleList;
        }


        // executado após o doing em background - processo o retorno do doInBackground
        @Override
        protected void onPostExecute(List<Article> articles) {
            super.onPostExecute(articles);
            for(Article obg : articles){
                Log.d("Article", "nome: " + obg.getTitle());
            }
        }
    }
}
