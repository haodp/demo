package com.demo.common.util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Base64;

public final class SecurityUtil {

	/**
	 * MD5 key加密
	 *
	 * @param originalContent
	 * @return
	 * @throws Exception
	 */
	public static String createMD5(String originalContent) throws Exception {
		MessageDigest md = null;

		md = MessageDigest.getInstance("MD5");
		md.update(originalContent.getBytes("UTF-8"));

		StringBuilder buf = new StringBuilder();
		byte[] bytes = md.digest();
		int i;
		for (int offset = 0; offset < bytes.length; offset++) {
			i = bytes[offset];
			if (i < 0) {
				i += 256;
			}
			if (i < 16) {
				buf.append("0");
			}
			buf.append(Integer.toHexString(i));
		}

		return buf.toString();
	}

	/**
	 * SHA加密
	 *
	 * @param originalContent
	 * @return
	 * @throws Exception
	 */
	public static String createSHA1(String decript) throws Exception {

		MessageDigest digest = java.security.MessageDigest.getInstance("SHA-1");
		digest.update(decript.getBytes("UTF-8"));
		byte messageDigest[] = digest.digest();
		StringBuffer hexString = new StringBuffer();
		for (int i = 0; i < messageDigest.length; i++) {
			String shaHex = Integer.toHexString(messageDigest[i] & 0xFF);
			if (shaHex.length() < 2) {
				hexString.append(0);
			}
			hexString.append(shaHex);
		}

		return hexString.toString();
	}

	public static String decodeBase64(String base64Context) throws UnsupportedEncodingException {

		byte[] bytes = Base64.decodeBase64(base64Context);
		return org.apache.commons.codec.binary.StringUtils.newStringUtf8(bytes);
	}

	/**
	 * SHA加密
	 * @param originalContent
	 * @return
	 * @throws Exception
	 */
	public static String SHA(byte[] bytes) {
		try {
			MessageDigest digest = java.security.MessageDigest.getInstance("SHA");
			digest.update(bytes);
			byte messageDigest[] = digest.digest();
			// Create Hex String
			StringBuffer hexString = new StringBuffer();
			// 字节数组转换为 十六进制 数
			for (int i = 0; i < messageDigest.length; i++) {
				String shaHex = Integer.toHexString(messageDigest[i] & 0xFF);
				if (shaHex.length() < 2) {
					hexString.append(0);
				}
				hexString.append(shaHex);
			}
			return hexString.toString();

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return "";
	}

	// 获得指定文件的byte数组
	public static byte[] getBytes(String filePath) {
		byte[] buffer = null;
		try {
			File file = new File(filePath);
			FileInputStream fis = new FileInputStream(file);
			ByteArrayOutputStream bos = new ByteArrayOutputStream(1000);
			byte[] b = new byte[1000];
			int n;
			while ((n = fis.read(b)) != -1) {
				bos.write(b, 0, n);
			}
			fis.close();
			bos.close();
			buffer = bos.toByteArray();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return buffer;
	}
}
