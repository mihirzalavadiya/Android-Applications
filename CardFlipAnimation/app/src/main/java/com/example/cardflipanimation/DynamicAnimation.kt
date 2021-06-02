package com.example.cardflipanimation

import android.content.Context
import android.content.Intent
import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.DisplayMetrics
import android.util.TypedValue
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.dynamicanimation.animation.SpringAnimation
import androidx.dynamicanimation.animation.DynamicAnimation
import androidx.dynamicanimation.animation.FlingAnimation
import androidx.dynamicanimation.animation.SpringForce
import com.example.cardflipanimation.databinding.ActivityDynamicAnimationBinding

class DynamicAnimation : AppCompatActivity() {

    private lateinit var binding2: ActivityDynamicAnimationBinding
    var sholdFlingUpwords: Boolean = true
    var v = 3000F

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding2 = ActivityDynamicAnimationBinding.inflate(layoutInflater)
        setContentView(binding2.root)

        setTitle(R.string.dynamic_animation)

        binding2.viewSpiring.setOnClickListener {
            findViewById<View>(R.id.view_spiring).let { img ->
                SpringAnimation(img, DynamicAnimation.TRANSLATION_Y, 0f).apply {
                    spring.setStiffness(SpringForce.STIFFNESS_LOW)
                    spring.setDampingRatio(SpringForce.DAMPING_RATIO_HIGH_BOUNCY)
                    setStartVelocity(8000F)
                    start()
                }
            }
        }

        binding2.viewFling.setOnClickListener {
            findViewById<View>(R.id.view_fling).let { img ->
                FlingAnimation(img, DynamicAnimation.TRANSLATION_Y).apply {
                    if (v == v)
                    {
                        v = -v
                    }
                    else if(v == -v) {
                        v = v
                    }
                    setStartVelocity(v)
                    setFriction(2F)
                    start()
                    sholdFlingUpwords = !sholdFlingUpwords
                }
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.object_animator, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        var id = item.getItemId()
        val intent = Intent(this, ObjectAnimator::class.java)
        if (id == R.id.object_animator) {
            startActivity(intent)
            return false
        }
        else if(id == R.id.dynamic_animation) {
            val intent1 = Intent(this, com.example.cardflipanimation.DynamicAnimation::class.java)
            startActivity(intent1)
            return false
        }
        else if(id == R.id.card_flip) {
            val intent2 = Intent(this, MainActivity::class.java)
            startActivity(intent2)
            return false
        }
        return super.onOptionsItemSelected(item)
    }

}