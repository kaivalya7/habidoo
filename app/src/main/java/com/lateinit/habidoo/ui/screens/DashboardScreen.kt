package com.lateinit.habidoo.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lateinit.habidoo.R
import com.lateinit.habidoo.ui.components.HabitStatsCard
import com.lateinit.habidoo.ui.model.Habit
import com.lateinit.habidoo.ui.model.HabitApprovalStatus
import com.lateinit.habidoo.ui.model.HabitProgressStatus
import com.lateinit.habidoo.ui.model.UserHabits
import com.lateinit.habidoo.ui.theme.HabidooTheme

/**
 * DashboardScreen is the main dashboard screen of the Habidoo app.
 * It shows an overview of the user's habits, statistics, and quick actions.
 *
 * @param modifier Modifier to be applied to the screen.
 */
@Composable
fun DashboardScreen(modifier: Modifier = Modifier) {
    Scaffold(
        topBar = { DashboardTopBar() },
        content = { innerPadding ->
            DashboardScreenContent(modifier = modifier.padding(innerPadding))
        },
        bottomBar = { DashboardBottomBar() }
    )
}

@Composable
fun DashboardTopBar(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            modifier = Modifier.padding(4.dp),
            text = stringResource(R.string.app_name),
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.SemiBold,
            letterSpacing = 1.5.sp,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
        Icon(
            modifier = Modifier
                .size(48.dp)
                .padding(8.dp),
            painter = painterResource(R.drawable.round_settings_24),
            contentDescription = null
        )
    }
}

@Composable
fun DashboardScreenContent(modifier: Modifier = Modifier) {
    // TODO: Replace with actual user data retrieval logic
    HabitStatsCard(
        modifier = modifier.padding(8.dp),
        userHabits = UserHabits(
            userName = "John Doe",
            habits = listOf(
                Habit(
                    name = "Drink Water",
                    habitApprovalStatus = HabitApprovalStatus.PENDING,
                    habitProgressStatus = HabitProgressStatus(done = 5, total = 10)
                ),
                Habit(
                    name = "Exercise",
                    habitApprovalStatus = HabitApprovalStatus.APPROVED,
                    habitProgressStatus = HabitProgressStatus(done = 3, total = 5)
                ),
                Habit(
                    name = "Play Guitar",
                    habitApprovalStatus = HabitApprovalStatus.REJECTED,
                    habitProgressStatus = HabitProgressStatus(done = 2, total = 4)
                ),
            )
        )
    )
}

@Composable
fun DashboardBottomBar(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(12.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Icon(
            modifier = Modifier
                .size(48.dp)
                .padding(8.dp),
            painter = painterResource(R.drawable.round_playlist_add_24),
            contentDescription = null
        )
        Icon(
            modifier = Modifier
                .size(48.dp)
                .padding(8.dp),
            painter = painterResource(R.drawable.round_notifications_none_24),
            contentDescription = null
        )
        Icon(
            modifier = Modifier
                .size(48.dp)
                .padding(8.dp),
            painter = painterResource(R.drawable.round_pending_actions_24),
            contentDescription = null
        )
    }
}

@Preview
@Composable
private fun DashboardScreenPreview() {
    HabidooTheme {
        DashboardScreen()
    }
}
