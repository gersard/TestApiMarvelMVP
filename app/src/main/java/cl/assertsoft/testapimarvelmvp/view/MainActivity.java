package cl.assertsoft.testapimarvelmvp.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
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
import cl.assertsoft.testapimarvelmvp.presenter.InterfacesPresenter;
import cl.assertsoft.testapimarvelmvp.presenter.ListaFragmentPresenterImpl;
import cl.assertsoft.testapimarvelmvp.presenter.MainActivityPreseenterImpl;
import cl.assertsoft.testapimarvelmvp.utils.Funciones;
import cl.assertsoft.testapimarvelmvp.view.interfaces.InterfacesView;

public class MainActivity extends AppCompatActivity implements InterfacesView.MainActivityView,NavigationView.OnNavigationItemSelectedListener {


    @BindView(R.id.edit_name_character_toolbar)
    EditText editNameCharacter;
    @BindView(R.id.nav_view)
    NavigationView navView;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;

    private InterfacesPresenter.ListaFragmentPresenter listaFragmentPresenter;
    private InterfacesPresenter.MainActivityPresenter mainActivityPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        setTitle(null);
        configureUI(toolbar);
    }

    private void configureUI(Toolbar toolbar) {
        ListadoFragment fragment = ListadoFragment.newInstance();
        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commitAllowingStateLoss();
        listaFragmentPresenter = new ListaFragmentPresenterImpl(fragment, this);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();


        editNameCharacter.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    listaFragmentPresenter.seearchCharacter(editNameCharacter.getText().toString());
                    Funciones.actionKeyboard(MainActivity.this, editNameCharacter, false);
                    return true;
                }
                return false;
            }
        });

        mainActivityPresenter = new MainActivityPreseenterImpl(this);
//        mainActivityPresenter.navigationItemSelected();
        navView.getMenu().performIdentifierAction(R.id.nav_inicio,0);
        navView.setNavigationItemSelectedListener(this);

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
            listaFragmentPresenter.seearchCharacter(editNameCharacter.getText().toString());
        }
    }


    @Override
    public void replaceFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment)
                .commitAllowingStateLoss();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        mainActivityPresenter.navigationItemSelected(item,drawerLayout);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else{
            super.onBackPressed();
        }

    }
}
