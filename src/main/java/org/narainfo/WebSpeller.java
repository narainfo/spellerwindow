package org.narainfo;

import java.util.ArrayList;
import java.util.List;

import org.narainfo.domain.ErrInfo;
import org.narainfo.domain.Page;
import org.narainfo.tool.ParseXml;
import org.narainfo.tool.WordCntCheck;

public class WebSpeller {
    // Native method declaration
    native byte[] Check(byte[] _strInput, boolean bWeakOpt);
    //native byte[] Check(byte[] _strInput);	
    native byte[] CheckNext(byte[] _strInput, boolean bWeakOpt);
	native void AddUserDic(byte[] _strInput);
	native void DeleteUserDic(byte[] _strInput);
	native void AddExUserDic(byte[] _strWord, byte[] _strCandWord, int nKind);
	native void DeleteExUserDic(byte[] _strWord);

	// Load the library
	static {
		System.load("C:\\dev\\module\\PnuNlpCore.dll");
	}

	//입력받은 문장을 검사하여 결과 출력. 300어절씩 나누어서 pageList에 저장.
	public List<Page> getResultHTML(String query, boolean bWeakOpt) {

		byte buf[];
		String tmp = "";
		List<Page> pageList = new ArrayList<Page>();
		try {
				buf = Check(query.getBytes("UTF-8"), bWeakOpt);
				tmp = new String(buf, "EUC-KR");
				ParseXml parseXml = new ParseXml();
				List<ErrInfo> errList = parseXml.Parsing(tmp);
			
				Page page = new Page(0, query, errList);
				pageList.add(page);

			return pageList;
		} catch (Exception e) {
		}

		return null;
	}

	//xml 원문 그대로 유지하여 return, 앱이나 다른 사이트에서 연동해서 파싱 후 사용하는 사람 대상.
	public String getResultXML(String query, boolean bWeakOpt) {
		
		byte buf[];
		try {
			buf = Check(query.getBytes("UTF-8"), bWeakOpt);
			//String result = new String(buf,"UTF-8");
			String result = new String(buf,"EUC-KR");
			return result;
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
}
