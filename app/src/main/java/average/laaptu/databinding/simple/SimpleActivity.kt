package average.laaptu.databinding.simple

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import average.laaptu.databinding.R
import average.laaptu.databinding.databinding.ActivitySimpleBinding

class SimpleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding:ActivitySimpleBinding = DataBindingUtil.setContentView(this,R.layout.activity_simple)
        val userProfile = UserProfile("Tom","Cruise",R.drawable.ic_user)
        binding.userProfile = userProfile
    }
}
