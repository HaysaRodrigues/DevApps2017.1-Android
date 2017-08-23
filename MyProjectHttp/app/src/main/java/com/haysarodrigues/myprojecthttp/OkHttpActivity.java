package com.haysarodrigues.myprojecthttp;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import model.Article;
import okhttp3.OkHttpClient;
import okhttp3.Request;

public class OkHttpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ok_http);
    }

    public class OkhttpAsyncTask extends AsyncTask<String, Void, List<Article>>{


        @Override
        protected List<Article> doInBackground(String... strings) {
            List <Article> list = new ArrayList<>();



                OkHttpClient okHttpClient = new OkHttpClient();
                String url = strings[0];
                //Request request = new





            return null;
        }
    }
}
