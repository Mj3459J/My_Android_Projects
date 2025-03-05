package com.example.quadraticeqsolverdatabinding

import android.view.View
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.example.quadraticeqsolverdatabinding.BR
import com.example.quadraticeqsolverdatabinding.databinding.ActivityMainBinding
import kotlin.math.sqrt

class MyEquation(var binding:ActivityMainBinding) : BaseObservable() {
    @Bindable
    var a:String=""
        set(value) {
            field=value
            notifyPropertyChanged(BR.a)
        }
    @Bindable
    var b:String=""
        set(value) {
            field=value
            notifyPropertyChanged(BR.a)
        }
    @Bindable
    var c:String=""
        set(value) {
            field=value
            notifyPropertyChanged(BR.a)
        }

    fun solveEquation(view:View){
        var a=a.toInt()
        var b=b.toInt()
        var c=c.toInt()

        var discriminant=((b*b)-(4*a*c))

        var x1 :Double
        var x2 :Double
        if(discriminant>0){
            // Tow real roots.
            x1=(-b + sqrt(discriminant.toDouble()))/(2*a)
            x2=(-b - sqrt(discriminant.toDouble()))/(2*a)

            binding.resultText.text="X1 = $x1 , X2= $x2"
        }
        else if(discriminant<0){
            binding.resultText.text="No Real Roots"
        }
        else{
            // only one root possible
            x1=(-b/(2*a).toDouble())
            binding.resultText.text=" X1 = $x1"
        }
    }
}