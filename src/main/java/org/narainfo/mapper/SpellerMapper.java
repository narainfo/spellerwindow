package org.narainfo.mapper;

import org.narainfo.domain.ReplaceData;
import org.narainfo.domain.ReportData;
import org.narainfo.domain.SpellerData;
import org.springframework.stereotype.Repository;

@Repository
public interface SpellerMapper {

	public void insertClickReplace(ReplaceData replaceData) throws Exception;
	public void insertUserReplace(SpellerData spellerData) throws Exception;
	public void insertUserReplaceBackup(SpellerData spellerData) throws Exception;
	public void insertNoChange(SpellerData spellerData) throws Exception;
	public void insertBugreport(ReportData reportData) throws Exception;
}
