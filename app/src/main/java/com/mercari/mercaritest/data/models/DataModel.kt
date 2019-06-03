package com.mercari.mercaritest.data.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



class DataModel {
    @SerializedName("id")
    @Expose
    var id: String? = null
    @SerializedName("name")
    @Expose
    var name: String? = null
    @SerializedName("status")
    @Expose
    var status: String? = null

    @SerializedName("num_likes")
    @Expose
    var numLikes: Int? = null
    @SerializedName("num_comments")
    @Expose
    var numComments: Int? = null
    @SerializedName("price")
    @Expose
    var price: Int? = null
    @SerializedName("photo")
    @Expose
    var photo: String? = null
}