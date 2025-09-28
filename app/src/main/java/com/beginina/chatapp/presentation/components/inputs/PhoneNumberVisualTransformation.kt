package com.beginina.chatapp.presentation.components.inputs

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation

class PhoneNumberVisualTransformation : VisualTransformation{
    //phone mask: +X(XXX)XXX-XX-XX
    override fun filter(text: AnnotatedString): TransformedText {
        val digits = text.text.filter { it.isDigit() }
        val formatted = StringBuilder()

        for (i in digits.indices) {
            when (i) {
                0 -> formatted.append("+")
                1 -> formatted.append("(")
                4 -> formatted.append(")")
                7 -> formatted.append("-")
                9 -> formatted.append("-")
            }
            formatted.append(digits[i])
        }

        val formattedText = formatted.toString()
        val maxTransformed = formattedText.length

        val offsetMapping = object : OffsetMapping {
            override fun originalToTransformed(offset: Int): Int {
                val mapped = when {
                    offset == 0 -> offset + 1 // +
                    offset <= 1 -> offset + 2 // +X(
                    offset <= 4 -> offset + 3 // +X(XXX)
                    offset <= 7 -> offset + 4 // +X(XXX)XXX-
                    offset <= 9 -> offset + 5 // +X(XXX)XXX-XX-
                    else -> offset + 6
                }
                return mapped.coerceAtMost(maxTransformed)
            }

            override fun transformedToOriginal(offset: Int): Int {
                return when {
                    offset <= 1 -> 0
                    offset <= 3 -> offset - 1
                    offset <= 7 -> offset - 2
                    offset <= 11 -> offset - 3
                    offset <= 14 -> offset - 4
                    else -> offset - 5
                }.coerceAtLeast(0)
            }
        }

        return TransformedText(AnnotatedString(formatted.toString()), offsetMapping)
    }
}