/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cesar.utils;

import java.awt.Dimension;
import java.awt.Toolkit;

/**
 *
 * @author cesar
 */
public class SwingUtils {

    /**
     * Recebe dois paineis por parametro e substitui os conteudos do painelBase
     * pelo conteudo do painelConteudo
     *
     * @param painelBase
     * @param painelConteudo
     * @author Cesar
     * @since Java 1.8
     */
    public static void trocarMenu(javax.swing.JPanel painelBase, javax.swing.JPanel painelConteudo) {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension scrsize = toolkit.getScreenSize();
        painelBase.setVisible(false);
        painelBase.removeAll();
        int width = (int) scrsize.getWidth();
        int heigh = (int) scrsize.getHeight();

        painelBase.add(painelConteudo);
        painelConteudo.setSize(painelBase.getSize());
        painelBase.setVisible(true);
    }

    public static void addInternalFrame(javax.swing.JDesktopPane desktopBase, javax.swing.JInternalFrame frameConteudo) {

        desktopBase.add(frameConteudo);
        Dimension desktopSize = desktopBase.getSize();
        Dimension jInternalFrameSize = frameConteudo.getSize();
        frameConteudo.setLocation((desktopSize.width - jInternalFrameSize.width) / 2,
                (desktopSize.height - jInternalFrameSize.height) / 2);
//        desktopBase.add(frameConteudo);
        frameConteudo.moveToFront();
        frameConteudo.setVisible(true);
    }

}
