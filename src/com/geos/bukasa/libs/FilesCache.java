package com.geos.bukasa.libs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import android.graphics.Bitmap;
import android.os.Environment;
import android.util.Log;

public class FilesCache {

	private static final String BUKASA_BASE_DIR = "/Android/data/com.geos.bukasa";
	private static final String LOG_TAG = "Files Cache";
	private static final String LOG_TAG_ERROR = "Files Cache Error";
	
	public static final String BUKASA_CACHE_DIR 		= BUKASA_BASE_DIR + "/cache/";
	public static final String BUKASA_DOWNLOADS_DIR 	= BUKASA_BASE_DIR + "/downloads/";
	public static final String BUKASA_FILES_DIR 		= BUKASA_BASE_DIR + "/files/";
	public static final String BUKASA_PHOTOS_DIR 		= BUKASA_BASE_DIR + "/photos/";
	
	
	public FilesCache(){
		super();
	}
	
	public void createDirectories(){
		File tarjeta = Environment.getExternalStorageDirectory();
		
		File cacheFile 		= new File(tarjeta.getAbsoluteFile() + BUKASA_CACHE_DIR);
		File downloadsFile 	= new File(tarjeta.getAbsoluteFile() + BUKASA_DOWNLOADS_DIR);
		File filesFile 		= new File(tarjeta.getAbsoluteFile() + BUKASA_FILES_DIR);
		File photosFile 	= new File(tarjeta.getAbsoluteFile() + BUKASA_PHOTOS_DIR);
		
		if(!cacheFile.exists())
			cacheFile.mkdirs();
		
		if(!downloadsFile.exists())
			downloadsFile.mkdirs();
		
		if(!filesFile.exists())
			filesFile.mkdirs();
		
		if(!photosFile.exists())
			photosFile.mkdirs();
	}
	
	public void saveFile(String file_name, String data, String path){
		try {
            File tarjeta = Environment.getExternalStorageDirectory();
            File file = new File(tarjeta.getAbsoluteFile() + path, file_name);
            
            OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(file));
            osw.write(data);
            osw.flush();
            osw.close();
            Log.i(LOG_TAG, "File created successfully");
        } catch (IOException ioe) {
        	Log.i(LOG_TAG_ERROR, ioe.getMessage());
        }
	}
	
	public void saveImageFile(String image_name, String path, Bitmap img){
		try {
			File tarjeta = Environment.getExternalStorageDirectory();
            File file = new File(tarjeta.getAbsoluteFile() + path, image_name);
            
			FileOutputStream out = new FileOutputStream(file);
			
			img.compress(Bitmap.CompressFormat.JPEG, 90, out);
			
			Log.i(LOG_TAG, "Image saved successfully");
		} catch (Exception e) {
			e.printStackTrace();
			Log.e(LOG_TAG_ERROR, e.getMessage());
		}
	}
	
	public String readFile(String file_name, String path){
		String data = "";
		
		try{
			File tarjeta = Environment.getExternalStorageDirectory();
			File file = new File(tarjeta.getAbsoluteFile() + path, file_name);
			
			if(file.exists()){
				FileInputStream fIn = new FileInputStream(file);
	            InputStreamReader isr = new InputStreamReader(fIn);
	            BufferedReader br = new BufferedReader(isr);
	            String line = br.readLine();
	            
	            while (line != null) {
	                data += line;
	                line = br.readLine();
	            }
	            
	            br.close();
	            isr.close();
	            Log.i(LOG_TAG, "Read data file finished");
			}
			
		}catch(IOException e){
			Log.i(LOG_TAG_ERROR, e.getMessage());
		}
		
		return data;
	}
	
	public boolean existsFile(String file_name, String path){
		File tarjeta = Environment.getExternalStorageDirectory();
        File file = new File(tarjeta.getAbsolutePath() + path, file_name);
        
        return file.exists();
	}
}
