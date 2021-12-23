package pairmatching.processor;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.stream.Collectors;

public class FileProcessor {
	public List<String> readCrewNames(CrewFile crewFile) throws FileNotFoundException {
		BufferedReader br = new BufferedReader(new FileReader(crewFile.getAbsolutePath()));
		return br.lines().collect(Collectors.toList());
	}
}
