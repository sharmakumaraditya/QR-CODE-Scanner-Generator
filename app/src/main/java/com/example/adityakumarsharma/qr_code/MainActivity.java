package com.example.adityakumarsharma.qr_code;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button generate, scan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        scan=(Button)findViewById(R.id.scan);
        generate=(Button)findViewById(R.id.generate);
        generate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentSignUP=new Intent(getApplicationContext(),qr_code_generator.class);
                startActivity(intentSignUP);
            }
        });

        scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentSign=new Intent(getApplicationContext(),qr_scanner.class);
                startActivity(intentSign);
            }
        });
    }
}
