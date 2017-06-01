package tr.com.adesso.weatherapp.features.home;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import io.reactivex.Observable;
import io.reactivex.android.plugins.RxAndroidPlugins;
import io.reactivex.schedulers.Schedulers;
import tr.com.adesso.weatherapp.utils.ServiceResult;
import tr.com.adesso.weatherapp.utils.services.models.Main;
import tr.com.adesso.weatherapp.utils.services.models.WeatherData;
import tr.com.adesso.weatherapp.utils.services.realm.models.Person;

/**
 * Created by serefbulbul on 30/05/2017.
 */
public class HomePagePresenterTest {

    private HomePageContract.View view;
    private HomePageContract.Interactor interactor;
    private HomePageContract.Presenter presenter;

    @BeforeClass
    public static void setupClass() {
        RxAndroidPlugins.setInitMainThreadSchedulerHandler(schedulerCallable -> Schedulers.trampoline());
    }

    @Before
    public void setUp() throws Exception {
        view = Mockito.mock(HomePageContract.View.class);
        interactor = Mockito.mock(HomePageContract.Interactor.class);
        presenter = new HomePagePresenter(view, interactor);

        Mockito.when(interactor.getWeatherData(Mockito.anyString())).thenReturn(Observable.never());
        Mockito.when(view.onSomeTextChange()).thenReturn(Observable.<CharSequence>never());
        Mockito.when(view.onSomeButtonClick()).thenReturn(Observable.never());
    }

    @After
    public void tearDown() throws Exception {
        presenter.unsubscribe();
    }

    @Test
    public void testObserveContinueButtonClick_emptyPassword() throws Exception {
        WeatherData weatherData = new WeatherData();
        weatherData.setName("London");

        Main main = new Main();
        main.setTemp(18.0);

        weatherData.setMain(main);

        ServiceResult<WeatherData> result = new ServiceResult<>(weatherData);

        Mockito.when(view.onSomeButtonClick()).thenReturn(Observable.just(new Object()));
        Mockito.when(interactor.getWeatherData(Mockito.anyString())).thenReturn(Observable.just(result));

        Person person = new Person();
        person.setName("asd");

        Mockito.when(interactor.getPerson(Mockito.anyString())).thenReturn(person);

        presenter.subscribe();

        Mockito.verify(view, Mockito.times(2)).setCurrentLocationName("London");
        Mockito.verify(view, Mockito.times(2)).setCurrentLocationTemperature("18.0");
        Mockito.verify(view, Mockito.times(2)).hideProgressView();
    }
}