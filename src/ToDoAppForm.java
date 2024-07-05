import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToDoAppForm {
    private JTextField textField1;
    private JButton addButton;
    private JButton deleteButton;
    private JButton clearButton;
    private JList<String> taskList;
    private JPanel mainPanel;


    private DefaultListModel<String> listModel;

    public ToDoAppForm() {
        listModel = new DefaultListModel<>();
        taskList.setModel(listModel);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String task = textField1.getText();
                if (!task.isEmpty()) {
                    listModel.addElement(task);
                    textField1.setText("");
                }
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = taskList.getSelectedIndex();
                if (selectedIndex != -1) {
                    listModel.remove(selectedIndex);
                }
            }
        });

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listModel.clear();
            }
        });
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}