
package tr.com.adesso.weatherapp.utils.services.network.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;
import org.parceler.Parcel.Serialization;

@Parcel(Serialization.BEAN)
public class Wind {

    @SerializedName("speed")
    private Double speed;
    @SerializedName("deg")
    private Integer deg;

    public Double getSpeed() {
        return speed;
    }

    public void setSpeed(Double speed) {
        this.speed = speed;
    }

    public Integer getDeg() {
        return deg;
    }

    public void setDeg(Integer deg) {
        this.deg = deg;
    }

}
