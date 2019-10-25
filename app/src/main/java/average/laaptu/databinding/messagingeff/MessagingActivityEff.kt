package average.laaptu.databinding.messagingeff

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.Observable
import androidx.databinding.Observable.OnPropertyChangedCallback
import average.laaptu.databinding.R
import average.laaptu.databinding.databinding.ActivityMessagingEffBinding
import average.laaptu.databinding.messaging.MessagingComponentEff
import average.laaptu.databinding.BR
import average.laaptu.databinding.messaging.addOnPropertyChanged
import io.reactivex.disposables.Disposable

class MessagingActivityEff : AppCompatActivity() {


    lateinit var disposable: Disposable
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMessagingEffBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_messaging_eff)

        val messagingComponentEff = MessagingComponentEff("Hello", { message ->
            println("I am clicked with $message")
        }, false)

        binding.messagingComponentViewEff.messagingComponentEff = messagingComponentEff
//        messagingComponentEff.addOnPropertyChangedCallback(object : OnPropertyChangedCallback() {
//            override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
//                if (propertyId == BR.draft) {
//                     messagingComponentEff.btnEnabled = !messagingComponentEff.draft.isNullOrEmpty()
//                }
//            }
//        })
        disposable = messagingComponentEff.addOnPropertyChanged { component, i ->
            if (i == BR.draft)
                component.btnEnabled = !component.draft.isNullOrEmpty()
        }

        disposable.dispose()


    }
}
