package com.nykaa.wishlist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.io.File;
import java.io.FileInputStream;

@SpringBootApplication
@EnableAutoConfiguration
public class WishlistApplication {

	public static void main(String[] args) {

	/*	File fileName = new File("d:/sample.txt");

		FileInputStream inFile = new FileInputStream("/Users/saurabh.raj/");
		int fileLength = (int) fileName.length();

		byte Bytes[] = new byte[fileLength];

		System.out.println("File size is: " + inFile.read(Bytes));

		String file1 = new String(Bytes);
		System.out.println("File content is:\n" + file1);

		//close file
		inFile.close();*/
		try {
			SpringApplication.run(WishlistApplication.class, args);
			//SpringApplication.run(MyApplication.class, args);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
