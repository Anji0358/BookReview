package com.example.bookreview.form;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import lombok.Data;

@Data
public class SignupForm {

	@NotBlank(message = "ユーザー名を入力してください")
	@Size(min = 3, max = 20, message = "ユーザー名は3〜20文字で入力してください")
    private String username;

    @NotBlank(message = "メールアドレスを入力してください")
    @Email(message = "メール形式で入力してください")
    private String email;

    @NotBlank(message = "パスワードを入力してください")
    @Size(min = 8, message = "パスワードは8文字以上で入力してください")
    private String password;
}
