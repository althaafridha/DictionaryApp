package com.althaafridha.translationapp

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.althaafridha.translationapp.data.TranslateResponseItem
import com.althaafridha.translationapp.network.ApiConfig
import com.althaafridha.translationapp.network.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TranslationViewModel: ViewModel() {
	 val listTranslation = MutableLiveData<ArrayList<TranslateResponseItem>>()

	fun getSearchApi(word: String){
		ApiConfig.getApiService().getQuery(word).enqueue(object :Callback<ArrayList<TranslateResponseItem>>{
			override fun onResponse(
				call: Call<ArrayList<TranslateResponseItem>>,
				response: Response<ArrayList<TranslateResponseItem>>
			) {
				listTranslation.value = response.body()
			}

			override fun onFailure(call: Call<ArrayList<TranslateResponseItem>>, t: Throwable) {
				Log.e("TAG", "onFailure: $t", )
			}
		})
	}
	fun getSearchTranslate(): LiveData<ArrayList<TranslateResponseItem>> = listTranslation
}