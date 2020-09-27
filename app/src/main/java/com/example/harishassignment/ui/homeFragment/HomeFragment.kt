package com.example.harishassignment.ui.homeFragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.harishassignment.R
import com.example.harishassignment.databinding.HomeFragmentBinding
import com.example.harishassignment.ui.homeFragment.adapter.HomeAdapter
import com.example.harishassignment.ui.homeFragment.db.Product
import com.example.harishassignment.ui.homeFragment.db.ProductDB
import com.example.harishassignment.ui.homeFragment.db.ProductRepositry
import com.example.harishassignment.ui.updateFragment.UpdateCardViewModel
import java.util.*

class HomeFragment : Fragment() {
    private lateinit var viewModel: HomeViewModel
    private lateinit var binding : HomeFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.home_fragment, container, false)
        val dao= ProductDB.getInstance(requireContext()).productDAO
        val productRepositry = ProductRepositry(dao)
        val factory = HomeViewModelFactory(productRepositry)
        viewModel = ViewModelProvider(requireActivity(),factory).get(HomeViewModel::class.java)
        binding.myViewModel = viewModel
        binding.lifecycleOwner = this

        recyclerViewSetup();
        fabClick();
        return binding.root
    }



    private fun displayProducts() {
        viewModel.getProDuctList().observe(viewLifecycleOwner, androidx.lifecycle.Observer {
//            Log.d("list",it.size.toString())

            if(it.size==0){
                binding.noData.visibility=View.VISIBLE
                binding.recyclerView.adapter= HomeAdapter(it,viewModel);
            }else{
                binding.noData.visibility=View.GONE
                binding.recyclerView.adapter= HomeAdapter(it,viewModel);
            }
        })
    }

    private fun fabClick() {
        binding.floatingActionButton.setOnClickListener {
            // navigate to update screen
            Navigation.findNavController(it)
                .navigate(R.id.action_homeFragment_to_updateCardFragment)
        }
    }

    private fun recyclerViewSetup() {
        val linearLayoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        binding.recyclerView.layoutManager = linearLayoutManager
        displayProducts()
    }





}