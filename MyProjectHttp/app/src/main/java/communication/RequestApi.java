package communication;

import model.ResultNewAPI;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Haysa on 12/08/17.
 */

public interface RequestApi {

    //?source=the-verge&sortBy=top&apiKey=220f0186b217493291490cc084ca2185

    @GET("articles")
    Call<ResultNewAPI> getNewsApi(@Query("source") String source,
                                  @Query("sortBy") String sortBy,
                                  @Query("apiKey") String apiKey);
}
