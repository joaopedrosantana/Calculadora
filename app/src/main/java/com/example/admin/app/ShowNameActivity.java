package com.example.admin.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by admin on 01/08/2017.
 */

public class ShowNameActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showname);

        String txtMain = getIntent().getStringExtra("txtMain");
        TextView name = (TextView) findViewById(R.id.txtshow);

        name.setText("Olá " + txtMain);


        Button backMain = (Button) findViewById(R.id.back_main);

        backMain.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(ShowNameActivity.this, MainActivity.class);
                startActivity(intent1);
                finish();
            }
    });
}
}


