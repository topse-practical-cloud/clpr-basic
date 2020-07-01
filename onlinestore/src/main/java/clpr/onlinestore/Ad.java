package clpr.onlinestore;

public class Ad {
    private String redirectUrl;
	private String text;

    public Ad(){
    }

    public String getRedirectUrl() {
        return redirectUrl;
    }
    
    public void setRedirectUrl(String redirectUrl){
        this.redirectUrl = redirectUrl;
    }

    public String getText() {
        return text;

    }
    public void setText(String text){
        this.text = text;
    }
}