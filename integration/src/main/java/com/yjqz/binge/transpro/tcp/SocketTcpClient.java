package com.yjqz.binge.transpro.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketTcpClient {

	public static void main(String[] args) throws UnknownHostException, IOException {
		
		String host = "127.0.0.1";
		int port = 8897;
		Socket socket = new Socket(host,port);
		Writer writer = new OutputStreamWriter(socket.getOutputStream());
		writer.write("你好,服务器。");
		writer.flush();
		 
		BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		socket.setSoTimeout(10*1000);
		StringBuffer sb = new StringBuffer();
		String temp;
		int index;
		while((temp = br.readLine()) != null) {
			if((index = temp.indexOf("eof")) != -1){
				sb.append(temp.substring(0, index));
				break;
			}
			sb.append(temp);
		}
		System.out.println("服务端 : "+ sb);
		writer.close();
		br.close();
		socket.close();
	}
}
