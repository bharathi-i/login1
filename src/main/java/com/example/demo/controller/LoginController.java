package com.example.demo.controller;

//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Users;
import com.example.demo.form.LoginForm;
import com.example.demo.repository.UsersRepository;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class LoginController {
 @RequestMapping (value="/login",method=RequestMethod.GET)
	public String getLoginForm() {
		return "login";
	
 }
 
 @Autowired
 private UsersRepository userrepo;

		@RequestMapping (value="/login",method=RequestMethod.POST,produces = {"application/json"})
		public String login (@ModelAttribute(name="LoginForm") LoginForm LoginForm) {
			String username = LoginForm.getUsername();
			
			String password = LoginForm.getPassword();
			System.out.println("name:"+username +"pssword:"+password);
			Users user=userrepo.findByname(username.trim());
		//System.out.println("name:"+	user.size());
			if(user!=null) {
				if(user.getPassword().equals(password.trim())) {
				return "index";
				}else {
					return "invalid password";
				}
			}
		//	model.addAttribute("invalidCredentials",true);
			return "Invalid UserName";


}
}