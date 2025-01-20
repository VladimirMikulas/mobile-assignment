package com.vlamik.core.domain.models

import com.vlamik.core.data.models.RocketDto
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

data class RocketListItemModel(
    val id: String,
    val name: String,
    val firstFlight: String
)

fun RocketDto.toRocketListItemModel(): RocketListItemModel = RocketListItemModel(
    id = id.orEmpty(),
    name = name.orEmpty(),
    firstFlight = getFirstFlightDateFormat(firstFlight.orEmpty())
)

fun getFirstFlightDateFormat(date: String): String {
    val formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy")
    return LocalDateTime.parse(date).format(formatter)
}
