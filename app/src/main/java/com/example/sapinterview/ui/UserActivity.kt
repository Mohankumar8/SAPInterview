package com.example.sapinterview.ui

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sapinterview.R
import com.example.sapinterview.data.entities.User
import com.example.sapinterview.di.Injector
import kotlinx.android.synthetic.main.activity_main.*

class UserActivity : AppCompatActivity() {

    private val userList = mutableListOf<User>()
    lateinit var adapter: UserAdapter

    private val viewModel: UserViewModel by lazy {
        ViewModelProvider(this,Injector.get().viewModelFactory())
            .get(UserViewModel::class.java)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRecyclerView()
        observeSuccess()
        observeFailure()
        observeLoading()
    }

    private fun initRecyclerView() {
        adapter = UserAdapter(userList)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun observeSuccess() {
        viewModel.user.observe(this, Observer {
            userList.addAll(it)
            adapter.notifyDataSetChanged()
        })
    }

    private fun observeFailure() {
        viewModel.error.observe(this, Observer {
            Toast.makeText(this, it, Toast.LENGTH_LONG).show()
        })
    }

    private fun observeLoading() {
        viewModel.isLoading.observe(this) { isLoading ->
            if (isLoading) {
                progressBar.visibility = View.VISIBLE
            } else {
                progressBar.visibility = View.GONE
            }
        }
    }
}