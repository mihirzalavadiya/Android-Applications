package com.example.cardflipanimation

import android.graphics.Point
import android.graphics.Rect
import android.graphics.RectF
import android.animation.ObjectAnimator
import android.animation.Animator
import android.animation.AnimatorSet
import android.animation.AnimatorListenerAdapter
import android.content.Intent
import android.icu.util.CurrencyAmount
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.view.animation.DecelerateInterpolator
import android.widget.ImageButton
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity


import androidx.fragment.app.FragmentActivity
import com.example.cardflipanimation.databinding.ActivityZoomAnimationBinding

class ZoomAnimation : AppCompatActivity() {

    private lateinit var binding4: ActivityZoomAnimationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding4 = ActivityZoomAnimationBinding.inflate(layoutInflater)
        setContentView(binding4.root)

        binding4.btnZoomIn.setOnClickListener {
            val animZoomIn: Animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in)
            binding4.imageView.startAnimation(animZoomIn)
        }

        binding4.btnZoomOut.setOnClickListener {
            val animZoomOut: Animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_out)
            binding4.imageView.startAnimation(animZoomOut)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.object_animator, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        var id = item.getItemId()
        val intent = Intent(this, com.example.cardflipanimation.ObjectAnimator::class.java)
        if (id == R.id.object_animator) {
            startActivity(intent)
            return false
        }
        else if(id == R.id.dynamic_animation) {
            val intent1 = Intent(this, DynamicAnimation::class.java)
            startActivity(intent1)
            return false
        }
        else if(id == R.id.card_flip) {
            val intent2 = Intent(this, MainActivity::class.java)
            startActivity(intent2)
            return false
        }
        else if(id == R.id.zoom_animation) {
            val intent2 = Intent(this, ZoomAnimation::class.java)
            startActivity(intent2)
            return false
        }
        else if(id == R.id.auto_animate) {
            val intent2 = Intent(this, AutoAnimate::class.java)
            startActivity(intent2)
            return false
        }
        return super.onOptionsItemSelected(item)
    }
}