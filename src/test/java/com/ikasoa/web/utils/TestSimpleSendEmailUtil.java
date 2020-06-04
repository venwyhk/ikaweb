package com.ikasoa.web.utils;

public class TestSimpleSendEmailUtil {

	public static void main(String[] args) {
		SimpleSendEmailTool simpleSendEmailTool = new SimpleSendEmailTool("notice@zhinanzhen.org", "Znz@2020",
				SimpleSendEmailTool.SmtpServerEnum.EXMAIL_QQ);
		simpleSendEmailTool.send("larry7696@gmail.com", "您有一条新的服务订单任务请及时处理", "情爱的lei<br/>您有一条新的服务订单任务请及时处理。<br/>XXX");
	}

}
