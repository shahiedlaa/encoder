package com.luv2code.springcoredemo;

import com.luv2code.springcoredemo.common.Characters;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.Scanner;

@SpringBootApplication
public class SpringcoredemoApplication {

	static void main(String[] args) {
		Characters characters = new Characters();
		Scanner scanner = new Scanner(System.in);
		String choice;
		String offset;
		String text;
		String textToEncode;
		String textToDecode;

		while (true) {
			System.out.println("Hello... Do you want to (E)ncode or (D)ecode?");
			choice = scanner.nextLine().trim().toUpperCase();

			switch (choice) {
			case "E":
				System.out.println("Choose your offset character (alphabets only)...");
				offset = scanner.nextLine().trim().toUpperCase();
				if(offset.matches("^[a-zA-Z]$")) {
					System.out.println("Provide plain text to encode...");
					text = scanner.nextLine().trim().toUpperCase();
					textToEncode = offset + text;
					System.out.println("Your encoded text is " + offset + characters.encode(textToEncode));
					break;
				}
				else {
					System.out.println("Error: Invalid offset character");
					break;
				}
				case "D":
					System.out.println("Provide encoded text to decode...");
					textToDecode = scanner.nextLine().trim().toUpperCase();
					System.out.println("Your decoded text is " + characters.decode(textToDecode));
					break;
					default: System.out.println("Invalid choice. Please enter 'E' or 'D'.");
			}
		}

	}

}
