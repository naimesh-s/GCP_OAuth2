//package com.externalModeller.gcp.GCPWebApp;
//
//import java.io.BufferedReader;
//import java.io.DataOutputStream;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.net.HttpURLConnection;
//import java.net.URL;
//import java.net.URLEncoder;
//import java.security.GeneralSecurityException;
//import java.util.HashMap;
//import java.util.LinkedHashMap;
//import java.util.Map;
//import java.util.Properties;
//
//import org.json.JSONObject;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.env.Environment;
//
//@Configuration
//public class OAuthGCPConfiguration {
//	
//	@Autowired
//	private Environment env;
//	
//	/*
//	 * public String AccessToken() { String accessToken = ""; StringBuilder strBuild
//	 * = new StringBuilder();
//	 * 
//	 * String authURL = "https://accounts.google.com/o/oauth2/token?"; String code =
//	 * "4/SVisuz_x*********************"; String client_id =
//	 * "******************e.apps.googleusercontent.com"; String client_secret =
//	 * "*******************"; String redirect_uri = "urn:ietf:wg:oauth:2.0:oob";
//	 * String grant_type="authorization_code"; strBuild.append("code=").append(code)
//	 * .append("&client_id=").append(client_id)
//	 * .append("&client_secret=").append(client_secret)
//	 * .append("&redirect_uri=").append(redirect_uri)
//	 * .append("&grant_type=").append(grant_type);
//	 * System.out.println(strBuild.toString()); try{ URL obj = new URL(authURL);
//	 * HttpURLConnection con = (HttpURLConnection) obj.openConnection();
//	 * con.setDoOutput(true); con.setRequestMethod("POST");
//	 * 
//	 * con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
//	 * con.setRequestProperty("Host", "www.googleapis.com");
//	 * 
//	 * //BufferedWriter bw = new BufferedWriter(new
//	 * OutputStreamWriter(con.getOutputStream())); //bw.write(strBuild.toString());
//	 * //bw.close();
//	 * 
//	 * DataOutputStream wr = new DataOutputStream(con.getOutputStream());
//	 * wr.writeBytes(strBuild.toString()); wr.flush(); wr.close();
//	 * 
//	 * //OutputStreamWriter out = new OutputStreamWriter(con.getOutputStream());
//	 * System.out.println(con.getResponseCode());
//	 * System.out.println(con.getResponseMessage());
//	 * 
//	 * } catch (Exception e) { System.out.println("Error."); } return ""; }
//	 */
//	
//	private Map<String, String> getClientIdAndClientSecret(){
//		Map<String, String> clientIdAndClientSecretMap = new HashMap<String, String>();
//		
//		 try (InputStream input = new FileInputStream("/src/main/resources/application.properties")) {
//
//	            Properties prop = new Properties();
//
//	            // load a properties file
//	            prop.load(input);
//	            
//	            clientIdAndClientSecretMap.put("ClientId", prop.getProperty("spring.security.oauth2.client.registration.google.client-id"));
//	    		clientIdAndClientSecretMap.put("ClientSecret", prop.getProperty("spring.security.oauth2.client.registration.google.client-secret"));
//	    		clientIdAndClientSecretMap.put("scope", prop.getProperty("spring.security.oauth2.client.registration.google.scope"));
//	    		
//	            // get the property value and print it out
//	            System.out.println(prop.getProperty("spring.security.oauth2.client.registration.google.client-id"));
//	            System.out.println(prop.getProperty("spring.security.oauth2.client.registration.google.client-secret"));
//	            System.out.println(prop.getProperty("spring.security.oauth2.client.registration.google.scope"));
//	        } catch (IOException ex) {
//	            ex.printStackTrace();
//	        }
//		 
//		 return clientIdAndClientSecretMap;
//	}
//	
//	public Map<String, String> getCodeFromGoogle(){
//		Map<String, String> mainMap = new HashMap<String, String>();
//		Map<String, String> clientIdAndClientSecretMap = getClientIdAndClientSecret();
//		
//		
//		return mainMap;
//	}
//	
//	public String getAccessToken()
//	{
//	    try
//	    {
//	        Map<String,Object> params = new LinkedHashMap<>();
//	        params.put("grant_type","refresh_token");
//	        params.put("client_id","");
//	        params.put("client_secret","");
////	        params.put("refresh_token",[YOUR REFRESH TOKEN]);
//
//	        StringBuilder postData = new StringBuilder();
//	        for(Map.Entry<String,Object> param : params.entrySet())
//	        {
//	            if(postData.length() != 0)
//	            {
//	                postData.append('&');
//	            }
//	            postData.append(URLEncoder.encode(param.getKey(),"UTF-8"));
//	            postData.append('=');
//	            postData.append(URLEncoder.encode(String.valueOf(param.getValue()),"UTF-8"));
//	        }
//	        byte[] postDataBytes = postData.toString().getBytes("UTF-8");
//
//	        URL url = new URL("https://accounts.google.com/o/oauth2/token");
//	        HttpURLConnection con = (HttpURLConnection)url.openConnection();
//	        con.setDoOutput(true);
//	        con.setUseCaches(false);
//	        con.setRequestMethod("POST");
//	        con.getOutputStream().write(postDataBytes);
//
//	        BufferedReader  reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
//	        StringBuffer buffer = new StringBuffer();
//	        for (String line = reader.readLine(); line != null; line = reader.readLine())
//	        {
//	            buffer.append(line);
//	        }
//
//	        JSONObject json = new JSONObject(buffer.toString());
//	        String accessToken = json.getString("access_token");
//	        return accessToken;
//	    }
//	    catch (Exception ex)
//	    {
//	        ex.printStackTrace(); 
//	    }
//	    return null;
//	}
//}
