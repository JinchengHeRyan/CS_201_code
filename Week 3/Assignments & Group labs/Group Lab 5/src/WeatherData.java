public class WeatherData {
	public static String getWordBefore(String html, int i) {
		String word = "";
		while (!Character.isSpaceChar(html.charAt(i))) {
			word = html.charAt(i--) + word;
		}
		return word;
	}

	public static void downloadWeatherData(String url) {
		System.err.println("Loading...");

		In page = new In(url);
		String html = page.readAll();
		
		Out o = new Out("downloaded_file.html");
		o.print(html);

		System.err.println("Finished loading");

		int lastIndex = 0;

		int temp_url_index1 = url.indexOf("/lishi/");
		int temp_url_index2 = url.indexOf("/month/");
		String city = url.substring(temp_url_index1 + 7, temp_url_index2);

		String pattern1 = "<a href='/lishi/" + city + "/";
		while (true) {
			int i1 = html.indexOf(pattern1, lastIndex);
			if (i1 == -1) {
				break;
			}

			int i2 = html.indexOf(".html", i1);
			String date = html.substring(i1 + pattern1.length(), i2);

			int i3 = html.indexOf("℃", i2);
			if (i3 == -1) {
				break;
			}
			String high = getWordBefore(html, i3 - 1);
			if (high.length() == 0) {
				break;
			}

			int i4 = html.indexOf("℃", i3 + 1);
			if (i4 == -1) {
				break;
			}
			String low = getWordBefore(html, i4 - 1);

			System.out.println(date + "," + high + "," + low);
			
			lastIndex = i4;
		}
	}

	public static void getdata(String url) {
		if (url.matches(".*html") ) {
			downloadWeatherData(url);
		}
		else {
			String[] month_list = {"01","02","03","04","05","06","07","08","09","10","11","12"};
			for (int i = 0; i < month_list.length; i++) {
				String final_url = url + month_list[i] + ".html";
				downloadWeatherData(final_url);
			}
		}
	}

	public static void main(String[] args) {
		getdata(args[0]);
	}
}