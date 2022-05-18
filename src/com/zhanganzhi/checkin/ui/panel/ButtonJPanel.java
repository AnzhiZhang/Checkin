package com.zhanganzhi.checkin.ui.panel;

import com.zhanganzhi.checkin.ui.Home;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ButtonJPanel extends JPanel {
    Home home;

    /**
     * Panel of Buttons.
     *
     * @param home The {@code Home}
     * @see Home
     */
    public ButtonJPanel(Home home) {
        this.home = home;
        setSize(new Dimension(720, 50));

        // Statistics Button
        var statisticsJButton = new JButton("统计");
        statisticsJButton.addActionListener(e -> {
            var uncheckedStudentsList = new ArrayList<String>();
            for (String name : home.getStudentsManager().getStudentsArray()) {
                if (!home.getStudentsManager().getStudentStatus(name)) {
                    uncheckedStudentsList.add(name);
                }
            }
            var message = "<html><body><p style='width: 480px;'>未签到学生：" + String.join("，", uncheckedStudentsList) + "</p></body></html>";
            JOptionPane.showMessageDialog(this, message, "统计", JOptionPane.WARNING_MESSAGE);
        });
        add(statisticsJButton);

        // Clear Button
        var clearJButton = new JButton("清零");
        clearJButton.addActionListener(e -> {
            var password = JOptionPane.showInputDialog(this, "请输入密码", "身份验证", JOptionPane.PLAIN_MESSAGE);
            if (password == null) {
                return;
            }
            if (password.equals(home.getPasswordManager().getPassword())) {
                for (String name : home.getStudentsManager().getStudentsArray()) {
                    home.getStudentsManager().setStudentStatus(name, false);
                }
                home.getStudentsJPanel().initialize();
                JOptionPane.showMessageDialog(this, "清零成功", "清零", JOptionPane.PLAIN_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "密码错误！", "身份验证", JOptionPane.ERROR_MESSAGE);
            }
        });
        add(clearJButton);

        // Change Password Button
        var changePasswordJButton = new JButton("修改密码");
        changePasswordJButton.addActionListener(e -> {
            var password1 = JOptionPane.showInputDialog(this, "请输入新密码", "修改密码", JOptionPane.PLAIN_MESSAGE);
            if (password1 == null) {
                return;
            } else if (password1.equals("")) {
                JOptionPane.showMessageDialog(this, "密码不能为空！", "修改密码", JOptionPane.ERROR_MESSAGE);
                return;
            }
            var password2 = JOptionPane.showInputDialog(this, "请再次输入新密码", "修改密码", JOptionPane.PLAIN_MESSAGE);
            if (password2 == null) {
                return;
            }
            if (password1.equals(password2)) {
                home.getPasswordManager().setPassword(password1);
                JOptionPane.showMessageDialog(this, "密码已更新", "修改密码", JOptionPane.PLAIN_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "两次输入的密码不一致！", "修改密码", JOptionPane.ERROR_MESSAGE);
            }
        });
        add(changePasswordJButton);
    }
}
