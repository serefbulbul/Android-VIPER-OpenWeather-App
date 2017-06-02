
package tr.com.adesso.weatherapp.utils.services.network.models;

import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;
import org.parceler.Parcel.Serialization;

@Parcel(Serialization.BEAN)
public class Clouds {

    @SerializedName("all")
    private Integer all;

    public Integer getAll() {
        return all;
    }

    public void setAll(Integer all) {
        this.all = all;
    }

}
