package com.example.elliesiddowayassignment2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout mainLayout = new LinearLayout(this);
        mainLayout.setOrientation(LinearLayout.VERTICAL);

        //Create initial screen
        LinearLayout addressBar = new LinearLayout(this);
        addressBar.setOrientation(LinearLayout.HORIZONTAL);
        AppCompatButton backButton = new AppCompatButton(this);
        backButton.setText("B");
        AppCompatButton forwardButton = new AppCompatButton(this);
        forwardButton.setText("F");
        AppCompatButton goButton = new AppCompatButton(this);
        goButton.setText("Go");
        AppCompatEditText urlTextBox = new AppCompatEditText(this);

        LinearLayout.LayoutParams buttonLayoutParams = new LinearLayout.LayoutParams(200, 200);
        buttonLayoutParams.weight = 1;
        backButton.setLayoutParams(buttonLayoutParams);
        forwardButton.setLayoutParams(buttonLayoutParams);
        goButton.setLayoutParams(buttonLayoutParams);

        LinearLayout.LayoutParams addressBarLayoutParams = new LinearLayout.LayoutParams(700, ViewGroup.LayoutParams.WRAP_CONTENT);
        addressBarLayoutParams.weight = 10;
        addressBar.setLayoutParams(addressBarLayoutParams);

        addressBar.addView(backButton);
        addressBar.addView(forwardButton);
        addressBar.addView(urlTextBox);
        addressBar.addView(goButton);

        LinearLayout.LayoutParams fullAddressBarLayoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        fullAddressBarLayoutParams.weight = 1;
        addressBar.setLayoutParams(fullAddressBarLayoutParams);
        mainLayout.addView(addressBar);

        WebView webView = new WebView(this);
        webView.setWebViewClient(new WebViewClient());
        webView.getSettings().setJavaScriptEnabled(true);
        LinearLayout.LayoutParams webViewLayoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        webViewLayoutParams.weight = 50;
        webView.setLayoutParams(webViewLayoutParams);
        mainLayout.addView(webView);
        setContentView(mainLayout);

        //Events



        History history = new History();

        goButton.setOnClickListener(view -> {
            String url = urlTextBox.getText().toString();
            webView.loadUrl(url);
            history.addToHistory(url);

        });

        backButton.setOnClickListener(view -> {
            String newUrl = history.goBack();
            webView.loadUrl(newUrl);
            urlTextBox.setText(newUrl);
        });

        forwardButton.setOnClickListener(view -> {
            String newUrl = history.goForward();
            urlTextBox.setText(newUrl);
            webView.loadUrl(newUrl);
        });

    }
}