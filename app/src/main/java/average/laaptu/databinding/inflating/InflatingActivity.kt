package average.laaptu.databinding.inflating

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.text.Editable
import android.text.TextWatcher
import androidx.databinding.DataBindingUtil
import androidx.databinding.adapters.TextViewBindingAdapter
import average.laaptu.databinding.R
import average.laaptu.databinding.databinding.InflatingContentBinding
import average.laaptu.databinding.simpleobservable.SimpleUser
import kotlinx.android.synthetic.main.activity_inflating.*

class InflatingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inflating)
        val binding: InflatingContentBinding = DataBindingUtil.inflate(
            layoutInflater, R.layout.inflating_content, parentLayout, true
        )
        val simpleUser = SimpleUser("Donald", "Trump", R.drawable.ic_user)
        binding.simpleUser = simpleUser
        Handler().postDelayed({
            simpleUser.fName.set("Barack")
            simpleUser.lName.set("Obama")
        }, 3000)

        val textWatcher = TextViewBindingAdapter.AfterTextChanged {
            println("## after text changes = ${it.toString()}")
        }

        binding.textWatcher = textWatcher
    }
}
