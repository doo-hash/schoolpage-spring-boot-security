package com.mockpage.schoolwebapp.schoolpage.home.captcha;

public class CaptchaResponse {	
	
	public boolean success;
	public String chalenge_ts;
	public String hostname;
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getChalenge_ts() {
		return chalenge_ts;
	}
	public void setChalenge_ts(String chalenge_ts) {
		this.chalenge_ts = chalenge_ts;
	}
	public String getHostname() {
		return hostname;
	}
	public void setHostname(String hostname) {
		this.hostname = hostname;
	}
	
	
}
