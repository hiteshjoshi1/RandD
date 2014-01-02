package net.hitesh.webservice.security;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;



import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ws.security.WSPasswordCallback;
import org.springframework.stereotype.Component;

@Component
public class ServerCallback implements CallbackHandler {

	protected static Log log = LogFactory.getLog(ServerCallback.class);
	private Map<String, String> userPasswords =  new HashMap<String, String>();
	private Map<String, String> keyPasswords = new HashMap<String, String>();

	public ServerCallback() {   

		userPasswords.put("wsuser", "awspwd");
		// some example key passwords
		keyPasswords.put("myservicekey","sspass");
		//keyPasswords.put("bob",   "keypswd");


	}


	@Override
	public void handle(Callback[] callbacks) throws IOException,
	UnsupportedCallbackException {
		for (int i = 0; i < callbacks.length; i++) { 
			if (callbacks[i] instanceof WSPasswordCallback) {
				WSPasswordCallback pc = (WSPasswordCallback) callbacks[i];

				log.info("identifier: "+pc.getIdentifier()+", usage: "+pc.getUsage());
				String id=pc.getIdentifier();
				int usage = pc.getUsage();

				if(usage == WSPasswordCallback.USERNAME_TOKEN ) {
					// Logic to get the password for the username token to validate the username token
					String userPass = userPasswords.get(id);
					//System.out.println("Password used with UserName--> "+userPass);
					if (userPass != null) {        
						pc.setPassword(userPass);      
						System.out.println("Set Password in User serevr   "+pc.getPassword());
						return;       
					}
				} else if (usage == WSPasswordCallback.SIGNATURE || usage == WSPasswordCallback.DECRYPT ) {
					String keyPass = keyPasswords.get(id);
					System.out.println("Password Used In Signing xerver---> "+keyPass);

					if (keyPass != null) {  

						pc.setPassword(keyPass); 
						System.out.println("Set Password in Signing  server  "+pc.getPassword());
						return;       
					}
				}

			}		   


			/*	
				if (pc.getUsage() == WSPasswordCallback.USERNAME_TOKEN) {
					// for passwords sent in digest mode we need to provide the password,
					// because the original one can't be un-digested from the message

					// we can throw either of the two Exception types if authentication fails

					if (! user.equals(pc.getIdentifier()))
					{
						throw new IOException("unknown user: "+pc.getIdentifier());
					}
					// this will throw an exception if the passwords don't match
					pc.setPassword(pwd);

				} */

			/*if (user.equals(pc.getIdentifier())) {
					pc.setPassword(pwd);
				}*/
			else {
				throw new UnsupportedCallbackException(callbacks[i], "Unrecognized Callback");
			}
		}
	}

/*	public void setAliasPassword(String alias, String password) {     
		passwords.put(alias, password);    }*/

}
