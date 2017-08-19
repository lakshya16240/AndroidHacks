package com.cb.android.restapi

/**
 * Created by GhanshamBansal on 28/06/17.
 */

data class User (
        val name: String,
        val address: Address
) {
    data class Address (
            val street: String,
            val suite: String,
            val city: String
    )


}