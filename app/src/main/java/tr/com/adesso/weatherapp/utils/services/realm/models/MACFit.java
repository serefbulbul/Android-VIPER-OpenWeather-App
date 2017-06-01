
package tr.com.adesso.weatherapp.utils.services.realm.models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MACFit {

    @SerializedName("data")
    @Expose
    private List<Club> data = null;
    @SerializedName("success")
    @Expose
    private Boolean success;

    public List<Club> getData() {
        return data;
    }

    public void setData(List<Club> data) {
        this.data = data;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

}
