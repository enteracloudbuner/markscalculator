package com.example.markscalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
private EditText editText_ninth,editText_eleven;
private TextView tv_tenthscore,tv_tenthtotal,tv_tenthperecnt,tv_tenthgrade,tv_secondscore,tv_intertotal,tv_inter_percent,tv_intergrade;
private Button btn_metric,btn_inter,btn_detail ;
private static int SPLASH_TIME = 3000; //This is 3 seconds


int ninthscore,eleventhscore;
double matricscore,matric_total,matric_percentage,interscore,inter_total,interpercentage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText_ninth = findViewById(R.id.ninthscore);
        tv_tenthscore = findViewById(R.id.tvmatric);
        tv_tenthtotal = findViewById(R.id.tvtotalmatric);
        tv_tenthperecnt = findViewById(R.id.tvpercentage);
        tv_tenthgrade = findViewById(R.id.tvgrade);
        editText_eleven=findViewById(R.id.eleventhscore);
        tv_secondscore=findViewById(R.id.tvhssc);
        tv_intertotal=findViewById(R.id.tvtotalhssc);
        tv_inter_percent=findViewById(R.id.tvpercentage1);
        tv_intergrade=findViewById(R.id.tvgrade1);
        btn_metric = findViewById(R.id.btnmatic);
        btn_inter=findViewById(R.id.bthssc);
        btn_detail=findViewById(R.id.details);
        btn_metric.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {





               if (editText_ninth.getText().toString().isEmpty()){
                   Toast.makeText(getApplicationContext(),"Please enter your 9th Marks ",Toast.LENGTH_SHORT).show();
               }
                else {
                   ninthscore= Integer.parseInt(editText_ninth.getText().toString());

                   if (ninthscore > 530) {
                       Toast.makeText(getApplicationContext(), "invalid Score (should not exceed 530) ", Toast.LENGTH_SHORT).show();

                   }

                   else {
                       matricscore = ninthscore + (0.03 * ninthscore);
                       matricscore = Math.floor(matricscore);
                       tv_tenthscore.setText("class 10th Marks = " + matricscore);
                       matric_total = ninthscore + matricscore;
                       matric_total = Math.floor(matric_total);
                       tv_tenthtotal.setText("SSC total Marks = " + matric_total);
                       matric_percentage = (matric_total / 1100) * 100;
                       matric_percentage = Math.round(matric_percentage);
                       tv_tenthperecnt.setText("Percentage = " + matric_percentage);
                       if (matric_percentage > 100) {
                           Toast.makeText(getApplicationContext(), "Not Possible", Toast.LENGTH_SHORT).show();
                       } else if (matric_percentage >= 80) {
                           tv_tenthgrade.setText("Grade = A1");
                       } else if (matric_percentage >= 70) {
                           tv_tenthgrade.setText("Grade = A");
                       } else if (matric_percentage >= 60) {
                           tv_tenthgrade.setText("Grade = B");
                       } else if (matric_percentage >= 50) {
                           tv_tenthgrade.setText("Grade = C");
                       } else if (matric_percentage >= 40) {
                           tv_tenthgrade.setText("Grade = D ");
                       } else if (matric_percentage < 40) {
                           tv_tenthgrade.setText("Grade = E");
                       }


                   }
               }



            }
        });

        btn_inter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {





                if (editText_eleven.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(),"Please enter your first year Marks ",Toast.LENGTH_SHORT).show();
                }
                else {

                    eleventhscore= Integer.parseInt(editText_eleven.getText().toString());

                if (eleventhscore>530){
                    Toast.makeText(getApplicationContext(),"invalid Score (should not exceed 530) ",Toast.LENGTH_SHORT).show();

                }
                else {
                    interscore= eleventhscore + (0.03*eleventhscore);
                    interscore=Math.floor(interscore);
                    tv_secondscore.setText("class 12th Marks = "+interscore);
                    inter_total=eleventhscore+interscore;
                    inter_total=Math.floor(inter_total);
                    tv_intertotal.setText("HSSC total Marks = "+inter_total);
                    interpercentage=(inter_total/1100)*100;
                    interpercentage=Math.round(interpercentage);
                    tv_inter_percent.setText("Percentage = "+interpercentage);
                    if ( interpercentage > 100) {
                        Toast.makeText(getApplicationContext(), "Not Possible", Toast.LENGTH_SHORT).show();
                    } else if ( interpercentage >= 80) {
                        tv_intergrade.setText("Grade = A1");
                    } else if (interpercentage >= 70) {
                        tv_intergrade.setText("Grade = A");
                    } else if ( interpercentage >= 60) {
                        tv_intergrade.setText("Grade = B");
                    } else if (interpercentage >= 50) {
                        tv_intergrade.setText("Grade = C");
                    } else if (interpercentage >= 40) {
                        tv_intergrade.setText("Grade = D ");
                    } else if (interpercentage < 40) {
                        tv_intergrade.setText("Grade = E");
                    }


                }}



            }
        });

        btn_detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,DetailActivity.class);
                startActivity(i);

            }
        });






    }
}
