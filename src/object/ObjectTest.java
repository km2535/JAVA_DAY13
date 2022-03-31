package object;

public class ObjectTest {
	public static void main(String[] args) {
//		Car타입의 클래스를 만들고 mycar로 객체화 시켰다.
		Car mycar = new Car("Ferrari");
//		객체화 시켜서 객체의 이름을 출력했다.
		System.out.println(mycar);
//		String타입으로 mycar를 toString함수를 사용하였다.
		String str = mycar.toString();
//		String메소드를 사용한 mycar를 str에 담고 출력했다.
		System.out.println(str);
		
		Car momcar = new Car("K8");
		System.out.println(momcar);
	}
}
class Car{
	String brand;

	public Car(String brand) {
		super();
		this.brand = brand;
	}
	
	@Override
	public String toString() {
		return "브랜드 : "+brand;
	}
	
}
