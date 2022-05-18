package com.zhanganzhi.checkin;

import com.zhanganzhi.checkin.tools.PasswordManager;
import com.zhanganzhi.checkin.tools.StudentsManager;
import com.zhanganzhi.checkin.ui.Home;


public class Main {
    public static void main(String[] args) {
        PasswordManager passwordManager = new PasswordManager();
        StudentsManager studentsManager = new StudentsManager();
        new Home(passwordManager, studentsManager);
    }
}
