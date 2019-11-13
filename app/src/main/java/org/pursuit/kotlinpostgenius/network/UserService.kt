package org.pursuit.kotlinpostgenius.network

import io.reactivex.Single
import org.pursuit.kotlinpostgenius.model.DataWrapper
import org.pursuit.kotlinpostgenius.model.UserInfo
import retrofit2.http.Body
import retrofit2.http.POST

private const val ENDPOINT_URL = "users"

interface UserService {

    @POST(ENDPOINT_URL)
    fun createUser(@Body userInfo: UserInfo): Single<DataWrapper>
}