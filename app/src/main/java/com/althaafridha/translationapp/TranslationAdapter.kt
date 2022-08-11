package com.althaafridha.translationapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.althaafridha.translationapp.data.DefinitionsItem
import com.althaafridha.translationapp.databinding.ItemTranslationBinding

class TranslationAdapter: RecyclerView.Adapter<TranslationAdapter.ViewHolder>() {

	private val listTranslation = ArrayList<DefinitionsItem>()

	class ViewHolder(val itemTranslation: ItemTranslationBinding):RecyclerView.ViewHolder(itemTranslation.root)

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
		ItemTranslationBinding.inflate(LayoutInflater.from(parent.context), parent, false)
	)

	override fun onBindViewHolder(holder: ViewHolder, position: Int) {
		holder.itemTranslation.apply {
			with(listTranslation[position]){
				tvNumber.text = "${position + 1}. "
				tvDefinition.text = definition
			}
		}
	}

	override fun getItemCount() = listTranslation.size

	fun setData(data: ArrayList<DefinitionsItem>){
		listTranslation.clear()
		listTranslation.addAll(data)
	}
}