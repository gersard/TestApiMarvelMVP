package cl.assertsoft.testapimarvelmvp.view;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.CheckBox;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import cl.assertsoft.testapimarvelmvp.R;
import cl.assertsoft.testapimarvelmvp.adapter.ListaCharactersAdapter;
import cl.assertsoft.testapimarvelmvp.model.Result;
import cl.assertsoft.testapimarvelmvp.presenter.InterfacesPresenter;
import cl.assertsoft.testapimarvelmvp.presenter.ListaFragmentPresenterImpl;
import cl.assertsoft.testapimarvelmvp.view.custom.RecyclerViewWithEmptySupport;
import cl.assertsoft.testapimarvelmvp.view.interfaces.InterfacesView;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListadoFragment extends Fragment implements InterfacesView.ListaFragmentView {


    @BindView(R.id.progress_bar)
    ProgressBar mProgressBar;
    @BindView(R.id.recycler_view)
    RecyclerViewWithEmptySupport mRecyclerView;
    @BindView(R.id.txt_empty_view_sin_resultados)
    TextView mTxtEmptyView;
    Unbinder unbinder;
    private InterfacesPresenter.ListaFragmentPresenter presenter;
    private ListaCharactersAdapter adapter;
    public ListadoFragment() {
        // Required empty public constructor
    }

    public static ListadoFragment newInstance(){
        return new ListadoFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_listado, container, false);
        unbinder = ButterKnife.bind(this, view);
        presenter = new ListaFragmentPresenterImpl(this, getActivity());
        presenter.getDataCharacters();
        configureUI();
        return view;
    }

    private void configureUI() {
        adapter = new ListaCharactersAdapter(getActivity());
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setEmptyView(mTxtEmptyView);
        mRecyclerView.setAdapter(adapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void actionProgress(boolean show) {
        if (show) {
            mProgressBar.setVisibility(View.VISIBLE);
            mRecyclerView.setVisibility(View.GONE);
            mTxtEmptyView.setVisibility(View.GONE);
        } else {
            mProgressBar.setVisibility(View.GONE);
        }
    }

    @Override
    public void showError(String error) {
        Toast.makeText(getContext(), error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showResults(List<Result> characters) {
        mProgressBar.setVisibility(View.GONE);
        mRecyclerView.setVisibility(View.VISIBLE);
        if (adapter != null) {
            adapter.addCharacters(characters);
            adapter.setItemClickListener(new ListaCharactersAdapter.ItemClickListener() {
                @Override
                public void onItemClick(Result result, int position) {
                    presenter.convertDataToString(result);
                }

                @Override
                public void onCheckedChangeListener(Result character, final CheckBox checkBox, boolean isFavorite) {
                    if (isFavorite) {
                        animateCheckboxFavorite(checkBox);
                    }
                    presenter.setFavoriteCharacter(character, isFavorite);
                }
            });

        }
    }

    @Override
    public void goToDetail(String character) {
        Intent intent = new Intent(getActivity(), DetalleCharacterActivity.class);
        intent.putExtra("info", character);
        startActivity(intent);
    }

    @Override
    public void showMessageFavorite(String name, boolean isFavorite) {
        String message = (isFavorite) ? getString(R.string.add_favorite, name) : getString(R.string.remove_favorite, name);
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void noResultsFound() {
        mProgressBar.setVisibility(View.GONE);
        mRecyclerView.setVisibility(View.VISIBLE);
        adapter.addCharacters(new ArrayList<Result>());
    }

    private void animateCheckboxFavorite(final CheckBox checkBox) {
        Animation zoomin = AnimationUtils.loadAnimation(getActivity(), R.anim.zoom_in);
        final Animation zoomout = AnimationUtils.loadAnimation(getActivity(), R.anim.zoom_out);
        checkBox.startAnimation(zoomin);
        zoomin.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                checkBox.startAnimation(zoomout);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }
}
