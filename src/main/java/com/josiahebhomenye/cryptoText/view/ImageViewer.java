package com.josiahebhomenye.cryptoText.view;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by Josiah on 12/12/2015.
 */
public class ImageViewer extends JComponent {

    final BufferedImage image;

    public ImageViewer(BufferedImage image){
        this.image = image;
    }

    public BufferedImage getImage(){
        return image;
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D)g.create();
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
        g2d.drawImage(image, 0, 0, getWidth(), getHeight(), null);
    }
}
