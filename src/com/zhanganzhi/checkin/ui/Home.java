package com.zhanganzhi.checkin.ui;

import com.zhanganzhi.checkin.tools.PasswordManager;
import com.zhanganzhi.checkin.tools.StudentsManager;
import com.zhanganzhi.checkin.ui.panel.ButtonJPanel;
import com.zhanganzhi.checkin.ui.panel.StudentsJPanel;

import javax.swing.*;
import java.awt.*;

public class Home extends JFrame {
    PasswordManager passwordManager;
    StudentsManager studentsManager;
    ButtonJPanel buttonJPanel;
    StudentsJPanel studentsJPanel;

    /**
     * The Home of UI.
     *
     * @param passwordManager A {@code PasswordManager} object
     * @param studentsManager A {@code StudentsManager} object
     * @see PasswordManager
     * @see StudentsManager
     */
    public Home(PasswordManager passwordManager, StudentsManager studentsManager) {
        this.passwordManager = passwordManager;
        this.studentsManager = studentsManager;
        setBounds(
                ((Toolkit.getDefaultToolkit().getScreenSize().width) / 2) - 360,
                ((Toolkit.getDefaultToolkit().getScreenSize().height) / 2) - 240,
                720, 480
        );
        setResizable(false);
        setTitle("签到系统");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Setup GridBagLayout
        setLayout(new GridBagLayout());
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1;

        // Button JPanel
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weighty = 0.03;
        buttonJPanel = new ButtonJPanel(this);
        add(buttonJPanel, gridBagConstraints);

        // Students JPanel
        gridBagConstraints.gridy = 1;
        gridBagConstraints.weighty = 0.97;
        studentsJPanel = new StudentsJPanel(this);
        add(studentsJPanel, gridBagConstraints);

        setVisible(true);
    }

    /**
     * Get {@code PasswordManager} of this system.
     *
     * @return The {@code PasswordManager} object
     * @see PasswordManager
     */
    public PasswordManager getPasswordManager() {
        return passwordManager;
    }

    /**
     * Get {@code StudentsManager} of this system.
     *
     * @return The {@code StudentsManager} object
     * @see StudentsManager
     */
    public StudentsManager getStudentsManager() {
        return studentsManager;
    }

    /**
     * Get {@code ButtonJPanel} in this frame.
     *
     * @return The {@code ButtonJPanel} object
     * @see ButtonJPanel
     */
    public ButtonJPanel getButtonJPanel() {
        return buttonJPanel;
    }

    /**
     * Get {@code StudentsJPanel} in this frame.
     *
     * @return The {@code StudentsJPanel} object
     * @see StudentsJPanel
     */
    public StudentsJPanel getStudentsJPanel() {
        return studentsJPanel;
    }
}
