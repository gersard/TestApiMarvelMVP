package cl.assertsoft.testapimarvelmvp.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.EditorInfo;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cl.assertsoft.testapimarvelmvp.R;
import cl.assertsoft.testapimarvelmvp.adapter.ListaCharactersAdapter;
import cl.assertsoft.testapimarvelmvp.model.Result;
import cl.assertsoft.testapimarvelmvp.presenter.MainActivityPresenter;
import cl.assertsoft.testapimarvelmvp.presenter.MainActivityPresenterImpl;
import cl.assertsoft.testapimarvelmvp.utils.Funciones;
import cl.assertsoft.testapimarvelmvp.view.custom.RecyclerViewWithEmptySupport;
import cl.assertsoft.testapimarvelmvp.view.interfaces.MainActivityView;

public class MainActivity extends AppCompatActivity implements MainActivityView {

    @BindView(R.id.progress_bar)
    ProgressBar mProgressBar;
    @BindView(R.id.recycler_view)
    RecyclerViewWithEmptySupport mRecyclerView;
    @BindView(R.id.edit_name_character_toolbar)
    EditText editNameCharacter;
    @BindView(R.id.txt_empty_view_sin_resultados)
    TextView txtEmptyViewSinResultados;
    private MainActivityPresenter presenter;
    ListaCharactersAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        presenter = new MainActivityPresenterImpl(this, this);
        presenter.getDataCharacters();
        setTitle(null);


        configureUI();
    }

    private void configureUI() {
        adapter = new ListaCharactersAdapter(this);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setEmptyView(txtEmptyViewSinResultados);
        mRecyclerView.setAdapter(adapter);

        editNameCharacter.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    presenter.getCharactersSearched(editNameCharacter.getText().toString());
                    Funciones.actionKeyboard(MainActivity.this, editNameCharacter, false);
                    return true;
                }
                return false;
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void actionProgress(boolean show) {
        if (show) {
            mProgressBar.setVisibility(View.VISIBLE);
            mRecyclerView.setVisibility(View.GONE);
            txtEmptyViewSinResultados.setVisibility(View.GONE);
        } else {
            mProgressBar.setVisibility(View.GONE);
        }
    }

    @Override
    public void showError(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
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
        Intent intent = new Intent(this, DetalleCharacterActivity.class);
        intent.putExtra("info", character);
        startActivity(intent);
    }

    @Override
    public void showMessageFavorite(String name, boolean isFavorite) {
        String message = (isFavorite) ? getString(R.string.add_favorite, name) : getString(R.string.remove_favorite, name);
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void noResultsFound() {
        mProgressBar.setVisibility(View.GONE);
        mRecyclerView.setVisibility(View.VISIBLE);
        adapter.addCharacters(new ArrayList<Result>());
    }


    @OnClick(R.id.img_btn_search_character_toolbar)
    public void searchCharacter() {
        mRecyclerView.setVisibility(View.GONE);
        if (editNameCharacter.getText().toString().trim().length() != 0) {
            Funciones.actionKeyboard(MainActivity.this, editNameCharacter, false);
            presenter.getCharactersSearched(editNameCharacter.getText().toString());
        }
    }

    private void animateCheckboxFavorite(final CheckBox checkBox) {
        Animation zoomin = AnimationUtils.loadAnimation(MainActivity.this, R.anim.zoom_in);
        final Animation zoomout = AnimationUtils.loadAnimation(MainActivity.this, R.anim.zoom_out);
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
