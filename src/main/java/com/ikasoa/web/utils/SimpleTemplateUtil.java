package com.ikasoa.web.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;

import com.ikasoa.core.utils.ObjectUtil;
import com.ikasoa.core.utils.StringUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SimpleTemplateUtil {

	public static String parse(InputStream inputStream, Map<String, String> variables) {
		String str = "";
		if (ObjectUtil.isNull(inputStream))
			return str;
		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
		try {
			String line;
			while ((line = reader.readLine()) != null)
				str += line;
		} catch (IOException e) {
			log.error(e.getMessage());
			return str;
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
			}
		}
		if (ObjectUtil.isNotNull(variables))
			for (String key : variables.keySet()) {
				str = str.replaceAll(StringUtil.merge("\\$\\{", key, "\\}"), variables.get(key));
			}
		return str;
	}

}
