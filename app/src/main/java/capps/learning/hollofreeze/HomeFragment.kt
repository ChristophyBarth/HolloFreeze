package capps.learning.hollofreeze

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import capps.learning.hollofreeze.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var categoryAdapter: CategoryAdapter
    private lateinit var listOfCategories: MutableList<Category>

    private lateinit var itemCollectionAdapter: ItemCollectionAdapter
    private lateinit var listOfItems: MutableList<Item>

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

        categoryAdapter = CategoryAdapter(requireContext(), listOfCategories)

        binding.recyclerView.adapter = categoryAdapter
        binding.recyclerView.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

        listOfItems = mutableListOf(
            Item(
                name = "Nike Air Max",
                description = "Experience comfort and style with these iconic sneakers.",
                amount = 129.99,
                imageRes = R.drawable.ic_bag
            ),
            Item(
                name = "Ray-Ban Sunglasses",
                description = "Protect your eyes in style with these classic shades.",
                amount = 89.99,
                imageRes = R.drawable.ic_bag
            ),
            Item(
                name = "Apple iPhone 14",
                description = "Capture stunning photos and enjoy seamless performance.",
                amount = 799.99,
                imageRes = R.drawable.ic_bag
            ),
            Item(
                name = "Sony PlayStation 5",
                description = "Immerse yourself in the next generation of gaming.",
                amount = 499.99,
                imageRes = R.drawable.ic_bag
            ),
            Item(
                name = "Bose QuietComfort Headphones",
                description = "Enjoy your music without distractions with noise cancellation.",
                amount = 299.99,
                imageRes = R.drawable.ic_bag
            ),
            Item(
                name = "Samsung Galaxy Watch 5",
                description = "Stay connected and track your fitness goals.",
                amount = 249.99,
                imageRes = R.drawable.ic_bag
            ),
            Item(
                name = "GoPro HERO11 Black",
                description = "Capture your adventures in stunning 5.3K video.",
                amount = 399.99,
                imageRes = R.drawable.ic_bag
            ),
            Item(
                name = "Kindle Paperwhite",
                description = "Read comfortably with a glare-free display.",
                amount = 139.99,
                imageRes = R.drawable.ic_bag
            ),
            Item(
                name = "Fitbit Versa 4",
                description = "Track your activity and sleep with this stylish fitness tracker.",
                amount = 199.99,
                imageRes = R.drawable.ic_bag
            ),
            Item(
                name = "Lenovo ThinkPad X1 Carbon",
                description = "Boost your productivity with this powerful and lightweight laptop.",
                amount = 1299.99,
                imageRes = R.drawable.ic_bag
            )
        )

        itemCollectionAdapter = ItemCollectionAdapter(listOfItems)
        binding.collectionRecyclerView.adapter = itemCollectionAdapter
        binding.collectionRecyclerView.layoutManager = LinearLayoutManager(requireContext())
    }
}