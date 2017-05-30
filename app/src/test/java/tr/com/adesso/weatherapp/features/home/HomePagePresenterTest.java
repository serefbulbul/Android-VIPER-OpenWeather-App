package tr.com.adesso.weatherapp.features.home;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import tr.com.adesso.weatherapp.utils.services.models.Main;
import tr.com.adesso.weatherapp.utils.services.models.WeatherData;

import static org.junit.Assert.*;

/**
 * Created by serefbulbul on 30/05/2017.
 */
public class HomePagePresenterTest {

    private HomePageInteractor interactor;
    private HomePagePresenter presenter;

    @Before
    public void setUp() throws Exception {
        interactor = Mockito.mock(HomePageInteractor.class);
        presenter = new HomePagePresenter(interactor);

        Mockito.when(presenter.getOnSomeTextChange()).thenReturn(Observable.<String>never());
    }

    @After
    public void tearDown() throws Exception {
        presenter.unsubscribe();
    }

    @Test
    public void testObserveContinueButtonClick_emptyPassword() throws Exception {
        final CountDownLatch signal = new CountDownLatch(2);

        final WeatherData weatherData = new WeatherData();
        weatherData.setName("asd");

        Main main = new Main();
        main.setTemp(12.0);

        weatherData.setMain(main);

        Mockito.when(interactor.observeLondonData()).thenReturn(Observable.just(weatherData));

        final Object[] weatherStrings = new Object[2];

        presenter.getWeatherDataName()
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        weatherStrings[0] = s;

                        signal.countDown();
                    }
                });

        presenter.getWeatherDataTemperature()
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        weatherStrings[1] = s;

                        signal.countDown();
                    }
                });

        presenter.subscribe();

        signal.await(5, TimeUnit.SECONDS);

        assertEquals(weatherStrings[0], weatherData.getName());
        assertEquals(weatherStrings[1], String.valueOf(weatherData.getMain().getTemp()));
    }
}