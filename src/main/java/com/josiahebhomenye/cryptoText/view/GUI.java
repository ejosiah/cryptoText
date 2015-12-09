package com.josiahebhomenye.cryptoText.view;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by jay on 09/12/15.
 */
public class GUI extends JFrame{

	static final String APP_NAME = "Crypto Text";
	static final int WIDTH = 1024;
	static final int HEIGHT = 760;

	static final ExecutorService BACKGROUND_SERVICE = Executors.newCachedThreadPool();

	private MenuLoader menuLoader;

	private JTextArea workspcae;

	public GUI() throws Exception{
		setTitle(APP_NAME);
		setSize(WIDTH, HEIGHT);
		setLayout(new BorderLayout());

		construct();
	}

	public void construct() throws Exception{
		menuLoader = new MenuLoader(this);
		JMenuBar menuBar = menuLoader.load("/Users/jay/projects/cryptoText/src/main/resources/menus.json");
		add(menuBar, BorderLayout.NORTH);
		workspcae = new JTextArea();
		add(new JScrollPane(workspcae), BorderLayout.CENTER);
		add(new Label("Status Bar"), BorderLayout.SOUTH);

	}

	public JTextArea getWorkspcae(){
		return workspcae;
	}


	public void init(){
		setVisible(true);
	}

	public <T>Future<T> runInBackground(Callable<T> callable){
		return BACKGROUND_SERVICE.submit(callable);
	}

	public void runInBackground(Runnable runnable){
		BACKGROUND_SERVICE.execute(runnable);
	}
}
