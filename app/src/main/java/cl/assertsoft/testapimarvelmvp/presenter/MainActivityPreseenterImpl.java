package cl.assertsoft.testapimarvelmvp.presenter;

import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;

import cl.assertsoft.testapimarvelmvp.interactor.InterfacesInteractor;
import cl.assertsoft.testapimarvelmvp.interactor.MainActivityInteractorImpl;
import cl.assertsoft.testapimarvelmvp.view.interfaces.InterfacesView;

/**
 * Created by Gerardo on 02-07-2017.
 */

public class MainActivityPreseenterImpl implements InterfacesPresenter.MainActivityPresenter {

    private InterfacesView.MainActivityView mainActivityView;
    InterfacesInteractor.MainActivityInteractor interactor;

    public MainActivityPreseenterImpl(InterfacesView.MainActivityView mainActivityView) {
        this.mainActivityView = mainActivityView;
        interactor = new MainActivityInteractorImpl(this);
    }

    @Override
    public void navigateFragment(Fragment fragment) {
        mainActivityView.replaceFragment(fragment);
    }

    @Override
    public void navigationItemSelected(MenuItem item, DrawerLayout drawerLayout) {
        interactor.navigateTo(item,drawerLayout);
    }
}
