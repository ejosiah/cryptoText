package com.josiahebhomenye.cryptoText.view.handler;

import com.josiahebhomenye.cryptoText.view.GUI;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by Josiah on 12/12/2015.
 */
public class TextFileHandler extends IOHandler {


    public TextFileHandler(GUI gui, File file) {
        super(gui, file);
    }

    @Override
    void loadFile() {
        gui.runInBackground(() -> {
            try {
                Scanner scanner = new Scanner(file);
                final StringBuilder sbr = new StringBuilder();
                while(scanner.hasNextLine()){
                    sbr.append(scanner.nextLine()).append("\n");
                }
                gui.invokeLater(() -> { gui.getWorkspcae().setText(sbr.toString()); });
            } catch (FileNotFoundException e1) {
                // ignore file should exist
            }
        });
    }
}
