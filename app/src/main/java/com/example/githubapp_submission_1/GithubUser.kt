package com.example.githubapp_submission_1

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class GithubUser (
    var username: String = "",
    var name: String = "",
    var longLocation: String = "",
    var shortLocation: String = "",
    var repository: String = "",
    var company: String = "",
    var followers: String = "",
    var following: String = "",
    var avatar: Int = 0
) : Parcelable