package com.example.assignment3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;

import android.os.Bundle;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.GridLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        GridLayout calculatorLayout = new GridLayout(this);

        ArrayList<calculatorButtonData> buttonData = new ArrayList<>();
        String buttonColor = "BLACK";
        buttonData.add(new calculatorButtonData("0", 4, 2, 1, calculatorButtonData.ButtonType.NUMBER, buttonColor));
        buttonData.add(new calculatorButtonData("1", 3, 1, 1, calculatorButtonData.ButtonType.NUMBER, buttonColor));
        buttonData.add(new calculatorButtonData("2", 3, 2, 1, calculatorButtonData.ButtonType.NUMBER, buttonColor));
        buttonData.add(new calculatorButtonData("3", 3, 3, 1, calculatorButtonData.ButtonType.NUMBER, buttonColor));
        buttonData.add(new calculatorButtonData("4", 2, 1, 1, calculatorButtonData.ButtonType.NUMBER, buttonColor));
        buttonData.add(new calculatorButtonData("5", 2, 2, 1, calculatorButtonData.ButtonType.NUMBER, buttonColor));
        buttonData.add(new calculatorButtonData("6", 2, 3, 1, calculatorButtonData.ButtonType.NUMBER, buttonColor));
        buttonData.add(new calculatorButtonData("7", 1, 1, 1, calculatorButtonData.ButtonType.NUMBER, buttonColor));
        buttonData.add(new calculatorButtonData("8", 1, 2, 1, calculatorButtonData.ButtonType.NUMBER, buttonColor));
        buttonData.add(new calculatorButtonData("9", 1, 3, 1, calculatorButtonData.ButtonType.NUMBER, buttonColor));
        buttonData.add(new calculatorButtonData("<-", 4, 1, 1, calculatorButtonData.ButtonType.BACKSPACE, buttonColor));
        buttonData.add(new calculatorButtonData(".", 4, 3, 1, calculatorButtonData.ButtonType.DECIMAL, buttonColor));
        buttonData.add(new calculatorButtonData("/", 1, 4, 1, calculatorButtonData.ButtonType.OPERATOR, buttonColor));
        buttonData.add(new calculatorButtonData("*", 2, 4, 1, calculatorButtonData.ButtonType.OPERATOR, buttonColor));
        buttonData.add(new calculatorButtonData("+", 3, 4, 1, calculatorButtonData.ButtonType.OPERATOR, buttonColor));
        buttonData.add(new calculatorButtonData("-", 4, 4, 1, calculatorButtonData.ButtonType.OPERATOR, buttonColor));
        buttonData.add(new calculatorButtonData("=", 5, 4, 1, calculatorButtonData.ButtonType.OPERATOR, buttonColor));
        buttonData.add(new calculatorButtonData("Clear", 5, 1, 2, calculatorButtonData.ButtonType.CLEAR, buttonColor));
        buttonData.add(new calculatorButtonData("Dump", 5, 3, 1, calculatorButtonData.ButtonType.DUMP, buttonColor));

        AppCompatTextView buttonDisplay = new AppCompatTextView(this);
        GridLayout.LayoutParams buttonParams = new GridLayout.LayoutParams();
        buttonParams.rowSpec = GridLayout.spec(0, 1.0f);
        buttonParams.columnSpec = GridLayout.spec(0, 4, 1.0f);
        buttonDisplay.setTextSize(32);
        buttonDisplay.setGravity(Gravity.CENTER);
        buttonDisplay.setLayoutParams(buttonParams);
        calculatorLayout.addView(buttonDisplay);

        setContentView(calculatorLayout);

        buttonData.forEach(data -> {
            AppCompatButton button = new AppCompatButton(this);
            button.setTextSize(24);
            button.setText(data.text);
            GridLayout.LayoutParams params = new GridLayout.LayoutParams();
            params.rowSpec = GridLayout.spec(data.row, 1.0f);
            params.columnSpec = GridLayout.spec(data.col, data.colSpan, 1.0f);
            button.setLayoutParams(params);

            calculatorLayout.addView(button);

        });


    }
}