package com.todoapp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ToDoApp {
    public static void main(String[] args) {
        JFrame frame = new JFrame("To-Do List");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JTextField taskField = new JTextField();
        JButton addButton = new JButton("Add Task");
        JButton deleteButton = new JButton("Delete Task");
        JButton clearButton = new JButton("Clear List");

        DefaultListModel<CheckBoxListItem> listModel = new DefaultListModel<>();
        JList<CheckBoxListItem> taskList = new JList<>(listModel);
        taskList.setCellRenderer(new CheckBoxListRenderer());

        taskList.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int index = taskList.locationToIndex(e.getPoint());
                CheckBoxListItem item = listModel.getElementAt(index);
                item.setSelected(!item.isSelected());
                taskList.repaint(taskList.getCellBounds(index, index));
            }
        });

        taskField.addActionListener(e -> {
            String task = taskField.getText();
            if (!task.isEmpty()) {
                listModel.addElement(new CheckBoxListItem(task));
                taskField.setText("");
            }
        });


        panel.add(taskField, BorderLayout.NORTH);
        panel.add(new JScrollPane(taskList), BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(clearButton);

        panel.add(buttonPanel, BorderLayout.SOUTH);

        addButton.addActionListener(e -> {
            String task = taskField.getText();
            if (!task.isEmpty()) {
                listModel.addElement(new CheckBoxListItem(task));
                taskField.setText("");
            }
        });

        deleteButton.addActionListener(e -> {
            int selectedIndex = taskList.getSelectedIndex();
            if (selectedIndex != -1) {
                listModel.remove(selectedIndex);
            }
        });

        clearButton.addActionListener(e -> {
            listModel.clear();
        });


        frame.add(panel);
        frame.setVisible(true);
    }
}

