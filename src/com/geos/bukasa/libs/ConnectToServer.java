package com.geos.bukasa.libs;

import java.io.File;
import java.util.ArrayList;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

import android.os.AsyncTask;

public class ConnectToServer {

	// Public constants
	public static final String METHOD_GET = "GET";
	public static final String METHOD_POST = "POST";
	public static final String URL_BASE = "";
	
	// Private constants
	private static final String LOG_TAG = "Connection Server";
	
	// Instance
	private static ConnectToServer instance;
	
	// Client HTTP
	private HttpClient client;
	
	public ConnectToServer(){
		super();
		
		client = new DefaultHttpClient();
	}
	
	public static final ConnectToServer getInstance(){
		if(instance == null){
			instance = new ConnectToServer();
		}
		
		return instance;
	}
	
	public void sendToServer(ArrayList<ServerParam> params, String url, String method){
		
	}
	
	public class SendPost extends AsyncTask<Void, Void, Void> {

		private HttpPost post;
		
		@Override
		protected Void doInBackground(Void... params) {
			// TODO Auto-generated method stub
			return null;
		}
		
	}
	
	public class SendGet extends AsyncTask<Void, Void, Void>{

		private HttpGet get;
		
		public SendGet(){
			
		}
		
		@Override
		protected Void doInBackground(Void... params) {
			// TODO Auto-generated method stub
			return null;
		}
		
	}
	
	public static abstract class ResponseServerListener {
		public abstract void success(String response);
		public abstract void error(String response);
		public abstract void onFinal();
	}
	
	public class ServerParam {
		// Constants
		public static final int PARAM_TYPE_STRING = 0;
		public static final int PARAM_TYPE_FILE = 1;
		
		public String param_name;
		public String param_string;
		public File param_file;
		public int type;
		
		public ServerParam(String param_name, String param){
			this.param_name = param_name;
			this.param_string = param;
			this.type = PARAM_TYPE_STRING;
		}
		
		public ServerParam(String param_name, File param){
			this.param_name = param_name;
			this.param_file = param;
			this.type = PARAM_TYPE_FILE;
		}
	}
}
