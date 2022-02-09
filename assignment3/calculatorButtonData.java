package com.example.assignment3;

public class calculatorButtonData {

    public static enum ButtonType {
        NUMBER, DECIMAL, OPERATOR, BACKSPACE, CLEAR, DUMP
    }

    final public String text;
    final public int row;
    final public int col;
    final public int colSpan;
    final public ButtonType type;
    final public String color;

    public calculatorButtonData(String text, int row, int col, int colSpan, ButtonType type, String color) {
        this.text = text;
        this.row = row;
        this.col = col;
        this.colSpan = colSpan;
        this.type = type;
        this.color = color;
    }
}
