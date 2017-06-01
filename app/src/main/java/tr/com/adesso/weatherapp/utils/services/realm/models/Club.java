
package tr.com.adesso.weatherapp.utils.services.realm.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Club {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("legacyId")
    @Expose
    private Integer legacyId;
    @SerializedName("latitude")
    @Expose
    private String latitude;
    @SerializedName("longitude")
    @Expose
    private String longitude;
    @SerializedName("openingDate")
    @Expose
    private String openingDate;
    @SerializedName("weekdaysOpeningTime")
    @Expose
    private String weekdaysOpeningTime;
    @SerializedName("weekdaysClosingTime")
    @Expose
    private String weekdaysClosingTime;
    @SerializedName("weekendOpeningTime")
    @Expose
    private String weekendOpeningTime;
    @SerializedName("weekendClosingTime")
    @Expose
    private String weekendClosingTime;
    @SerializedName("imagesUrl")
    @Expose
    private String imagesUrl;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("clubCity")
    @Expose
    private String clubCity;
    @SerializedName("corporationType")
    @Expose
    private String corporationType;
    @SerializedName("isPresaleClub")
    @Expose
    private Boolean isPresaleClub;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getLegacyId() {
        return legacyId;
    }

    public void setLegacyId(Integer legacyId) {
        this.legacyId = legacyId;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getOpeningDate() {
        return openingDate;
    }

    public void setOpeningDate(String openingDate) {
        this.openingDate = openingDate;
    }

    public String getWeekdaysOpeningTime() {
        return weekdaysOpeningTime;
    }

    public void setWeekdaysOpeningTime(String weekdaysOpeningTime) {
        this.weekdaysOpeningTime = weekdaysOpeningTime;
    }

    public String getWeekdaysClosingTime() {
        return weekdaysClosingTime;
    }

    public void setWeekdaysClosingTime(String weekdaysClosingTime) {
        this.weekdaysClosingTime = weekdaysClosingTime;
    }

    public String getWeekendOpeningTime() {
        return weekendOpeningTime;
    }

    public void setWeekendOpeningTime(String weekendOpeningTime) {
        this.weekendOpeningTime = weekendOpeningTime;
    }

    public String getWeekendClosingTime() {
        return weekendClosingTime;
    }

    public void setWeekendClosingTime(String weekendClosingTime) {
        this.weekendClosingTime = weekendClosingTime;
    }

    public String getImagesUrl() {
        return imagesUrl;
    }

    public void setImagesUrl(String imagesUrl) {
        this.imagesUrl = imagesUrl;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getClubCity() {
        return clubCity;
    }

    public void setClubCity(String clubCity) {
        this.clubCity = clubCity;
    }

    public String getCorporationType() {
        return corporationType;
    }

    public void setCorporationType(String corporationType) {
        this.corporationType = corporationType;
    }

    public Boolean getIsPresaleClub() {
        return isPresaleClub;
    }

    public void setIsPresaleClub(Boolean isPresaleClub) {
        this.isPresaleClub = isPresaleClub;
    }

}
