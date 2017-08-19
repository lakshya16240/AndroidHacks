package com.cb.android.qrcode;

import android.Manifest;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;
import java.net.URI;
import java.util.ArrayList;

import static android.support.v7.widget.AppCompatDrawableManager.get;

public class SharingActivity extends AppCompatActivity {

    private static String[] PERMISSIONS_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };

    StringBuilder sb_fileList= new StringBuilder("");
    StringBuilder sb;
    QRCode qrCode;
    Context context = this;
    ArrayList<Files> fileList;
    RecyclerView rvFiles;
    ShareAdapter shareAdapter;

    public static final int REQUEST_EXTERNAL_STORAGE=345;
    public static final int PICKFILE_REQUEST_CODE = 346;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sharing);

        verifyStoragePermissions(this);
        fileList = new ArrayList<Files>();
        rvFiles = (RecyclerView) findViewById(R.id.rvFiles);
        rvFiles.setLayoutManager(new LinearLayoutManager(this));
        shareAdapter = new ShareAdapter(this, new ArrayList<Files>());
        rvFiles.setAdapter(shareAdapter);

        ((Button) findViewById(R.id.fileSelect)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("*/*"); //this line forces the user to select a pdf...you can simply remove this line to be able to choose all files
                startActivityForResult(intent, PICKFILE_REQUEST_CODE);



            }
        });

        ((Button) findViewById(R.id.bv_genFiles)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sb_fileList.length()!=0) {
                    qrCode = new QRCode(context, sb_fileList.toString(), SharingActivity.this);
                    qrCode.parseData();
                }
                else{
                    Toast.makeText(context, "Please Select at Least One File", Toast.LENGTH_SHORT).show();
                }

            }
        });



    }

    public static void verifyStoragePermissions(Activity activity) {
        // Check if we have write permission
        int permission = ActivityCompat.checkSelfPermission(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE);

        if (permission != PackageManager.PERMISSION_GRANTED) {
            // We don't have permission so prompt the user
            ActivityCompat.requestPermissions(activity,PERMISSIONS_STORAGE,REQUEST_EXTERNAL_STORAGE);
        }
    }

    public String getMimeType(Uri uri) {
        String mimeType = null;
        if (uri.getScheme().equals(ContentResolver.SCHEME_CONTENT)) {
            ContentResolver cr = getApplicationContext().getContentResolver();
            mimeType = cr.getType(uri);
        } else {
            String fileExtension = MimeTypeMap.getFileExtensionFromUrl(uri
                    .toString());
            mimeType = MimeTypeMap.getSingleton().getMimeTypeFromExtension(
                    fileExtension.toLowerCase());
        }
        return mimeType;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        try {
            super.onActivityResult(requestCode, resultCode, data);

            if (requestCode == PICKFILE_REQUEST_CODE && resultCode == RESULT_OK) {
                Uri file = data.getData();
                if(file!=null) {//this is our file uri
                    sb = new StringBuilder(file.getLastPathSegment());
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {

                        sb_fileList.append(sb);
                        sb_fileList.append(":::::::  ");
                        Log.d("SHARING ===========", "onActivityResult: "  + getMimeType(file));
                        fileList.add(new Files(getMimeType(file), sb.toString()));

                        shareAdapter.updateFileList(fileList);

                    } else {
                        (sb_fileList.append(sb)).append(" ");
                    }
                }
            }
        } catch (Exception ex) {
            Toast.makeText(getApplicationContext(), ex.toString(), Toast.LENGTH_SHORT).show();
        }

    }
}
