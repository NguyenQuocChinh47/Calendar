package com.example.calendar;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    TextView txtCalendar, txtThongBao;
    EditText edtCalendar, edtCalendar1;
    Button btnThongBao;
    Calendar calendar, calendar1;
    //java.util
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtCalendar = findViewById(R.id.txt_Calendar);
        txtThongBao = findViewById(R.id.txt_ThongBao);
        edtCalendar = findViewById(R.id.edt_Calendar);
        edtCalendar1 = findViewById(R.id.edt_Calendar1);
        btnThongBao = findViewById(R.id.btn_BatDau);
        currentTime();
        batSuKien();
        batSuKien1();
        btnThongBao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edtCalendar.getText().toString().isEmpty() == false && edtCalendar1.getText().toString().isEmpty() == false){
                int number = (int) ((calendar1.getTimeInMillis() - calendar.getTimeInMillis()) / (1000*60*60*24));
                    if(number>=0) {
                    txtThongBao.setText("Khoảng cách 2 thời gian là: " + number);
                    }
                    else {
                        txtThongBao.setText("Thời gian kết thúc phải sau thời gian bắt đầu");
                        }
                }
                else {
                    txtThongBao.setText("Bạn chưa chọn ngày");
                }
            }
        });

    }

    private void batSuKien1() {
        edtCalendar1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chooseDate1();
            }
        });
    }

    private void batSuKien() {
        edtCalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chooseDate();
            }
        });
    }

    private void chooseDate() {
        calendar = Calendar.getInstance();
        //year
        int year = calendar.get(Calendar.YEAR);
        //month
        int month = calendar.get(Calendar.MONTH);
        //day
        int day = calendar.get(Calendar.DATE);
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendar.set(year,month,dayOfMonth);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyy");
                edtCalendar.setText(simpleDateFormat.format(calendar.getTime()));
            }
        },year,month,day);
        datePickerDialog.show();
    }

    private void chooseDate1() {
        calendar1 = Calendar.getInstance();
        //year
        int year = calendar1.get(Calendar.YEAR);
        //month
        int month = calendar1.get(Calendar.MONTH);
        //day
        int day = calendar1.get(Calendar.DATE);
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendar1.set(year,month,dayOfMonth);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyy");
                edtCalendar1.setText(simpleDateFormat.format(calendar1.getTime()));
            }
        },year,month,day);
        datePickerDialog.show();
    }

    private void currentTime() {
        Calendar calendar = Calendar.getInstance();
        // https://developer.android.com/reference/java/text/SimpleDateFormat
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("hh:mm:ss");
        txtCalendar.append("Thời gian hôm nay: "+simpleDateFormat1.format(calendar.getTime()) + "\n");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        txtCalendar.append(simpleDateFormat.format(calendar.getTime())+ "\n");
//        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("DD");
//        txtCalendar.append(simpleDateFormat2.format(calendar.getTime())+ "\n");
    }
}