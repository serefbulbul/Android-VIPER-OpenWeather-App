package tr.com.adesso.weatherapp.features.home;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.plugins.RxAndroidPlugins;
import io.reactivex.schedulers.Schedulers;
import tr.com.adesso.weatherapp.utils.ServiceResult;
import tr.com.adesso.weatherapp.utils.services.NetworkService;
import tr.com.adesso.weatherapp.utils.services.models.Main;
import tr.com.adesso.weatherapp.utils.services.models.WeatherData;
import tr.com.adesso.weatherapp.utils.services.realm.RealmService;
import tr.com.adesso.weatherapp.utils.services.realm.models.Person;

import static junit.framework.Assert.assertEquals;

/**
 * Created by serefbulbul on 30/05/2017.
 */
public class HomePageInteractorTest {

    private NetworkService networkService;
    private RealmService realmService;
    private HomePageInteractor interactor;

    @BeforeClass
    public static void setupClass() {
        RxAndroidPlugins.setInitMainThreadSchedulerHandler(schedulerCallable -> Schedulers.trampoline());
    }

    @Before
    public void setUp() throws Exception {
        networkService = Mockito.mock(NetworkService.class);
        realmService = Mockito.mock(RealmService.class);
        interactor = new HomePageInteractor(networkService, realmService);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testObserveContinueButtonClick_emptyPassword() throws Exception {
        final CountDownLatch signal = new CountDownLatch(1);

        WeatherData weatherData = new WeatherData();
        weatherData.setName("asd");

        Main main = new Main();
        main.setTemp(12.0);

        weatherData.setMain(main);

        Person person = new Person();
        person.setName("asd");

        Mockito.when(networkService.getWeatherData(Mockito.anyString(), Mockito.anyString(), Mockito.anyString())).thenReturn(Observable.just(weatherData));
        Mockito.when(realmService.getPerson(Mockito.anyString())).thenReturn(person);

        final List<ServiceResult<WeatherData>> results = new ArrayList<>();

        interactor.getWeatherData("asd")
                .subscribe(result -> {
                    results.add(result);

                    signal.countDown();
                });

        signal.await(5, TimeUnit.SECONDS);

        assertEquals(results.get(0).getData().getName(), weatherData.getName());
        assertEquals(results.get(0).getData().getMain().getTemp(), weatherData.getMain().getTemp());
    }
}