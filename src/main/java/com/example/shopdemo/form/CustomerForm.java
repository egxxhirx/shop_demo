package com.example.shopdemo.form;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class CustomerForm implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;

    @Size(max = 55, min = 6)
    private String email;

    @NotNull(message="メールアドレスを入力してください")
    @Size(max = 55, min = 6)
    @Pattern(regexp="[a-zA-Z0-9]*", message="パスワードは英数である必要があります")
    private String password;

}