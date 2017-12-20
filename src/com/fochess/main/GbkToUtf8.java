package com.fochess.main;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.Collection;

import org.apache.commons.io.FileUtils;

/**
 * @Author: fochess
 * @Date: 2017-12-20
 * @Version: V1.0
 * @Copyright: www.fochess.com
 * @Description:
 */
public class GbkToUtf8 {

	/**
	 * 判断文件是否是utf-8编码
	 * @param key
	 * @return booleam
	 */
	public static boolean isUTF8(String key) {
		try {
			key.getBytes("utf-8");
			return true;
		} catch (UnsupportedEncodingException e) {
			System.out.println(2);
			return false;
		}
	}

	/**
	 * 使用common io批量将java编码从GBK转UTF-8
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		// GBK编码格式源码路径
		 String srcDirPath = "D:\\Java\\gbk";
		// 转为UTF-8编码格式源码路径
		String utf8DirPath = "D:\\Java\\utf8";

		// 获取所有java文件
		Collection<File> javaGbkFileCol = FileUtils.listFiles(new File(srcDirPath), new String[] { "java" }, true);
		for (File javaGbkFile : javaGbkFileCol) {
			boolean bUtf8Encoding = isUTF8(javaGbkFile.getAbsolutePath().substring(srcDirPath.length()));
			if (!bUtf8Encoding) {
				// UTF8格式文件路径
				String utf8FilePath = utf8DirPath + javaGbkFile.getAbsolutePath().substring(srcDirPath.length());
				// 使用GBK读取数据，然后用UTF-8写入数据
				FileUtils.writeLines(new File(utf8FilePath), "UTF-8", FileUtils.readLines(javaGbkFile, "GBK"));
			}
			System.out.println();
		}
		System.out.println("success.");
	}
}
