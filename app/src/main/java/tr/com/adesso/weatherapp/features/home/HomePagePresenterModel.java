package tr.com.adesso.weatherapp.features.home;

/**
 * Created by serefbulbul on 31/05/2017.
 */

public class HomePagePresenterModel {

    private String name;

    private Double temp;

    public HomePagePresenterModel(String name, Double temp) {
        this.name = name;
        this.temp = temp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getTemp() {
        return temp;
    }

    public void setTemp(Double temp) {
        this.temp = temp;
    }
}
