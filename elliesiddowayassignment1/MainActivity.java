package com.elliesiddowayassignment1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextView;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        LinearLayout mainLayout = new LinearLayout(this);
        mainLayout.setOrientation(LinearLayout.VERTICAL);

        AppCompatEditText[] words = new AppCompatEditText[5];
        AppCompatTextView[] wordType = new AppCompatTextView[5];

        for(int i=0; i<5; i++){
            words[i] = new AppCompatEditText(this);
            words[i].setLines(2);
            words[i].setGravity(Gravity.START);

            wordType[i] = new AppCompatTextView(this);
            System.out.println(i);
        }

        wordType[0].setText("Group/team name");
        wordType[1].setText("Plural Noun");
        wordType[2].setText("Planet name");
        wordType[3].setText("Noun");
        wordType[4].setText("City name");

        for(int j=0; j<5; j++){
            mainLayout.addView(wordType[j]);
            mainLayout.addView(words[j]);
        }

        AppCompatButton button = new AppCompatButton(this);
        button.setText("Generate Mad Lib");

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String[] text = new String[5];
                for(int k=0; k<5; k++){
                    text[k] = words[k].getText().toString();
                }
                AppCompatTextView story = new AppCompatTextView(MainActivity.this);

                String fullStory = "There was once a group of superheroes named the " + text[0] + ". " +
                        "They had to fight off the evil " + text[1] + " to save their city. The " +
                        text[1] + " came from the planet " + text[2] + ". In order to defeat their" +
                        " enemy, the " + text[1] + ", the " + text[0] + " needed the " + text[3] +
                        ". Eventually," + " they found the " + text[3] + " and saved the city of " + text[4] + ".";

                story.setText(fullStory);
                setContentView(story);
            }
        });

        mainLayout.addView(button);

        setContentView(mainLayout);



    }

}

/*
Mad lib story
There was a group of superheroes named ____0____. They had to fight off the evil ____1____.
The ____1____ came from the planet ___2___. In order to defeat their enemy, the ___1___, they needed the
___3___. Eventually, they found the ___3___ and saved the city of ___4___.

Words required:
0. Group/team name
1. Plural noun
2. Planet name
3. Noun
4. City name

 */