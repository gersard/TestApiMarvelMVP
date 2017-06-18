package cl.assertsoft.testapimarvelmvp.interfaces;

import java.util.List;

import cl.assertsoft.testapimarvelmvp.model.Result;

/**
 * Created by Gerardo on 17-06-2017.
 */

public interface MainActivityView {
    //Acciones que realizará la vista
    void actionProgress(boolean show);
    void showError(String error);
    void showResults(List<Result> characters);
}
