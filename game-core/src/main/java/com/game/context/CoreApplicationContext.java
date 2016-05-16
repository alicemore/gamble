package com.game.context;

import java.lang.reflect.Modifier;
import java.util.List;

import com.game.net.cmd.Cmd;
import com.game.net.cmd.Command;
import com.game.net.cmd.CommandContext;

public class CoreApplicationContext {
	private static CommandContext cmdContext;
	
	 private static void loadCmds(List<Class<?>> classes) throws InstantiationException, IllegalAccessException {
	        for (Class<?> clazz : classes) {
	            Cmd ann = clazz.getAnnotation(Cmd.class);
	            if(ann != null && !Modifier.isAbstract(clazz.getModifiers()) && !Modifier.isInterface(clazz.getModifiers())) {
	            	short value = ann.value();
	            	Object bean = cmdContext.get(value);
	            	bean = bean == null ? clazz.newInstance() : bean;
	            	
	            	cmdContext.registerCmd(value, (Command)bean);
	            }
	        }
	    }
}
