package org.narainfo.controller;

import java.io.IOException;

import org.narainfo.tool.CheckVersion;
import org.narainfo.tool.FilterIP;
import org.narainfo.tool.GetIP;
import org.narainfo.tool.SendMail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	@Autowired
	private GetIP getIP;
	
	@Autowired
	private FilterIP filterIP;
	
	@Autowired
	private SendMail sendMail;
	
	@Autowired
	private CheckVersion checkVersion;
	
	//메인
	@RequestMapping("/")
	public String index(Model model) throws IOException {
		//IP확인 후 차단일 경우 DeniedAccess로 아닐경우 index로 이동.
		String ip = getIP.getClientIP();
		boolean chk = filterIP.filterUserIP(ip);
		
		if(!chk) {
			return "DeniedAccess";
		}
		
		model.addAttribute("version", checkVersion.getVersion());
		return "index";
	}
	
	//검사기 구매 문의 페이지
	@RequestMapping("/SpellerOrder")
	public String spellerOrder() {
		return "SpellerOrder";
	}

	//'의견 보내기' 페이지
	@RequestMapping("/UserReport")
	public String userReport() {
		return "UserReport";
	}
	
	//메일 보내기 버튼 클릭시 작동.
	@RequestMapping("/SendMail")
	public String SendMail(@RequestParam("content") String contents) {
		sendMail.send(contents);
		return "redirect:/";
	}
	
}
