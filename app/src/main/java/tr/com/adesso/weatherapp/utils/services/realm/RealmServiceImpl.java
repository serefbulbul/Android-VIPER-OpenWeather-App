package tr.com.adesso.weatherapp.utils.services.realm;

import io.realm.Realm;
import tr.com.adesso.weatherapp.utils.RealmUtils;
import tr.com.adesso.weatherapp.utils.services.realm.models.Person;

/**
 * Created by serefbulbul on 01/06/2017.
 */

public class RealmServiceImpl implements RealmService {

    private final Realm realm;

    public RealmServiceImpl(Realm realm) {
        this.realm = realm;
    }

    @Override
    public void createPerson(String name) {
        realm.beginTransaction();

        Person person = realm.createObject(Person.class, RealmUtils.getPrimaryKeyId(realm.where(Person.class)));
        person.setName(name);

        realm.commitTransaction();
    }

    @Override
    public Person getPerson(String name) {
        realm.beginTransaction();

        Person person = realm.where(Person.class).equalTo("name", name).findFirst();

        realm.commitTransaction();

        return person;
    }
}
