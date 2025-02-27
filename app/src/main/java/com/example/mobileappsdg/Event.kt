package com.example.mobileappsdg

import android.os.Parcel
import android.os.Parcelable

data class Event(
    val title: String,
    val date: String,
    val time: String,
    val location: String,
    val imageResId: Int,
    val participants: Int,
    val description: String
) : Parcelable {
    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(title)
        parcel.writeString(date)
        parcel.writeString(time)
        parcel.writeString(location)
        parcel.writeInt(imageResId)
        parcel.writeInt(participants)
        parcel.writeString(description)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Event> {
        override fun createFromParcel(parcel: Parcel): Event {
            return Event(
                parcel.readString() ?: "",
                parcel.readString() ?: "",
                parcel.readString() ?: "",
                parcel.readString() ?: "",
                parcel.readInt(),
                parcel.readInt(),
                parcel.readString() ?: ""
            )
        }

        override fun newArray(size: Int): Array<Event?> {
            return arrayOfNulls(size)
        }
    }
}



