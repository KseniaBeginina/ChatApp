package com.beginina.chatapp.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp
import com.beginina.chatapp.R

val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily(Font(R.font.montserrat_regular)),
        fontSize = 16.sp,
        lineHeight = 24.sp
    )
)

val h1 = TextStyle(
    fontFamily = FontFamily(Font(R.font.montserrat_medium)),
    fontSize = 24.sp,
    lineHeight = 24.sp
)
val h2 = TextStyle(
    fontFamily = FontFamily(Font(R.font.montserrat_medium)),
    fontSize = 18.sp,
    lineHeight = 24.sp
)
val b1 = TextStyle(
    fontFamily = FontFamily(Font(R.font.montserrat_regular)),
    fontSize = 16.sp,
    lineHeight = 24.sp
)
val subtitle = TextStyle(
    fontFamily = FontFamily(Font(R.font.montserrat_medium)),
    fontSize = 14.sp,
    lineHeight = 24.sp
)
val button = TextStyle(
    fontFamily = FontFamily(Font(R.font.montserrat_semibold)),
    fontSize = 16.sp,
    lineHeight = 24.sp
)
val bottomBar = TextStyle(
    fontFamily = FontFamily(Font(R.font.montserrat_semibold)),
    fontSize = 12.sp,
    lineHeight = 24.sp
)
val logo = TextStyle(
    fontFamily = FontFamily(Font(R.font.montserrat_bold)),
    fontSize = 36.sp,
    lineHeight = 24.sp
)