package com.example.bookreview.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import lombok.Data;

@Data
public class BookForm {

	@NotBlank(message = "タイトルを入力してください")
	@Size(max = 100, message = "タイトルは100文字以内で入力してください")
	private String title;

	@NotBlank(message = "著者名を入力してください")
	@Size(max = 100, message = "著者名は20文字以内で入力してください")
	private String author;

	@NotBlank(message = "出版日を入力してください")
	@Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$", message = "出版日はYYYY-MM-DD形式で入力してください")
	private String isbn;

	@NotBlank(message = "説明を入力してください")
	@Size(max = 500, message = "説明は500文字以内で入力してください")
	private String description;

}
