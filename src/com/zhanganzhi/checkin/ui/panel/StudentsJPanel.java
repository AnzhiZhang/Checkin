package com.zhanganzhi.checkin.ui.panel;

import com.zhanganzhi.checkin.ui.Home;

import javax.swing.*;
import java.awt.*;

public class StudentsJPanel extends JPanel {
    Home home;

    /**
     * Panel of Students.
     *
     * @param home The {@code Home}
     * @see Home
     */
    public StudentsJPanel(Home home) {
        this.home = home;
        setPreferredSize(new Dimension(680, 430));
        initialize();
    }

    /**
     * Initialize student buttons.
     */
    public void initialize() {
        removeAll();
        repaint();
        for (String name : home.getStudentsManager().getStudentsArray()) {
            var button = new JButton(name);
            button.setForeground(Color.RED);
            button.addActionListener(e -> {
                home.getStudentsManager().setStudentStatus(name, true);
                button.setForeground(Color.BLACK);
                button.setBackground(Color.GREEN);
            });
            add(button);
        }
        revalidate();
    }
}
