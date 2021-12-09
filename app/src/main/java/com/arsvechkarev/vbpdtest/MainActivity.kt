package com.arsvechkarev.vbpdtest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import by.kirich1409.viewbindingdelegate.CreateMethod
import by.kirich1409.viewbindingdelegate.viewBinding
import com.arsvechkarev.vbpdtest.databinding.ActivityMainBinding
import com.arsvechkarev.vbpdtest.databinding.ItemToAddBinding

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private val mainBinding: ActivityMainBinding by viewBinding(ActivityMainBinding::bind)

    private val innerBinding: ItemToAddBinding by viewBinding(createMethod = CreateMethod.INFLATE)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding.rootLayout.setOnClickListener {
            if (!innerBinding.itemButton.isAttachedToWindow) {
                // Works fine in 1.4.6, but crashes in 1.5.3
                mainBinding.rootLayout.addView(innerBinding.itemButton)
            }
        }
    }
}
