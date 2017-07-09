package cl.assertsoft.testapimarvelmvp.presenter;

import cl.assertsoft.testapimarvelmvp.interactor.FavoriteFragmentInteractorImpl;
import cl.assertsoft.testapimarvelmvp.interactor.InterfacesInteractor;
import cl.assertsoft.testapimarvelmvp.model.CharacterRealm;
import cl.assertsoft.testapimarvelmvp.view.interfaces.InterfacesView;
import io.realm.RealmResults;

/**
 * Created by Gerardo on 08-07-2017.
 */

public class FavoriteFragmentPresenterImpl implements InterfacesPresenter.FavoriteFragmentPresenter {

    private InterfacesView.FavoriteFragmentView view;
    private InterfacesInteractor.FavoriteFragmentInteractor interactor;

    public FavoriteFragmentPresenterImpl(InterfacesView.FavoriteFragmentView view) {
        this.view = view;
        interactor = new FavoriteFragmentInteractorImpl(this);
    }

    @Override
    public void getFavoriteCharacters() {
        if (interactor != null){
            interactor.getFavoriteCharacters();
        }
    }

    @Override
    public void showFavoriteList(RealmResults<CharacterRealm> characterRealms) {
        if (view != null){
            view.showFavoriteCharacters(characterRealms);
        }
    }
}
