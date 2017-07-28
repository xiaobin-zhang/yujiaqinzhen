package com.yjqz.binge.transpro.sslcontext;

import java.io.OutputStream;
import java.net.Socket;
import java.security.SecureRandom;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

public class SslClentSocekt {

	public static void main(String[] args) throws Exception {
		SSLContext context = SSLContext.getInstance("SSL");
		context.init(null, new TrustManager[] { new MyX509TrustManager() }, new SecureRandom());
		SSLSocketFactory factory = context.getSocketFactory();
		Socket socket = factory.createSocket("localhost", 9696);
		OutputStream out = socket.getOutputStream();
		out.write("i am clent".getBytes());
		out.flush();
		out.close();
		socket.close();
	}
}
