package com.example.litelist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

private lateinit var todoAdaper: TodoAdapter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        splashButton.setOnClickListener {
            splashButton.setVisibility(View.INVISIBLE)
            splashText.setVisibility(View.INVISIBLE)
            rvTodoItems.setVisibility(View.VISIBLE)
            etTodoTitle.setVisibility(View.VISIBLE)
            btnAddTodo.setVisibility(View.VISIBLE)
            btnDeleteDoneTodos.setVisibility(View.VISIBLE)
            checkoutButton.setVisibility(View.VISIBLE)

        }

        checkoutButton.setOnClickListener {
            val intent = Intent(this, Checkout::class.java)
            startActivity(intent)
        }
        todoAdaper = TodoAdapter(mutableListOf())

        rvTodoItems.adapter = todoAdaper
        rvTodoItems.layoutManager = LinearLayoutManager(this)

        btnAddTodo.setOnClickListener{
            val todoTitle = etTodoTitle.text.toString()
            if(todoTitle.isNotEmpty()) {
                val todo = Todo(todoTitle)
                todoAdaper.addTodo(todo)
                etTodoTitle.text.clear()
            }
        }

        btnDeleteDoneTodos.setOnClickListener{
        todoAdaper.deleteDoneTodos()
        }
    }


}