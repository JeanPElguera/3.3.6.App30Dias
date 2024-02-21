package com.example.app30dias

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.app30dias.model.Game
import com.example.app30dias.ui.theme.App30DiasTheme


@Composable
fun GameItem(
    game: Game,
    modifier: Modifier = Modifier
)
{
    var expanded by remember { mutableStateOf(false) }
    val color by animateColorAsState(
        targetValue = if (expanded) MaterialTheme.colorScheme.tertiaryContainer
        else MaterialTheme.colorScheme.primaryContainer,
        label = "",
    )

    Card(modifier = modifier) {
        Column(
            modifier = Modifier
                .animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioHighBouncy,
                        stiffness = Spring.StiffnessMedium
                    )
                ).background(color = color)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(dimensionResource(R.dimen.padding_small))
            ) {
                GameInformation(game.diaRes, game.nameRes)
                Spacer(modifier = Modifier.weight(1f))
                GameItemButton(expanded = expanded, onClick = { expanded = !expanded })
            }
            GameIcon(
                game.imageRes,
                onClick = { expanded = !expanded },
                modifier = Modifier.padding(dimensionResource(R.dimen.padding_medium))
            )
            if (expanded) {
                GameDes(
                    game.descriptionRes,
                    game.gameImage ,
                    gameRating = game.rating,
                    modifier = Modifier.padding(
                        start = dimensionResource(R.dimen.padding_medium),
                        top = dimensionResource(R.dimen.padding_small),
                        end = dimensionResource(R.dimen.padding_medium),
                        bottom = dimensionResource(R.dimen.padding_medium)
                    )
                )
            }

        }
    }
}


@Composable
private fun GameItemButton(
    expanded: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
){
    IconButton(
        onClick = onClick,
        modifier = modifier
    ) {
        Icon(
            imageVector = if (expanded) Icons.Filled.ExpandLess
            else Icons.Filled.ExpandMore,
            contentDescription = stringResource(R.string.expand_button_content_description),
            tint = MaterialTheme.colorScheme.secondary
        )
    }
}

@Composable
fun GameDes(
    @StringRes gameHobby: Int,
    @DrawableRes gameImage: Int,
    gameRating: Float,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        Text(
            text = stringResource(R.string.about),
            style = MaterialTheme.typography.labelSmall
        )
        Spacer(modifier = Modifier.height(dimensionResource(R.dimen.spacer_small)))
        Text(
            text = stringResource(gameHobby),
            style = MaterialTheme.typography.bodyLarge
        )
        Spacer(modifier = Modifier.height(dimensionResource(R.dimen.spacer_small)))

        RatingBar(gameRating = gameRating)
        Spacer(modifier = Modifier.height(dimensionResource(R.dimen.spacer_medium)))
        Image(
            modifier = Modifier
                .padding(dimensionResource(R.dimen.padding_small))
                .width(dimensionResource(R.dimen.imageWidth))
                .height(dimensionResource(R.dimen.imageHeight))
                .clip(MaterialTheme.shapes.medium),

            contentScale = ContentScale.FillWidth,
            painter = painterResource(gameImage),
            contentDescription = null,
            alignment = Alignment.Center
        )
    }
}

@Composable
fun RatingBar(gameRating: Float) {
    Row {
        for (i in 1..5) {
            Icon(
                imageVector = if (i <= gameRating) Icons.Filled.Star else Icons.Outlined.Star,
                contentDescription = null,
                modifier = Modifier.padding(end = dimensionResource(R.dimen.padding_small)),
                tint = if (i <= gameRating) Color.Yellow else Color.Gray
            )
        }
    }
}

@Composable
fun GameIcon(
    @DrawableRes gameIcon: Int,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Image(
        modifier = modifier
            .clickable(onClick = onClick)
            .padding(dimensionResource(R.dimen.padding_small))
            .width(dimensionResource(R.dimen.imageWidth))
            .height(dimensionResource(R.dimen.imageHeight))
            .clip(MaterialTheme.shapes.medium),

        contentScale = ContentScale.FillWidth,
        painter = painterResource(gameIcon),
        contentDescription = null,
        alignment = Alignment.Center
    )
}




@Composable
fun GameInformation(
    gameDayNumber: Int,
    @StringRes gameName: Int,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {

        Text(
            text = stringResource(id = R.string.day, gameDayNumber),
            style = MaterialTheme.typography.displayMedium,
            modifier = Modifier.padding(top = dimensionResource(R.dimen.padding_small))
        )
        Text(
            text = stringResource(gameName)
        )
    }
}

@Preview
@Composable
fun DiasPreview() {
    App30DiasTheme(darkTheme = false) {
        GamesApp()
    }
}
@Preview
@Composable
fun DiasPreviewThemeDark(){
    App30DiasTheme(darkTheme = true) {
        GamesApp()
    }
}