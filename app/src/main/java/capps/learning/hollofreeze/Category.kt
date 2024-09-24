package capps.learning.hollofreeze

import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes

data class Category(var name: String, @DrawableRes var icon: Int, @ColorRes var color: Int)
