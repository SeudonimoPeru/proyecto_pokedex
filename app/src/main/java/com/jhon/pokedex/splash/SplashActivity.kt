package com.jhon.pokedex.splash

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.jhon.pokedex.componentes.blur.BlurBox
import com.jhon.pokedex.componentes.blur.BlurEngine
import com.jhon.pokedex.componentes.loading.Loading
import com.jhon.pokedex.databinding.ActivitySplashBinding
import com.jhon.pokedex.main.PrincipalActivity
import com.jhon.pokedex.utils.Constans
import com.jhon.pokedex.utils.Constans.delaySplash
import com.jhon.pokedex.utils.startNewActivityClearStack
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class SplashActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashBinding
    private var blurEngine: BlurEngine = BlurBox()
    private lateinit var ivLogoLindley: ImageView
    private var loadingSplash: Loading = Loading()
    private lateinit var tvVersion: TextView


    fun hideProgress() {
        loadingSplash.dismiss()
    }

    fun showProgress() {
        loadingSplash.show(supportFragmentManager, "loadingDialog")
    }

    fun showTextSplash() {
        tvVersion.visibility = View.VISIBLE
    }

    fun hideTextSplash() {
        tvVersion.visibility = View.GONE
    }

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ivLogoLindley = binding.ivImageLogoLindley
        tvVersion = binding.tvVersion
        tvVersion.text = "V.${packageManager.getPackageInfo(packageName, 0).versionName}"


        lifecycleScope.launch {

            hideTextSplash()
            val radius = Constans.radius
            showProgress()
            delay(delaySplash)
            showTextSplash()
            hideProgress()
            delay(delaySplash)

            startNewActivityClearStack<PrincipalActivity>()
        }

    }

}
