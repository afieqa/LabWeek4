package server;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import googletranslate.Translation;

public class ServerTranslationApplication {

public static void main (String[] args) throws IOException {
		
		ServerFrame test = new ServerFrame();
		test.setVisible(true);
		
		ServerSocket s = new ServerSocket(9999);
		Socket ss = s.accept();
		
		
		DataInputStream din = new DataInputStream(ss.getInputStream());
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		DataOutputStream dout = new DataOutputStream(ss.getOutputStream());
		Translation translate = new Translation();
		test.setConnectionStatus(true);
		while(true) {
			String yoo = din.readUTF();
			System.out.println("yoo");
			String words = translate.Translate(yoo);
			System.out.println(words);
			
			dout.writeUTF(words);
			
		}
	
	}
		
	}