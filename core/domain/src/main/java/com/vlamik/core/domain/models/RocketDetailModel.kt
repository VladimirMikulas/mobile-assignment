package com.vlamik.core.domain.models

import com.vlamik.core.data.models.RocketDto

data class RocketDetailModel(
    val description: String,
    val height: Int,
    val diameter: Int,
    val mass: Int,
    val firstStage: FirstStageDetailModel,
    val secondStage: SecondStageDetailModel,
    val images: List<String>

)

fun RocketDto.toRocketDetailModel(): RocketDetailModel = RocketDetailModel(
    description = description.orEmpty(),
    height = height?.meters?.toInt() ?: -1,
    diameter = diameter?.meters?.toInt() ?: -1,
    mass = mass?.kg?.toInt() ?: -1,
    firstStage = firstStage.toFirstStageDetailModel(),
    secondStage = secondStage.toSecondStageDetailModel(),
    images = flickrImages.orEmpty()
)
