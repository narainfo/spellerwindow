package org.narainfo.domain;

//에러정보 vo
public class ErrInfo {

	private int ErrorIdx;
	private String OrgStr;
	private String CandWord;
	private String Help;
	private int Start;
	private int End;
	private int CorrectMethod;
	
	public int getErrorIdx() {
		return ErrorIdx;
	}

	public void setErrorIdx(int errorIdx) {
		this.ErrorIdx = errorIdx;
	}

	public String getOrgStr() {
		return OrgStr;
	}

	public void setOrgStr(String orgStr) {
		this.OrgStr = orgStr;
	}

	public String getCandWord() {
		return CandWord;
	}

	public void setCandWord(String candWord) {
		this.CandWord = candWord;
	}

	public String getHelp() {
		return Help;
	}

	public void setHelp(String help) {
		this.Help = help;
	}

	public int getStart() {
		return Start;
	}

	public void setStart(int start) {
		this.Start = start;
	}

	public int getEnd() {
		return End;
	}

	public void setEnd(int end) {
		this.End = end;
	}
	
	public int getCorrectMethod() {
		return CorrectMethod;
	}

	public void setcorrectMethod(int CorrectMethod) {
		this.CorrectMethod = CorrectMethod;
	}
	
	public ErrInfo(int errorIdx, String orgStr, String candWord, String help, int CorrectMethod, int start, int end) {
		
		this.ErrorIdx = errorIdx;
		this.OrgStr = orgStr;
		this.CandWord = candWord;
		this.Help = help;
		this.CorrectMethod = CorrectMethod;
		this.Start = start;
		this.End = end;
	}

	@Override
	public String toString() {
		return "ErrInfo [ErrorIdx=" + ErrorIdx + ", OrgStr=" + OrgStr + ", CandWord=" + CandWord + ", Help=" + Help
				+ ", CorrectMethod=" + CorrectMethod + ", Start=" + Start + ", End=" + End + "]";
	}



}
