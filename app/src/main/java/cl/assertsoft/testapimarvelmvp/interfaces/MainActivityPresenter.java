package cl.assertsoft.testapimarvelmvp.interfaces;

import java.util.List;

import cl.assertsoft.testapimarvelmvp.model.Result;

/**
 * Created by Gerardo on 17-06-2017.
 */

public interface MainActivityPresenter {

    void showErrorPresenter(String error);
    void showResultPresenter(List<Result> results);
    void getDataCharacters();

}
