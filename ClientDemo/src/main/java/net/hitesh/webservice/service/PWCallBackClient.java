package net.hitesh.webservice.service;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ws.security.WSPasswordCallback;
import org.apache.xml.security.utils.Base64;

public class PWCallBackClient implements CallbackHandler {
	private Map<String, String> keyPasswords = new HashMap<String, String>();
	private Map<String, String> userPasswords = new HashMap<String, String>();

	protected static Log log = LogFactory.getLog(PWCallBackClient.class);



	public PWCallBackClient()
	{
		keyPasswords.put("myclientkey", "cspass");
		userPasswords.put("wsuser", "awspwd");
	}

	public void handle (Callback[] callbacks) throws IOException, UnsupportedCallbackException {
		for (int i = 0; i < callbacks.length; i++) {
			if (callbacks[i] instanceof WSPasswordCallback) {
				WSPasswordCallback pc = (WSPasswordCallback) callbacks[i];


				String id=pc.getIdentifier();

				int usage=pc.getUsage();
				if(usage==WSPasswordCallback.USERNAME_TOKEN)
				{
					//System.out.println("Usage of Token"+pc.getUsage());
					String userPass = userPasswords.get(id);
					//System.out.println("Password used with UserName--> "+userPass);
					if (userPass != null) {        
						pc.setPassword(userPass);      
						//System.out.println("Set Password in User   "+pc.getPassword());
						return;       
					}
				}
				if (usage == WSPasswordCallback.DECRYPT || usage == WSPasswordCallback.SIGNATURE) 
				{
					//System.out.println("Usage of Token in encryption"+pc.getUsage());
					//System.out.println("Value of ID Here in encryption---->"+id);
					String keyPass = keyPasswords.get(id);
					//System.out.println("Password Used In Signing---> "+keyPass);
					if (keyPass != null) { 
						pc.setPassword(keyPass); 
						//System.out.println("Set Password in Signing   "+pc.getPassword());
						return;       
					}
				}

			} else {
				throw new UnsupportedCallbackException(callbacks[i], "Unrecognized Callback");
			}
		}
	}

	/*private String generatePasswordDigest(String pwd)
	{
		Random generator = new Random();
	    String nonceString = String.valueOf(generator.nextInt(999999999));

	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
	    Calendar cal = Calendar.getInstance();
	    String createdTimeStamp=dateFormat.format(cal.getTime());
	   return  calculatePasswordDigest(nonceString,createdTimeStamp,pwd);

	}

	private String calculatePasswordDigest(String nonce, String created, String password) {
        String encoded = null;
        try {
            String pass = hexEncode(nonce) + created + password;
            MessageDigest md = MessageDigest.getInstance( "SHA1" );
            md.update( pass.getBytes() );
            byte[] encodedPassword = md.digest();
              encoded = Base64.encode(encodedPassword);

              //here
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(PWCallBackClient.class.getName()).log(Level.SEVERE, null, ex);
        }

        return encoded;
    }

    private String hexEncode(String in) {
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < (in.length() - 2) + 1; i = i + 2) {
            int c = Integer.parseInt(in.substring(i, i + 2), 16);
            char chr = (char) c;
            sb.append(chr);
        }
        return sb.toString();
    }*/

	public void setAliasPassword(String alias, String password) {
		keyPasswords.put(alias, password);
	}

}

