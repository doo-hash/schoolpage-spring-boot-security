package com.mockpage.schoolwebapp.schoolpage.home.validator;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.mockpage.schoolwebapp.schoolpage.home.captcha.CaptchaResponse;
import com.mockpage.schoolwebapp.schoolpage.home.captcha.CaptchaSettings;

@Component
public class CaptchaValidator {
	
	@Autowired
	private RestTemplate resttemplate;
	
	@Autowired
	private CaptchaSettings captchaSettings;
	
	public boolean isValidate(String captcha) {
		
		URI verifyUri = URI.create(String.format(
		          "https://www.google.com/recaptcha/api/siteverify?secret=%s&response=%s",
		          captchaSettings.getSecret(), captcha));
		
		CaptchaResponse res = resttemplate.postForObject(verifyUri, null, CaptchaResponse.class);
		
		return res.isSuccess();
	}
}

