package com.vlamik.core.domain.models

import com.vlamik.core.data.models.RocketDto

data class RocketDetailModel(
    val description: String,
    val height: Double,
    val diameter: Double,
    val mass: Double,
    val firstStage: FirstStageDetailModel,
    val secondStage: SecondStageDetailModel,
    val images: List<String>

)

fun RocketDto.toRocketDetailModel(): RocketDetailModel = RocketDetailModel(
    description = description.orEmpty(),
    height = height?.meters ?: -1.0,
    diameter = diameter?.meters ?: -1.0,
    mass = mass?.kg ?: -1.0,
    firstStage = firstStage.toFirstStageDetailModel(),
    secondStage = secondStage.toSecondStageDetailModel(),
    images = flickrImages.orEmpty()
)
