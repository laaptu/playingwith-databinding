package average.laaptu.databinding.bindingadapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import average.laaptu.databinding.R
import average.laaptu.databinding.databinding.ActivitySimpleAdapterBinding
import average.laaptu.databinding.databinding.ActivitySimpleBinding
import average.laaptu.databinding.simpleobservable.SimpleUser

class SimpleBindingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivitySimpleAdapterBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_simple_adapter)
        val simpleUser = SimpleUser(
            "Tom",
            "Cruise",
            imgUrlLink = "https://i.ytimg.com/vi/grE8YaQmRQs/maxresdefault.jpg"
        )
        binding.simpleUser = simpleUser
    }
}
