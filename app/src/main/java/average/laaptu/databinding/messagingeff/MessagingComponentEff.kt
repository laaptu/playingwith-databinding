package average.laaptu.databinding.messaging

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.Observable
import average.laaptu.databinding.BR
import io.reactivex.disposables.Disposable
import io.reactivex.disposables.Disposables
import kotlin.reflect.KProperty

class MessagingComponentEff(
    _draft: String,
    val onClick: (message: String) -> Unit,
    _btnEnabled: Boolean
) :
    BaseObservable() {

    @get:Bindable
    var draft: String by bindable(_draft, BR.draft)

    @get:Bindable
    var btnEnabled: Boolean by bindable(_btnEnabled, BR.btnEnabled)

//    val btnEnabled: Boolean
//        @Bindable("draft")
//        get() = !draft.isNullOrEmpty()
}

class BindableDelegate<in R : BaseObservable, T : Any>(
    private var value: T,
    private val bindingEntry: Int
) {
    operator fun getValue(thisRef: R, property: KProperty<*>): T = value

    operator fun setValue(thisRef: R, property: KProperty<*>, newValue: T) {
        value = newValue
        thisRef.notifyPropertyChanged(bindingEntry)
    }
}

fun <R : BaseObservable, T : Any> bindable(value: T, bindingEntry: Int): BindableDelegate<R, T> =
    BindableDelegate(value, bindingEntry)

fun <T : Observable> T.addOnPropertyChanged(callback: (T,i:Int) -> Unit):Disposable =
    object : Observable.OnPropertyChangedCallback() {
        override fun onPropertyChanged(observable: Observable?, i: Int) =
            callback(observable as T, i)
    }.also { addOnPropertyChangedCallback(it) }.let {
        Disposables.fromAction { removeOnPropertyChangedCallback(it) }
    }


interface DoSomething{
    fun doNow()
}

class Phone{
    fun addDoSomething(doSomething: DoSomething){

    }
}

class Employee{

}

fun Phone.addOnPropertyChange(fun1:()->Unit):Employee = object:DoSomething{
    override fun doNow() {
    }
}.also {
    addDoSomething(it)
}.let{

    Employee()
}