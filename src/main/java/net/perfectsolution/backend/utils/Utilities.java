package net.perfectsolution.backend.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Utilities {
	public static Properties getProperties(String webPath, String filename) throws IOException {

		Properties props = new Properties();
		try {
			File file = new File(webPath, filename);
			FileInputStream fis = new FileInputStream(file);
			props.load(fis);
			fis.close();
		} catch (IOException ex) {
			throw new IOException("Failed to load " + filename + ": " + ex.getMessage());
		}
		return props;
	}
}
