package average.laaptu.databinding.simpleobservable

import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ObservableField
import average.laaptu.databinding.R
import average.laaptu.databinding.databinding.ActivitySimpleObservableBinding

class SimpleObservableActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivitySimpleObservableBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_simple_observable)
        val simpleUser = SimpleUser("Ronald", "Regan", R.drawable.ic_user)
        binding.simpleUser = simpleUser
        Handler().postDelayed({
            simpleUser.fName.set("Tom")
            simpleUser.lName.set("Cruise")
        }, 3000)
    }
}

class SimpleUser(firstName: String, lastName: String, imageId: Int = 0, imgUrlLink: String = "") {
    val fName: ObservableField<String> = ObservableField()
    val lName: ObservableField<String> = ObservableField()
    val imgId: ObservableField<Int> = ObservableField()
    val imgUrl: ObservableField<String> = ObservableField()

    init {
        fName.set(firstName)
        lName.set(lastName)
        imgId.set(imageId)
        imgUrl.set(imgUrlLink)
    }

}
