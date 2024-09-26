package capps.learning.hollofreeze

import androidx.annotation.DrawableRes

data class Item(
    var name: String,
    var description: String,
    var amount: Double,
    @DrawableRes var imageRes: Int
)
