package com.example.bookreview.form;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class SignupForm {

	@NotBlank(message = "ユーザー名を入力してください")
    private String username;

    @NotBlank(message = "メールアドレスを入力してください")
    @Email(message = "メール形式で入力してください")
    private String email;

    @NotBlank(message = "パスワードを入力してください")
    private String password;
}
