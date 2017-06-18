package cl.assertsoft.testapimarvelmvp.api;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Gerardo on 17-06-2017.
 */

public class ApiAdapter {
    private static ApiService API_SERVICE;

    public static ApiService getApiService(){
        if (API_SERVICE == null){

            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient client = new OkHttpClient.Builder()
                    .addInterceptor(interceptor)
                    .connectTimeout(6, TimeUnit.SECONDS)
                    .readTimeout(8, TimeUnit.SECONDS)
                    .build();

            Retrofit adapter = new Retrofit.Builder()
                    .baseUrl(ApiConstants.URL_BASE)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            API_SERVICE = adapter.create(ApiService.class);


        }
        return API_SERVICE;
    }
}
