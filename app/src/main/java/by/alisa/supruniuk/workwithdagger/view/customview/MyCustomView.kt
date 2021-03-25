package by.alisa.supruniuk.workwithdagger.view.customview

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.os.Build
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import androidx.annotation.RequiresApi
import by.alisa.supruniuk.workwithdagger.R
import by.alisa.supruniuk.workwithdagger.databinding.MyCustomViewBinding


@SuppressLint("NewApi")
@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
class MyCustomView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
): FrameLayout(context, attrs) {

    private var _viewBinding: MyCustomViewBinding? = null
    private val viewBinding get() = _viewBinding!!

    init {
        attrs?.let {
            _viewBinding = MyCustomViewBinding.inflate(LayoutInflater.from(context), this, true)
            val view = viewBinding.root
            val typedArray = context.obtainStyledAttributes(it, R.styleable.MyCustomView, 0, 0)

            viewBinding.tvNameColor.text = colorName
            viewBinding.myView.setBackgroundColor(colorNum)

            typedArray.recycle()
        }
    }

    companion object {
        var colorName: String = "Color"
            set(value) {
                field = value
                viewBinding.tvNameColor.text = field
            }

        var colorNum: Int = Color.BLACK
            set(value) {
                field = value
                viewBinding.myView.setBackgroundColor(field)
            }
    }

}