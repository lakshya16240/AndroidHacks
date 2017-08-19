package com.cb.android.permissions;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;

/**
 * Created by GhanshamBansal on 06/07/17.
 */

public class PermissionManager {

    private PermissionResultListener permissionResultListener;
    private Context context;
    private String permission;

    public PermissionManager(PermissionResultListener permissionResultListener, Context context, String permission) {
        this.permissionResultListener = permissionResultListener;
        this.context = context;
        this.permission = permission;
    }

    void askForPermission(Context context,String permission,PermissionResultListener permissionResultListener){
        if(permission.equals(Manifest.permission.READ_EXTERNAL_STORAGE) || permission.equals(Manifest.permission.WRITE_EXTERNAL_STORAGE)){
            permissionResultListener.onPermissionGranted();
        }
        else {
            permissionResultListener.onPermissionDenied();
        }
    }

}
