package com.example.adityakumarsharma.qr_code;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class qr_scanner extends AppCompatActivity {
private Button scan ;
    private EditText edit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr_scanner);
        scan = (Button)findViewById(R.id.scan_btn);
        final Activity activity = this;
        scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IntentIntegrator integ = new IntentIntegrator(activity);
                integ.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
                integ.setPrompt("Scan the QR Code");
                integ.setCameraId(0);
                integ.setBeepEnabled(false);
                integ.setBarcodeImageEnabled(false);
                integ.initiateScan();
            }
        });
    }

    @Override
protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        edit = (EditText)findViewById(R.id.editText);
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if(result!=null) {
            if (result.getContents() == null) {
                edit.setText("you cancelled the scanning");
            } else {
                edit.setText(result.getContents());
            }
        }
        else
        {
            super.onActivityResult(requestCode , resultCode , data);
        }
    }
}
