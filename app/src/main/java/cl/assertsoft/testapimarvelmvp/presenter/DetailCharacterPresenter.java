package cl.assertsoft.testapimarvelmvp.presenter;

import cl.assertsoft.testapimarvelmvp.model.Result;

/**
 * Created by Gerardo on 22-06-2017.
 */

public interface DetailCharacterPresenter {

    void convertDataToObject(String info);
    void showInfoDetail(Result info);

}
