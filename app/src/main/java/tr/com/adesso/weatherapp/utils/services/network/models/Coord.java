
package tr.com.adesso.weatherapp.utils.services.network.models;

import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;
import org.parceler.Parcel.Serialization;

@Parcel(Serialization.BEAN)
public class Coord {

    @SerializedName("lon")
    private Double lon;
    @SerializedName("lat")
    private Double lat;

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

}
