package com.example.excercise1.data

import android.os.Parcel
import android.os.Parcelable

class HouseInformation(val homeId : Int, val address: String, val price : String, val imgResID : Int, val houseType: HouseType) : Parcelable {
    override fun describeContents(): Int {
        return 0;
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(address)
        dest.writeString(price)
        dest.writeInt(imgResID)
        dest.writeString(houseType.name)
        dest.writeInt(homeId)
    }

}
