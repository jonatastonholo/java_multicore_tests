package mains;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class TestProcess {
	private static final String CMD = "C:\\Windows\\System32\\cmd.exe";
	public static void main(String[] args) throws IOException {
		String line;
		Scanner scan = new Scanner(System.in);
//		Process process = Runtime.getRuntime().exec("/bin/bash");
		Process process = Runtime.getRuntime().exec(CMD);
		OutputStream stdin = process.getOutputStream ();
		InputStream stderr = process.getErrorStream ();
		InputStream stdout = process.getInputStream ();

		BufferedReader reader = new BufferedReader (new InputStreamReader(stdout));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(stdin));

		System.out.println("Entre com alguma coisa: ");
		String input = scan.nextLine();
		input += "\n";
		writer.write(input);
		writer.flush();

		System.out.println("Entre com outra coisa: ");
		input = scan.nextLine();
		input += "\n";
		writer.write(input);
		writer.flush();

		while ((line = reader.readLine ()) != null) {
		System.out.println ("Stdout: " + line);
		}

		System.out.println("Entre com mais alguma coisa: ");
		input = scan.nextLine();
		input += "\n";
		writer.write(input);
		writer.close();

		while ((line = reader.readLine ()) != null) {
		System.out.println ("Stdout: " + line);
		}
	}
}
