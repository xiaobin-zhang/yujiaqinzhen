package com.yjqz.binge.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.io.IOUtils;
import org.junit.Test;

/**
 * 文件压缩.
 * @author zhangxiaobin
 *
 */
public class ZipUtilTest {
	@Test
	public void mainjiami() throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IOException {
		String desKey = "abcdefgh12348765hgfedcba";
		String zipFileName = "C:\\Users\\zhangxiaobin\\Desktop\\temp\\a.zip";
		String zipEntryStr = " ";
		String fileName = "C:\\Users\\zhangxiaobin\\Desktop\\temp\\a.txt";
		jiamijiaya(desKey, zipFileName, zipEntryStr, fileName);
	}
	@Test
	public void mainjiemi() throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IOException {
		String desKey = "123456788765432112345678";
		String zipFileName = "G:\\hesthhh\\xrfOut\\aaa.zip";
		String fileName = "G:\\hesthhh\\xrfOut\\aaa";
		jiemijiaya(desKey, zipFileName, fileName);
	}
	
	public void jiamijiaya(String desKey, String zipFileName, String zipEntryStr, String fileName) {
		OutputStream outputStream = null;
		FileOutputStream fileOutputStream = null;
		FileInputStream fileInputStream = null;
		System.out.println(zipEntryStr);
		try {
			fileOutputStream = new FileOutputStream(zipFileName);
			SecretKey secretKey = new SecretKeySpec(desKey.getBytes(), "DESede");
			Cipher c1 = Cipher.getInstance("DESede");
			c1.init(Cipher.ENCRYPT_MODE, secretKey);
			OutputStream encryptOutPutStream = new CipherOutputStream(fileOutputStream, c1);
			ZipOutputStream zipOutPutStream = new ZipOutputStream(encryptOutPutStream);
			zipOutPutStream.putNextEntry(new ZipEntry(zipEntryStr));
			outputStream = zipOutPutStream; 
			fileInputStream = new FileInputStream(fileName);
			IOUtils.copy(fileInputStream, outputStream);
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (outputStream != null) {
					outputStream.close();
				} else if (fileInputStream != null) {
					fileInputStream.close();
				} else if (fileOutputStream != null) {
					fileOutputStream.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	public void jiemijiaya(String desKey, String zipFileName, String fileName) {
		InputStream inputStream = null;
		FileInputStream fileInputStream = null;
		FileOutputStream fileOutputStream = null;
		try {
			fileInputStream = new FileInputStream(zipFileName);
			SecretKey keySpec = new SecretKeySpec(desKey.getBytes(), "DESede");
			Cipher cipher = Cipher.getInstance("DESede");
			cipher.init(Cipher.DECRYPT_MODE, keySpec);
			InputStream cipherInputStream = new CipherInputStream(fileInputStream, cipher);
			ZipInputStream zipInputStream = new ZipInputStream(cipherInputStream);
			ZipEntry nextEntry = zipInputStream.getNextEntry();
			inputStream = zipInputStream;
			if (nextEntry == null) {
				System.out.println("解密失败");
				inputStream = null;
			}
			fileOutputStream = new FileOutputStream(fileName);
			IOUtils.copy(inputStream, fileOutputStream);
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (inputStream != null) {
					inputStream.close();
				} else if (fileInputStream != null) {
					fileInputStream.close();
				} else if (fileOutputStream != null) {
					fileOutputStream.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
}
