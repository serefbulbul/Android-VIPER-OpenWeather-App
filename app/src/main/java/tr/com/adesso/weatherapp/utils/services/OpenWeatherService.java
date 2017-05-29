package tr.com.adesso.weatherapp.utils.services;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;
import tr.com.adesso.weatherapp.utils.services.models.WeatherData;

/**
 * Created by serefbulbul on 29/05/2017.
 */

public interface OpenWeatherService {

    @GET("weather?")
    Observable<WeatherData> getWeatherDataWithLatAndLon(@Query("lat") int lat,
                                                        @Query("lon") int lon,
                                                        @Query("appid") String id,
                                                        @Query("units") String unit);
    @GET("weather?")
    Observable<WeatherData> getWeatherData(@Query("q") String city,
                                           @Query("appid") String id,
                                           @Query("units") String unit);
}
