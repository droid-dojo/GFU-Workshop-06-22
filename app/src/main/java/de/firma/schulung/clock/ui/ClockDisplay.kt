package de.firma.schulung.clock.ui

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.unit.sp
import de.firma.schulung.clock.ObservableClock
import java.util.*

@Composable
fun ClockDisplay() {

    val time = ObservableClock().observeTime().collectAsState(initial = Date(0)).value

    Text(text = "The current Time is: $time", fontSize = 20.sp)

}