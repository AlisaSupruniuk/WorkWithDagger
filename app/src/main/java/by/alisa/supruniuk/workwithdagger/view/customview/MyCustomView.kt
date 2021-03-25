package by.alisa.supruniuk.workwithdagger.view.customview

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.os.Build
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import androidx.annotation.RequiresApi
import by.alisa.supruniuk.workwithdagger.R
import kotlinx.android.synthetic.main.fragment_my.view.*


@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
class MyCustomView @JvmOverloads constructor(context: Context,
                                             attrs: AttributeSet? = null,
                                             defStyle: Int = 0,
                                             defStyleRes: Int = 0):
                FrameLayout(context, attrs, defStyle, defStyleRes) {

    init {

        attrs?.let {
            val typedArray = context.obtainStyledAttributes(it, R.styleable.MyCustomView, 0, 0)

            tvNameColor.text = colorName
            myView.setBackgroundColor(colorNum)

            typedArray.recycle()
        }
    }

    companion object{
        var colorName: String = "Hello"
        var colorNum: Int = Color.BLACK
    }

//    fun setBackground(colorNum: Int){
//            tvNameColor.text = colorName
//    }
//
//    fun setText(colorName: String){
//        myView.setBackground(colorNum)
//    }
}
