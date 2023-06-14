package com.example.todolistadexample.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.show_ad.logic.data.AdValueExample
import com.example.show_ad.logic.domain.AdUseCase
import com.example.todolistadexample.R
import com.example.todolistadexample.databinding.AditemBinding

class Banner: Fragment() {

    private lateinit var binding: AditemBinding
    private var adValueExample = AdValueExample()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.aditem, container, false)
        adValueExample = AdUseCase().excute()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getData()
    }

    private fun getData() {
        binding.tvTitle.text = adValueExample.title
        binding.tvContent.text = adValueExample.content
        binding.tvIntroduce.text = adValueExample.addIntroduce
        binding.ivAdPhoto.setImageURI(adValueExample.addIntroduce.toUri())
    }
}