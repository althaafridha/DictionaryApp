package com.althaafridha.translationapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.ViewModelProvider
import com.althaafridha.translationapp.databinding.ActivityMainBinding
import retrofit2.Callback

class MainActivity : AppCompatActivity() {

	private var _binding: ActivityMainBinding? = null
	private val binding get() = _binding as ActivityMainBinding

	private lateinit var viewModel : TranslationViewModel

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		_binding = ActivityMainBinding.inflate(layoutInflater)
		setContentView(binding.root)

		supportActionBar?.hide()

		viewModel = ViewModelProvider(this)[TranslationViewModel::class.java]

		viewModel.getSearchTranslate().observe(this){
			if(it != null){
				binding.tvWord.text = it[0].word
				binding.tvPhonetic.text = it[0].phonetic
				binding.tvDefinition.text = it[0].meanings?.get(0)?.definitions?.get(0)?.definition
			} else {
				Toast.makeText(applicationContext, "No Found Word", Toast.LENGTH_SHORT).show()
			}

		}

		getSearchTranslate()
	}

	private fun getSearchTranslate() {
		binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
			override fun onQueryTextSubmit(query: String?): Boolean {
				query.let {
					viewModel.getSearchApi(it.toString())
				}
				return true
			}

			override fun onQueryTextChange(newText: String?): Boolean {
				return false
			}

		})
	}
}