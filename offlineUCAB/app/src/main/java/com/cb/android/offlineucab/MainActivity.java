package com.cb.android.offlineucab;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.zxing.qrcode.encoder.QRCode;
import com.uber.sdk.android.core.UberSdk;
import com.uber.sdk.core.auth.Scope;
import com.uber.sdk.rides.client.SessionConfiguration;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;

import java.io.ByteArrayOutputStream;
import java.util.Arrays;

import static android.R.attr.onClick;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    Button button;
    EditText et_fName;
    EditText et_sName;
    EditText et_phone;
    EditText et_email;
    EditText et_password;
    String EditTextValue ;

    Thread thread ;
    public final static int QRcodeWidth = 500 ;
    Bitmap bitmap ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_fName = (EditText) findViewById(R.id.et_fName);
        et_sName = (EditText) findViewById(R.id.et_sName);
        et_phone = (EditText) findViewById(R.id.et_phone);
        et_email = (EditText) findViewById(R.id.et_Email);
        et_password = (EditText) findViewById(R.id.et_password);
        button = (Button) findViewById(R.id.bv_submit);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditTextValue = parsedData(et_fName.getText().toString()
                                            , et_sName.getText().toString()
                                            , et_email.getText().toString()
                                            , Integer.valueOf(et_phone.getText().toString())
                                            , et_password.getText().toString());
                try {
                    bitmap = TextToImageEncode(EditTextValue);
                    ByteArrayOutputStream stream = new ByteArrayOutputStream();
                    bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
                    byte[] byteArray = stream.toByteArray();
                    Intent i = new Intent(MainActivity.this,QRCodeActivity.class);
                    i.putExtra("image",byteArray);
                    startActivity(i);
                }
                catch (WriterException e) {
                    e.printStackTrace();
                }

            }
        });
    }
    public String parsedData(String fName , String sName , String email , int phone , String password)
    {
        String stringValue;
        stringValue = fName + sName + email + phone + password;
        return  stringValue;
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
                        ContextCompat.getColor(this,R.color.uber_black) : ContextCompat.getColor(this,R.color.uber_white);
            }
        }
        Bitmap bitmap = Bitmap.createBitmap(bitMatrixWidth, bitMatrixHeight, Bitmap.Config.ARGB_4444);

        bitmap.setPixels(pixels, 0, 500, 0, 0, bitMatrixWidth, bitMatrixHeight);
        return bitmap;
    }
}
