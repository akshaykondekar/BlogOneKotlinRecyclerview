package com.core.blogonekotlinrecyclerview

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private val animalsAdapter = AnimalsAdapter(arrayListOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.title = "Animals"

        val a1 = Animal("Bear", R.drawable.beer,"Bears are large mammals that eat mostly meat, with the exception of panda bears which are herbivores and live also entirely on bamboo.")
        val a2 = Animal("Cat", R.drawable.cat,"Cats, also called domestic cats (Felis catus), are small, carnivorous (meat-eating) mammals, of the family Felidae. Domestic cats are often called house cats when kept as indoor pets.")
        val a3 = Animal("Dog", R.drawable.dog,"Dogs (Canis lupus familiaris) are domesticated mammals, not natural wild animals. They were originally bred from wolves. They have been bred by humans for a long time, and were the first animals ever to be domesticated. There are different studies that suggest that this happened between 15.000 and 100.000 years before our time.")
        val a4 = Animal("Deer", R.drawable.deer,"The deer (singular and plural) are a group of even-toed ungulate mammals.[1] They form the family Cervidae. A male deer is called a stag or buck, a female deer is called a doe or hind, and a young deer is called a fawn, kid or calf.")
        val a5 = Animal("Elephant", R.drawable.elephant,"Elephants are the largest land animals on Earth, and they're one of the most unique-looking animals, too. With their characteristic long noses, or trunks; large, floppy ears; and wide, thick legs, there is no other animal with a similar physique.")
        val a6 = Animal("Jaguar", R.drawable.jaguar,"One of the big cats, jaguar’s are solitary animals, usually hunting at night, they often drag their food up trees for safe keeping, they love to swim and roam the rainforests of Central and South America.")
        val a7 = Animal("Lion", R.drawable.lion,"The lion (Panthera leo) is a large mammal of the Felidae (cat) family. Some large males weigh over 250 kg (550 lb). Today, wild lions live in sub-Saharan Africa and in Asia. Lions are adapted for life in grasslands and mixed areas with trees and grass.")
        val a8 = Animal("Tiger", R.drawable.tiger,"The tiger (Panthera tigris) is the largest extant cat species and a member of the genus Panthera. It is most recognisable for its dark vertical stripes on orange-brown fur with a lighter underside.")

        val animalList : ArrayList<Animal> = arrayListOf(a1,a2,a3,a4,a5,a6,a7,a8)

        val itemDecoration = ItemOffsetDecoration(this@MainActivity, R.dimen.item_offset)

        rvAnimals.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@MainActivity,
                LinearLayoutManager.VERTICAL,false)
            addItemDecoration(itemDecoration)
            adapter = animalsAdapter
        }
        animalList.let {
            animalsAdapter.updateAnimalList(it)
        }

        animalsAdapter.clickedItemAction {
            Toast.makeText(this@MainActivity,it.name,Toast.LENGTH_SHORT).show()
        }
    }
}