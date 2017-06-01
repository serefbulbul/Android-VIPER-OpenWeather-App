package tr.com.adesso.weatherapp.utils.services.realm.models;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by serefbulbul on 01/06/2017.
 */

public class Person extends RealmObject {

    @PrimaryKey
    private long id;
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
