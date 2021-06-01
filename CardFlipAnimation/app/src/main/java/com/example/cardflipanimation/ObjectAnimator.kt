package com.example.cardflipanimation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.animation.ObjectAnimator
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
}