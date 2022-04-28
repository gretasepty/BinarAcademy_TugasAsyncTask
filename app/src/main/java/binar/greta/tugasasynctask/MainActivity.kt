package binar.greta.tugasasynctask

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import binar.greta.tugasasynctask.model.GetAllFilmItem
import binar.greta.tugasasynctask.network.ApiClient
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listFilm().execute()
    }

    inner  class listFilm : AsyncTask<Void, Void, Void>() {


        override fun onPreExecute() {
            super.onPreExecute()
        }

        override fun doInBackground(vararg params: Void?): Void? {
           getData()
            return null
        }

        override fun onProgressUpdate(vararg values: Void?) {
            super.onProgressUpdate(*values)
        }

        override fun onPostExecute(result: Void?) {
            super.onPostExecute(result)
        }

        fun getData(){
            ApiClient.instance.getAllFilm()
                .enqueue(object : retrofit2.Callback<List<GetAllFilmItem>>{
                    override fun onResponse(
                        call: Call<List<GetAllFilmItem>>,
                        response: Response<List<GetAllFilmItem>>
                    ) {
                        if(response.isSuccessful){
                            val daFilm = response.body()
                            val adapt = Adapter(daFilm!!)

                            val linma = LinearLayoutManager(applicationContext,
                                LinearLayoutManager.VERTICAL, false)
                            rv_film.layoutManager = linma
                            rv_film.adapter = adapt
                        }else{
                            Toast.makeText(this@MainActivity, "Gagal", Toast.LENGTH_SHORT)
                        }
                    }

                    override fun onFailure(call: Call<List<GetAllFilmItem>>, t: Throwable) {
                        Toast.makeText(this@MainActivity, t.message, Toast.LENGTH_SHORT)
                    }
                })
        }
    }


}