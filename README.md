# JAVA_DAY13

# JAVA-13

## API(Application Programming Interface)

- 응용 프로그램 프로그래밍 인터페이스
- 자바 시스템을 제어하기 위해서 자바에서 제공하는 명령어들을 의미한다.
- 선배 개발자들이 java에서 코딩을 쉽게 할 수 있도록 미리 만들어 놓은 것들
- API의 종류는 굉장히 많고 다양하기 때문에 모두 외우는 것은 절대 불가하다.
  그렇기 때문에 처음 보는 API라도 설명을 잘 읽고 맞는 목적으로 사용하는 방법을 알아야한다.

### CoolSMS 살펴보기

- 사용방법
  회원가입 > API등록
  개발연동 > API KEY 관리 > API Secret (2차 비밀번호 설정)
  고객지원 > 개발자센터 > SDK > JAVA
  JAVA SDK2.2 > Start here
  github에서 javaSDK-2.2.jar 파일 다운
  다시 홈페이지에서 JsonSimpleLibrary 다운
  이클립스로 돌아와서 다운받은 jar파일 import 하기
  ![](https://media.vlpt.us/images/km2535/post/3f34fd31-0038-4b00-ada4-5e96bb478233/image.png)
  만들고자 하는 프로젝에서 우측 마우스 클릭 >
  Build Path > Configure Build Path 클릭
  ![](https://media.vlpt.us/images/km2535/post/705a09f4-0a8b-41cc-89d7-ae8adf3223ff/image.png)
  Libraries 클릭 > Add External JARs 클릭, 저장한 파일 import
  다시 홈페이지에서 SDK > JAVA > JAVA SDK2.2 > example에서
  원하는 코드 선택
  SMS(단문) 발송
  해당 코드는 홈페이지에서 복사했다.

```java
package sms;

import java.util.HashMap;
import org.json.simple.JSONObject;
import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;

public class CoolSMSTest {
	public static void main(String[] args) {
		String api_key = "API 키";
	    String api_secret = "API SECRET 키";
	    Message coolsms = new Message(api_key, api_secret);

	    // 4 params(to, from, type, text) are mandatory. must be filled
	    HashMap<String, String> params = new HashMap<String, String>();
	    params.put("to", "받는사람 번호");
	    params.put("from", "보내는사람 번호");
	    params.put("type", "SMS");
	    params.put("text", "보낼 메세지");
	    params.put("app_version", "test app 1.2"); // application name and version

	    try {
			//메세지 전송
			JSONObject obj = (JSONObject) coolsms.send(params);
			//보내진 이후에 해야할 행위들 작성
			System.out.println(obj.toString());
	    } catch (CoolsmsException e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCode());
	    }
	}
}
```

## Object 클래스

모든 클래스들의 최상위 클래스이다.

- toString()
  - 객체 출력 시 나올 문자열 정의 / 객체가 가지고 있는 정보들을 설명하는 문자열
  ```java
  public String toString() {
        return getClass().getName() + "@" + Integer.toHexString(hashCode());
    }
  ```
  String 타입의 toString메소드는 객체클래스의 메소드를 가지고 있다.
  간단히 살펴보면 toString을 사용하면 클래스.클래스명@클래스와 관련한 정수를 리턴하고 있다.
  한번 toString으로 출력해보자

```java
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
	}
}
class Car{
	String brand;

	public Car(String brand) {
		super();
		this.brand = brand;
	}
```

결과는 다음과 같다.

```
object.Car@15db9742
object.Car@15db9742
```

Object클래스의 메소드로 toString을 살펴보았듯이 return값을 형식에 맞추어주고 있다.
그런데 위의 결과값을 알아볼 수 있겠는가?
물론 Object클래스의 Car타입클래스임이라고 알아 볼 수 있어도 그닥 우리가 원하는 값은 아니다. 명시적으로 우리가 원하는 값을 반환시켜보자
앞서 보았듯이 toString은 public메소드이다. 즉, 상속받은 클래스에서 재정의해서 사용이 가능하는 것이다. 그럼 우리가 원하는 값으로 return 시킬 수 있다.

더구나 클래스명만 출력한다면 toString의 역할을 수행하니 이보다 편할 수 없다.

```java
package object;

public class ObjectTest {
	public static void main(String[] args) {
//		Car타입의 클래스를 만들고 mycar로 객체화 시켰다.
		Car mycar = new Car("Ferrari");
//		객체화 시켜서 객체의 이름을 출력했다.
		System.out.println(mycar);
	}
}
class Car{
	String brand;

	public Car(String brand) {
		super();
		this.brand = brand;
	}
    // 아래와 같이 toString을 재정의하여 우리가 원하는 값을 반환하도록 하였다.
	@Override
	public String toString() {
		return "브랜드 : "+brand;
	}

}
```

결과는 다음과 같다.

```
브랜드 : Ferrari
```

우리가 원하는 클래스값을 받았다.
비교해보자

```
object.Car@15db9742
```

어떤 것이 더 보기 쉬운가???
재정의 한게 더 보기 어렵다면 분명 재정의의 목적을 달성하지 못한 것이다.
이제 Car클래스를 사용하면 클래스명만 출력했을 때 위와 같은 결과 값을 받을 수 있을 것이다.

위와 같은 개념과 동일하게 equals()와 hasCode()메소드를 살펴보자

아래의 equals메소드를 살펴보기 이전 ==는 무엇인가??

- ==
  - 두 조소값이 같은지 확인하는 연산자

먼저 아래의 코드를 살펴보자

```java
String msg1 = "RedVelvet";
String msg2 = "RedVelvet";
System.out.println(msg1 == msg2);

String msg3 = new String("RedVelvet");
String msg4 = new String("RedVelvet");
System.out.println(msg3 == msg4);
```

각각의 연산자는 어떤 값을 반환하게 될까??
먼저 String은 true를 반환하고 아래 2개의 객체는 false를 반환한다.
어떻게 이런 일이 일어날까? 둘다 똑같은 값이 아닌가???
먼저 String으로 변수를 만들면 최초에 이 변수의 주소값이 할당된다.
이 변수의 주소값은 RedVelvet이라는 값이 있는 msg1의 변수를 가지고 있다.
그리고 이어서 다시 String 타입의 변수를 만들고 값을 할당하면 주소를 다시 할당하는 것이 아니라 동일한 값이 있는지 확인하고 있으면 같은 주소를 할당하고 다른면 다른 주소를 할당하게 된다.
(무슨 말인지 모르면 검색 ㄱㄱ, 내가 공부하려고 써놓은거라 읽어도 무슨말인지 모를 꺼임ㅋ)

그럼 String을 new라는 키워드로 객체를 생성하면 어떻게 될까??
당근 클래스의 객체화처럼 동작하여 '서로 다른 주소값'을 할당하게 된다.
객체를 생성할때마다 다른 주소값을 할당하는 것처럼 말이다.

다시 처음으로 돌아와서 ==은 두 주소값이 같은지 확인하는 연산자라고 했다.
그래서 아래의 코드는 true / false가 되는 것이다.

```java
String msg1 = "RedVelvet";
String msg2 = "RedVelvet";
System.out.println(msg1 == msg2);
//같은 주소값을 비교하는 거임 그래서 true


String msg3 = new String("RedVelvet");
String msg4 = new String("RedVelvet");
System.out.println(msg3 == msg4);
//다른 주소를 비교하는 거임 그래서 false
```

그럼 equals메소드를 살펴보자, equals메소드는 클래스 객체비교와 String타입의 클래스 비교는 서로 다른 값을 반환한다.

- equals()
  - 두 주소값이 같은지 확인하는 메소드

아래 코드 중 첫번째 결과는 true를 리턴하고 두번재는 fasle를 리턴한다.
어떻게 된 일이까?
사실 equals는 주소값을 리턴하는 것이 맞다.

```java
		String msg3 = new String("RedVelvet");
		String msg4 = new String("RedVelvet");
		System.out.println(msg3.equals(msg4));

		//동위객체
		User user1 = new User(1, 1234);
		User user2 = new User(1, 1234);
		System.out.println(user1.equals(user2));
```

첫번째와 두번째 equals는 서로 다른 메소드를 참조한다.
String을 비교하는 equals

```java
public boolean equals(Object anObject) {
        if (this == anObject) {
            return true;
        }
        if (anObject instanceof String) {
            String anotherString = (String)anObject;
            int n = value.length;
            if (n == anotherString.value.length) {
                char v1[] = value;
                char v2[] = anotherString.value;
                int i = 0;
                while (n-- != 0) {
                    if (v1[i] != v2[i])
                        return false;
                    i++;
                }
                return true;
            }
        }
        return false;
    }
```

위의 코드를 완벽히 이해하기 힘들지만 최대한 풀어보면 주소값이 같다면 true를 리턴한다. 하지만 우리가 만든 String 비교는 서로다른 주소값을 가지고 있다.
그래서 첫번째 조건문을 통과하고 2번째 조건문에 도달한다. instanceof로 비교하여 참이면 그 값이 조건문을 거치도록 하였다. 우리는 String을 비교했음으로 조건문에 들어가 실행된다. String타입으로 다운캐스팅 되고 n이라는 변수로 값을 비교하고 같지 않다면 false, 같다면 true를 반환한다.
두번째 조건문도 거짓이면 false를 반환한다. 우리가 비교하는 문자열은 n으로 비교했을 때 참임으로 true를 반환하게 되었다.

Object를 비교하는 equals는 단순 주소값만 비교한다.

```java
public boolean equals(Object obj) {
        return (this == obj);
    }
```

자, 그렇다면 이제 우리는 String 클래스가 equals 메소드를 재정의하여 사용했다는 것을 알았으니 우리도 우리 입맛에 맞게 재정의 해보도록 하자.
우리는 String이 아니라 객체도 값이 동일하면 true를 리턴하도록 재정의 해 볼 것이다.

```java
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
```

위와 같이 정의하면 이제 아래의 코드도 true를 반환한다.

```java
//동위객체
		User user1 = new User(1, 1234);
		User user2 = new User(1, 1234);
		System.out.println(user1.equals(user2));
```

- hasCode()
  - 해쉬값(주소값 관련된 어떤 int값 리턴)

해쉬코드도 주소값을 정수로 리턴하기 때문에 서로 다른 객체는 서로 다른 값을 반환한다.

```java
System.out.println(user1.hashCode()); //366712642
System.out.println(user2.hashCode()); //1829164700
```

우리는 값이 동일한 객체면 동일하게 만들어 주는 오버라이드 과정을 거치도록 할 것이다.
따라서 hashCode도 오버라이드 하면 된다.

```java
@Override
public int hashCode(){
	return userid;
}
```

위 코드에서는 동일한 객체들이 가지는 동일한 값으로 단순하게 리턴하였다.

따라서 이제 두개의 객체는 동일한 주소값을 가진다.

```java
System.out.println(user1.hashCode()); //1
System.out.println(user2.hashCode()); //1
```

우리는 이 Object클래스들의 메소드들을 재정의하면서 우리가 원하는 값, 우리가 원하는 리턴값을 우리에게 맞게 가공하는 과정이 중요하다.
