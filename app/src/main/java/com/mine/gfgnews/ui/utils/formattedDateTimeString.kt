package com.mine.gfgnews.ui.utils

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeFormatterBuilder
import java.time.format.TextStyle
import java.time.temporal.ChronoField
import java.util.Locale


val outputFormat = "dd MMMM yyyy, HH:mm:ss"


fun formatDateFromString(inputDateTime: String): String {
    val inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
    val outputFormatter = DateTimeFormatterBuilder()
        .appendText(ChronoField.MONTH_OF_YEAR, TextStyle.SHORT)
        .appendLiteral(" ")
        .appendValue(ChronoField.DAY_OF_MONTH,2)
        .appendLiteral(", ")
        .appendValue(ChronoField.YEAR)
        .appendLiteral(" ")
        .appendLiteral("| ")
        .appendValue(ChronoField.CLOCK_HOUR_OF_AMPM,2)
        .appendLiteral(":")
        .appendValue(ChronoField.MINUTE_OF_HOUR,2)
        .appendLiteral(" ")
        .appendText(ChronoField.AMPM_OF_DAY, TextStyle.SHORT)
        .toFormatter(Locale.ENGLISH)

    val dateTime: LocalDateTime = LocalDateTime.parse(inputDateTime, inputFormatter)
    return outputFormatter.format(dateTime)
}