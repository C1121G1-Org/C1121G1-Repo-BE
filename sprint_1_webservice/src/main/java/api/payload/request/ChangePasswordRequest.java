package api.payload.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/*
    Created by KhaiTT
    Date: 22:30 31/05/2022
    Function: This object use to hold the current and new password to change password.
*/
public class ChangePasswordRequest {
    @NotBlank(message = "Vui lòng nhập mật khẩu hiện tại.")
    private String currentPassword;

    @NotBlank(message = "Vui lòng nhập mật khẩu mới.")
    @Pattern(regexp = "^.*(?=.{8,})(?=..*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$",
            message = "Mật khẩu phải có ít nhất 8 ký tự, 1 chữ viết hoa, 1 chữ viết thường, 1 ký tự đặt biệt, 1 chữ số và không được chứa khoảng trắng, tab, v.v")
    private String newPassword;
    @NotBlank(message = "Vui lòng nhập xác nhận mật khẩu mới.")
    @Pattern(regexp = "^.*(?=.{8,})(?=..*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$",
            message = "Mật khẩu phải có ít nhất 8 ký tự, 1 chữ viết hoa, 1 chữ viết thường, 1 ký tự đặt biệt, 1 chữ số và không được chứa khoảng trắng, tab, v.v")
    private String confirmNewPassword;

    public ChangePasswordRequest() {
    }

    public String getCurrentPassword() {
        return currentPassword;
    }

    public void setCurrentPassword(String currentPassword) {
        this.currentPassword = currentPassword;
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
