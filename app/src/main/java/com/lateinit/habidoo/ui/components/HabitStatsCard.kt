package com.lateinit.habidoo.ui.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lateinit.habidoo.R
import com.lateinit.habidoo.ui.model.Habit
import com.lateinit.habidoo.ui.model.HabitApprovalStatus
import com.lateinit.habidoo.ui.model.HabitProgressStatus
import com.lateinit.habidoo.ui.model.UserHabits
import com.lateinit.habidoo.ui.theme.HabidooTheme
import java.time.LocalDate
import java.time.format.DateTimeFormatter

/**
 * HabitStatsCard is a reusable composable function that represents a card displaying statistics
 * of a user's habits. It can be used in the dashboard or habit detail screens to provide users
 * with insights into their habit performance.
 *
 * @param modifier Modifier to be applied to the card.
 */
@Composable
fun HabitStatsCard(modifier: Modifier = Modifier, userHabits: UserHabits) {
    Card(
        modifier = modifier
            .padding(8.dp)
            .border(1.dp, MaterialTheme.colorScheme.onBackground, RoundedCornerShape(12.dp)),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 16.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = getDateString(),
            )
            Text(
                text = userHabits.userName,
                fontWeight = FontWeight.SemiBold
            )

            // TODO: Calendar icon should be clickable to open a date picker or calendar view in V2
            Icon(
                painter = painterResource(id = R.drawable.round_calendar_month_24),
                contentDescription = null,
                modifier = Modifier.padding(4.dp)
            )
        }
        LazyColumn(modifier = Modifier.padding(4.dp)) {
            items(items = userHabits.habits) { habit ->
                HabitStateItem(habit = habit)
            }
        }
    }
}

private fun getDateString(): String {
    // TODO: Get today's date for now, will be replaced with actual date-wise habit data logic in V2
    val currentDate = LocalDate.now()
    val formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")
    return currentDate.format(formatter)
}

@Preview
@Composable
private fun HabitStatsCardPreview() {
    HabidooTheme {
        HabitStatsCard(
            userHabits = UserHabits(
                userName = "John Doe",
                habits = listOf(
                    Habit(
                        name = "Drink Water",
                        habitApprovalStatus = HabitApprovalStatus.APPROVED,
                        habitProgressStatus = HabitProgressStatus(done = 5, total = 10)
                    ),
                    Habit(
                        name = "Exercise",
                        habitApprovalStatus = HabitApprovalStatus.PENDING,
                        habitProgressStatus = HabitProgressStatus(done = 2, total = 5)
                    )
                )
            )
        )
    }
}
