package com.example.buttonclick1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Console;

public class MainActivity extends AppCompatActivity {


    //в первом случае мы получаем нажатие кнопки как раньше
    //во втором случае мы получаем нажжатие через встроенную ф-я кнопки указав её в xml


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //получаем сообщение и кнопку
        TextView text1=findViewById(R.id.textInput1);
        Button button1=findViewById(R.id.button1);

        //обрабатываем нажатие кнопки
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                showToast(text1.getText().toString());

            }
        });

        }


    public void button2Click(View v){
        TextView text2=findViewById(R.id.textInput2);
        //мы как бы приводим обьект v к классу button


        showToast( ((Button)v).getText().toString() +" "+text2.getText().toString());
    }


    private void showToast(String text){
        //Toast небольшое уведомление снизу
        Toast.makeText(this, text, Toast.LENGTH_LONG).show();

        }


    public void buttonExitClick(View v){

        //для создания большого уведомления мы сперва используем сборщик уведомления

        AlertDialog.Builder builder =new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Большая подсказка")
                .setMessage("Вы хотите выйти из приложения?")
                .setCancelable(false)
                .setPositiveButton("Конечно", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish(); //закрываем приложение
                    }
                })
                .setNegativeButton("Нет", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel(); //отменяем это окно
                    }
                });

            //создаём диалоговое окно и даём ему все параметы
            AlertDialog dialog=builder.create();
            dialog.show();//показываем окно

    }




}