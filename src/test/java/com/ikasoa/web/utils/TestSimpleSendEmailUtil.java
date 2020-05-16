package com.ikasoa.web.utils;

public class TestSimpleSendEmailUtil {

	public static void main(String[] args) {
		SimpleSendEmailUtil simpleSendEmailUtil = new SimpleSendEmailUtil("notice@zhinanzhen.org", "Znz@2020",
				SimpleSendEmailUtil.SmtpServerEnum.EXMAIL_QQ);
		simpleSendEmailUtil.send("larry7696@gmail.com", "Test", "TESTTESTTEST");
	}

}
