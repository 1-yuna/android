package com.siheung_alba.alba.model
import android.os.Parcel
import android.os.Parcelable
import java.util.*

class ResumeModel(
    val email: String?,
    val title: String?,
    val career: String?,
    val created_at : String?,
    val resume_id : String?,
    val introduce: String?,
    val updated_at: String?
) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    )

    constructor(
        email: String?,
        title: String?,
        career: String?,
        introduce: String?,
        updated_at: String?
    ) : this(
        email,
        title,
        career,
        getCurrentDate(),
        generateResumeId(),
        introduce,
        updated_at
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(title)
        parcel.writeString(introduce)
        parcel.writeString(updated_at)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ResumeModel> {
        override fun createFromParcel(parcel: Parcel): ResumeModel {
            return ResumeModel(parcel)
        }

        override fun newArray(size: Int): Array<ResumeModel?> {
            return arrayOfNulls(size)
        }

        private fun getCurrentDate(): String {
            val calendar = Calendar.getInstance()
            val day = calendar.get(Calendar.DAY_OF_MONTH)
            val month = calendar.get(Calendar.MONTH) + 1
            val year = calendar.get(Calendar.YEAR)
            return "$month/$day/$year"
        }

        private fun generateResumeId(): String {
            // 랜덤한 resume_id 생성 로직을 구현해야 함
            // 예시로 UUID를 사용하여 랜덤한 문자열 생성
            return UUID.randomUUID().toString()
        }
    }
}
