package com.incrowdsports.task.data

import com.incrowdsports.task.data.models.FixtureDetails
import com.incrowdsports.task.data.models.NetworkResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface FixtureDetailsService {

    @GET("matches/{feedMatchId}")
    suspend fun getFixtureDetails(
        @Path("feedMatchId") feedMatchId: Long,
    ): NetworkResponse<FixtureDetails>

}