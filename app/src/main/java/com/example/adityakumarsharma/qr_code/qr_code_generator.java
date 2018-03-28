package com.example.adityakumarsharma.qr_code;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class qr_code_generator extends AppCompatActivity {

    CheckBox swim,run,foot,rugby,dance;
    StringBuilder result = new StringBuilder();
    Button generate;
    RadioGroup group_age , group_gender , group_training , group_exercise;
    RadioButton radio_age , radio_gender , radio_training , radio_exercise;
    int total=0;
    String uniquekey = new String();
    String text;
    ImageView image;
    int time=0;
    String time_break= new String();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr_code_generator);
        generate = (Button)findViewById(R.id.button_generate);
        generate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final EditText ed = (EditText)findViewById(R.id.editText1);
                swim = (CheckBox) findViewById(R.id.checkBox1);
                run = (CheckBox) findViewById(R.id.checkBox2);
                foot = (CheckBox) findViewById(R.id.checkBox3);
                rugby = (CheckBox) findViewById(R.id.checkBox4);
                dance = (CheckBox) findViewById(R.id.checkBox5);
                group_age = (RadioGroup)findViewById(R.id.group_age);
                group_gender = (RadioGroup)findViewById(R.id.group_gender);
                group_training = (RadioGroup)findViewById(R.id.group_training);
                group_exercise = (RadioGroup)findViewById(R.id.group_exercise);
                image = (ImageView)findViewById(R.id.image);
                MultiFormatWriter multi = new MultiFormatWriter();




                //adding the name of the user to the result
                String s = ed.getText().toString();
                result.append("NAME : "+ s + "\n");
                uniquekey=s;

                //FINDING THE STRING FOR AGE
                int age_id = group_age.getCheckedRadioButtonId();
                radio_age =(RadioButton) findViewById(age_id);
                result.append("AGE: "+radio_age.getText().toString() + "\n");
                uniquekey=uniquekey+(radio_age.getText().toString() + "\n");
                result.append("Unique Key :" + uniquekey );

                //FINDING THE STRING FOR GENDER
                int gender_id = group_gender.getCheckedRadioButtonId();
                radio_gender =(RadioButton) findViewById(gender_id);
                result.append("GENDER: "+radio_gender .getText().toString() + "\n");

                //FINDING THE STRING FOR TRAINING
                int train_id = group_training.getCheckedRadioButtonId();
                radio_training =(RadioButton) findViewById(train_id);
                result.append("TRAINING TYPE: "+radio_training.getText().toString() + "\n");

                //FINDING THE STRING FOR EXERCISE
                int exer_id = group_exercise.getCheckedRadioButtonId();
                radio_exercise =(RadioButton) findViewById(exer_id);
                result.append("EXERCISE TYPE: "+radio_exercise.getText().toString() + "\n");




               result.append("SPORTS: ");
                //adding the text of the checkbox to result
                if(swim.isChecked())
                {
                    result.append("swimming\n");
                    time=time+1;
                }

                if(run.isChecked())
                {
                    result.append("Running\n");

                }

                if(foot.isChecked())
                {
                    result.append("Football\n");

                }

                if(rugby.isChecked())
                {
                    result.append("Rugby\n");

                }

                if(dance.isChecked())
                {
                    result.append("Dance\n");
                    time=time+1;

                }



                if((radio_age.getText().toString()=="10")||(radio_age.getText().toString()=="10-15")||(radio_gender.getText().toString()=="F"))
                {
                    time=time+1;
                }
                else
                {
                    time=time+2;
                }
                if((radio_training.getText().toString()=="Maui Thai"))
                {
                    time=time+2;
                }
                if((radio_exercise.getText().toString()=="Cardio"))
                {
                    time=time+1;
                }
                String tmpStr10 = String.valueOf(time);

                result.append("The Time You need to do exercise is: "+tmpStr10+"\n");



                 text = result.toString().trim();
                try{
                    BitMatrix bitMatrix = multi.encode(text, BarcodeFormat.QR_CODE,200,200);
                    BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
                    Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);
                    image.setImageBitmap(bitmap);
                }
                catch(WriterException e)
                {
                    e.printStackTrace();
                }

            }
        });
    }



}
