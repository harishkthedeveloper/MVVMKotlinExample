package com.example.harishassignment.ui.homeFragment.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.harishassignment.R
import com.example.harishassignment.databinding.RowHomeBinding
import com.example.harishassignment.ui.homeFragment.HomeFragment
import com.example.harishassignment.ui.homeFragment.HomeViewModel
import com.example.harishassignment.ui.homeFragment.db.Product

class HomeAdapter(private  val productsList: List<Product>,private val viewModel: HomeViewModel): RecyclerView.Adapter<MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding : RowHomeBinding = DataBindingUtil.inflate(layoutInflater, R.layout.row_home,parent,false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(productsList[position])
        holder.binding.imageView.setOnClickListener {
            viewModel.deleteProduct(productsList[position])
            notifyDataSetChanged()
            Toast.makeText(it.context, "Product Deleted", Toast.LENGTH_SHORT).show();
        }
    }

    override fun getItemCount(): Int {
       return productsList.size
    }


}
class MyViewHolder(val  binding:RowHomeBinding):RecyclerView.ViewHolder(binding.root){
    fun bind(product: Product){
        binding.itemName.text = product.item_name
        binding.itemPrice.text = "₹ "+product.item_rate.toString()
        binding.qty.text = product.item_qty.toString()
        binding.totalAmount.text = "₹ "+product.item_total.toString()

    }
}