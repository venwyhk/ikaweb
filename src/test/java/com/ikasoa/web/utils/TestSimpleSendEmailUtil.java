package com.ikasoa.web.utils;

public class TestSimpleSendEmailUtil {

	public static void main(String[] args) {
		SimpleSendEmailTool simpleSendEmailTool = new SimpleSendEmailTool("notice@zhinanzhen.org", "EpibqJ2R6CFwvqiU",
				SimpleSendEmailTool.SmtpServerEnum.EXMAIL_QQ);
		simpleSendEmailTool.send("larry7696@gmail.com,7311930@qq.com", "test", "XXOO");
	}

}
