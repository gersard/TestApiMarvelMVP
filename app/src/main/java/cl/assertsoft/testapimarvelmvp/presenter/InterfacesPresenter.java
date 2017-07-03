package cl.assertsoft.testapimarvelmvp.presenter;

import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;

import java.util.List;

import cl.assertsoft.testapimarvelmvp.model.Result;

/**
 * Created by Gerardo on 02-07-2017.
 */

public class InterfacesPresenter {

    public interface DetailCharacterPresenter{
        void convertDataToObject(String info);
        void showInfoDetail(Result info);
    }

    public interface ListaFragmentPresenter{
        void showErrorPresenter(String error);
        void showResultPresenter(List<Result> results);
        void getDataCharacters();
        void convertDataToString(Result character);
        void goToDetail(String character);
        void setFavoriteCharacter(Result character, boolean isFavorite);
        void showMessageFavorite(String name, boolean isFavorite);
        void noResultsFound();
        void seearchCharacter(String character);
    }

    public interface MainActivityPresenter{
        void navigateFragment(Fragment fragment);
        void navigationItemSelected(MenuItem item, DrawerLayout drawerLayout);
    }

}
