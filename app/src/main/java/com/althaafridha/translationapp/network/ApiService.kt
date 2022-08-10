package com.althaafridha.translationapp.network

import com.althaafridha.translationapp.data.TranslateResponseItem
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

	@GET("{word}")
	fun getQuery(@Path("word") word: String): Call<ArrayList<TranslateResponseItem>>
}