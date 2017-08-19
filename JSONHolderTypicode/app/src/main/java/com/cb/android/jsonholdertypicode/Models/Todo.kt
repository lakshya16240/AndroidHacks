package com.cb.android.jsonholdertypicode.Models

/**
 * Created by GhanshamBansal on 01/07/17.
 */

data class Todo(
        val userId: Int,
        val id: Int,
        val title: String,
        val completed : Boolean
)