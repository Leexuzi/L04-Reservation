package sg.edu.rp.c346.id22027176.l04_reservation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    Button btnBook;
    Button btnReset;
    TextView name;
    TextView number;
    TextView size;
    TextView allInfo;
    CheckBox smoke;
    DatePicker dp;
    TimePicker tp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnBook = findViewById(R.id.btnBook);
        btnReset = findViewById(R.id.btnReset);
        name = findViewById(R.id.name);
        number = findViewById(R.id.number);
        size = findViewById(R.id.size);
        allInfo = findViewById(R.id.allInfo);
        smoke = findViewById(R.id.smoke);
        dp = findViewById(R.id.slctDate);
        tp = findViewById(R.id.slctTime);
        tp.setIs24HourView(true);

        final String[] dateTime = {""}; //i dont understand, but ill just use this anyway
        final String[] date = {""};
        final String[] time = {""};
        btnBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                date[0] = dp.getDayOfMonth()+"/"+dp.getMonth()+"/"+dp.getYear();
                time[0] = tp.getHour()+" : "+tp.getMinute();
                dateTime[0] = "Reserved "+date[0]+", "+time[0];

                Context context = getApplicationContext();
                Toast.makeText(context, dateTime[0], Toast.LENGTH_SHORT).show();

                String[] smoking = {""};
                if(smoke.isChecked()){
                    smoking[0] = "Sitting in smoking area";
                }
                else{
                    smoking[0] = "Sitting in non-smoking area";
                }
                String phName=name.getText().toString();
                String phNumber=number.getText().toString();
                String phSize=size.getText().toString();
                String info = "Name: "+phName+"\nMobile: "+phNumber+"\nGroup size: "+phSize+"\n"+smoking[0]+"\nReservation on: "+date[0]+"\nAt: "+time[0];
                allInfo.setText(info);
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dp.updateDate(2023, 6, 1);
                tp.setHour(19);
                tp.setMinute(30);
                name.setText("");
                number.setText("");
                size.setText("");
                smoke.setChecked(false);
            }
        });

    }
}