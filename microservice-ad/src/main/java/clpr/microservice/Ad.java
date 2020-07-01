package clpr.microservice;

public class Ad {
    private final String redirectUrl;
	private final String text;

	public Ad(String redirectUrl, String text) {
		this.redirectUrl = redirectUrl;
		this.text = text;
	}

	public String getRedirectUrl() {
		return redirectUrl;
	}

	public String getText() {
		return text;
	}
}