package com.example.demo.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class UserForm {
	
	private String id;
	
	@NotBlank(message="���O����͂��Ă�������")
	private String name;
	
	@NotBlank(message="���[���A�h���X����͂��Ă�������")
	@Email(message="���[���A�h���X�̌`���œ��͂��Ă�������")
	private String email;
	
	@NotBlank(message="�p�X���[�h����͂��Ă�������")
	@Pattern(regexp="^(?=.*?[0-9])(?=.*?[a-z])(?=.*?[A-Z])[0-9a-zA-Z]{8,16}$|^$" ,message="���������͂��Ă�������")
	private String password;
	
	@NotBlank(message="�m�F�p�p�X���[�h����͂��Ă�������")
	private String ConfirmPassword;
	
	@NotBlank(message="�X�֔ԍ�����͂��Ă�������")
	@Pattern(regexp="^[0-9]{3}-[0-9]{4}$|^$", message="�X�֔ԍ���XXX-XXXX�̌`���œ��͂��Ă�������")
	private String zipcode;
	
	@NotBlank(message="�Z������͂��Ă�������")
	private String address;
	
	@NotBlank(message="�d�b�ԍ�����͂��Ă�������")
	@Pattern(regexp="^[0-9]{3,4}-[0-9]{3,4}-[0-9]{3,4}$|^$", message="�d�b�ԍ���XXXX-XXXX-XXXX�̌`���œ��͂��Ă�������")
	private String telephone;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPassword() {
		return ConfirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		ConfirmPassword = confirmPassword;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	@Override
	public String toString() {
		return "UserForm [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password
				+ ", ConfirmPassword=" + ConfirmPassword + ", zipcode=" + zipcode + ", address=" + address
				+ ", telephone=" + telephone + "]";
	}

	
}
