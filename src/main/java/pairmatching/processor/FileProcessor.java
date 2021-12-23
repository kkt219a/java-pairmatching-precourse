package pairmatching.processor;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FileProcessor {
	/**
	 * 파일을 찾을 수 없을 땐 빈 리스트를 반환한다.
	 * @param crewFile - 어떤 크루 파일을 가져올 지 입력한다.
	 * @return 크루들의 이름 리스트를 반환한다.
	 */
	public List<String> readCrewNames(CrewFile crewFile) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(crewFile.getAbsolutePath()));
			return br.lines().collect(Collectors.toList());
		} catch (FileNotFoundException e) {
			return new ArrayList<>();
		}
	}
}
