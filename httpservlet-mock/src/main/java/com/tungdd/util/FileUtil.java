package com.tungdd.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FileUtil {

	static final Logger logger = LogManager.getLogger(FileUtil.class);

	public static String readFile(String urlFile) {
		try {
			File myObj = new File(urlFile);
			Scanner myReader = new Scanner(myObj);
			StringBuilder sb = new StringBuilder();
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
//	        System.out.println(data);
				sb.append(data);
			}
			myReader.close();
			return sb.toString();
		} catch (FileNotFoundException e) {
			logger.error("An error occurred. " + e);
			e.printStackTrace();
		}
		return null;
	}
}
