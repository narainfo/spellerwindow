package org.narainfo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/results")
public class ResultController {
	
	//결과 화면에서 검사기 구매문의 클릭시.
	@RequestMapping("/SpellerOrder")
	public String spellerOrder() {
		return "SpellerOrder";
	}

	//결과 화면에서 의견보내기 클릭시.
	@RequestMapping("/UserReport")
	public String userReport() {
		return "UserReport";
	}
}
