package cl.assertsoft.testapimarvelmvp.interactor;

import android.content.Context;
import android.util.Log;

import java.util.List;

import cl.assertsoft.testapimarvelmvp.R;
import cl.assertsoft.testapimarvelmvp.api.ApiAdapter;
import cl.assertsoft.testapimarvelmvp.interfaces.MainActivityInteractor;
import cl.assertsoft.testapimarvelmvp.interfaces.MainActivityPresenter;
import cl.assertsoft.testapimarvelmvp.model.ResponseApiMarvel;
import cl.assertsoft.testapimarvelmvp.model.Result;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Gerardo on 17-06-2017.
 */

public class MainActivityInteractorImpl implements MainActivityInteractor {

    //Relacion con el presenter
    MainActivityPresenter mainActivityPresenter;

    public MainActivityInteractorImpl(MainActivityPresenter mainActivityPresenter) {
        this.mainActivityPresenter = mainActivityPresenter;
    }

    @Override
    public void getCharactersInteractor(Context context) {
        String ts = context.getString(R.string.timestamp_api_key);
        String publicApikey = context.getString(R.string.public_api_key);
        String hash = context.getString(R.string.hash_api_key);

        Call<ResponseApiMarvel> call = ApiAdapter.getApiService().getCharacters(ts,publicApikey,hash);
        call.enqueue(new Callback<ResponseApiMarvel>() {
            @Override
            public void onResponse(Call<ResponseApiMarvel> call, Response<ResponseApiMarvel> response) {
                if (response.body() != null){
                    List<Result> results = response.body().getData().getResults();
                    mainActivityPresenter.showResultPresenter(results);
                }
            }

            @Override
            public void onFailure(Call<ResponseApiMarvel> call, Throwable t) {
                mainActivityPresenter.showErrorPresenter(t.getMessage());
            }
        });
    }
}
