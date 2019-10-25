package average.laaptu.databinding.messaging

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import average.laaptu.databinding.BR

class MessagingComponent(
    private var _draft: String,
    val onClick: (message:String) -> Unit,
    private var _btnEnabled: Boolean
) :
    BaseObservable() {
    var draft
        @Bindable get() = _draft
        set(value) {
            _draft = value
            btnEnabled = value.isNotEmpty()
            notifyPropertyChanged(BR.draft)
        }

    var btnEnabled: Boolean
        @Bindable get() = _btnEnabled
        set(value) {
            if (value != _btnEnabled) {
                _btnEnabled = value
                notifyPropertyChanged(BR.btnEnabled)
            }
        }

    fun onBtnClick(){

    }
}