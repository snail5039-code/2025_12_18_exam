package com.example.test.util;

public class Util {
	
	public static String jsReplace(String msg, String url) {
		if(msg == null) {
			msg = "";
		}
		if(url == null || url.length() == 0) {
			url = "/";
		}
		
		return String.format("""
				<script>
					const msg = '%s'.trim();
					if(msg.length > 0) {
						alert(msg);
					}
					
					const url = '%s'.trim();
					if(url == 'hb') {
						history.back();
					}
					location.replace(url);
				</script>
				""", msg, url);
	}
}
