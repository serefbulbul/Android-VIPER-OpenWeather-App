package tr.com.adesso.weatherapp.utils;

/**
 * Created by serefbulbul on 29/05/2017.
 */

public final class Constants {

    private Constants() {

    }

    public static final String TIMBER_LOG = "TIMBER_LOG";
    public static final String HTTP_CACHE_DIR = "okhttp_cache";
    public static final int HTTP_CACHE_SIZE = 10 * 1024 * 1024; //10MB
    public static final long THROTTLE_TIME_IN_MILLISECONDS = 500;
    public static final String OPEN_WEATHER_API_KEY = "4abf3b21b72f324add11d4445f40f32a";
}
