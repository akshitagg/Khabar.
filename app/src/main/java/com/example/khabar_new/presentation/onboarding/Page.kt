package com.example.khabar_new.presentation.onboarding

import androidx.annotation.DrawableRes
import com.example.khabar_new.R

data class Page(
    val title : String,
    val description : String,
    @DrawableRes val image : Int
)

val pages = listOf(
    Page(
        title = "Overwhelmed by the news cycle?",
        description = "Personalize your news feed and stay up to date with the stories that matter to you!",
        image = R.drawable.onboarding1
    ),
    Page(
        title = "Be the first to know every khabar!",
        description = "Go through the important articles, hand-picked for you.",
        image = R.drawable.onboarding2
    ),
    Page(
        title = "Written, curated and fact checked.",
        description = "We are focused on facts. No opinions, No commentary",
        image = R.drawable.onboarding3
    )
)


