package com.dto;

//dto - data transfer object
public class MemberDto {

	private int no;
	private String name;
	private int age;
	private String gender;
	private String location;
	private String job;
	private String tel;
	private String email;
	
	public MemberDto() {
		
		
	}
	
	public MemberDto(int no, String name, int age, String gender, String location, String job, String tel,
			String email) {
		super();
		this.no = no;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.location = location;
		this.job = job;
		this.tel = tel;
		this.email = email;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "MemberDto [no=" + no + ", name=" + name + ", age=" + age + ", gender=" + gender + ", location="
				+ location + ", job=" + job + ", tel=" + tel + ", email=" + email + "]";
	}
	
	
	
	
	
}
