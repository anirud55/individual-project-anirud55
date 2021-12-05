package com.lafaconio;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class GenOP {

	public static void writeToFile(String filename, ArrayList<String> data) throws IOException {
		FileWriter fileWriter = new FileWriter(filename);
		PrintWriter printWriter = new PrintWriter(fileWriter);
		for (String line : data) {
			printWriter.println(line);
		}
		printWriter.close();
	}

}
