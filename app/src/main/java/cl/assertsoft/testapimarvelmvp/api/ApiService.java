package cl.assertsoft.testapimarvelmvp.api;

import cl.assertsoft.testapimarvelmvp.model.ResponseApiMarvel;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Gerardo on 17-06-2017.
 */

public interface ApiService {
    @GET(ApiConstants.URL_GET_CHARACTERS)
    Call<ResponseApiMarvel> getCharacters(@Query(ApiConstants.PARAM_TIMESTAMP) String ts,
                                          @Query(ApiConstants.PARAM_API_KEY) String apiKey,
                                          @Query(ApiConstants.PARAM_HASH) String hash
    );
}
