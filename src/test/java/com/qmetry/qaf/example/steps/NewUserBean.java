package com.qmetry.qaf.example.steps;

import java.util.Date;

import com.qmetry.qaf.automation.data.BaseFormDataBean;
import com.qmetry.qaf.automation.ui.annotations.UiElement;

import static com.qmetry.qaf.automation.util.RandomStringGenerator.RandomizerTypes.*;
import com.qmetry.qaf.automation.util.Randomizer;

public class NewUserBean extends BaseFormDataBean {
    // default randomizer length: 10 type: mixed
    
    @Randomizer(type = LETTERS_ONLY)
    @UiElement(required = true, fieldLoc = "firstName.loc")
    private String firstName;
     
    @Randomizer(type = LETTERS_ONLY)
    @UiElement(required = true, fieldLoc = "middleName.loc")
    private String middleName;
    
    @Randomizer(type = LETTERS_ONLY)
    @UiElement(required = true, fieldLoc = "lastName.loc")
    private String lastName;
    
    @Randomizer(type = LETTERS_ONLY)
    @UiElement(required = true, fieldLoc = "username.loc")
    private String username;
    
    @Randomizer(length = 8)
    @UiElement(required = true, fieldLoc = "password.loc")
    private String password;
    
    @Randomizer(length = 8)
    @UiElement(required = true, fieldLoc = "confirmPassword.loc")
    private String confirmPassword;
    
    @Randomizer(suffix = "@gmail.com", length = 6)
    private String email;
    
    @Randomizer(type = DIGITS_ONLY, minval = 18, maxval = 100)
    private String age;
     
    @Randomizer(minval = 7, maxval = 15)
    private Date dateOfTravel;
   
    @Randomizer(skip = true)
    private String dontRandomizeMe;
    
    
    public static void main(String[] args) {
		NewUserBean userBean = new NewUserBean();
		
		userBean.fillRandomData();
		System.out.println(userBean.toString());
	}
}
