package com.example.navigationcomponent

import android.os.Parcel
import android.os.Parcelable
import java.math.BigDecimal

data class Money(val amount: BigDecimal): Parcelable {
    override fun describeContents(): Int {
        TODO("Not yet implemented")
    }

    override fun writeToParcel(dest: Parcel?, flags: Int) {
        TODO("Not yet implemented")
    }

}