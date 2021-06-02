package com.example.cardflipanimation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.animation.ObjectAnimator
import android.content.Intent
import android.view.Menu
import android.view.MenuItem
import com.example.cardflipanimation.databinding.ActivityObjectAnimatorBinding

class ObjectAnimator : AppCompatActivity() {

    private lateinit var binding1: ActivityObjectAnimatorBinding
    lateinit var objectAnimator: ObjectAnimator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding1 = ActivityObjectAnimatorBinding.inflate(layoutInflater)
        setContentView(binding1.root)

        setTitle(R.string.object_animator)
        objectAnimator = ObjectAnimator.ofFloat(binding1.carimage, "x", 850f);

        binding1.btnmove.setOnClickListener {
            objectAnimator.setDuration(3000)
            objectAnimator.start()

//            objectAnimator = ObjectAnimator.ofFloat(binding1.carimage, "rotation", 90f);
//            objectAnimator.setDuration(3000)
//            objectAnimator.setStartDelay(3000)
//            objectAnimator.start()
//
//            objectAnimator = ObjectAnimator.ofFloat(binding1.carimage, "y", 1300f);
//            objectAnimator.setDuration(3000)
//            objectAnimator.setStartDelay(6000)
//            objectAnimator.start()
//
//            objectAnimator = ObjectAnimator.ofFloat(binding1.carimage, "rotation", 180f);
//            objectAnimator.setDuration(3000)
//            objectAnimator.setStartDelay(9000)
//            objectAnimator.start()
//
//            objectAnimator = ObjectAnimator.ofFloat(binding1.carimage, "x", -10f);
//            objectAnimator.setDuration(3000)
//            objectAnimator.setStartDelay(12000)
//            objectAnimator.start()
//
//            objectAnimator = ObjectAnimator.ofFloat(binding1.carimage, "rotation", 270f);
//            objectAnimator.setDuration(3000)
//            objectAnimator.setStartDelay(15000)
//            objectAnimator.start()
//
//            objectAnimator = ObjectAnimator.ofFloat(binding1.carimage, "y", -10f);
//            objectAnimator.setDuration(3000)
//            objectAnimator.setStartDelay(18000)
//            objectAnimator.start()
//
//            objectAnimator = ObjectAnimator.ofFloat(binding1.carimage, "rotation", 360f);
//            objectAnimator.setDuration(3000)
//            objectAnimator.setStartDelay(21000)
//            objectAnimator.start()
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
        return super.onOptionsItemSelected(item)
    }
}