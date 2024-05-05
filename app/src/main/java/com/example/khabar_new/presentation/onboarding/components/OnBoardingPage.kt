package com.example.khabar_new.presentation.onboarding.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.khabar_new.R
import com.example.khabar_new.presentation.Dimensions.HorizPadding
import com.example.khabar_new.presentation.Dimensions.SpacerPadding
import com.example.khabar_new.presentation.Dimensions.VertiPadding
import com.example.khabar_new.presentation.onboarding.Page
import com.example.khabar_new.presentation.onboarding.pages

@Composable
fun OnboardingPage(
    page: Page
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Image(
            painterResource(id = page.image),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.6f),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(SpacerPadding))

        Text(
            text = page.title,
            modifier = Modifier.padding(horizontal = HorizPadding, vertical = VertiPadding),
            style = MaterialTheme.typography.displaySmall.copy(fontWeight = FontWeight.Bold),
            color = colorResource(id = R.color.display_small)
        )

        Text(
            text = page.description,
            modifier = Modifier.padding(horizontal = HorizPadding),
            color = colorResource(id = R.color.text_medium),
            style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.SemiBold)
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewItem() {
    OnboardingPage(page = pages[1])
}
