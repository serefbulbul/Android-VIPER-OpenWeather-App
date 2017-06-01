package tr.com.adesso.weatherapp.utils;


import retrofit2.adapter.rxjava2.HttpException;

/**
 * Created by serefbulbul on 01/06/2017.
 */

public class ADSError {

    private int errorCode;
    private String errorMessage;

    public ADSError(int errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public ADSError(Throwable throwable) {
        HttpException httpException = (HttpException) throwable;

        errorCode = httpException.response().code();
        errorMessage = httpException.response().message();
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
