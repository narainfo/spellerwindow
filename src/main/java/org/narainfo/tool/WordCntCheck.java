package org.narainfo.tool;

import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class WordCntCheck {

	public ArrayList<String> splitStr(String query){
		
		ArrayList<String> splitStr = new ArrayList<String>();

		int wordCnt = 0;
		
		String[] splitQuery = query.split("\\n");

		StringBuffer sb = new StringBuffer();
		
		for(int i=0;i<splitQuery.length;i++) {

			wordCnt += splitQuery[i].length();
			sb.append(splitQuery[i]);
			
			if(wordCnt>1200 || i == splitQuery.length-1) {
				wordCnt = 0;
				splitStr.add(sb.toString());
				sb = new StringBuffer();
			}
		}
	
		return splitStr;
	}
}
