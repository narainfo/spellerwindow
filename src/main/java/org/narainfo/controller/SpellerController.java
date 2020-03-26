package org.narainfo.controller;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.narainfo.WebSpeller;
import org.narainfo.domain.Page;
import org.narainfo.tool.WordCntCheck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
//@RequestMapping("/speller")
public class SpellerController {

	@Autowired
	private WordCntCheck wordCntCheck;

	//결과화면
	@PostMapping("/results")
	public String results(@RequestParam(value="text1", required=false) String value, String btnModeChange, @RequestParam(value="pageIdx", required=false) Integer getIdx, Model model) {
		String remainingValue = null;
		int pageIdx=0;

		if( getIdx == null){
			pageIdx = 0;
		} else{
			pageIdx = getIdx;
		}

		boolean bWeakOpt = false;
		
		if(btnModeChange == null || btnModeChange.equals("true")) {
			bWeakOpt = true;
		}

		ArrayList<String> remainingValueList = wordCntCheck.splitStr(value);

		if(remainingValueList.size()>1){
			StringBuilder tmpSb = new StringBuilder();
			for(int i = 1; i<remainingValueList.size();i++){
				tmpSb.append(remainingValueList.get(i));
			}
			remainingValue = tmpSb.toString();
		}
		
		WebSpeller webSpeller = new WebSpeller();
		List<Page> correctResultList = webSpeller.getResultHTML(remainingValueList.get(0), bWeakOpt);
		
		if(correctResultList.get(0).getErrInfo().size() == 0 && (pageIdx == 0 && remainingValueList.size() == 1)){
			return "ErrorResult";
		}
		JSONArray jsonData = new JSONArray(correctResultList);
		

		model.addAttribute("totalPageCnt", remainingValueList.size()+pageIdx);

				
		model.addAttribute("result", jsonData); //json으로 변경해서 return
		model.addAttribute("remainingValue", remainingValue);
		model.addAttribute("bWeakOpt", bWeakOpt);
		model.addAttribute("pageIdx", pageIdx);
		return "results";
	}

}
