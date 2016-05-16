package com.game;

import java.util.ArrayList;
import java.util.List;

import com.game.util.clazz.ClassScanner;
import com.hoolai.util.log.Log;


public class Bootstrap {

	public static void main(String[] args) {
		String includes = "*-SNAPSHOT.jar;com.game.*";
		String excludes = "";
		List<String> classNames = ClassScanner.scanClassNames(includes, excludes);
		List<Class<?>> classes = new ArrayList<Class<?>>(classNames.size());
	        for (String className : classNames) {
	            try {
	                classes.add(Class.forName(className));
	            } catch (ClassNotFoundException e) {
	                Log.error("class not found", e);
	            }
	        }
		
	}
}
