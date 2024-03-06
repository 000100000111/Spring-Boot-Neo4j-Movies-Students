/**
 * Copyright (c) 2018-2028, LookAhead.
 * <p>
 * Licensed under the GNU LESSER GENERAL PUBLIC LICENSE 3.0;
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.gnu.org/licenses/lgpl.html
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.appleyk.utils;

import cn.hutool.core.codec.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 * 实现AES加解密
 *
 * @author: martin
 * @date: 2018/8/21 15:12
 * @description:
 */
public class AesUtil {
	private static final Logger LOGGER = LoggerFactory.getLogger(AesUtil.class);

	private static final String KEY_ALGORITHM = "AES";
	private static final String CHAR_SET = "UTF-8";
	/**
	 * AES的密钥长度
	 */
	private static final Integer SECRET_KEY_LENGTH = 128;
	/**
	 * 加解密算法/工作模式/填充方式
	 */
	private static final String DEFAULT_CIPHER_ALGORITHM = "AES/ECB/PKCS5Padding";

	// 加密
	public static String encrypt(String sSrc, String sKey) {
		if (sKey == null) {
			System.out.print("Key为空null");
			return null;
		}
		// 判断Key是否为16位
		if (sKey.length() != 16) {
			System.out.print("Key长度不是16位");
			return null;
		}
		try {
			byte[] raw = sKey.getBytes(CHAR_SET);
			SecretKeySpec skeySpec = new SecretKeySpec(raw, KEY_ALGORITHM);
			Cipher cipher = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);//"算法/模式/补码方式"
			cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
			byte[] encrypted = cipher.doFinal(sSrc.getBytes("utf-8"));
			return Base64.encode(encrypted);//此处使用BASE64做转码功能，同时能起到2次加密的作用。
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "加密失败！";
	}

	// 解密
	public static String decrypt(String sSrc, String sKey) {
		try {
			// 判断Key是否正确
			if (sKey == null) {
				System.out.print("Key为空null");
				return null;
			}
			// 判断Key是否为16位
			if (sKey.length() != 16) {
				System.out.print("Key长度不是16位");
				return null;
			}
			byte[] raw = sKey.getBytes(CHAR_SET);
			SecretKeySpec skeySpec = new SecretKeySpec(raw, KEY_ALGORITHM);
			Cipher cipher = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);
			cipher.init(Cipher.DECRYPT_MODE, skeySpec);
			byte[] encrypted1 = Base64.decode(sSrc);//先用base64解密
			try {
				byte[] original = cipher.doFinal(encrypted1);
				String originalString = new String(original,CHAR_SET);
				return originalString;
			} catch (Exception e) {
				System.out.println(e.toString());
				return null;
			}
		} catch (Exception ex) {
			System.out.println(ex.toString());
			return null;
		}
	}

	public static void main(String[] args) throws Exception {

		/*
		 * 此处使用AES-128-ECB加密模式，key需要为16位。
		 */
//		String d = "1591034263153725441";		// 就是手机号
//		String destPath = "/root/coursewareData/textbook/" + "node.en/" + d;
////		String cKey = DigestUtil.md5_16bit(destPath + "_" + Func.random(6));
//		String cKey = Func.md5Hex(destPath + "_" + Func.random(6));
//
//		// 需要加密的字串
//		String cSrc = "la123456";
//		System.out.println("cKey:" + cKey);
//		System.out.println("cSrc:" + cSrc);
//		// 加密
//		String enKey = encrypt(cSrc, Func.md5_16bit(Func.toStr("18211110000")));
////		String enString = encrypt(cSrc, cKey);
//		System.out.println("加密后的enKey是：" + enKey);
//		// 解密
//		String DeString = decrypt(enKey, Func.md5_16bit(Func.toStr("18211110000")));
//		System.out.println("解密后的字串是：" + DeString);
//
//		String enCKey = "6Qi5TUp0lxPPWTTeGPrWdg==";
//		String ckey1 = AesUtil.decrypt(enCKey, Func.md5_16bit(Func.toStr("18211110000")));
//		System.out.println("ckey1:" + ckey1);
	}
}
