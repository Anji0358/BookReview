package com.example.bookreview.form;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

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
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private LocalDate publishedDate;

	@NotBlank(message = "説明を入力してください")
	@Size(max = 500, message = "説明は500文字以内で入力してください")
	private String description;

}
