package com.josiahebhomenye.cryptoText.view.handler;

import com.josiahebhomenye.cryptoText.view.GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;

import java.io.*;

/**
 * Created by jay on 09/12/15.
 */
public class OpenFileHandler extends Handler {

	final IOHandlerSelector ioHandlers;

	public OpenFileHandler(GUI gui) {
		super(gui);
		this.ioHandlers = new IOHandlerSelector(gui);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JFileChooser chooser = new JFileChooser();
		int returnValue = chooser.showOpenDialog(gui);

		if(returnValue == JFileChooser.APPROVE_OPTION){

			final File file = chooser.getSelectedFile();
			IOHandler fileHandler = ioHandlers.forFile(new File(file.getAbsolutePath()));
			fileHandler.loadFile();
		}

	}
}
