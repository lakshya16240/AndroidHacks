package com.cb.android.restapi

/**
 * Created by GhanshamBansal on 28/06/17.
 */
data class PostComment (
        val postId: kotlin.Int,
        val id: kotlin.Int,
        val name: String,
        val email: String,
        val body: String
)