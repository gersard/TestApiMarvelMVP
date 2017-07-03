package cl.assertsoft.testapimarvelmvp.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cl.assertsoft.testapimarvelmvp.R;
import cl.assertsoft.testapimarvelmvp.adapter.ListaCharactersAdapter;
import cl.assertsoft.testapimarvelmvp.presenter.InterfacesPresenter;
import cl.assertsoft.testapimarvelmvp.utils.Funciones;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.edit_name_character_toolbar)
    EditText editNameCharacter;

    private InterfacesPresenter.ListaFragmentPresenter presenter;
    ListaCharactersAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        presenter = new ListaFragmentPresenterImpl(this, this);

        setTitle(null);


        configureUI();
    }

    private void configureUI() {
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



    @OnClick(R.id.img_btn_search_character_toolbar)
    public void searchCharacter() {
        if (editNameCharacter.getText().toString().trim().length() != 0) {
            Funciones.actionKeyboard(MainActivity.this, editNameCharacter, false);
            presenter.getCharactersSearched(editNameCharacter.getText().toString());
        }
    }


}
