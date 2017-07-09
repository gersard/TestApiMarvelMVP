package cl.assertsoft.testapimarvelmvp.view;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import cl.assertsoft.testapimarvelmvp.R;
import cl.assertsoft.testapimarvelmvp.adapter.ListaFavoriteCharacterAdapter;
import cl.assertsoft.testapimarvelmvp.model.CharacterRealm;
import cl.assertsoft.testapimarvelmvp.presenter.FavoriteFragmentPresenterImpl;
import cl.assertsoft.testapimarvelmvp.presenter.InterfacesPresenter;
import cl.assertsoft.testapimarvelmvp.view.custom.RecyclerViewWithEmptySupport;
import cl.assertsoft.testapimarvelmvp.view.interfaces.InterfacesView;
import io.realm.RealmResults;

/**
 * A simple {@link Fragment} subclass.
 */
public class FavoritosFragment extends Fragment implements InterfacesView.FavoriteFragmentView{


    @BindView(R.id.recycler_favorites)
    RecyclerViewWithEmptySupport mRecyclerFavorites;
    Unbinder unbinder;
    private ListaFavoriteCharacterAdapter adapter;
    private InterfacesPresenter.FavoriteFragmentPresenter presenter;

    public FavoritosFragment() {
        // Required empty public constructor
    }

    public static FavoritosFragment newInstance() {
        return new FavoritosFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_favoritos, container, false);
        unbinder = ButterKnife.bind(this, view);
        configureUI();
        presenter = new FavoriteFragmentPresenterImpl(this);
        presenter.getFavoriteCharacters();
        return view;
    }

    private void configureUI(){
        adapter = new ListaFavoriteCharacterAdapter(getContext());
        mRecyclerFavorites.setLayoutManager(new GridLayoutManager(getContext(),2));
        mRecyclerFavorites.setAdapter(adapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void showFavoriteCharacters(RealmResults<CharacterRealm> characterRealmRealmResults) {
        adapter.addCharacters(characterRealmRealmResults);
    }
}
