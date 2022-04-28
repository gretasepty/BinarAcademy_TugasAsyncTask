package binar.greta.tugasasynctask

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import binar.greta.tugasasynctask.model.GetAllFilmItem
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_layout.view.*

class Adapter(private var datafilm : List<GetAllFilmItem>) : RecyclerView.Adapter<Adapter.ViewHolder>() {

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView)  {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layout = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_layout,parent, false)
        return ViewHolder(layout)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.txt_judul.text = datafilm[position].name
        holder.itemView.txt_tanggal.text = datafilm[position].date
        holder.itemView.txt_sutradara.text = datafilm[position].director

        Glide.with(holder.itemView.context).load(datafilm[position].image).into(holder.itemView.img_Film)
    }

    override fun getItemCount(): Int {
        return datafilm.size
    }
}