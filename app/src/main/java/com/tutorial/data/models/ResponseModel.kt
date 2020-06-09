package com.tutorial.data.models

import android.os.Parcel
import android.os.Parcelable

data class ResponseModel(
    val results: List<MainModel>? = emptyList(),
    val page: Long? = -1L,
    val total_pages: Long? = -1L
): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.createTypedArrayList(MainModel),
        parcel.readValue(Long::class.java.classLoader) as? Long,
        parcel.readValue(Long::class.java.classLoader) as? Long
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeTypedList(results)
        parcel.writeValue(page)
        parcel.writeValue(total_pages)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ResponseModel> {
        override fun createFromParcel(parcel: Parcel): ResponseModel {
            return ResponseModel(parcel)
        }

        override fun newArray(size: Int): Array<ResponseModel?> {
            return arrayOfNulls(size)
        }
    }
}