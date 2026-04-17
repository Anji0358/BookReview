package com.example.bookreview.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        // ログイン判定を無視して、直接本のリストへ
        return "redirect:/books";
    }
}

/*
@Controller
public class HomeController {
	
	@GetMapping("/")
	public String home(Authentication authentication) {
	    // 認証情報が存在し、かつ匿名ユーザーでない場合（ログイン済み）
	    if (authentication != null && authentication.isAuthenticated() && 
	        !(authentication instanceof AnonymousAuthenticationToken)) {
	        return "redirect:/books";
	    }

	    // 未ログインならログイン画面へ
	    return "redirect:/login";
	}
}
*/