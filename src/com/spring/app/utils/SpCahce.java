package com.spring.app.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Log;

/**
 * 对象缓存类
 * @author yd
 *
 * @param <T>
 */
public class SpCahce<T> {

	private Context context;
	private String saveName = "";

	public SpCahce(Context context) {
		this.context = context;
	}

	/**
	 * 保存对象
	 * 对象一定要序列化
	 * @param object
	 */
	public void saveObject(T object) {
		try {
			saveObject(serialize(object),null);
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
	
	public void saveObject(T object,String key){
		try {
			saveObject(serialize(object),key);
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	/**
	 * 拿取对象
	 * 
	 * @return
	 */
	public T getSpObject(T object) {
		try {
			return deSerialization(getObject(object,null));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 拿取对象
	 * 
	 * @return
	 */
	public T getSpObject(T object,String key) {
		try {
			return deSerialization(getObject(object,key));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 序列化对象
	 * 
	 * @param person
	 * @return
	 * @throws IOException
	 */
	private String serialize(T object) throws IOException {
		saveName = object.getClass().getSimpleName();
		long startTime = System.currentTimeMillis();
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
		objectOutputStream.writeObject(object);
		String serStr = byteArrayOutputStream.toString("ISO-8859-1");
		serStr = java.net.URLEncoder.encode(serStr, "UTF-8");
		objectOutputStream.close();
		byteArrayOutputStream.close();
		Log.d("serial", "serialize str =" + serStr);
		long endTime = System.currentTimeMillis();
		Log.d("serial", "序列化耗时为:" + (endTime - startTime));
		return serStr;
	}

	/**
	 * 反序列化对象
	 * 
	 * @param str
	 * @return
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	private T deSerialization(String str) throws IOException, ClassNotFoundException {
		long startTime = System.currentTimeMillis();
		String redStr = java.net.URLDecoder.decode(str, "UTF-8");
		ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(redStr.getBytes("ISO-8859-1"));
		ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
		T object = (T) objectInputStream.readObject();
		objectInputStream.close();
		byteArrayInputStream.close();
		long endTime = System.currentTimeMillis();
		Log.d("serial", "反序列化耗时为:" + (endTime - startTime));
		return object;
	}

	private void saveObject(String strObject,String key) {
		if(key!=null && key.length()>0){
			saveName = saveName+key;
		}
		SharedPreferences sp = context.getSharedPreferences(saveName, 0);
		Editor edit = sp.edit();
		edit.putString(saveName, strObject);
		edit.commit();
	}

	private String getObject(T object,String key) {
		saveName = object.getClass().getSimpleName();
		if(key!=null){
			saveName = saveName + key;
		}
		SharedPreferences sp = context.getSharedPreferences(saveName, 0);
		return sp.getString(saveName, null);
	}

}
