package com.qmetry.qaf.example.steps;

import com.qmetry.qaf.automation.data.BaseFormDataBean;
import com.qmetry.qaf.automation.ui.annotations.UiElement;
import com.qmetry.qaf.automation.util.Randomizer;


public class LoginFormBean extends BaseFormDataBean{
	@Randomizer
    @UiElement(required = true, order = 1, fieldLoc = "username.login" )
    private String username;
	
	@Randomizer
    @UiElement(required = true, order = 2, fieldLoc = "password.login")
    private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
    
    
}
