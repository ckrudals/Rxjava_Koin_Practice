package com.example.rxpra

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rxpra.data.repository.UserRepositoryImpl
import com.example.rxpra.dto.UserResponse
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.core.SingleObserver
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.observers.DisposableCompletableObserver
import io.reactivex.rxjava3.observers.DisposableSingleObserver
import io.reactivex.rxjava3.schedulers.Schedulers

class ViewModel(private val userRepositoryImpl: UserRepositoryImpl) : ViewModel() {

    private val compositeDisposable = CompositeDisposable()

    private val _text = MutableLiveData<String>()
    val text: LiveData<String> get() = _text

    suspend fun writeText(name: String, projectName: String) {
        addDisposable(userRepositoryImpl.getUser(name, projectName)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                Log.d("TAG", "writeText: $it")
            }, {

            })
        )


    }


    fun addDisposable(disposable: Disposable) {
        compositeDisposable.add(disposable)
    }


}