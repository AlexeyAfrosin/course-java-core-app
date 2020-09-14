package com.a.afrosin.course.java.core.app;

import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame {

    static final int WINDOW_WIDTH = 505;
    static final int WINDOW_HEIGHT = 555;
    static int WINDOW_X;
    static int WINDOW_Y;

    private BattleField battleField;
    private SettingWindow settingWindow;

    public GameWindow() {

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        WINDOW_X = (screenSize.width - WINDOW_WIDTH) / 2;
        WINDOW_Y = (screenSize.height - WINDOW_HEIGHT) / 2;

        setLocation(WINDOW_X, WINDOW_Y);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(WINDOW_X, WINDOW_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("TicTacToe");

        battleField = new BattleField(this);
        add(battleField, BorderLayout.CENTER);

        settingWindow = new SettingWindow(this);

        JPanel jPanel = new JPanel(new GridLayout(1, 2));
        JButton buttonNewGame = new JButton("Start new game");
        JButton buttonExit = new JButton("Exit");

        jPanel.add(buttonNewGame);
        jPanel.add(buttonExit);
        add(jPanel, BorderLayout.SOUTH);

        buttonNewGame.addActionListener(e -> {
            settingWindow.setVisible(true);
        });

        buttonExit.addActionListener(e -> {
            System.exit(0);
        });


        setVisible(true);
    }

    public void startNewGame(int mode, int fieldSize, int winningLength) {
        battleField.startNewGame(mode, fieldSize, winningLength);
    }
}
