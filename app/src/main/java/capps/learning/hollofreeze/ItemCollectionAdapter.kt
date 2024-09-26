package capps.learning.hollofreeze

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import capps.learning.hollofreeze.databinding.ItemCollectionItemBinding

class ItemCollectionAdapter(private val items: List<Item>) :
    RecyclerView.Adapter<ItemCollectionAdapter.ItemCollectionVH>() {

    class ItemCollectionVH(private val binding: ItemCollectionItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Item) {
            /*binding.nameTv.text = item.name
            binding.descTv.text = item.description
            binding.amountTv.text = "$${item.amount}"
            binding.itemIv.setImageResource(item.imageRes)*/

            binding.apply {
                nameTv.text = item.name
                descTv.text = item.description
                amountTv.text = "$${item.amount}"
                itemIv.setImageResource(item.imageRes)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemCollectionVH {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemCollectionItemBinding = ItemCollectionItemBinding.inflate(layoutInflater)
        return ItemCollectionVH(itemCollectionItemBinding)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ItemCollectionVH, position: Int) {
        val item = items[position]
        holder.bind(item)
    }
}