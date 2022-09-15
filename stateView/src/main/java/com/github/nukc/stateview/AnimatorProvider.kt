package com.github.nukc.stateview

import android.animation.Animator
import android.view.View


interface AnimatorProvider {
    fun showAnimation(view: View): Animator?

    fun hideAnimation(view: View): Animator?
}