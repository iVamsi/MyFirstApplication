package com.vamsi.myfirstapplication;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button button;
    Button dialog;
    ListView listView;

    String[] countries = {"India", "South Korea", "France", "Germany", "Austria", "Poland"};
    ArrayAdapter<String> adapter;

    int counter=0;

    public static final String TAG = "VAMC";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "Inside onCreate()");

        button = (Button) findViewById(R.id.button);
        dialog = (Button) findViewById(R.id.dialog);
        listView = (ListView) findViewById(R.id.listView);

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, countries);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "Clicked on " + listView.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void openAnotherActivity(View v) {
        Intent intent = new Intent(MainActivity.this, ActivityB.class);
        intent.putExtra("int_value", "Got from Activity A");
        Toast.makeText(MainActivity.this, "Started Activity B", Toast.LENGTH_SHORT).show();
        startActivity(intent);
    }

    public void onShowDialog(View v) {
        Intent intent = new Intent(MainActivity.this, DialogActivity.class);
        startActivity(intent);
    }

    public void onButtonClick(View v) {

        Intent i = new Intent();
        i.setAction("com.vamsi.hello");
        sendBroadcast(i);

    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);

        outState.putInt("counter", counter);
        Log.d(TAG, counter + " value is saved.");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        counter = savedInstanceState.getInt("counter");
        Log.d(TAG, counter + " value is restored.");
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.d(TAG, "Inside onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "Inside onResume()");
        counter++;
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "Inside onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "Inside onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "Inside onDestroy()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "Inside onRestart()");
    }

    protected void showSimpleDialog(View v) {
        AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
        alertDialog.setTitle("Hi");
        alertDialog.setMessage("Hello");
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }
}
