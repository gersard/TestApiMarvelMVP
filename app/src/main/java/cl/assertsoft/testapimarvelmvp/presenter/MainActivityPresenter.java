package cl.assertsoft.testapimarvelmvp.presenter;

import org.json.JSONObject;

import java.util.List;

import cl.assertsoft.testapimarvelmvp.model.Result;

/**
 * Created by Gerardo on 17-06-2017.
 */

public interface MainActivityPresenter {

    void showErrorPresenter(String error);
    void showResultPresenter(List<Result> results);
    void getDataCharacters();
    void convertDataToString(Result character);
    void goToDetail(String character);
    void getCharactersSearched(String character);
    void setFavoriteCharacter(Result character, boolean isFavorite);
    void showMessageFavorite(String name, boolean isFavorite);
    void noResultsFound();

}
