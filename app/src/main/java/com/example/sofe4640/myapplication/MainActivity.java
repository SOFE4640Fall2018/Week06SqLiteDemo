package com.example.sofe4640.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText userInputs ;
    EditText  buckesText;
    MySQLiteHelper mySQLiteHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mySQLiteHelper = new MySQLiteHelper(this,null,null,1);

        displayDatabase();
    }


    //list all of teh current rows in the database
    private void displayDatabase(){

        String allRecords = mySQLiteHelper.databaseToString();
        buckesText = (EditText) findViewById(R.id.buckesText);
        buckesText.setText(allRecords);

    }

    public void deleteButtonClicked(View v){
        userInputs = (EditText) findViewById(R.id.userInputs);
        mySQLiteHelper.deleteRecord(userInputs.getText().toString().toLowerCase());
        displayDatabase();
        userInputs.setText("");
    }

    public void addButtonClicked(View v){
        userInputs = (EditText) findViewById(R.id.userInputs);
        Products product = new Products(userInputs.getText().toString(),10);
        mySQLiteHelper.addRecord(product);
        displayDatabase();
        userInputs.setText("");
    }


}
