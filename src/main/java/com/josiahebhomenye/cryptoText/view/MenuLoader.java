package com.josiahebhomenye.cryptoText.view;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.josiahebhomenye.cryptoText.view.handler.Handler;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Map;

/**
 * Created by jay on 09/12/15.
 */
public class MenuLoader {

	private static final String packageName = "com.josiahebhomenye.cryptoText.view.handler.";
	private final GUI gui;

	public MenuLoader(GUI gui){
		this.gui = gui;
	}

	@SuppressWarnings("unchecked")
	JMenuBar load(String filename) throws Exception{
		ObjectMapper mapper = new ObjectMapper();
		ArrayList<Map<String, Object>> data = mapper.readValue(new File(filename), ArrayList.class);
		JMenuBar menuBar = new JMenuBar();

		data.stream().forEach((Map<String, Object> item) -> {
			JMenu menu = convert(item);
			menuBar.add(menu);
		});

		return menuBar;
	}

	@SuppressWarnings("unchecked")
	JMenu convert(Map<String, Object> data){
		JMenu menu = new JMenu(data.get("name").toString());
		ArrayList<Map<String, Object>> items = (ArrayList<Map<String, Object>>) data.get("items");

		items.stream().forEach((Map<String, Object> item) -> {
			JMenuItem menuItem = new JMenuItem(item.get("name").toString());
			if(item.containsKey("items")){

				ArrayList<Map<String, Object>> subItmes = (ArrayList<Map<String, Object>>) item.get("items");
				subItmes.stream().forEach((Map<String, Object> subItem) ->{
					menuItem.add(convert(subItem));
				});
			}

			if(item.containsKey("handler")){
				String className = packageName  + item.get("handler").toString();

				try {
					Class<? extends Handler> clazz = (Class<? extends Handler>) MenuLoader.class.forName(className);
					Constructor<? extends Handler> constructor = clazz.getDeclaredConstructor(GUI.class);
					menuItem.addActionListener(constructor.newInstance(gui));
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (InstantiationException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (NoSuchMethodException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}

			}

			menu.add(menuItem);
		});
		return menu;
	}
}
