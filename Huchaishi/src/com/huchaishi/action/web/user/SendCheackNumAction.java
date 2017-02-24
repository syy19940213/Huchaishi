package com.huchaishi.action.web.user;

import com.alibaba.fastjson.JSON;
import com.huchaishi.hibernate.user.User;
import com.huchaishi.hibernate.user.UserFactory;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class SendCheackNumAction extends ActionSupport{
	
	private String mobile;
	private String sendcheackNum;
	private String result;
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getSendcheackNum() {
		return sendcheackNum;
	}
	public void setSendcheackNum(String sendcheackNum) {
		this.sendcheackNum = sendcheackNum;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	
	public String execute(){
		UserFactory userDao = new UserFactory();
		List<User> userList=userDao.findUserByUserPhoneNume(mobile);
		Map<String,String> map = new HashMap<String,String>();
		if(userList.size()==0){
			String url = "action=send&userid=1474&account=106验证码账户&password=888081lu&mobile="+mobile+"&content=【互差事】您的验证码为："+sendcheackNum+"&sendTime=&extno=";
			System.out.println(url);
			String data = sendPost("http://121.40.79.174:9001/sms.aspx",url);
			map.put("success", "success");
			result = JSON.toJSONString(map);
			System.out.println(sendcheackNum);
		}else{
			map.put("error", "手机号码重复");
			result = JSON.toJSONString(map);
			System.out.println(result);
		}
		
		
		return Action.SUCCESS;
	}
	
	public  String sendPost(String url, String param) {
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            // �򿪺�URL֮�������
            URLConnection conn = realUrl.openConnection();
            // ����ͨ�õ���������
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // ����POST�������������������
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // ��ȡURLConnection�����Ӧ�������
            out = new PrintWriter(conn.getOutputStream());
            // �����������
            out.print(param);
            // flush������Ļ���
            out.flush();
            // ����BufferedReader����������ȡURL����Ӧ
            in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("���� POST ��������쳣��"+e);
            e.printStackTrace();
        }
        //ʹ��finally�����ر��������������
        finally{
            try{
                if(out!=null){
                    out.close();
                }
                if(in!=null){
                    in.close();
                }
            }
            catch(IOException ex){
                ex.printStackTrace();
            }
        }
        return result;
    }    

}
