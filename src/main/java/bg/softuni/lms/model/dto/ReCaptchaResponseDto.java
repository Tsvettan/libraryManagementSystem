package bg.softuni.lms.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.util.List;

@JsonInclude(Include.NON_NULL)
public class ReCaptchaResponseDto {

    private boolean success;
    private List<String> errorCodes;

    public boolean isSuccess() {
        return success;
    }

    public ReCaptchaResponseDto setSuccess(boolean success) {
        this.success = success;
        return this;
    }

    public List<String> getErrorCodes() {
        return errorCodes;
    }

    public ReCaptchaResponseDto setErrorCodes(List<String> errorCodes) {
        this.errorCodes = errorCodes;
        return this;
    }
}
