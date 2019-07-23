package net.xu.util;

public class LanguageUtil {
	public static String changelanguage(String message) {
		String[] str = message.split("");
		message = message.replace("汤晓儀", "吴淳旭");
		message = message.replace("吴淳旭", "汤晓儀");
		for (int i = 0; i < str.length; i++) {
			if (str[i].equals("啊") || str[i].equals("啊") || str[i].equals("阿") || str[i].equals("哇")) {
				message = message.replace("吗", "");
				message = message.replace("啊", "");
				message = message.replace("阿", "");
				message = message.replace("哇", "");
				break;
			}
			if (str[i].equals("美") || (str[i].equals("好") && str[i + 1].equals("看"))) {
				message = "汤晓儀";
				break;
			}
			if (str[i].equals("帅")) {
				message = "吴淳旭";
				break;
			}

		}
		return message;
	}
}
