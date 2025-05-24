package com.lateinit.habidoo.ui.model

import com.lateinit.habidoo.utils.StringUtils.emptyString

data class Habit(
    var name: String = emptyString(),
    var habitApprovalStatus: HabitApprovalStatus = HabitApprovalStatus.PENDING,
    var habitProgressStatus: HabitProgressStatus = HabitProgressStatus()
)
