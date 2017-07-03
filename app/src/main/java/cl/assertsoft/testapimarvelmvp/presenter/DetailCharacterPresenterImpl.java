package cl.assertsoft.testapimarvelmvp.presenter;

import android.content.Context;

import cl.assertsoft.testapimarvelmvp.interactor.DetailCharacterInteractorImpl;
import cl.assertsoft.testapimarvelmvp.interactor.InterfacesInteractor;
import cl.assertsoft.testapimarvelmvp.model.Result;
import cl.assertsoft.testapimarvelmvp.view.interfaces.InterfacesView;

/**
 * Created by Gerardo on 22-06-2017.
 */

public class DetailCharacterPresenterImpl implements InterfacesPresenter.DetailCharacterPresenter {

    private InterfacesView.DetailCharacterView detailCharacterView;
    private InterfacesInteractor.DetailCharacterInteractor interactor;
    Context context;

    public DetailCharacterPresenterImpl(InterfacesView.DetailCharacterView detailCharacterView, Context context) {
        this.detailCharacterView = detailCharacterView;
        this.context = context;
        interactor = new DetailCharacterInteractorImpl(this);
    }

    @Override
    public void convertDataToObject(String info) {
        interactor.convertDataToObject(info);
    }

    @Override
    public void showInfoDetail(Result info) {
        if (detailCharacterView != null){
            detailCharacterView.showInfo(info);
        }
    }
}
