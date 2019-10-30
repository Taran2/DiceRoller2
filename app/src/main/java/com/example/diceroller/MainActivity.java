package com.example.diceroller;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;



import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.Random;



import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity<Question> extends AppCompatActivity {

    private Button validate;
    private Object numbertofind;
    private int counter = 0;
    private TextView TN;
    private EditText Input_Num;
    private TextView G;
    int number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button nextPage = (Button) findViewById(R.id.button4);
        nextPage.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent intent = new Intent (MainActivity.this, second_Screen.class);
                startActivity(intent);

            }

        });{

        }

        G = findViewById(R.id.msg);
        TN = findViewById(R.id.cview);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public int random_num_gen(){
        Random r = new Random();
        number = r.nextInt(6);
        return number;
    }

    public void on_button_click(View view) {
        Input_Num = findViewById(R.id.numberEntered);
        TextView tv = this.findViewById(R.id.textView);

        random_num_gen(); //calls method for generating random num

        tv.setText(Integer.toString(number));

        int n = Integer.parseInt(Input_Num.getText().toString());

        if (n < 1 || n > 6) {
            Toast.makeText(this, "Invalid Input", Toast.LENGTH_SHORT).show();
        } else if (n == number) {

            //Forgot to call .show() to display the toast
            Toast.makeText(this, "Congratulations", Toast.LENGTH_SHORT).show();

            counter = counter + 1;
            //The R.id of the view was not the same in the XML, I've changed the XML id to counterView
            TextView a = findViewById(R.id.counterView);
            a.setText(Integer.toString(counter));
        }
    }

    public void d_icebreaker(View view) {
        TextView F = this.findViewById(R.id.textView);

        ArrayList<String> Questions = new ArrayList<String>(); //create new array that stores 6 sentences

        Questions.add("If you could go anywhere in the world, where would you go?");
        Questions.add("If you were stranded on a desert island, what three things would you want to take with you?");
        Questions.add("If you could eat only one food for the rest of your life, what would that be?");
        Questions.add("If you won a million dollars, what is the first thing you would buy?");
        Questions.add("If you could spaned the day with one fictional character, who would it be?");
        Questions.add("If you found a magic lantern and a genie gave you three wishes, what would you wish?");

        F.setText(Questions.get(random_num_gen()));

    }
}












