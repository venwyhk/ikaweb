package com.ikasoa.web.utils;

public class TestSimpleSendEmailUtil {

	public static void main(String[] args) {
		SimpleSendEmailTool simpleSendEmailTool = new SimpleSendEmailTool("notice@zhinanzhen.org", "Znz@2020",
				SimpleSendEmailTool.SmtpServerEnum.EXMAIL_QQ);
		simpleSendEmailTool.send("larry7696@gmail.com", "Test", "123123");
	}

}
