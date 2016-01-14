package com.josiahebhomenye.cryptoText;

import com.josiahebhomenye.cryptoText.view.GUI;

import javax.swing.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by jay on 09/12/15.
 */
public class Main {

	static void createAndInitializeUI(){
		try {
			new GUI().init();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static void main(String[] args) throws Exception{
		SwingUtilities.invokeLater(Main::createAndInitializeUI);

	}
}
