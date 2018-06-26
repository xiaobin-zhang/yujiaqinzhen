package com.yjqz.binge.io;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.junit.Test;

/**
 * 读Txt文件.
 * @author zhangxiaobin
 *
 */
public class TxtReader {

	@Test
	public void readTxt() throws IOException {
		File file = new File("C:\\Users\\zhangxiaobin\\Desktop\\temp\\fql.txt");
		File targetFile = new File("C:\\Users\\zhangxiaobin\\Desktop\\temp\\B_CBIB_REPAY_FQL_FqlCCPay_20180625_001.txt");
		List<String> fileLines = FileUtils.readLines(file, "UTF-8");
		List<String> head = new ArrayList<String>();
		StringBuilder sb = new StringBuilder();
		String headStr = sb.append("3").append("|")
							.append("315.92").append("|")
							.append("03002971517").append("|")
							.append("51000631748").append("|")
							.append("2018-06-25").toString();
		head.add(headStr);
		FileUtils.writeLines(targetFile, "UTF-8", head, IOUtils.LINE_SEPARATOR_UNIX, true);
		FileUtils.writeLines(targetFile, "UTF-8", fileLines, IOUtils.LINE_SEPARATOR_UNIX, true);
	}
}
