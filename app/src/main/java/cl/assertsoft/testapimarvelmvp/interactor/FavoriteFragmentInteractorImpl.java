package cl.assertsoft.testapimarvelmvp.interactor;

import android.util.Log;

import cl.assertsoft.testapimarvelmvp.model.CharacterRealm;
import cl.assertsoft.testapimarvelmvp.presenter.InterfacesPresenter;
import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmResults;

/**
 * Created by Gerardo on 08-07-2017.
 */

public class FavoriteFragmentInteractorImpl implements InterfacesInteractor.FavoriteFragmentInteractor {

    InterfacesPresenter.FavoriteFragmentPresenter presenter;

    public FavoriteFragmentInteractorImpl(InterfacesPresenter.FavoriteFragmentPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void getFavoriteCharacters() {
        Realm realm = Realm.getDefaultInstance();
        RealmResults<CharacterRealm> characterRealms = realm.where(CharacterRealm.class).equalTo(CharacterRealm.CHARACTER_FAVORITE,true).findAllAsync();
        characterRealms.addChangeListener(new RealmChangeListener<RealmResults<CharacterRealm>>() {
            @Override
            public void onChange(RealmResults<CharacterRealm> characterRealms) {
                if (presenter != null){
                    presenter.showFavoriteList(characterRealms);
                }
            }
        });

    }
}
