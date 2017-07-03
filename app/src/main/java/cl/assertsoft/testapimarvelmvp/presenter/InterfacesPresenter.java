package cl.assertsoft.testapimarvelmvp.presenter;

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
        void getCharactersSearched(String character);
        void setFavoriteCharacter(Result character, boolean isFavorite);
        void showMessageFavorite(String name, boolean isFavorite);
        void noResultsFound();
    }

}
