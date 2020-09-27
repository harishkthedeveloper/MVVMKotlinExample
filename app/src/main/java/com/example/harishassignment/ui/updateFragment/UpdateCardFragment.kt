package com.example.harishassignment.ui.updateFragment

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.harishassignment.R
import com.example.harishassignment.databinding.HomeFragmentBinding
import com.example.harishassignment.databinding.UpdateCardFragmentBinding
import com.example.harishassignment.ui.homeFragment.db.ProductDB
import com.example.harishassignment.ui.homeFragment.db.ProductRepositry

class UpdateCardFragment : Fragment() {

    private lateinit var binding : UpdateCardFragmentBinding

    private lateinit var viewModel: UpdateCardViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.update_card_fragment, container, false)
        val dao= ProductDB.getInstance(requireContext()).productDAO
        val productRepositry = ProductRepositry(dao)
        val factory = UpdateCardViewModelFactory(productRepositry)
        viewModel = ViewModelProvider(requireActivity(),factory).get(UpdateCardViewModel::class.java)
        binding.myViewModel = viewModel
        binding.lifecycleOwner = this


        binding.imageView2.setOnClickListener {
            Navigation.findNavController(it).popBackStack()
        }
        binding.button.setOnClickListener {
           if(binding.productName.text.isNullOrEmpty()){
               showMessage("Please enter product name");
           }else if(binding.productQty.text.isNullOrEmpty()){
               showMessage("Please enter product quantity");
           }else if(binding.productPrice.text.isNullOrEmpty()){
               showMessage("Please enter product price");
           }else{
               viewModel.saveOrUpdate()
               showMessage("Product Added");
               Navigation.findNavController(it).popBackStack()
           }
        }


        return binding.root
    }

    private fun showMessage(msg:String) {
        Toast.makeText(requireContext(), msg, Toast.LENGTH_SHORT).show();
    }


}