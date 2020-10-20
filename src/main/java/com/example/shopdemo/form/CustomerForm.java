package com.example.shopdemo.form;

import java.io.Serializable;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


import lombok.Data;

@Data
public class CustomerForm implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;

    @Email(message="メールアドレスの形式が間違っています")
    @NotBlank(message="メールアドレスを入力してください")
    private String email;

    @NotNull(message="パスワードを入力してください")
    @Size(max = 55, min = 6, message="パスワードは6文字以上55文字以内の英数である必要があります")
    @Pattern(regexp="[a-zA-Z0-9]*", message="パスワードは英数である必要があります")
    private String password;

    @NotNull(message="確認用パスワードを入力してください")
    private String confirmPassword;

    @AssertTrue(message="確認用パスワードが一致しません")
    public boolean isValidPassword() {
        if(password.equals(confirmPassword)) return true;
        return false;
    }
}