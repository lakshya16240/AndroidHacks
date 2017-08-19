package com.cb.android.qrcode;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;

import java.io.ByteArrayOutputStream;

import static android.R.attr.bitmap;
import static android.R.color.black;
import static android.R.color.white;

public class InformationActivity extends AppCompatActivity {

    EditText name;
    EditText email;
    EditText address;
    EditText pan;
    EditText adhaar;
    EditText phone;
    public static final int QRcodeWidth = 500;
    Bitmap bitmap;
    Context context =this;
    StringBuilder sb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        name = ((EditText) findViewById(R.id.name));
        email = (EditText) findViewById(R.id.email);
        address = (EditText) findViewById(R.id.address);
        pan = (EditText) findViewById(R.id.pan);
        adhaar = (EditText) findViewById(R.id.adhaar);
        phone = (EditText) findViewById(R.id.phone);
        ((Button) findViewById(R.id.generate)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value = parsedData(name.getText().toString(),
                                            email.getText().toString(),
                                            address.getText().toString(),
                                            pan.getText().toString(),
                                            adhaar.getText().toString(),
                                            phone.getText().toString());

                QRCode qrCode = new QRCode(context,value,InformationActivity.this);
                qrCode.parseData();

            }
        });



    }
    public String parsedData(String name, String email, String address, String pan , String adhaar , String phone){
        sb = new StringBuilder(name + "/n" + email + "/n" + address + "/n" + pan + "/n" + adhaar + "/n" + phone);
        return sb.toString();
    }

    Bitmap TextToImageEncode(String Value) throws WriterException {
        BitMatrix bitMatrix;
        try {
            bitMatrix = new MultiFormatWriter().encode(
                    Value,
                    BarcodeFormat.DATA_MATRIX.QR_CODE,
                    QRcodeWidth, QRcodeWidth, null
            );

        } catch (IllegalArgumentException Illegalargumentexception) {

            return null;
        }
        int bitMatrixWidth = bitMatrix.getWidth();

        int bitMatrixHeight = bitMatrix.getHeight();

        int[] pixels = new int[bitMatrixWidth * bitMatrixHeight];

        for (int y = 0; y < bitMatrixHeight; y++) {
            int offset = y * bitMatrixWidth;

            for (int x = 0; x < bitMatrixWidth; x++) {

                pixels[offset + x] = bitMatrix.get(x, y) ?
                        ContextCompat.getColor(this,black) : ContextCompat.getColor(this,white);
            }
        }
        Bitmap bitmap = Bitmap.createBitmap(bitMatrixWidth, bitMatrixHeight, Bitmap.Config.ARGB_4444);

        bitmap.setPixels(pixels, 0, 500, 0, 0, bitMatrixWidth, bitMatrixHeight);
        return bitmap;
    }
}
