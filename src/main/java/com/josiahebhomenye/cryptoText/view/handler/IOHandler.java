package com.josiahebhomenye.cryptoText.view.handler;

import com.josiahebhomenye.cryptoText.view.GUI;

import java.io.File;

/**
 * Created by Josiah on 12/12/2015.
 */
public abstract class IOHandler {
    protected final GUI gui;
    protected final File file;

    public IOHandler(GUI gui, File file){
        this.gui = gui;
        this.file = file;
    }

    abstract void loadFile();


}
