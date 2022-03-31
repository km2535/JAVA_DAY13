package object;

public class ObjectTest2 {
	public static void main(String[] args) {
		String msg1 = "RedVelvet";
		String msg2 = "RedVelvet";
		System.out.println(msg1 == msg2);
		
		String msg3 = new String("RedVelvet");
		String msg4 = new String("RedVelvet");
		System.out.println(msg3 == msg4);
		System.out.println(msg1.equals(msg2));
		System.out.println(msg3.equals(msg4));
		
		//동위객체
		User user1 = new User(1, 1234);
		User user2 = new User(1, 1234);
		System.out.println(user1.equals(user2));
		
		System.out.println(user1.hashCode());
		System.out.println(user2.hashCode());
	}
}
class User{
	int userid;
	int userpw;
	
	public User(int userid, int userpw) {
		this.userid = userid;
		this.userpw = userpw;
	}
	
	@Override
	public boolean equals(Object obj) {
//		최초 객체가 들어오면서 우리의 객체는 Object 상위 클래스에 담기기 때문에 업캐스팅이 이루어 진다.
		//1. 타입비교(해당하는 클래스 타입의 객체가 매개변수로 넘어왔는지)
//		업캐스팅 되었는지 확인하고 맞으면 다운 캐스팅
		if(obj instanceof User) {
			//2. 다운캐스팅
			User target = (User)obj;
			
			//3. 조건 판별
			//if(this.userid.equals(target.userid))
			if(this.userid == target.userid) {
				if(this.userpw == target.userpw) {
					return true;
				}
			}
		}
		return false;
	}
	
//	@Override
//	public int hashCode() {
//		return userid;
//	}
	
}







