package cl.assertsoft.testapimarvelmvp.utils;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

/**
 * Created by Gerardo on 23-06-2017.
 */

public final class Funciones {

    public static void actionKeyboard(Context context, View view, boolean showKeyboard){
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        if (showKeyboard){
            imm.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT);
        }else{
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }


}
