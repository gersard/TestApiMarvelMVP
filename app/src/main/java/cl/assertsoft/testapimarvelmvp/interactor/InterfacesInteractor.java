package cl.assertsoft.testapimarvelmvp.interactor;

import android.content.Context;

import cl.assertsoft.testapimarvelmvp.model.Result;

/**
 * Created by Gerardo on 02-07-2017.
 */

public class InterfacesInteractor {

    public interface DetailCharacterInteractor{
        void convertDataToObject(String data);
    }

    public interface ListaFragmentInteractor{
        void getCharactersInteractor(Context context);
        void getCharactersSearched(Context context, String name);
        void convertResultToJson(Result character);
        void setFavoriteStatus(Result character, boolean isChecked);
    }
}
