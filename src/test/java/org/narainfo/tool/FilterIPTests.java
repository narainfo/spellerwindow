package org.narainfo.tool;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FilterIPTests {

	@Autowired
	private FilterIP filterIP;
	
	@Test
	public void IP허용() throws IOException {
		
		assertThat(filterIP.filterUserIP("203.246.171.170")).isTrue();
		assertThat(filterIP.filterUserIP("203.246.171.155")).isTrue();
		assertThat(filterIP.filterUserIP("203.246.171.110")).isTrue();
		assertThat(filterIP.filterUserIP("211.56.96.201")).isTrue();
		assertThat(filterIP.filterUserIP("211.56.96.200")).isTrue();
		assertThat(filterIP.filterUserIP("211.56.96.199")).isTrue();
		assertThat(filterIP.filterUserIP("211.56.96.198")).isTrue();
		assertThat(filterIP.filterUserIP("211.56.96.197")).isTrue();
		assertThat(filterIP.filterUserIP("211.56.96.196")).isTrue();
		assertThat(filterIP.filterUserIP("110.15.18.136")).isTrue();
	}
}
