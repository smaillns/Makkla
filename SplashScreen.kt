package com.example.smail.projectmob

import android.animation.*
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.graphics.drawable.AnimationDrawable
import android.support.constraint.ConstraintLayout
import android.view.View
import android.widget.LinearLayout
//import sun.security.krb5.internal.KDCOptions.with
import android.widget.ImageView
import android.view.animation.Animation
import android.opengl.ETC1.getHeight
import android.opengl.ETC1.getWidth
import android.view.animation.ScaleAnimation
import android.animation.AnimatorSet
import android.animation.Animator
import android.animation.Animator.AnimatorListener








class SplashScreen : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val image = findViewById<ImageView>(R.id.logo)

        scale(image)


//        val intent = Intent(applicationContext,
//                MainActivity::class.java)
//        startActivity(intent)
        //finish()
    }

    fun scale(image: ImageView) {

        val scalex = PropertyValuesHolder.ofFloat (View.SCALE_X, 0.95f, 1f)
        val scaley = PropertyValuesHolder.ofFloat(View.SCALE_Y,  0.95f, 1f)
        val anim = ObjectAnimator.ofPropertyValuesHolder(image, scalex, scaley)
        anim.repeatCount = 2
        anim.repeatMode = ValueAnimator.REVERSE
        anim.duration = 1000
        anim.start()


        anim.addListener(object: AnimatorListener{
            override fun onAnimationStart(animation: Animator) {
                // ...
            }

            override fun onAnimationRepeat(animation: Animator) {}
            override fun onAnimationEnd(animation: Animator) {
                val intent = Intent(applicationContext,
                        MainActivity::class.java)
                startActivity(intent)
                anim.cancel()
                finish()
            }
            override fun onAnimationCancel(animation: Animator){}
        })

    }
}
