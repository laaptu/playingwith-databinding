package average.laaptu.databinding.bindingadapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso

object ImageBindingAdapter {
    @JvmStatic
    @BindingAdapter("imgSrc")
    fun setImgSrc(imgView: ImageView, imgUrl: String) {
        println("####imgUrl = $imgUrl")
        Picasso.get().load(imgUrl).into(imgView)
    }
}