package api.payload.request;

/*
    Created by KhaiTT
    Date: 19:29 03/06/2022
    Function: This object use to hold new password to reset password.
*/
public class ResetPasswordRequest {
    private String email;
    private String newPassword;
    private String confirmNewPassword;

    public ResetPasswordRequest() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getConfirmNewPassword() {
        return confirmNewPassword;
    }

    public void setConfirmNewPassword(String confirmNewPassword) {
        this.confirmNewPassword = confirmNewPassword;
    }
}
