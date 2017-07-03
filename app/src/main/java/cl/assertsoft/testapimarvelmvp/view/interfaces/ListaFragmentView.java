package cl.assertsoft.testapimarvelmvp.view.interfaces;

import org.json.JSONObject;

import java.util.List;

import cl.assertsoft.testapimarvelmvp.model.Result;

/**
 * Created by Gerardo on 17-06-2017.
 */

public interface ListaFragmentView {
    //Acciones que realizará la vista
    void actionProgress(boolean show);
    void showError(String error);
    void showResults(List<Result> characters);
    void goToDetail(String character);
    void showMessageFavorite(String name, boolean isFavorite);
    void noResultsFound();
}
