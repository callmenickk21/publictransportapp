package com.example.publictransportapp

import android.os.Parcel
import android.os.Parcelable
import java.io.Serializable

class TerminalRVModel(
    val terminalName: String?,
    val terminalDescription: String?
):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(terminalName)
        parcel.writeString(terminalDescription)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<TerminalRVModel> {
        override fun createFromParcel(parcel: Parcel): TerminalRVModel {
            return TerminalRVModel(parcel)
        }

        override fun newArray(size: Int): Array<TerminalRVModel?> {
            return arrayOfNulls(size)
        }
    }
}