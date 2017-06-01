package tr.com.adesso.weatherapp.utils;

import io.realm.RealmQuery;

/**
 * Created by serefbulbul on 01/06/2017.
 */

public class RealmUtils {

    public static int getPrimaryKeyId(RealmQuery<?> realmQuery) {
        if (realmQuery.max("id") != null)
            return realmQuery.max("id").intValue() + 1;
        return 0;
    }
}
