package com.beginina.chatapp.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.beginina.chatapp.R
import com.beginina.chatapp.ui.theme.Black
import com.beginina.chatapp.ui.theme.LightGray
import com.beginina.chatapp.ui.theme.MiddleGrayLight

@Composable
fun PhotoEditComponent() {
    Box(
        modifier = Modifier
            .size(72.dp)
            .clickable {
                //TODO choose camera or galery
            }
    ) {
//            AsyncImage(
//                modifier = Modifier
//                    .size(72.dp)
//                    .clip(CircleShape),
//                model =  ImageRequest.Builder(context).data().build(),
//                contentScale = ContentScale.Crop,
//                contentDescription = null,
//            )
        Image(
            modifier = Modifier
                .size(72.dp)
                .clip(CircleShape)
                .background(LightGray),
            painter = painterResource(R.drawable.photo_profile_default),
            contentDescription = null
        )
        Box(
            modifier = Modifier
                .size(24.dp)
                .align(Alignment.TopEnd)
                .clip(CircleShape)
                .background(LightGray)
                .border(1.dp, MiddleGrayLight, CircleShape),
            contentAlignment = Alignment.Center
        ){
            Icon(
                modifier = Modifier.size(12.dp),
                painter = painterResource(id = R.drawable.edit),
                contentDescription = null,
                tint = Black
            )
        }
    }
}

@Preview (showBackground = true)
@Composable
private fun CheckPhotoEdit() {
    PhotoEditComponent()
}