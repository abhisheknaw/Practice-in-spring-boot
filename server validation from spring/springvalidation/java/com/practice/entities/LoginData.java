package com.practice.entities;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class LoginData {
	
		@NotBlank(message = "username cannot be empty!!!!!")                     //validating username
		@Size(min=3,max=15,message="username must be between 3 to 15 characters")
		private String userName;
		
		@Pattern(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$",message = "invalid email")
		private String email;
		
		@AssertTrue(message = "must agree terms and conditions")
		private boolean agreed;
		public boolean isAgreed() {
			return agreed;
		}
		public void setAgreed(boolean agreed) {
			this.agreed = agreed;
		}
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		@Override
		public String toString() {
			return "LoginData [userName=" + userName + ", email=" + email + "]";
		}
		
}
