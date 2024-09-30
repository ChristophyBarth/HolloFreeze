package capps.learning.hollofreeze

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import capps.learning.hollofreeze.databinding.FragmentHomeBinding

@SuppressLint("NotifyDataSetChanged")
class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var categoryAdapter: CategoryAdapter
    private lateinit var listOfCategories: MutableList<Category>

    private lateinit var itemCollectionAdapter: ItemCollectionAdapter
    private lateinit var listOfItems: MutableList<Item>

    private lateinit var listOfBags: MutableList<Item>
    private lateinit var listOfShoes: MutableList<Item>
    private lateinit var listOfJewelries: MutableList<Item>
    private lateinit var listOfTees: MutableList<Item>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bagCategory = Category("Bags", R.drawable.ic_bag, R.color.ourPrimaryColor)
        val shoeCategory = Category("Shoes", R.drawable.ic_shoe, android.R.color.holo_blue_light)
        val jewelryCategory =
            Category("Jewelries", R.drawable.ic_jewelry, android.R.color.holo_orange_light)
        val teeCategory = Category("Tees", R.drawable.ic_shirt, android.R.color.holo_green_dark)

        listOfCategories = mutableListOf()
        listOfCategories.add(bagCategory)
        listOfCategories.add(shoeCategory)
        listOfCategories.add(jewelryCategory)
        listOfCategories.add(teeCategory)

        listOfBags = mutableListOf(Item(
            name = "Classic Leather Tote",
            description = "A timeless leather tote bag with ample space for daily essentials. Durable and stylish for every occasion.",
            amount = 79.99,
            imageRes = R.drawable.ic_bag
        ),
            Item(
                name = "Canvas Weekend Bag",
                description = "Spacious and lightweight, this canvas weekend bag is perfect for short trips. Features multiple compartments.",
                amount = 59.49,
                imageRes = R.drawable.ic_bag
            ),
            Item(
                name = "Minimalist Backpack",
                description = "A sleek and modern backpack with padded straps and laptop compartment. Ideal for work or travel.",
                amount = 49.99,
                imageRes = R.drawable.ic_bag
            ),
            Item(
                name = "Vintage Crossbody Bag",
                description = "A small, stylish crossbody bag with a retro vibe. Made with high-quality vegan leather and brass details.",
                amount = 34.99,
                imageRes = R.drawable.ic_bag
            ),
            Item(
                name = "Sport Duffel Bag",
                description = "Durable duffel bag with water-resistant fabric. Great for gym sessions or outdoor adventures.",
                amount = 65.00,
                imageRes = R.drawable.ic_bag
            ),
            Item(
                name = "Laptop Messenger Bag",
                description = "Stylish and functional messenger bag designed to safely carry laptops up to 15 inches. Includes multiple pockets.",
                amount = 89.99,
                imageRes = R.drawable.ic_bag
            ),
            Item(
                name = "Drawstring Gym Bag",
                description = "Lightweight drawstring bag made of durable nylon. Ideal for quick trips to the gym or carrying sports gear.",
                amount = 14.99,
                imageRes = R.drawable.ic_bag
            ),)
        listOfShoes = mutableListOf(
            Item(
                name = "Classic Sneakers",
                description = "Stylish and comfortable sneakers perfect for everyday wear.",
                amount = 59.99,
                imageRes = R.drawable.ic_shoe
            ),
            Item(
                name = "Running Shoes",
                description = "Lightweight shoes designed for optimal performance during runs.",
                amount = 79.99,
                imageRes = R.drawable.ic_shoe
            ),
            Item(
                name = "Leather Boots",
                description = "Durable leather boots ideal for both casual and formal occasions.",
                amount = 129.99,
                imageRes = R.drawable.ic_shoe
            ),
            Item(
                name = "Sandals",
                description = "Comfortable sandals perfect for summer outings and beach days.",
                amount = 39.99,
                imageRes = R.drawable.ic_shoe
            ),
            Item(
                name = "High-Top Sneakers",
                description = "Trendy high-top sneakers that provide support and style.",
                amount = 89.99,
                imageRes = R.drawable.ic_shoe
            ),
            Item(
                name = "Dress Shoes",
                description = "Elegant dress shoes suitable for formal events and occasions.",
                amount = 99.99,
                imageRes = R.drawable.ic_shoe
            )

        )
        listOfJewelries = mutableListOf(
            Item(
                name = "Gold Necklace",
                description = "Elegant gold necklace that adds a touch of sophistication to any outfit.",
                amount = 149.99,
                imageRes = R.drawable.ic_jewelry
            ),
            Item(
                name = "Diamond Earrings",
                description = "Stunning diamond earrings that sparkle with every movement.",
                amount = 199.99,
                imageRes = R.drawable.ic_jewelry
            ),
            Item(
                name = "Silver Bracelet",
                description = "Chic silver bracelet perfect for everyday wear or special occasions.",
                amount = 79.99,
                imageRes = R.drawable.ic_jewelry
            ),
            Item(
                name = "Pearl Ring",
                description = "Classic pearl ring that exudes timeless elegance and charm.",
                amount = 129.99,
                imageRes = R.drawable.ic_jewelry
            ),
            Item(
                name = "Statement Necklace",
                description = "Bold statement necklace designed to turn heads and make an impression.",
                amount = 89.99,
                imageRes = R.drawable.ic_jewelry
            ),
        )
       listOfTees = mutableListOf(
        Item(
            name = "Vintage Wash Tee",
            description = "Stylish vintage wash T-shirt for a relaxed, worn-in feel.",
            amount = 29.99,
            imageRes = R.drawable.ic_shirt
        ),
        Item(
            name = "Sporty Performance Tee",
            description = "Lightweight performance tee designed for workouts and active wear.",
            amount = 34.99,
            imageRes = R.drawable.ic_shirt
        ),
        Item(
            name = "Long Sleeve Tee",
            description = "Comfortable long sleeve tee for cooler weather and layering.",
            amount = 29.99,
            imageRes = R.drawable.ic_shirt
        ),)




        categoryAdapter = CategoryAdapter(requireContext(), listOfCategories,
            object : OnItemClicked {
                override fun itemClicked(position: Int) {
                    when (position) {
                        0 -> {
                            loadBagItems()
                        }

                        1 -> {
                            loadShoeItems()
                        }

                        2 -> {
                            loadJewelryItems()
                        }

                        3 -> {
                            loadTeesItems()
                        }
                    }
                }
            })

        binding.recyclerView.adapter = categoryAdapter
        binding.recyclerView.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

        listOfItems = mutableListOf()
        listOfItems.addAll(listOfBags)

        itemCollectionAdapter = ItemCollectionAdapter(listOfItems)
        binding.collectionRecyclerView.adapter = itemCollectionAdapter
        binding.collectionRecyclerView.layoutManager = LinearLayoutManager(requireContext())
    }


    fun loadBagItems() {
        listOfItems.clear()

        listOfItems.addAll(listOfBags)

        itemCollectionAdapter.notifyDataSetChanged()
    }

    fun loadShoeItems() {
        listOfItems.clear()

        listOfItems.addAll(listOfShoes)
        itemCollectionAdapter.notifyDataSetChanged()
    }

    fun loadJewelryItems() {
        listOfItems.clear()

        listOfItems.addAll(listOfJewelries)
        itemCollectionAdapter.notifyDataSetChanged()
    }

    fun loadTeesItems() {
        listOfItems.clear()

        listOfItems.addAll(listOfTees)
        itemCollectionAdapter.notifyDataSetChanged()
    }
}