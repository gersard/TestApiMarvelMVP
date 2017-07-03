package cl.assertsoft.testapimarvelmvp.presenter;

import android.content.Context;

import java.util.List;

import cl.assertsoft.testapimarvelmvp.interactor.InterfacesInteractor;
import cl.assertsoft.testapimarvelmvp.interactor.ListaFragmentInteractorImpl;
import cl.assertsoft.testapimarvelmvp.view.interfaces.ListaFragmentView;
import cl.assertsoft.testapimarvelmvp.model.Result;

/**
 * Created by Gerardo on 17-06-2017.
 */

public class ListaFragmentPresenterImpl implements InterfacesPresenter.ListaFragmentPresenter {
    //Relación con la vista
    private ListaFragmentView listaFragmentView;
    //Relación con le Interactor
    private InterfacesInteractor.ListaFragmentInteractor listaFragmentInteractor;
    Context context;

    public ListaFragmentPresenterImpl(ListaFragmentView listaFragmentView, Context context) {
        this.listaFragmentView = listaFragmentView;
        listaFragmentInteractor = new ListaFragmentInteractorImpl(this);
        this.context = context;
    }

    @Override
    public void showErrorPresenter(String error) {
        if (listaFragmentView != null){
            listaFragmentView.actionProgress(false);
            listaFragmentView.showError(error);
        }
    }

    @Override
    public void showResultPresenter(List<Result> results) {
        if (listaFragmentView != null){
            listaFragmentView.actionProgress(false);
            listaFragmentView.showResults(results);
        }
    }

    @Override
    public void getDataCharacters() {
        if (listaFragmentView != null){
            listaFragmentView.actionProgress(true);
            listaFragmentInteractor.getCharactersInteractor(context);
        }
    }

    @Override
    public void convertDataToString(Result character) {
        listaFragmentInteractor.convertResultToJson(character);
    }

    @Override
    public void goToDetail(String character) {
        if (listaFragmentView != null){
            listaFragmentView.goToDetail(character);
        }
    }

    @Override
    public void getCharactersSearched(String character) {
        if (listaFragmentView != null){
            listaFragmentView.actionProgress(true);
            listaFragmentInteractor.getCharactersSearched(context,character);
        }

    }

    @Override
    public void setFavoriteCharacter(Result character, boolean isFavorite) {
        if (listaFragmentInteractor != null){
            listaFragmentInteractor.setFavoriteStatus(character,isFavorite);
        }
    }

    @Override
    public void showMessageFavorite(String name, boolean isFavorite) {
        if (listaFragmentView != null){
            listaFragmentView.showMessageFavorite(name,isFavorite);
        }
    }

    @Override
    public void noResultsFound() {
        if (listaFragmentView != null){
            listaFragmentView.noResultsFound();
        }
    }
}
