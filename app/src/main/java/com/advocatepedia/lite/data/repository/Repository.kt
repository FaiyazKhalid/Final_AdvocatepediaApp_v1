package com.advocatepedia.lite.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

interface Repository {
    val dataStatus: StateFlow<Status>
    /**
     * Single source of truth for the "today" response
     */
    val data: Flow<Any>
    enum class Status { Error, Success, Loading }
}