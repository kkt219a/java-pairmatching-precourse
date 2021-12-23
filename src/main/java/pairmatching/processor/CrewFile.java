package pairmatching.processor;

import java.net.URL;
import java.util.Objects;

public enum CrewFile {
	FRONT_END("frontend-crew.md"),
	BACK_END("backend-crew.md");

	private final String fileName;

	CrewFile(String fileName) {
		this.fileName = fileName;
	}

	public String getAbsolutePath() {
		URL fileUrl = CrewFile.class.getClassLoader().getResource(this.fileName);
		Objects.requireNonNull(fileUrl);
		return fileUrl.getPath();
	}
}
