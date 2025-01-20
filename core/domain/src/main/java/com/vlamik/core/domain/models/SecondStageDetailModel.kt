package com.vlamik.core.domain.models

import com.vlamik.core.data.models.SecondStage

data class SecondStageDetailModel(
    val reusable: Boolean,
    val engines: Int,
    val fuelAmountTons: Int,
    val burnTimeSEC: Int,
)

fun SecondStage.toSecondStageDetailModel(): SecondStageDetailModel = SecondStageDetailModel(
    reusable = reusable ?: false,
    engines = engines?.toInt() ?: -1,
    fuelAmountTons = fuelAmountTons?.toInt() ?: -1,
    burnTimeSEC = burnTimeSEC?.toInt() ?: -1
)
