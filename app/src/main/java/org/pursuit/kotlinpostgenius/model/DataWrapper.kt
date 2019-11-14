package org.pursuit.kotlinpostgenius.model

data class DataWrapper(val data: List<UserInfo>)

data class UserInfo(val id: Int,
                    val email: String,
                    val first_name: String,
                    val last_name: String,
                    val avatar: String)
