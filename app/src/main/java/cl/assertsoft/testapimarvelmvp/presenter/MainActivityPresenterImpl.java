package cl.assertsoft.testapimarvelmvp.presenter;

import android.content.Context;

import java.util.List;

import cl.assertsoft.testapimarvelmvp.interactor.MainActivityInteractorImpl;
import cl.assertsoft.testapimarvelmvp.interfaces.MainActivityInteractor;
import cl.assertsoft.testapimarvelmvp.interfaces.MainActivityPresenter;
import cl.assertsoft.testapimarvelmvp.interfaces.MainActivityView;
import cl.assertsoft.testapimarvelmvp.model.Result;

/**
 * Created by Gerardo on 17-06-2017.
 */

public class MainActivityPresenterImpl implements MainActivityPresenter {
    //Relación con la vista
    private MainActivityView mainActivityView;
    //Relación con le Interactor
    private MainActivityInteractor mainActivityInteractor;
    Context context;

    public MainActivityPresenterImpl(MainActivityView mainActivityView, Context context) {
        this.mainActivityView = mainActivityView;
        mainActivityInteractor = new MainActivityInteractorImpl(this);
        this.context = context;
    }

    @Override
    public void showErrorPresenter(String error) {
        if (mainActivityView != null){
            mainActivityView.actionProgress(false);
            mainActivityView.showError(error);
        }
    }

    @Override
    public void showResultPresenter(List<Result> results) {
        if (mainActivityView != null){
            mainActivityView.actionProgress(false);
            mainActivityView.showResults(results);
        }
    }

    @Override
    public void getDataCharacters() {
        if (mainActivityView != null){
            mainActivityView.actionProgress(true);
            mainActivityInteractor.getCharactersInteractor(context);
        }
    }
}
