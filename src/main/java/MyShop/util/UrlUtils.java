package MyShop.util;


public class UrlUtils {

	public static boolean isStaticUrl(String url) {
		return url.startsWith("/static/");
	}

	public static boolean isMediaUrl(String url) {
		return url.startsWith("/media/");
	}

	private UrlUtils() {
	}
}
