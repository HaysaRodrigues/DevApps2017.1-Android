package communication;

import android.os.AsyncTask;
import android.support.annotation.RequiresApi;

import java.util.List;

import model.Article;
import retrofit2.Retrofit;

/**
 * Created by Haysa on 12/08/17.
 */

public class RetrofitAsyncTask extends AsyncTask<String, Void, List<Article>> {


    //?source=the-verge&sortBy=top&apiKey=220f0186b217493291490cc084ca2185

    @Override
    protected List<Article> doInBackground(String... param) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://newsapi.org/v1/")
                .build();

        RequestApi api = retrofit.create(RequestApi.class);
        ParamRequest parameter = param[0];

        return null;
    }
}
