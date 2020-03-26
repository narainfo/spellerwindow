package org.narainfo.tool;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class CheckVersion {

	public String getVersion() throws IOException {
		
		Path path = Paths.get("C:\\dev\\versionInfo\\version.dat");
		List<String> confirmAgent = Files.readAllLines(path, StandardCharsets.UTF_8);		
		
		return confirmAgent.get(0);
	}
}
