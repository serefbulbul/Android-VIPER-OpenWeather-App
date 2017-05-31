package tr.com.adesso.weatherapp.features.home;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.android.plugins.RxAndroidPlugins;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import tr.com.adesso.weatherapp.utils.services.OpenWeatherService;
import tr.com.adesso.weatherapp.utils.services.models.Main;
import tr.com.adesso.weatherapp.utils.services.models.WeatherData;

import static junit.framework.Assert.assertEquals;

/**
 * Created by serefbulbul on 30/05/2017.
 */
public class HomePageInteractorTest {

    private HomePageInteractor interactor;
    private OpenWeatherService openWeatherService;

    @BeforeClass
    public static void setupClass() {
        RxAndroidPlugins.setInitMainThreadSchedulerHandler(new Function<Callable<Scheduler>, Scheduler>() {
            @Override
            public Scheduler apply(Callable<Scheduler> schedulerCallable) throws Exception {
                return Schedulers.trampoline();
            }
        });
    }

    @Before
    public void setUp() throws Exception {
        openWeatherService = Mockito.mock(OpenWeatherService.class);
        interactor = new HomePageInteractor(openWeatherService);
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

        Mockito.when(openWeatherService.getWeatherData(Mockito.anyString(), Mockito.anyString(), Mockito.anyString())).thenReturn(Observable.just(weatherData));

        final HomePagePresenterModel[] responsePresenterModel = new HomePagePresenterModel[1];

        interactor.getWeatherData("asd")
                .subscribe(presenterModel -> {
                    responsePresenterModel[0] = presenterModel;

                    signal.countDown();
                });

        signal.await(5, TimeUnit.SECONDS);

        assertEquals(responsePresenterModel[0].getName(), weatherData.getName());
        assertEquals(responsePresenterModel[0].getTemp(), weatherData.getMain().getTemp());
    }
}