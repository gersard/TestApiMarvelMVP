package cl.assertsoft.testapimarvelmvp.view.interfaces;

import android.support.v4.app.Fragment;

import java.util.List;

import cl.assertsoft.testapimarvelmvp.model.Result;

/**
 * Created by Gerardo on 02-07-2017.
 */

public class InterfacesView {

    public interface DetailCharacterView {
        void showInfo(Result character);
    }

    public interface MainActivityView {
        void replaceFragment(Fragment fragment);
    }

    public interface ListaFragmentView{
        //Acciones que realizará la vista
        void actionProgress(boolean show);
        void showError(String error);
        void showResults(List<Result> characters);
        void goToDetail(String character);
        void showMessageFavorite(String name, boolean isFavorite);
        void noResultsFound();
    }

}
