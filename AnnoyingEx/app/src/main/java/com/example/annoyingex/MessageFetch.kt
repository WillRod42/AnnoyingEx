package com.example.annoyingex

import android.content.Context
import android.widget.Toast
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.android.volley.Request
import com.android.volley.Response
import com.google.gson.Gson


class MessageFetch(context: Context) {
    private val requestQueue = Volley.newRequestQueue(context)
    private val url = "https://raw.githubusercontent.com/echeeUW/codesnippets/master/ex_messages.json"

    fun getMessages(context: Context, onMessagesReady: (Messages) -> Unit) {
        val stringRequest = StringRequest(Request.Method.GET, url,
            Response.Listener { response ->
                val gson = Gson()
                val messages = gson.fromJson(response, Messages::class.java)

                onMessagesReady(messages)
            },
            Response.ErrorListener {
                Toast.makeText(context, "Volley request failed", Toast.LENGTH_SHORT).show()
            })
        requestQueue.add(stringRequest)
    }
}