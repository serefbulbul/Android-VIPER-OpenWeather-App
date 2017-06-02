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
import tr.com.adesso.weatherapp.utils.services.network.OpenWeatherService;
import tr.com.adesso.weatherapp.utils.services.network.models.Main;
import tr.com.adesso.weatherapp.utils.services.network.models.WeatherData;
import tr.com.adesso.weatherapp.utils.services.realm.RealmService;
import tr.com.adesso.weatherapp.utils.services.realm.models.Bookmark;

import static junit.framework.Assert.assertEquals;

/**
 * Created by serefbulbul on 30/05/2017.
 */
public class HomePageInteractorTest {

    private OpenWeatherService openWeatherService;
    private RealmService realmService;
    private HomePageInteractor interactor;

    @BeforeClass
    public static void setupClass() {
        RxAndroidPlugins.setInitMainThreadSchedulerHandler(schedulerCallable -> Schedulers.trampoline());
    }

    @Before
    public void setUp() throws Exception {
        openWeatherService = Mockito.mock(OpenWeatherService.class);
        realmService = Mockito.mock(RealmService.class);
        interactor = new HomePageInteractor(openWeatherService, realmService);
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

        Bookmark bookmark = new Bookmark();
        bookmark.setName("asd");

        Mockito.when(openWeatherService.getWeatherData(Mockito.anyString(), Mockito.anyString(), Mockito.anyString())).thenReturn(Observable.just(weatherData));
        Mockito.when(realmService.getBookmark(Mockito.anyString())).thenReturn(bookmark);

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