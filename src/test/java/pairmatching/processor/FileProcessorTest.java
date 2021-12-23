package pairmatching.processor;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class FileProcessorTest {
	@Test
	public void readNamesValidate() {
		FileProcessor fp = new FileProcessor();
		System.out.println(fp.readCrewNames(CrewFile.FRONT_END));
		System.out.println(fp.readCrewNames(CrewFile.BACK_END));
	}
}
