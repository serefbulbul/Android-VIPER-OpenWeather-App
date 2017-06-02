package tr.com.adesso.weatherapp.utils.services.realm;

import java.util.List;

import tr.com.adesso.weatherapp.utils.services.realm.models.Bookmark;

/**
 * Created by serefbulbul on 01/06/2017.
 */

public interface RealmService {

    void createBookmark(String name);

    Bookmark getBookmark(String name);

    List<Bookmark> getAllBookmark();
}
