package com.epam.task2;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadInfo {
	public static String readLines(String fileIn) throws IOException {
		FileInputStream inputStream = null;
		try {
			inputStream = new FileInputStream(fileIn);
			byte[] str = new byte[inputStream.available()];
			inputStream.read(str);
			String everything = new String(str);
			return everything;
		}
		catch (java.io.FileNotFoundException e) {
			System.out.println("File not found!");
			System.exit(0);
			return e.toString();
		}
		finally{
			inputStream.close();
		}
	}
	
}