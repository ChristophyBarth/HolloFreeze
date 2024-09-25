package capps.learning.hollofreeze

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import capps.learning.hollofreeze.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var categoryAdapter: CategoryAdapter
    private lateinit var listOfCategories : MutableList<Category>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bagCategory = Category("Bags", R.drawable.ic_cart, R.color.ourPrimaryColor)
        val shoeCategory = Category("Shoes", R.drawable.ic_profile, android.R.color.holo_blue_light)
        val jewelryCategory = Category("Jewelries", R.drawable.ic_home, android.R.color.holo_orange_light)
        val teeCategory = Category("Tees", R.drawable.ic_menu, android.R.color.holo_green_dark)

        listOfCategories = mutableListOf()
        listOfCategories.add(bagCategory)
        listOfCategories.add(shoeCategory)
        listOfCategories.add(jewelryCategory)
        listOfCategories.add(teeCategory)

        categoryAdapter = CategoryAdapter(requireContext(), listOfCategories)

        binding.recyclerView.adapter = categoryAdapter
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
    }
}