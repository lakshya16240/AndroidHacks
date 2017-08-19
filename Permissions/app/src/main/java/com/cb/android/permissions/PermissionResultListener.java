package com.cb.android.permissions;

/**
 * Created by GhanshamBansal on 06/07/17.
 */

public interface PermissionResultListener {
    void onPermissionGranted();
    void onPermissionDenied();
}
