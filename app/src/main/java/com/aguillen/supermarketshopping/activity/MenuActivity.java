package com.aguillen.supermarketshopping.activity;

import androidx.appcompat.app.AppCompatActivity;

import com.aguillen.supermarketshopping.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {

    private Button btArticles;
    private Button btGenerateList;
    private Button btExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        btArticles = (Button) findViewById(R.id.bt_articles);
        btGenerateList = (Button) findViewById(R.id.bt_generate_list);
        btExit = (Button) findViewById(R.id.bt_exit);

        btArticles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MenuActivity.this, ArticlesActivity.class);
                finish();
                startActivity(i);
            }
        });

        btGenerateList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}
