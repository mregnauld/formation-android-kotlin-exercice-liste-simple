package com.formationandroid.listesimple

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.formationandroid.listesimple.MemosAdapter.MemoViewHolder

class MemosAdapter(private val listeMemos: MutableList<Memo>) : RecyclerView.Adapter<MemoViewHolder>()
{

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MemoViewHolder
	{
		val viewMemo = LayoutInflater.from(parent.context).inflate(R.layout.item_memo, parent, false)
		return MemoViewHolder(viewMemo)
	}

	override fun onBindViewHolder(holder: MemoViewHolder, position: Int)
	{
		holder.textViewIntitule.text = listeMemos[position].intitule
	}

	override fun getItemCount(): Int
	{
		return listeMemos.size
	}

	/**
	 * Ajout d'un mémo à la liste.
	 * @param memo Mémo
	 */
	fun ajouterMemo(memo: Memo)
	{
		listeMemos.add(0, memo)
		notifyItemInserted(0)
	}

	/**
	 * ViewHolder.
	 */
	inner class MemoViewHolder(itemView: View) : ViewHolder(itemView)
	{

		// Vue intitulé mémo :
		var textViewIntitule: TextView = itemView.findViewById(R.id.memo_intitule)


        /**
		 * Constructeur.
		 */
		init
		{
            // listener :
			itemView.setOnClickListener {

				// affichage du toast :
				Toast.makeText(itemView.context, itemView.context.getString(R.string.main_message_position, adapterPosition), Toast.LENGTH_LONG).show()
			}
		}
	}

}