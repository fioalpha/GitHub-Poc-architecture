package com.fioalpha.poc.component

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.RelativeLayout
import com.fioalpha.poc.component.databinding.ErrorViewBinding

class ErrorViewComponent @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyleAttr: Int = 0
) : RelativeLayout(context, attributeSet, defStyleAttr) {

    private val viewBinding: ErrorViewBinding by lazy {
        ErrorViewBinding.inflate(LayoutInflater.from(context))
    }

    init {
        addView(viewBinding.root,
            RelativeLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT
            )
        )
    }

    fun setTryAgain(listener:() -> Unit) {
        viewBinding.errorTryAgain.setOnClickListener {
            listener()
        }
    }

}