package com.cb.android.jsonholdertypicode.Models

/**
 * Created by GhanshamBansal on 01/07/17.
 */

data class Comment (
        val postId: Int,
        val id: Int,
        val name: String,
        val email: String,
        val body: String
)
