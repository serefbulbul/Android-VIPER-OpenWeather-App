package tr.com.adesso.weatherapp.utils;

/**
 * Created by serefbulbul on 30/05/2017.
 */

public class ValidationResult {

    private Boolean valid;
    private int errorMessageId;

    public ValidationResult(Boolean valid) {
        this.valid = valid;
    }

    public ValidationResult(Boolean valid, int errorMessageId) {
        this.valid = valid;
        this.errorMessageId = errorMessageId;
    }

    public Boolean isValid() {
        return valid;
    }

    public void setValid(Boolean valid) {
        this.valid = valid;
    }

    public int getErrorMessageId() {
        return errorMessageId;
    }

    public void setErrorMessageId(int errorMessageId) {
        this.errorMessageId = errorMessageId;
    }
}