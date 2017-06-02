package tr.com.adesso.weatherapp.utils.services.realm;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;
import tr.com.adesso.weatherapp.utils.RealmUtils;
import tr.com.adesso.weatherapp.utils.services.realm.models.Bookmark;

/**
 * Created by serefbulbul on 01/06/2017.
 */

public class RealmServiceImpl implements RealmService {

    private final Realm realm;

    public RealmServiceImpl(Realm realm) {
        this.realm = realm;
    }

    @Override
    public void createBookmark(String name) {
        realm.beginTransaction();

        Bookmark bookmark = realm.createObject(Bookmark.class, RealmUtils.getPrimaryKeyId(realm.where(Bookmark.class)));
        bookmark.setName(name);

        realm.commitTransaction();
    }

    @Override
    public Bookmark getBookmark(String name) {
        realm.beginTransaction();

        Bookmark bookmark = realm.where(Bookmark.class).equalTo("name", name).findFirst();

        realm.commitTransaction();

        return bookmark;
    }

    @Override
    public List<Bookmark> getAllBookmark() {
        realm.beginTransaction();

        RealmResults<Bookmark> realmResults = realm.where(Bookmark.class).findAll();

        List<Bookmark> bookmarks = realm.copyFromRealm(realmResults);

        realm.commitTransaction();

        return bookmarks;
    }
}
