package com.zhanganzhi.checkin.tools;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class StudentsManager {
    String studentsFilePath = "students.txt";
    HashMap<String, Boolean> studentsMap;

    public StudentsManager() {
        File studentsFile = new File(studentsFilePath);

        // Initial file
        try {
            studentsFile.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Read data
        studentsMap = new HashMap<>();
        for (Object name : readStudentsFile()) {
            studentsMap.put((String) name, false);
        }
    }

    /**
     * Read the student list from the file.
     *
     * @return An {@code Object} array of names
     */
    private Object[] readStudentsFile() {
        Object[] list = new Object[0];
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(studentsFilePath));
            list = bufferedReader.lines().toArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * Get an array of student names.
     *
     * @return A {@code String} Array of names
     */
    public String[] getStudentsArray() {
        return studentsMap.keySet().toArray(new String[0]);
    }

    /**
     * Get status of a student.
     *
     * @param name Name of student, it should be in the list
     * @return Status
     */
    public boolean getStudentStatus(String name) {
        if (studentsMap.containsKey(name)) {
            return studentsMap.get(name);
        }
        return false;
    }

    /**
     * Set status of a student.
     *
     * @param name   Name of student, it should be in the list
     * @param status Status wil be set to the student
     */
    public void setStudentStatus(String name, boolean status) {
        if (studentsMap.containsKey(name)) {
            studentsMap.put(name, status);
        }
    }
}
