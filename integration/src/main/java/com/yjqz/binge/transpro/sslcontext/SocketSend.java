package com.yjqz.binge.transpro.sslcontext;

import java.io.OutputStream;
import java.net.Socket;

public class SocketSend {

	public static void main(String[] args) throws Exception {
		Socket socket = new Socket("localhost",9696);
		OutputStream out = socket.getOutputStream();
		out.write("i am clent".getBytes());
		out.flush();
		out.close();
		socket.close();
	}
}
