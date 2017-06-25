package cl.assertsoft.testapimarvelmvp;

import android.app.Application;

import com.facebook.stetho.Stetho;
import com.uphyca.stetho_realm.RealmInspectorModulesProvider;

import java.util.concurrent.atomic.AtomicInteger;

import cl.assertsoft.testapimarvelmvp.model.CharacterRealm;
import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.RealmResults;

/**
 * Created by Gerardo on 24-06-2017.
 */

public class MyApplication extends Application {

    public static AtomicInteger characterID;

    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
//        RealmLog.setLevel(LogLevel.ALL);

        Realm realm = Realm.getDefaultInstance();
        characterID = getIdByTable(realm, CharacterRealm.class,CharacterRealm.CHARACTER_ID);
        realm.close();

        Stetho.initialize(
                Stetho.newInitializerBuilder(this)
                        .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
                        .enableWebKitInspector(RealmInspectorModulesProvider.builder(this).build())
                        .build());

    }


    private <T extends RealmObject> AtomicInteger getIdByTable(Realm realm, Class<T> anyClass,String idColumnName){
        RealmResults<T> results = realm.where(anyClass).findAll();
        return (results.size()>0) ?  new AtomicInteger(results.max(idColumnName).intValue()) : new AtomicInteger();

    }

}
