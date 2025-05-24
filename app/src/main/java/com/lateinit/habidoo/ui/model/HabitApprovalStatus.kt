package com.lateinit.habidoo.ui.model

import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import com.lateinit.habidoo.R

enum class HabitApprovalStatus(@DrawableRes val icon: Int, @ColorRes val tint: Int) {
    PENDING(R.drawable.round_pending_actions_24, R.color.pending_status_tint),
    APPROVED(R.drawable.round_check_circle_24, R.color.approved_status_tint),
    REJECTED(R.drawable.round_cancel_24, R.color.rejected_status_tint);
}
