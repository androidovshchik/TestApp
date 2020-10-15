package defpackage.testapp

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
class Cover(
    @SerializedName("textId")
    @Expose
    var textId: String,
    @SerializedName("title")
    @Expose
    var title: String,
    @SerializedName("image")
    @Expose
    var image: String,
    @SerializedName("rating")
    @Expose
    var rating: Float,
    @SerializedName("description")
    @Expose
    var description: String,
    @SerializedName("author")
    @Expose
    var author: String
) : Parcelable