package net.hitesh.webservice.service;


import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.io.*;

import javax.xml.rpc.ServiceException;

import org.apache.axis.EngineConfiguration;
import org.apache.axis.configuration.FileProvider;
import org.apache.commons.httpclient.Credentials;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.UsernamePasswordCredentials;
import org.apache.commons.httpclient.auth.AuthScope;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
/*import org.apache.ws.security.handler.WSHandlerConstants;*/



public class DUmmyMainClass {

	public static void main(String[] args) {
		DUmmyMainClass dm = new DUmmyMainClass();

		dm.testSoapService();
		//dm.testRestServiceGet();
		//dm.testRESTServicePOST();

	}

	/**
	 * Authorization User Name and Pwd are hard coded in the SOAP stub class ContactSEIServiceSoapBindingStub
	 */
	public void  testSoapService(){
	//	addSSLConfig();		
			EngineConfiguration config = new FileProvider("client_deploy_sec.wsdd");
			
			// Service is the MAIn Class in the Generated Client
			ContactSEIService service= new ContactSEIServiceLocator(config);
			
			
			ContatctService port=null;
			try {
				// From Service you get a Port
				//port=service.getcontatctServicePort(new URL("https://localhost:9081/Spring3HibernateMaven/services/Contact"));
				port=service.getcontatctServicePort(new URL("http://localhost:9081/Spring3HibernateMaven/services/Contact"));
			} catch (MalformedURLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (ServiceException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
				    
		
			try {
				// Using Port call the Service, Port Interface will internally use the Generatd Stud class to make the final call, Here ContactSEIServiceSoapBindingStub
				ContactServiceResponse response=port.getContactById(0);
				if(response!=null)
				{
					System.out.println("First Name-->"+response.getFirstname());	
					System.out.println("Last Name-->"+response.getLastname());
					System.out.println("Email-->"+response.getEmail());
					System.out.println("Tele-->"+response.getTelephone());
				}

			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		System.out.println("By Name----->");

			try {
				ContactServiceResponse response[] =port.getContactByName("Hitesh");
				if(response!=null)
				{
					for(int i=0;i<response.length;i++){
						System.out.println("First Name-->"+response[i].getFirstname());	
						System.out.println("Last Name-->"+response[i].getLastname());
						System.out.println("Email-->"+response[i].getEmail());
						System.out.println("Tele-->"+response[i].getTelephone());
					}
				}

			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	
	}

/*	public void addSSLConfig(){
		String[][] props = {
			      { "javax.net.ssl.keyStore", "C://Users/hitjoshi/Documents/PWorkspace/ClientDemo/src/main/resources/clienttruststore.jks", },
			      //{ "javax.net.ssl.truststore", "C://Users/hitjoshi/Documents/PWorkspace/ClientDemo/src/main/resources/clienttruststore.jks", },
			      { "javax.net.ssl.keyStorePassword", "clientstorepass", },
			      { "javax.net.ssl.keyStoreType", "JKS", },
			    };
			    for (int i = 0; i < props.length; i++)
			      System.getProperties().setProperty(props[i][0], props[i][1]);

		
	}*/


	public void  testRestServiceGet()
	{

		HttpClient client = new HttpClient();
		
		/* for Apache Http 4.1 use this instead as getState is deprecated
		  DefaultHttpClient httpclient = new DefaultHttpClient();
		  httpclient.getCredentialsProvider().setCredentials(
                 new AuthScope("localhost", 443),
                 new UsernamePasswordCredentials("username", "password"));
		 */

		
		//set HTTP Pre-emptive Authentication to true
		client.getParams().setAuthenticationPreemptive(true);
		Credentials defaultcreds= new UsernamePasswordCredentials("wsuser","wspwd");
		// Get the State and set The Credentials to it
		client.getState().setCredentials(new AuthScope("localhost",8443, AuthScope.ANY_REALM), defaultcreds);


		String url="https://localhost:8443/Spring3HibernateMaven/services/rest/contactService/contact/0";

		GetMethod myMethod = new GetMethod(url);

		// Send GET request
		try {
			int statusCode = client.executeMethod(myMethod);
			if (statusCode != HttpStatus.SC_OK) {
				System.err.println("Method failed: " + myMethod.getStatusLine());
			}
		} catch (HttpException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		InputStream rstream = null;

		// Get the response body
		try {
			rstream = myMethod.getResponseBodyAsStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(rstream));
			String line;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


	public void testRESTServicePOST() 
	{
		HttpClient client = new HttpClient();
		//set HTTP Pre-emptive Authentication to true
		client.getParams().setAuthenticationPreemptive(true);
		Credentials defaultcreds= new UsernamePasswordCredentials("wsuser","wspwd");
		// Get the State and set The Credentials to it
		client.getState().setCredentials(new AuthScope("localhost",8443, AuthScope.ANY_REALM), defaultcreds);
		
		String url="https://localhost:8443/Spring3HibernateMaven/services/rest/contactService/contactName?fname=Sandeep";
		HttpMethod  myMethod= new PostMethod(url);
/*		HttpClientParams params = new HttpClientParams();
		params.setParameter("fname", "Hitesh");
	    //client.setParams(params);
		myMethod.getParams().setParameter("fname", "Hitesh");*/
		
		try {
			int statusCode = client.executeMethod(myMethod);
			if (statusCode != HttpStatus.SC_OK) {
				System.err.println("Method failed: " + myMethod.getStatusLine());
			}
		} catch (HttpException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		InputStream rstream = null;

		// Get the response body
		try {
			rstream = myMethod.getResponseBodyAsStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(rstream));
			String line;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	myMethod.releaseConnection();

	}

}


