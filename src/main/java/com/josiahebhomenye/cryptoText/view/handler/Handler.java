package com.josiahebhomenye.cryptoText.view.handler;

import com.josiahebhomenye.cryptoText.view.GUI;

import java.awt.event.ActionListener;

/**
 * Created by jay on 09/12/15.
 */
public abstract class Handler implements ActionListener{
	protected final GUI gui;

	public Handler(GUI gui){
		this.gui = gui;
	}
}
