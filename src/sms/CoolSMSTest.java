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




