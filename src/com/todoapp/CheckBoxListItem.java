package com.todoapp;

public class CheckBoxListItem {
    private String label;
    private boolean isSelected;

    public CheckBoxListItem(String label) {
        this.label = label;
        this.isSelected = false;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean isSelected) {
        this.isSelected = isSelected;
    }

    @Override
    public String toString() {
        return label;
    }
}
