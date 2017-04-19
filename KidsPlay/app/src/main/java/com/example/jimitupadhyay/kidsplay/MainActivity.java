package com.example.jimitupadhyay.kidsplay;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button Left;
    Button Right;
    Button Up;
    Button Down;
    Button save;
    Button clear;
    Button load;
    EditText editText;
    Editable editable;

    DatabaseHelper databaseHelper = new DatabaseHelper(this);




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Left = (Button) findViewById(R.id.button_left);
        Right = (Button) findViewById(R.id.button_right);
        Up = (Button) findViewById(R.id.button_up);
        Down = (Button) findViewById(R.id.button_down);

        save = (Button) findViewById(R.id.button_save);

        clear = (Button) findViewById(R.id.button_clear);

        load = (Button) findViewById(R.id.button_load);

        editText = (EditText) findViewById(R.id.editText);





        Right.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                editable = editText.getText();
                editText.setText(editable + "-");

            }
        });

        Left.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                editable = editText.getText();
                editText.setText(editable + "-");

            }
        });

        Up.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {


                editable = editText.getText();
                editText.setText(editable + "|");

            }
        });

        Down.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                editable = editText.getText();
                editText.setText(editable +"|");

            }
        });
        clear.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        editable = editText.getText();
                        editText.setText("");
                    }
                }
        );
        save.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Points points = new Points();
                        points.setName( editText.getText().toString());
                        databaseHelper.dbinsert(points);

                        databaseHelper.close();
                    }
                }
        );
        load.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {


                        List<Points> points = databaseHelper.searchStudents();
                        editable = editText.getText();
                        editText.setText(points.get(points.size() - 1).getName().toString());
                        //students.get(0).getName().toString();
                        databaseHelper.close();
                    }
                }
        );
    }
}