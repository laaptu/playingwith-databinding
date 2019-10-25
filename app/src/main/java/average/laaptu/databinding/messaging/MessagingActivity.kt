package average.laaptu.databinding.messaging

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import average.laaptu.databinding.R
import average.laaptu.databinding.databinding.ActivityMessagingBinding
import average.laaptu.databinding.databinding.MessagingComponentViewBinding
import kotlinx.android.synthetic.main.activity_messaging.*

class MessagingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMessagingBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_messaging)

        val messagingComponent = MessagingComponent("Hello", { message ->
            println("I am clicked with $message")
        }, false)

        binding.messagingComponentView.messagingComponent = messagingComponent
    }
}
