package com.example.jurairat.playme;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by jurairat on 27/01/2016.
 */
public class taskOne extends Activity {
    private static final int REQUEST_CODE = 10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.task_one);


    }
    public void onClick(View view) {
        EditText name = (EditText) findViewById(R.id.inputforname);
        EditText phone = (EditText) findViewById(R.id.inputforphone);
        String stringName = name.getText().toString();
        String stringPhone = phone.getText().toString();
        Intent i = new Intent(this, ResultActivity.class);
        i.putExtra("yourname", stringName);
        i.putExtra("yourphone",stringPhone);
        startActivityForResult(i, REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK && requestCode == REQUEST_CODE) {
            if (data.hasExtra("returnkey")) {
                String result = data.getExtras().getString("returnkey");
                if (result != null && result.length() > 0) {
                    Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
}
