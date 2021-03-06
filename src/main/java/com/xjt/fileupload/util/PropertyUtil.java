package com.xjt.fileupload.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyUtil {

	//通过类加载目录getClassLoader()加载属性文件
	public static String getPropertyByName(String path, String name) {
		String result = "";

		//通过类加载目录getClassLoader()加载属性文件
		InputStream in = PropertyUtil.class.getClassLoader().getResourceAsStream(path);
		// InputStream in =
		// this.getClass().getClassLoader().getResourceAsStream("mailServer.properties");

		// 注：Object.class.getResourceAsStream在action中调用报错，在普通java工程中可用
		// InputStream in =
		// Object.class.getResourceAsStream("/mailServer.properties");
		Properties prop = new Properties();
		try {
			prop.load(in);
			result = prop.getProperty(name).trim();
		} catch (IOException e) {
			System.out.println("读取配置文件出错");
			e.printStackTrace();
		}
		return result;
	}
}