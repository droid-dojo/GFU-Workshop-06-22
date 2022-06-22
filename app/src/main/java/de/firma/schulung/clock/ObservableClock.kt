package de.firma.schulung.clock

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.util.*

class ObservableClock {
    fun observeTime(): Flow<Date> {
        return flow {
            while (true) {
                emit(Calendar.getInstance().time)
                delay(1_000)
            }
        }
    }
}