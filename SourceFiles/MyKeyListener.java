package SourceFiles;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;
public class MyKeyListener extends JFrame implements KeyListener {

    private boolean leftPressed = false;
    private boolean rightPressed = false;
    private boolean upPressed = false;
    private boolean downPressed = false;
    private boolean tPressed = false;
    private boolean pPressed = false;
    private boolean sPressed = false;
    private boolean lPressed = false;
    private boolean spawnPressed = false;
    private boolean escPressed = false;

    public MyKeyListener(JFrame frame) {
        frame.setFocusable(true);
        frame.requestFocusInWindow();
        frame.addKeyListener(this);
        Component[] components = frame.getContentPane().getComponents();
        for (Component component : components) {
            if (component instanceof JPanel) {
                Component[] buttons = ((JPanel) component).getComponents();
                for (Component button : buttons) {
                    if (button instanceof JButton jButton) {
                        jButton.addActionListener(e -> {
                            switch (jButton.getText()) {
                                case "Next Round" -> tPressed = true;
                                case "Save" -> sPressed = true;
                                case "Load" -> lPressed = true;
                                case "Spawn Organism" -> spawnPressed = true;
                                case "Use Super Power" -> pPressed = true;
                            }
                        });
                    }
                }
            }
        }

        waitForAnyKey();
    }

    private void waitForAnyKey() {
        boolean keyPressed = false;
        while (!keyPressed) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (leftPressed || rightPressed || upPressed || downPressed ||
                    tPressed || pPressed || sPressed || lPressed || escPressed || spawnPressed) {
                keyPressed = true;
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        switch (keyCode) {
            case KeyEvent.VK_LEFT -> leftPressed = true;
            case KeyEvent.VK_RIGHT -> rightPressed = true;
            case KeyEvent.VK_UP -> upPressed = true;
            case KeyEvent.VK_DOWN -> downPressed = true;
            case KeyEvent.VK_ESCAPE -> escPressed = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        switch (keyCode) {
            case KeyEvent.VK_LEFT -> leftPressed = false;
            case KeyEvent.VK_RIGHT -> rightPressed = false;
            case KeyEvent.VK_UP -> upPressed = false;
            case KeyEvent.VK_DOWN -> downPressed = false;
            case KeyEvent.VK_ESCAPE -> escPressed = false;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    public boolean isLeftPressed() {
        return leftPressed;
    }

    public boolean isRightPressed() {
        return rightPressed;
    }

    public boolean isUpPressed() {
        return upPressed;
    }

    public boolean isDownPressed() {
        return downPressed;
    }

    public boolean isTPressed() {
        return tPressed;
    }

    public boolean isPPressed() {
        return pPressed;
    }

    public boolean isSPressed() {
        return sPressed;
    }

    public boolean isLPressed() {
        return lPressed;
    }

    public boolean isSpawnPressed() {
        return spawnPressed;
    }

    public boolean isEscPressed() {
        return escPressed;
    }

}
