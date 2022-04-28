package binar.greta.tugasasynctask.network

import binar.greta.tugasasynctask.model.GetAllFilmItem
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("film")
    fun getAllFilm() : Call<List<GetAllFilmItem>>
}