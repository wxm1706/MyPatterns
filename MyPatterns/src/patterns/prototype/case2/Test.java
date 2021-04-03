package patterns.prototype.case2;

public class Test {
	public static void main(String[] args) {
		Resume prototype = new Resume();
		prototype.setName("小红");
		prototype.setAge(22);
		prototype.setAddress("天生路2号");
		prototype.setEmail("xiaohong@swu.edu.cn");
		prototype.setPhoneNumber("15627272727");
		prototype.setWorkingAge(0);
		prototype.setIntention(new Item("求职意向", ""));
		prototype.setEducation(new Item("教育背景", "2016-2020，西南大学，计算机专业"));
		prototype.setSkills(new Item("技能特长", ""));
		prototype.setSelfEvaluation(new Item("自我评价", ""));
		
		Resume r1 = null;
		Resume r2 = null;
		try {
			r1 = (Resume) prototype.clone();
			r2 = (Resume) prototype.clone();
			r1.getIntention().setTxt("职位：后端工程师，期望月薪：20K");
			r1.getSkills().setTxt("Java语言、C#、C++、Python、主流框架");
			r1.getSelfEvaluation().setTxt("酷爱编程，逻辑思维能力强");
			
			r2.getIntention().setTxt("职位：前端工程师，期望月薪：20K");
			r2.getSkills().setTxt("Javascript、HTML、CSS、主流前端框架");
			r2.getSelfEvaluation().setTxt("界面设计能力强");
			
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		System.out.println(r1.create().toString());
		System.out.println(r2.create().toString());
	}
}
