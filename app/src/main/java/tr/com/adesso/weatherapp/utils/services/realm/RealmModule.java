package tr.com.adesso.weatherapp.utils.services.realm;

import dagger.Module;
import dagger.Provides;
import io.realm.Realm;
import tr.com.adesso.weatherapp.app.AppScope;

/**
 * Created by serefbulbul on 01/06/2017.
 */

@Module
public class RealmModule {

    @AppScope
    @Provides
    public Realm realm() {
        return Realm.getDefaultInstance();
    }

    @AppScope
    @Provides
    public RealmService realmService(Realm realm) {
        return new RealmServiceImpl(realm);
    }
}
