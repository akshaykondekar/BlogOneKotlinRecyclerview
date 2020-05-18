package com.core.blogonekotlinrecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.cv_animal_item.view.*

class AnimalsAdapter(private val animalList : ArrayList<Animal>)
    : RecyclerView.Adapter<AnimalsAdapter.AnimalViewHolder>() {

    private var itemAction: ((Animal) -> Unit)? = null

    fun updateAnimalList(newAnimalList : List<Animal>){
        animalList.clear()
        animalList.addAll(newAnimalList)
        notifyDataSetChanged()
    }

    fun clickedItemAction(action: (Animal) -> Unit) {
        this.itemAction = action
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalViewHolder {
        return AnimalViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.cv_animal_item,parent,false))
    }

    override fun getItemCount() = animalList.size

    override fun onBindViewHolder(holder: AnimalViewHolder, position: Int) {
        val animal : Animal = animalList[position]
        holder.bind(animal)
    }

    inner class AnimalViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        fun bind(animal: Animal) {
            itemView.ivAnimal.setImageResource(animal.image!!)
            itemView.tvAnimalName.text = animal.name!!
            itemView.tvAnimalInfo.text = animal.description!!

            itemAction?.let {
                itemView.setOnClickListener { it(animal) }
            }
        }
    }
}