package com.lafaconio;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ParseInput {

	public static ArrayList<ArrayList<String>> parseCsvFile(String filename) {
		ArrayList<ArrayList<String>> data = new ArrayList<>();
		Scanner scanner;
		try {
			scanner = new Scanner(new File(filename));
			scanner.nextLine();
			while (scanner.hasNextLine()) {
				String[] token = scanner.nextLine().split(",");
				List<String> row = Arrays.asList(token);
				data.add(new ArrayList<>(row));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return data;
	}

}
