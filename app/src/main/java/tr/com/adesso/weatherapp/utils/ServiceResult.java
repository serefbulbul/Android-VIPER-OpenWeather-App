package tr.com.adesso.weatherapp.utils;

/**
 * Created by serefbulbul on 01/06/2017.
 */

public class ServiceResult<T> {

    private int errorCode;
    private String errorMessage;

    private T data;
    private ADSError error;

    public ServiceResult(T data) {
        this.data = data;
    }

    public ServiceResult(ADSError error) {
        this.error = error;
    }

    public ServiceResult(Throwable throwable) {
        error = new ADSError(throwable);
    }

    public ADSError getError() {
        return error;
    }

    public void setError(ADSError error) {
        this.error = error;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
