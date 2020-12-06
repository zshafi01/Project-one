package com.simplilearn;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Stream;

public class HandlingFile {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("============================================================");
		System.out.println("===========Welcome To FileHandling Site=====================");
		System.out.println("============================================================");
		System.out.println("Please insert your user name:");
		String userName = scan.next();
		System.out.println("Welcome "+userName+", to our site! \n");
		
		String conti = "";

		do {
			System.out.println("Please choose your needs from the Options:");

			System.out.println("Option 1. If you want to see Existing files.");
			System.out.println("Option 2. If you want to add, delete or search file");
			System.out.println("============================================================");

			Integer userChose = scan.nextInt();

			if (userChose.equals(1)) {
				System.out.println("The following are list of Existing files.");
				listOfFiles();

			} else if (userChose.equals(2)) {
				System.out.println("Choose options from the list");
				System.out.println("============================================================");
				System.out.println("1.Adding a file");
				System.out.println("2.Deleting a file");
				System.out.println("3.Searching a file");
				System.out.println("4.Exit");
				Integer userchose = scan.nextInt();
				switch (userchose) {
				case 1:
					System.out.println("Add file");
					addFile();
					break;
				case 2:
					System.out.println("Delete file");
					deletingFile();
					break;
				case 3:
					System.out.println("Search file");
					searchingFile();
					break;
				case 4:
					System.out.println("Exit");
					break;
				default:
					System.out.println("Incorect choise. Please enter the correct choise");
				}
			} else {
				System.out.println("Incorect choise. Please enter correct choise");
			}
			
		System.out.println("Do you want to continue? y/n");
		conti = scan.next();
		} while (conti.equalsIgnoreCase("y"));
		System.out.println("Exiting...");
		System.out.println("Thank you for using our application.");

	}

	public static void listOfFiles() {
		System.out.println("============list of files======================================");
		File folder = new File("Myfiles");
		String contents[] = folder.list();

		for (int i = 0; i < contents.length; i++) {
			System.out.println(contents[i]);

		}
		System.out.println("=============list of files end=================================");
	}

	public static void addFile() {
		System.out.println("==============Adding file starts================================");
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter file name you want to add:");
		String Userfiletoadd = scan.next();

		Path path = Paths.get("Myfiles", Userfiletoadd);
		try (BufferedWriter writer = Files.newBufferedWriter(path)) {
			writer.write("welcome to simple learn");
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("File is added.");
		listOfFiles();
		System.out.println("===============Adding file ends==================================");
	}

	public static void deletingFile() {
		System.out.println("================Deleting file starts==============================");
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter file name you want to delete:");
		String Userfile = scan.next();

		Path path = Paths.get("Myfiles", Userfile);
		if (Files.exists(path)) {
			try {
				Files.delete(path);
				System.out.println("File is deleted.");
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}else {
			System.out.println("File is not found to delete.");
		}
		
		
		listOfFiles();
		System.out.println("==============Deleting file ends==================================");

	}

	public static void searchingFile() {
		System.out.println("==============Searching file starts===============================");
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter file name:");
		String Userfile = scan.next();

		Path path = Paths.get("Myfiles", Userfile);
		if (Files.exists(path)) {
			System.out.println("file is found");
		} else {
			System.out.println("file is not found:");
		}
		System.out.println("==============Searching file ends=================================");

	}
}
