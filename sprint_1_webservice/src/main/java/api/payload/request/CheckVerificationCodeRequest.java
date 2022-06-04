package api.payload.request;

/*
    Created by KhaiTT
    Date: 14:11 04/06/2022
    Function: This object use to hold email and code to check verification code is correct or not
*/
public class CheckVerificationCodeRequest {
    private String email;
    private String code;

    public CheckVerificationCodeRequest() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
