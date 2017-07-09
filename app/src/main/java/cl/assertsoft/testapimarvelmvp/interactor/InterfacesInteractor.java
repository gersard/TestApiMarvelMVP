package cl.assertsoft.testapimarvelmvp.interactor;

import android.content.Context;
import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;

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
        void convertResultToJson(Result character);
        void setFavoriteStatus(Result character, boolean isChecked);
        void getCharactersSearched(Context context, String name);
    }

    public interface MainActivityInteractor{
        void navigateTo(MenuItem item, DrawerLayout drawerLayout);
    }

    public interface FavoriteFragmentInteractor{
        void getFavoriteCharacters();
    }
}
