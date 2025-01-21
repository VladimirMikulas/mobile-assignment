package com.vlamik.core.domain.models

import com.vlamik.core.data.models.FirstStage

data class FirstStageDetailModel(
    val reusable: Boolean,
    val engines: Int,
    val fuelAmountTons: Double,
    val burnTimeSEC: Int,
)

fun FirstStage.toFirstStageDetailModel(): FirstStageDetailModel = FirstStageDetailModel(
    reusable = reusable ?: false,
    engines = engines?.toInt() ?: -1,
    fuelAmountTons = fuelAmountTons ?: -1.0,
    burnTimeSEC = burnTimeSEC?.toInt() ?: -1
)
