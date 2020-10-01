package austinwhite.tech.clickthepic

import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.view.View
import android.view.animation.Animation
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class AnimationActivity : AppCompatActivity() {

    fun gameOverScaler(gameOver: TextView) {
        textViewScaler(gameOver)
    }

    fun refreshGameScaler(refreshGame: Button) {
        buttonScaler(refreshGame)
    }

    fun gameObjectScaler(gameObject: ImageButton) {
        imageButtonScaler(gameObject)
    }

    fun gameObject2Scaler(gameObject2: ImageButton) {
        imageButtonScaler(gameObject2)
    }

    fun gameObject3Scaler(gameObject3: ImageButton) {
        imageButtonScaler(gameObject3)
    }

    fun imageButtonScaler(gameObject: ImageButton) {
        // Scale the view up to 2x its default size and back
        val scaleX = PropertyValuesHolder.ofFloat(View.SCALE_X, 2f)
        val scaleY = PropertyValuesHolder.ofFloat(View.SCALE_Y, 2f)
        val animator = ObjectAnimator.ofPropertyValuesHolder(gameObject, scaleX, scaleY)
        animator.duration = 300
        animator.repeatCount = 1
        animator.repeatMode = ObjectAnimator.REVERSE
        animator.start()
    }

    fun buttonScaler(refreshGame: Button) {
        val scaleX = PropertyValuesHolder.ofFloat(View.SCALE_X, 2f)
        val scaleY = PropertyValuesHolder.ofFloat(View.SCALE_Y, 2f)
        val animator = ObjectAnimator.ofPropertyValuesHolder(refreshGame, scaleX, scaleY)
        animator.duration = 500
        animator.repeatCount = 1
        animator.repeatMode = ObjectAnimator.REVERSE
        animator.start()

    }

    fun textViewScaler(gameOver: TextView) {
        val scaleX = PropertyValuesHolder.ofFloat(View.SCALE_X, 2f)
        val scaleY = PropertyValuesHolder.ofFloat(View.SCALE_Y, 2f)
        val animator = ObjectAnimator.ofPropertyValuesHolder(gameOver, scaleX, scaleY)
        animator.duration = 500
        animator.repeatCount = 1
        animator.repeatMode = ObjectAnimator.REVERSE
        animator.start()
    }

    fun scoreScaler(score: TextView) {
        val scaleX = PropertyValuesHolder.ofFloat(View.SCALE_X, 1.3f)
        val scaleY = PropertyValuesHolder.ofFloat(View.SCALE_Y, 1.3f)
        val animator = ObjectAnimator.ofPropertyValuesHolder(score, scaleX, scaleY)
        animator.duration = 500
        animator.repeatCount = 1
        animator.repeatMode = ObjectAnimator.REVERSE
        animator.start()
    }

    fun titleScaler(titleView: TextView) {
        val scaleX = PropertyValuesHolder.ofFloat(View.SCALE_X, 1.05f)
        val scaleY = PropertyValuesHolder.ofFloat(View.SCALE_Y, 1.05f)
        val animator = ObjectAnimator.ofPropertyValuesHolder(titleView, scaleX, scaleY)

        animator.duration = 500
        animator.repeatCount = Animation.INFINITE
        animator.repeatMode = ObjectAnimator.REVERSE
        animator.start()
    }

}