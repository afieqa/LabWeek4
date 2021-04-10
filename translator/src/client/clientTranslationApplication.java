package client;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class clientTranslationApplication {

	public static void main(String [] args) throws UnknownHostException, IOException
	{
		clientFrame test = new clientFrame();
		test.setVisible(true);
		
		Socket s = new Socket("localhost", 9999);
		DataOutputStream dout = new DataOutputStream(s.getOutputStream());
		DataInputStream din = new DataInputStream(s.getInputStream());
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			//String so = br.readLine();
			String english = "", malay = "",arabic = "",korean = "";
			
			if(test.getButton()) {
			System.out.println("masuk");
			String so = test.getText();
			dout.writeUTF(so);
			String yoo = din.readUTF();
			if (yoo.isBlank()) {
				test.setFound(false);
			}
			else {
				test.setFound(true);
				int change = 0;
				for(int i = 0;i<yoo.length()-1;i++) {
					if(yoo.charAt(i) == '.') {
						change++;
					}
					else {
						if(change == 0) {
							english += yoo.charAt(i);
						}
						else if(change == 1) {
							malay += yoo.charAt(i);
						}
						else if (change == 2) {
							arabic += yoo.charAt(i);
						}
						else {
							korean += yoo.charAt(i);
						}
					}
				}
			}
			test.setTranslationText(english, malay, arabic, korean);
			test.setButton();
			}
	
			
			}
		}
		
		
	}