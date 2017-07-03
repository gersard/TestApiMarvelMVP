package cl.assertsoft.testapimarvelmvp.interactor;

import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;

import cl.assertsoft.testapimarvelmvp.R;
import cl.assertsoft.testapimarvelmvp.presenter.InterfacesPresenter;
import cl.assertsoft.testapimarvelmvp.view.FavoritosFragment;
import cl.assertsoft.testapimarvelmvp.view.ListadoFragment;

/**
 * Created by Gerardo on 02-07-2017.
 */

public class MainActivityInteractorImpl implements InterfacesInteractor.MainActivityInteractor {

    private InterfacesPresenter.MainActivityPresenter presenter;

    public MainActivityInteractorImpl(InterfacesPresenter.MainActivityPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void navigateTo(MenuItem item, DrawerLayout drawerLayout) {
        switch (item.getItemId()){
            case R.id.nav_inicio:
                presenter.navigateFragment(ListadoFragment.newInstance());
                break;
            case R.id.nav_favoritos:
                presenter.navigateFragment(FavoritosFragment.newInstance());
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
    }
}
