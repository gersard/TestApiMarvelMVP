package cl.assertsoft.testapimarvelmvp.interactor;

import android.content.Context;

import cl.assertsoft.testapimarvelmvp.model.Result;

/**
 * Created by Gerardo on 17-06-2017.
 */

public interface MainActivityInteractor {

    void getCharactersInteractor(Context context);
    void getCharactersSearched(Context context, String name);
    void convertResultToJson(Result character);

}
