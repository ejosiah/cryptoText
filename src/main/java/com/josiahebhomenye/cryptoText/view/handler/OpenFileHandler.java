package com.josiahebhomenye.cryptoText.view.handler;

import com.josiahebhomenye.cryptoText.view.GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;

import java.io.*;
import java.util.Scanner;

/**
 * Created by jay on 09/12/15.
 */
public class OpenFileHandler extends Handler {

	public OpenFileHandler(GUI gui) {
		super(gui);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JFileChooser chooser = new JFileChooser();
		int returnValue = chooser.showOpenDialog(gui);

		if(returnValue == JFileChooser.APPROVE_OPTION){

			final File file = chooser.getSelectedFile();

			gui.runInBackground(() -> {
				try {
					Scanner scanner = new Scanner(file);
					StringBuilder sbr = new StringBuilder();
					while(scanner.hasNextLine()){
						sbr.append(scanner.nextLine()).append("\n");
					}
					gui.getWorkspcae().setText(sbr.toString());
				} catch (FileNotFoundException e1) {
					// ignore file should exist
				}
			});
		}

	}
}
