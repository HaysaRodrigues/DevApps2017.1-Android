package Utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import model.Article;

/**
 * Created by Haysa on 12/08/17.
 */

public class Util {

    public static final String pURL = "https://newsapi.org/v1/articles?source=the-verge&sortBy=top&apiKey=220f0186b217493291490cc084ca2185";
    public static final int timeout = 10000;



    public static boolean isConnected (Context context){

        /* Saber se tem connecção ou não */
        ConnectivityManager connectivityManager =
                (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo networkInfo =
                connectivityManager.getActiveNetworkInfo();

        if(networkInfo != null && networkInfo.isConnected()){
            return true;
        } else {
            Toast.makeText(context, "Sem conexão", Toast.LENGTH_SHORT).show();
        }



        return false;
    }

    // pegar o stream
    public static InputStream getStream(){


        try {
            URL url = new URL(pURL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(timeout);
            connection.setDoInput(true);
            connection.connect();

                if(connection.getResponseCode() == HttpURLConnection.HTTP_OK){

                    return connection.getInputStream();

                }


        } catch (MalformedURLException e) {
            e.printStackTrace(); // esse cara pode dar problema de url mal formada + abaixo IOEXCEPTION

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    // converter o stream para string para poder ler

    public static String streamToString (InputStream stream){

        String retorno = "";

        // checar conversão

        if(stream != null){

            byte [] bytes = new byte[1024];
            ByteArrayOutputStream baos =
                    new ByteArrayOutputStream();

            int read = 0;

            try {
                while ((read = stream.read(bytes)) > 0){
                    baos.write(bytes, 0, read);

                }

                return new String(baos.toByteArray());

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return retorno;

    }


    // transformar o que recebeu em objeto JSON
    public static List<Article> parse(String body){


        // lista de artigos
        List<Article> listArticle = new ArrayList<Article>();

        try {
            JSONObject jsonObject = new JSONObject(body);
            JSONArray jsonArray = jsonObject.getJSONArray("articles");


            // varrer o objecto json e pegar todos os parametros
            for (int x = 0; x < jsonArray.length(); x++){

                JSONObject obj =  jsonArray.getJSONObject(x);

                Article article = new Article(obj.getString("author"),
                        obj.getString("description"),
                        obj.getString("title"),
                        obj.getString("urlToImage"));

                listArticle.add(article);

            }


        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }


}
