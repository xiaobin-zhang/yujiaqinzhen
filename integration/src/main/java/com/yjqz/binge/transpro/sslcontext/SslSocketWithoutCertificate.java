package com.yjqz.binge.transpro.sslcontext;

import java.io.OutputStream;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
/**
 * 程序客户在不持有证书的情况下直接进行连接，
 * 服务器端会产生运行时异常javax.net.ssl.SSLHandshakeException: Received fatal alert: certificate_unknown，
 * 不允许进行连接。 
 * @author zhangxiaobin
 *
 */
public class SslSocketWithoutCertificate {

	public static void main(String[] args) throws Exception {
		SSLSocketFactory factory = (SSLSocketFactory) SSLSocketFactory.getDefault();
		SSLSocket socket = (SSLSocket) factory.createSocket("localhost", 9696);
		OutputStream out = socket.getOutputStream();
		out.write("i am clent".getBytes());
		out.flush();
		out.close();
		socket.close();
	}
}
