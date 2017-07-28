package com.yjqz.binge.transpro.sslcontext;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.Socket;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
@SuppressWarnings("all")
public class SslServerSocket {

	public static void main(String[] args) throws Exception {
		
		// key store相关信息 
		
		String keyName = "cnkey";
		char[] keyStorePwd = "123456789".toCharArray();
		char[] keyPwd = "123456789".toCharArray();
		// 装载当前目录下的key store. 可用jdk中的keytool工具生成keystore 
		InputStream in = new FileInputStream(new File("cnkey"));
		
		KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
		keyStore.load(in, keyPwd);
	    in.close();  
	  
		//初始化KeyManagerFactory
	    KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
	    keyManagerFactory.init(keyStore, keyPwd);
	    
	    //初始化SSLContext
	    SSLContext sslContext = SSLContext.getInstance("SSL");
	    sslContext.init(keyManagerFactory.getKeyManagers(),new TrustManager[] { new MyX509TrustManager() }, new SecureRandom());
	    
	    SSLServerSocketFactory serverSocketFactory = sslContext.getServerSocketFactory();
	    SSLServerSocket server = (SSLServerSocket) serverSocketFactory.createServerSocket(9696);
	    Socket socket = server.accept();
	    System.out.println("ok");
	    System.out.println(socket.getRemoteSocketAddress());
	    
	    // 当一个普通 socket 连接上来, 这里会抛出异常  javax.net.ssl.SSLException: Unrecognized SSL message
	    InputStream ins = socket.getInputStream();
	    byte[] buff = new byte[1024];
	    int len = ins.read(buff);
	    System.out.println("received : " + new String(buff, 0, len));
	    
	    ins.close();
	    in.close();
	    socket.close();
	    server.close();
	}
}

class MyX509TrustManager implements X509TrustManager{

	@Override
	public void checkClientTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
		
	}

	@Override
	public void checkServerTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
		
	}

	@Override
	public X509Certificate[] getAcceptedIssuers() {
		return null;
	}

}