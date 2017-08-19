package com.cb.android.qrcode;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.View;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;

import java.io.ByteArrayOutputStream;

import static android.R.attr.bitmap;
import static android.R.color.black;
import static android.R.color.white;
import static com.cb.android.qrcode.InformationActivity.QRcodeWidth;
import static com.google.zxing.qrcode.decoder.ErrorCorrectionLevel.Q;

/**
 * Created by GhanshamBansal on 09/07/17.
 */

public class QRCode {

    Context context;
    Context ActivityContext;
    private static Bitmap bitmap;
    String value;

    public QRCode(Context context, String value, Context ActivityContext) {
        this.context = context;
        this.value = value;
        this.ActivityContext=ActivityContext;
    }


    public void parseData(){
        try {
            Log.d("INFO ======", "onClick: ");
            bitmap = TextToImageEncode(value);
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
            byte[] byteArray = stream.toByteArray();
            Intent i;
            i = new Intent(ActivityContext,QRCodeActivity.class);
            i.putExtra("image",byteArray);
            context.startActivity(i);
        }
        catch (WriterException e) {
            e.printStackTrace();
        }
    }

    Bitmap TextToImageEncode(String Value) throws WriterException {
        BitMatrix bitMatrix;
        Log.d("QRCODE ====", "TextToImageEncode: ");
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
                        ContextCompat.getColor(context,black) : ContextCompat.getColor(context,white);
            }
        }
        Bitmap bitmap = Bitmap.createBitmap(bitMatrixWidth, bitMatrixHeight, Bitmap.Config.ARGB_4444);

        bitmap.setPixels(pixels, 0, 500, 0, 0, bitMatrixWidth, bitMatrixHeight);
        return bitmap;
    }
}
