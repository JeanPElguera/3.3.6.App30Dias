package com.example.app30dias.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

class Game (
    val diaRes: Int,
    @StringRes val nameRes: Int,
    @StringRes val descriptionRes: Int,
    @DrawableRes val imageRes: Int,
    @DrawableRes val gameImage: Int,
    val rating: Float,
)