package org.pursuit.kotlinpostgenius

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import org.pursuit.kotlinpostgenius.model.DataWrapper
import org.pursuit.kotlinpostgenius.model.UserInfo
import org.pursuit.kotlinpostgenius.network.RetrofitSingleton
import org.pursuit.kotlinpostgenius.network.UserService

class MainActivity : AppCompatActivity() {

    lateinit var textView: TextView
    var disposable: Disposable? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView = findViewById(R.id.trial_textview)
        createUser()
    }

    private fun createUser() {
        val userInfo: UserInfo = UserInfo(
            0,
            "me@me.com", "mo", "Syzlak", "mo.jpg"
        )

//        disposable =
//            wikiApiServe.hitCountCheck("query", "json", "search", srsearch)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(
//                    { result -> showResult(result.query.searchinfo.totalhits) },
//                    { error -> showError(error.message) }
//                )

        disposable =
        RetrofitSingleton.getInstance()
            ?.create(UserService::class.java)
            ?.createUser(userInfo)
            ?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.subscribe(
                {
                    val dataWrapper: DataWrapper = it
                val userInfo: UserInfo = dataWrapper.data.get(0)
                textView.setText(userInfo.first_name)
            },
                { callError()})

    }

    private fun callError() {
        Log.d("ERRORTAG", "this is error")
    }
}
