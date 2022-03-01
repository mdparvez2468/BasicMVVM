package com.example.basicmvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.basicmvvm.viewmodels.MainViewModel
import com.example.basicmvvm.viewmodels.MainViewModelFactory
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    private val textView: TextView
    get() = findViewById(R.id.t1)

    @Inject
    lateinit var mainViewModelFactory: MainViewModelFactory
    lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (application as FakerApplication).applicationComponent.inject(this)

        mainViewModel = ViewModelProvider(this, mainViewModelFactory).get(MainViewModel::class.java)

        mainViewModel.productLiveData.observe(this, Observer {
            textView.text = it.joinToString {
                x -> "ID: "+ x.id+"\nTitle: "+ x.title+"Description: "+ x.description + "\n\n"
            }
        })


    }
}