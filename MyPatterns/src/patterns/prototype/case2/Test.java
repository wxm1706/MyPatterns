package patterns.prototype.case2;

public class Test {
	public static void main(String[] args) {
		Resume prototype = new Resume();
		prototype.setName("С��");
		prototype.setAge(22);
		prototype.setAddress("����·2��");
		prototype.setEmail("xiaohong@swu.edu.cn");
		prototype.setPhoneNumber("15627272727");
		prototype.setWorkingAge(0);
		prototype.setIntention(new Item("��ְ����", ""));
		prototype.setEducation(new Item("��������", "2016-2020�����ϴ�ѧ�������רҵ"));
		prototype.setSkills(new Item("�����س�", ""));
		prototype.setSelfEvaluation(new Item("��������", ""));
		
		Resume r1 = null;
		Resume r2 = null;
		try {
			r1 = (Resume) prototype.clone();
			r2 = (Resume) prototype.clone();
			r1.getIntention().setTxt("ְλ����˹���ʦ��������н��20K");
			r1.getSkills().setTxt("Java���ԡ�C#��C++��Python���������");
			r1.getSelfEvaluation().setTxt("�ᰮ��̣��߼�˼ά����ǿ");
			
			r2.getIntention().setTxt("ְλ��ǰ�˹���ʦ��������н��20K");
			r2.getSkills().setTxt("Javascript��HTML��CSS������ǰ�˿��");
			r2.getSelfEvaluation().setTxt("�����������ǿ");
			
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		System.out.println(r1.create().toString());
		System.out.println(r2.create().toString());
	}
}
