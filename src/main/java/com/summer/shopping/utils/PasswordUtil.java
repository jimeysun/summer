package com.summer.shopping.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.util.StringUtils;

public class PasswordUtil {
	private static Logger LOG = LogManager.getLogger(PasswordUtil.class);
	
	/**
	 * Encrypt password by MD5
	 * @param password
	 * @return
	 */
	public static String encrypt(String password) {
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("MD5");
			md.update(password.getBytes());
			byte[] encrypMsg = md.digest();
			
			return new String(encrypMsg);
		} catch (NoSuchAlgorithmException e) {
			LOG.error("Error to encryt password", e);
			
			return null;
		}		
	}
	
	/**
	 * Compare password between user's input and DB stored password.
	 * @param passwordFromInput
	 * @param encryptPasswordFromDB
	 * @return
	 */
	public static boolean validatePassword(String passwordFromInput, String encryptPasswordFromDB) {
		if (StringUtils.isEmpty(passwordFromInput)
				|| StringUtils.isEmpty(encryptPasswordFromDB)) {
			return false;
		}
		
		return encryptPasswordFromDB.equals(encrypt(passwordFromInput));
		
	}
}
