package day06;

public class Member {
	
	String name;
	int age;
	public Member() {
		this("�ƹ���",20);
	}
	public Member(String name, int age) {
		this.name=name;
		this.age=age;
	}
	//�̸��� ���̰� ������ HashSet�� ������ �����ͷ� �����ϵ��� hashCode(), equals()�޼ҵ带
	//�������̵�����.
	@Override
	public int hashCode() {
		return name.hashCode()+age;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Member) {
			Member member=(Member) obj;
			boolean bool=member.name.equals(this.name) && (member.age==this.age);
			return bool;
		}else {
			return false;
		}
		
	}

}/////////////////////////////



