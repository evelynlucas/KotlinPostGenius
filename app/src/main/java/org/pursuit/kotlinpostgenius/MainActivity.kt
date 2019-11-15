package org.pursuit.kotlinpostgenius

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.VERTICAL
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import org.pursuit.kotlinpostgenius.model.DataWrapper
import org.pursuit.kotlinpostgenius.model.UserInfo
import org.pursuit.kotlinpostgenius.network.RetrofitSingleton
import org.pursuit.kotlinpostgenius.network.UserService
import org.pursuit.kotlinpostgenius.recyclerview.UserAdapter

class MainActivity : AppCompatActivity() {

    lateinit var textView: TextView
    var disposable: Disposable? = null
    val users: ArrayList<UserInfo> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView = findViewById(R.id.trial_textview)
        createUser()



    }

    private fun createUser() {
        val userInfo: UserInfo = UserInfo(
            0,
            "Mo", "mo.jpg"
        )

        //THIS IS POST REQUEST
//        disposable =
//            RetrofitSingleton.getInstance()
//                ?.create(UserService::class.java)
//                ?.createUser(userInfo)
//                ?.subscribeOn(Schedulers.io())
//                ?.observeOn(AndroidSchedulers.mainThread())
//                ?.subscribe(
//                    {
//                        val userInfo: UserInfo = it
//                        textView.setText(userInfo.first_name)
//                    },
//                    { callError()})

// THIS IS GET REQUEST
        disposable =
        RetrofitSingleton.getInstance()
            ?.create(UserService::class.java)
            ?.getUsers()
            ?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.map { it -> it.data }
            ?.subscribe(
                {
//                    val dataWrapper: DataWrapper = it
//                val userInfo: UserInfo = dataWrapper.data.get(0)
//                textView.setText(userInfo.first_name)
                    for (user in it) {
                        users.add(user)
                    }
                    Log.d("LISTSIZE", "size=" + users.size)
                    val rv = findViewById<RecyclerView>(R.id.recyclerview)
                    rv.layoutManager = LinearLayoutManager(this, VERTICAL, false)
                    var adapter = UserAdapter(users)
                    rv.adapter = adapter
            },
                { t -> Log.d("ERRORTAG", t.localizedMessage)})

    }

    private fun callError() {
        Log.d("ERRORTAG", "this is error")
    }
}
