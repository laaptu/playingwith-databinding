package average.laaptu.databinding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import average.laaptu.databinding.bindingadapter.SimpleBindingActivity
import average.laaptu.databinding.inflating.InflatingActivity
import average.laaptu.databinding.messaging.MessagingActivity
import average.laaptu.databinding.messagingeff.MessagingActivityEff
import average.laaptu.databinding.simple.SimpleActivity
import average.laaptu.databinding.simpledynamic.SimpleDynamicActivity
import average.laaptu.databinding.simpleobservable.SimpleObservableActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun goToSimpleActivity(view: View) {
        startActivity(Intent(this, SimpleActivity::class.java))
    }

    fun goToSimpleDynamicActivity(view: View) {
        startActivity(Intent(this, SimpleDynamicActivity::class.java))
    }

    fun goToSimpleObservableActivity(view: View) {
        startActivity(Intent(this, SimpleObservableActivity::class.java))
    }

    fun goToInflatingActivity(view: View) {
        startActivity(Intent(this, InflatingActivity::class.java))
    }

    fun goToSimpleBindingActivity(view: View) {
        startActivity(Intent(this, SimpleBindingActivity::class.java))
    }

    fun goToMessagingActivity(view: View) {
        startActivity(Intent(this, MessagingActivity::class.java))
    }

    fun goToMessagingActivityEff(view: View) {
        startActivity(Intent(this, MessagingActivityEff::class.java))
    }
}
