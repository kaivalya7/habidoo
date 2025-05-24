package com.lateinit.habidoo.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lateinit.habidoo.R
import com.lateinit.habidoo.ui.model.Habit
import com.lateinit.habidoo.ui.model.HabitApprovalStatus
import com.lateinit.habidoo.ui.model.HabitProgressStatus
import com.lateinit.habidoo.ui.theme.HabidooTheme

@Composable
fun HabitStateItem(modifier: Modifier = Modifier, habit: Habit) {
    Row(modifier = modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        Row(horizontalArrangement = Arrangement.Start) {
            val approvalStatus = habit.habitApprovalStatus
            Icon(
                modifier = modifier.padding(4.dp),
                painter = painterResource(id = approvalStatus.icon),
                contentDescription = null,
                tint = colorResource(id = approvalStatus.tint)
            )
            Text(modifier = modifier.padding(4.dp), text = habit.name, textAlign = TextAlign.Start)
        }
        Spacer(Modifier.weight(1f))
        Text(
            modifier = modifier.padding(4.dp),
            text = getProgressStatusText(habit.habitProgressStatus, stringResource(R.string.habit_progress_status_separator)),
            textAlign = TextAlign.Start
        )
    }
}

private fun getProgressStatusText(progressStatus: HabitProgressStatus, separator: String): String =
    progressStatus.done.toString() + separator + progressStatus.total.toString()

@Preview
@Composable
private fun HabitStateItemPreview() {
    HabidooTheme {
        HabitStateItem(
            habit = Habit(
                name = "Drink Water",
                habitApprovalStatus = HabitApprovalStatus.PENDING,
                habitProgressStatus = HabitProgressStatus(done = 5, total = 10)
            )
        )
    }
}
