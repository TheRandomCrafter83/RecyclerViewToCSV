package com.coderz.f1.recyclerviewtocsv.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.coderz.f1.recyclerviewtocsv.databinding.RecyclerPersonItemBinding
import com.coderz.f1.recyclerviewtocsv.models.Person

class PersonRecyclerAdapter :
    ListAdapter<Person,PersonRecyclerAdapter.PersonRecyclerViewHolder>(DiffCallback()) {
    private class DiffCallback : DiffUtil.ItemCallback<Person>() {
        override fun areItemsTheSame(oldItem: Person, newItem: Person) = oldItem.key == newItem.key
        override fun areContentsTheSame(oldItem: Person, newItem: Person) = oldItem.firstName == newItem.firstName
    }

    private lateinit var binding: RecyclerPersonItemBinding

    class PersonRecyclerViewHolder(binding: RecyclerPersonItemBinding) : RecyclerView.ViewHolder(binding.root) {
        //Not really needed unless setting up an onItemClick
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonRecyclerViewHolder {
        binding = RecyclerPersonItemBinding.inflate(LayoutInflater.from(parent.context.applicationContext))
        return PersonRecyclerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PersonRecyclerViewHolder, position: Int) {
        //do something here to display data
        binding.firstName.text = getItem(position).firstName
        binding.lastName.text = getItem(position).lastName
    }

    fun toCSVString():String{
        val builder:StringBuilder = java.lang.StringBuilder()
        builder.appendLine("First Name, Last Name")
        for(person:Person in currentList){
            builder.appendLine(person.toCSVString())
        }
        return builder.toString()
    }


}


