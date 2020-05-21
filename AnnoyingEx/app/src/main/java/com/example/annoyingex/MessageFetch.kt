package com.example.annoyingex

import android.content.Context
import android.widget.Toast
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.android.volley.Request
import com.android.volley.Response
import com.google.gson.Gson


class MessageFetch(private val context: Context) {
    private val requestQueue = Volley.newRequestQueue(context)
    private val url = "https://raw.githubusercontent.com/echeeUW/codesnippets/master/ex_messages.json"

    companion object {
        const val FAILED_REQUEST = "failed request"
    }

    fun getMessages(onMessagesReady: (Messages) -> Unit) {
        val stringRequest = StringRequest(Request.Method.GET, url,
            Response.Listener { response ->
                val gson = Gson()
                val messagesList = gson.fromJson(response, Messages::class.java)

                onMessagesReady(messagesList)
            },
            Response.ErrorListener {
                onMessagesReady(Messages(listOf(FAILED_REQUEST)))
                Toast.makeText(context, "Volley request failed", Toast.LENGTH_SHORT).show()
            })
        requestQueue.add(stringRequest)
    }
}