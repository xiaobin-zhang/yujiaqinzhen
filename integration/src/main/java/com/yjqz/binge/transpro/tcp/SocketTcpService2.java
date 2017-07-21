package com.yjqz.binge.transpro.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketTcpService2 {
	
	public static void main(String[] args) throws IOException {
		
		int port = 8897;
		@SuppressWarnings("resource")
		ServerSocket server = new ServerSocket(port);
		while(true) {
			Socket socket = server.accept();

			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			StringBuilder sb = new StringBuilder();
			String temp;
			int index;
			while((temp = br.readLine()) != null) {
				System.out.println(temp);
				if ((index = temp.indexOf("eof")) != -1) {
					sb.append(temp.substring(0, index));
					break;
				}
				sb.append(temp);
			}
			System.out.println("客户端: " + sb);
			Writer writer = new OutputStreamWriter(socket.getOutputStream());
			writer.write("你好,客户端.");
			writer.write("eof\n");
			writer.flush();
			writer.close();
			br.close();
			socket.close();
		}
	}
	
}



