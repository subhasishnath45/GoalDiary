package com.subhasishlive.goaldiary;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class Activitymain extends AppCompatActivity {

    Toolbar mToolbar;
    Button mBtnAdd;
    private View.OnClickListener mBtnAddListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Toast.makeText(Activitymain.this, "Button was clicked", Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mBtnAdd = (Button) findViewById(R.id.btn_add);
        mBtnAdd.setOnClickListener(mBtnAddListener);
        setSupportActionBar(mToolbar);
        initBackgroundImage();
    }

    private void initBackgroundImage() {
        ImageView background = (ImageView) findViewById(R.id.iv_background);
        Glide.with(this).load(R.drawable.background_app).into(background);
    }

    public void showDialog(View view) {
        
    }


}

