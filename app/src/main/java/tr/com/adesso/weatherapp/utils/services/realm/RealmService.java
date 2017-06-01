package tr.com.adesso.weatherapp.utils.services.realm;

import tr.com.adesso.weatherapp.utils.services.realm.models.Person;

/**
 * Created by serefbulbul on 01/06/2017.
 */

public interface RealmService {

    void createPerson(String name);

    Person getPerson(String name);
}
