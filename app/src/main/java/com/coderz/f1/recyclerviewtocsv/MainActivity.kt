package com.coderz.f1.recyclerviewtocsv

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.coderz.f1.recyclerviewtocsv.adapter.PersonRecyclerAdapter
import com.coderz.f1.recyclerviewtocsv.databinding.ActivityMainBinding
import com.coderz.f1.recyclerviewtocsv.models.Person

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter:PersonRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        adapter = PersonRecyclerAdapter()
        adapter.submitList(
            listOf(
                Person("1","John","doe"),
                Person("2","Jane","doe")
            )
        )
        binding.recyclerView.adapter = adapter
        binding.generateCSV.setOnClickListener(generateCSVListener)
    }

    private val generateCSVListener: View.OnClickListener = View.OnClickListener {
        val builder:AlertDialog.Builder = AlertDialog.Builder(this)
        builder.setTitle(getString(R.string.app_name))
        builder.setMessage(adapter.toCSVString())
        builder.setCancelable(true)
        builder.create().show()
    }
}