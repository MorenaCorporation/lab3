package com.example.myfavoritesuperheroes

import android.os.Parcel
import android.os.Parcelable

data class Heroes(val image: Int, val name: String) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString()!!
    ){

    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(image)
        parcel.writeString(name)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Heroes> {
        override fun createFromParcel(parcel: Parcel): Heroes {
            return Heroes(parcel)
        }

        override fun newArray(size: Int): Array<Heroes?> {
            return arrayOfNulls(size)
        }
    }
}
