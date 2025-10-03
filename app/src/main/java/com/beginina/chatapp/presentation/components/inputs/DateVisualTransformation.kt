package com.beginina.chatapp.presentation.components.inputs

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation

class DateVisualTransformation : VisualTransformation{
    //date mask: XX.XX.XXXX
    override fun filter(text: AnnotatedString): TransformedText {
        val digits = text.text.filter { it.isDigit() }
        val formatted = StringBuilder()

        for (i in digits.indices) {
            if (i == 2 || i == 4) {
                formatted.append(".")
            }
            formatted.append(digits[i])
        }

        val formattedText = formatted.toString()
        val maxTransformed = formattedText.length

        val offsetMapping = object : OffsetMapping {
            override fun originalToTransformed(offset: Int): Int {
                val mapped = when {
                    offset <= 2 -> offset
                    offset <= 4 -> offset + 1
                    else -> offset + 2
                }
                return mapped.coerceAtMost(maxTransformed)
            }

            override fun transformedToOriginal(offset: Int): Int {
                return when {
                    offset <= 2 -> offset
                    offset <= 5 -> offset - 1
                    else -> offset - 2
                }.coerceAtLeast(0)
            }
        }

        return TransformedText(AnnotatedString(formatted.toString()), offsetMapping)
    }
}