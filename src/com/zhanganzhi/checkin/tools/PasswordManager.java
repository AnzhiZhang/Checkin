package com.zhanganzhi.checkin.tools;

import java.io.*;

public class PasswordManager {
    String passwordFilePath = "password.txt";
    String password;

    public PasswordManager() {
        File passwordFile = new File(passwordFilePath);

        // Initial file or read.
        if (!passwordFile.exists()) {
            try {
                if (passwordFile.createNewFile()) {
                    savePassword("admin");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            password = readPassword();
        }
    }

    /**
     * Read the password from the file.
     *
     * @return Password in the file
     */
    private String readPassword() {
        String pwd = "";
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(passwordFilePath));
            pwd = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return pwd;
    }

    /**
     * Save the password in to the file.
     *
     * @param newPassword New password
     */
    private void savePassword(String newPassword) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(passwordFilePath));
            bufferedWriter.write(newPassword);
            bufferedWriter.close();
            password = newPassword;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Get current password.
     *
     * @return A string of password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set a new password and save it.
     *
     * @param newPassword New password
     */
    public void setPassword(String newPassword) {
        savePassword(newPassword);
    }
}
