package com.example.bookreview.form;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import lombok.Data;

@Data
public class ReviewForm {

	@NotBlank(message = "ユーザー名を入力してください")
	private String reviewerName;

	@NotBlank(message = "評価を入力してください")
	@Min(value = 1, message = "1-5で入力してください")
	@Max(value = 5, message = "1-5で入力してください")
	private Integer score;

	@NotBlank(message = "コメントを入力してください")
	@Size(max = 500, message = "説明は500文字以内で入力してください")
	private String content;
}
