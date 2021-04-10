package tcpdemo;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class clientCount {

	public static void main(String args[]) throws UnknownHostException, IOException
	{
		int count;
		String words;
		Scanner sc= new Scanner(System.in);
		Socket s = new Socket("127.0.0.1",8571);
		Scanner sc1= new Scanner(s.getInputStream());
		System.out.println("Enter any words: ");
		words=sc.nextLine();
		PrintStream p= new PrintStream(s.getOutputStream());
		p.println(words);
		
		count=sc1.nextInt();
		System.out.println(count);  
	}
}