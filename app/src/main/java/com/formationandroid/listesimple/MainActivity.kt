package com.formationandroid.listesimple

import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*

class MainActivity : AppCompatActivity()
{
	
	// Vues :
	private lateinit var recyclerView: RecyclerView
	private lateinit var editTextMemo: EditText

	// Adapter :
	private lateinit var memosAdapter: MemosAdapter

	
	override fun onCreate(savedInstanceState: Bundle?)
	{
		// init :
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		// vues :
		recyclerView = findViewById(R.id.liste_memos)
		editTextMemo = findViewById(R.id.saisie_memo)

		// à ajouter pour de meilleures performances :
		recyclerView.setHasFixedSize(true)

		// layout manager, décrivant comment les items sont disposés :
		val layoutManager = LinearLayoutManager(this)
		recyclerView.layoutManager = layoutManager

		// contenu d'exemple :
		val listeMemos: MutableList<Memo> = ArrayList()
		for (a in 0..19)
		{
			listeMemos.add(Memo("Mémo n°" + (a + 1)))
		}

		// adapter :
		memosAdapter = MemosAdapter(listeMemos)
		recyclerView.adapter = memosAdapter
	}

	/**
	 * Listener clic bouton valider.
	 * @param view Bouton valider
	 */
	@Suppress("UNUSED_PARAMETER")
	fun onClickBoutonValider(view: View?)
	{
		// ajout du mémo :
		memosAdapter.ajouterMemo(Memo(editTextMemo.text.toString()))

		// animation de repositionnement de la liste (sinon on ne voit pas l'item ajouté) :
		recyclerView.smoothScrollToPosition(0)

		// on efface le contenu de la zone de saisie :
		editTextMemo.setText("")
	}
	
}