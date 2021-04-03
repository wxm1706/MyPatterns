package patterns.prototype.case2;

public class Resume implements Cloneable{
	private String name;
	private String phoneNumber;
	private String email;
	private int age;
	private String address;
	private int workingAge;
	private Item intention;
	private Item education;
	private Item skills;
	private Item selfEvaluation;
	
	public StringBuilder create() {
		StringBuilder data = new StringBuilder();
		data.append("<html><body>\n");
		data.append("<h1>求职简历</h1>\n");
		data.append("<h3>姓名：" + name + "</h3>\n");
		data.append("<h3>电话：" + phoneNumber + "</h3>\n");
		data.append("<h3>邮箱：" + email + "</h3>\n");
		data.append("<h3>年龄：" + age + "</h3>\n");
		data.append("<h3>地址：" + address + "</h3>\n");
		data.append("<h3>工作经验：" + workingAge + "</h3>\n");
		data.append("<h2>" + intention.getTitle() + "</h2>\n");
		data.append("<p>" + intention.getTxt() + "</p>\n");
		data.append("<h2>" + education.getTitle() + "</h2>\n");
		data.append("<p>" + education.getTxt() + "</p>\n");
		data.append("<h2>" + skills.getTitle() + "</h2>\n");
		data.append("<p>" + skills.getTxt() + "</p>\n");
		data.append("<h2>" + selfEvaluation.getTitle() + "</h2>\n");
		data.append("<p>" + selfEvaluation.getTxt() + "</p>\n");
		
		data.append("</html></body>\n");
		return data;
	}
	
	public Object clone() throws CloneNotSupportedException {
		Resume copy = (Resume) super.clone();
		copy.setEducation((Item) this.getEducation().clone());
		copy.setIntention((Item) this.getIntention().clone());
		copy.setSkills((Item) this.getSkills().clone());
		copy.setSelfEvaluation((Item) this.getSelfEvaluation().clone());
		return copy;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getWorkingAge() {
		return workingAge;
	}
	public void setWorkingAge(int workingAge) {
		this.workingAge = workingAge;
	}

	public Item getIntention() {
		return intention;
	}

	public void setIntention(Item intention) {
		this.intention = intention;
	}

	public Item getEducation() {
		return education;
	}

	public void setEducation(Item education) {
		this.education = education;
	}

	public Item getSkills() {
		return skills;
	}

	public void setSkills(Item skills) {
		this.skills = skills;
	}

	public Item getSelfEvaluation() {
		return selfEvaluation;
	}

	public void setSelfEvaluation(Item selfEvaluation) {
		this.selfEvaluation = selfEvaluation;
	}
}
