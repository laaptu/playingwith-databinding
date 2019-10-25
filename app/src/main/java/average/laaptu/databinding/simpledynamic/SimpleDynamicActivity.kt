package average.laaptu.databinding.simpledynamic

import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.DataBindingUtil
import average.laaptu.databinding.BR
import average.laaptu.databinding.R
import average.laaptu.databinding.databinding.ActivitySimpleDynamicBinding

class SimpleDynamicActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivitySimpleDynamicBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_simple_dynamic)
        val userProfileChange = UserProfileChange("Gyan", "Basnet", R.drawable.ic_user)
        binding.userProfile = userProfileChange
        Handler().postDelayed({
            userProfileChange.firstName = "Tom"
            userProfileChange.lastName = "Cruise"
        }, 4000)
    }
}

class UserProfileChange(private var _firstName: String, _lastName: String, _imgUrl: Int) : BaseObservable() {
    var firstName: String
     @Bindable get() = _firstName
        set(value) {
            _firstName = value
            notifyPropertyChanged(BR.firstName)
        }

    var lastName: String = _lastName
    var imgUrl: Int = _imgUrl
}
