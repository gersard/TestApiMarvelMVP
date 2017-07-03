package cl.assertsoft.testapimarvelmvp.interactor;

import com.google.gson.Gson;

import cl.assertsoft.testapimarvelmvp.model.Result;
import cl.assertsoft.testapimarvelmvp.presenter.InterfacesPresenter;

/**
 * Created by Gerardo on 22-06-2017.
 */

public class DetailCharacterInteractorImpl implements InterfacesInteractor.DetailCharacterInteractor {

    InterfacesPresenter.DetailCharacterPresenter presenter;

    public DetailCharacterInteractorImpl(InterfacesPresenter.DetailCharacterPresenter presenter) {
        this.presenter = presenter;
    }


    @Override
    public void convertDataToObject(String data) {
        Gson gson = new Gson();
        Result info = gson.fromJson(data,Result.class);
        presenter.showInfoDetail(info);
    }
}
