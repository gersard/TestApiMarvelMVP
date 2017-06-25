package cl.assertsoft.testapimarvelmvp.interactor;

import android.content.Context;

import com.google.gson.Gson;

import java.util.List;

import cl.assertsoft.testapimarvelmvp.R;
import cl.assertsoft.testapimarvelmvp.api.ApiAdapter;
import cl.assertsoft.testapimarvelmvp.model.CharacterRealm;
import cl.assertsoft.testapimarvelmvp.presenter.MainActivityPresenter;
import cl.assertsoft.testapimarvelmvp.model.ResponseApiMarvel;
import cl.assertsoft.testapimarvelmvp.model.Result;
import io.realm.Realm;
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

        Call<ResponseApiMarvel> call = ApiAdapter.getApiService().getCharacters(ts,publicApikey,hash,80);
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

    @Override
    public void getCharactersSearched(Context context, String name) {
        String ts = context.getString(R.string.timestamp_api_key);
        String publicApikey = context.getString(R.string.public_api_key);
        String hash = context.getString(R.string.hash_api_key);

        Call<ResponseApiMarvel> call = ApiAdapter.getApiService().getCharactersSearched(ts,publicApikey,hash,name);
        call.enqueue(new Callback<ResponseApiMarvel>() {
            @Override
            public void onResponse(Call<ResponseApiMarvel> call, Response<ResponseApiMarvel> response) {
                if (response.body() != null){
                    List<Result> results = response.body().getData().getResults();
                    if (results.size() == 0){
                        mainActivityPresenter.noResultsFound();
                    }else{
                        mainActivityPresenter.showResultPresenter(results);
                    }

                }
            }

            @Override
            public void onFailure(Call<ResponseApiMarvel> call, Throwable t) {
                mainActivityPresenter.showErrorPresenter(t.getMessage());
            }
        });
    }

    @Override
    public void convertResultToJson(Result character) {
        Gson gson = new Gson();
        String charact = gson.toJson(character);
        mainActivityPresenter.goToDetail(charact);
    }

    @Override
    public void setFavoriteStatus(Result character, boolean isChecked) {
        Realm realm = Realm.getDefaultInstance();
        CharacterRealm characterRealm = realm.where(CharacterRealm.class).equalTo(CharacterRealm.CHARACTER_NAME,character.getName()).findFirst();
        realm.beginTransaction();
        if (characterRealm == null){
            characterRealm = new CharacterRealm();
            characterRealm.setCharacterId();
            characterRealm.setCharacterName(character.getName());
            characterRealm.setCharacterDescription(character.getDescription());
            characterRealm.setCharacterFavorite(isChecked);
            realm.copyToRealm(characterRealm);
        }else{
            characterRealm.setCharacterFavorite(isChecked);
        }
        realm.commitTransaction();
        mainActivityPresenter.showMessageFavorite(character.getName(),isChecked);
    }
}
