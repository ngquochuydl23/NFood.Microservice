package com.nsolution.nfood.Adapter.RecyclerView.Adapter

import android.content.Intent
import android.view.ViewGroup
import com.nsolution.nfood.Adapter.RecyclerView.Holder.CollectionHolder
import com.nsolution.nfood.Models.ItemCollectionDto
import com.nsolution.nfood.R
import com.nsolution.nfood.Ui.Collection.CollectionDetail

class CollectionAdapter(val listCollection: ArrayList<ItemCollectionDto>?) :
  BaseAdapter<CollectionHolder>() {
  
  private val COLLECTION_ID = "COLLECTION_ID"
  private val COLLECTION_TITLE = "COLLECTION_TITLE"
  
  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CollectionHolder {
    val view = getView(parent, viewType, R.layout.item_collection)
    return CollectionHolder(view)
  }
  
  override fun onBindViewHolder(holder: CollectionHolder, position: Int) {
    val itemCollection = listCollection?.get(position)
    
    holder.collectionTitle.text = itemCollection?.collectionTitle
    holder.collectionSubtitle.text = itemCollection?.collectionSubtitle
    
    setImage(holder.collectionImage, itemCollection?.collectionImage)
    holder.containerLayout.setOnClickListener {
      navigateToCollectionDetail(itemCollection?.collectionId, itemCollection?.collectionTitle)
    }
  }
  
  override fun getItemCount(): Int {
    return getSizeList(listCollection)
  }
  
  private fun navigateToCollectionDetail(collectionId: Int?, collectionString: String?) {
    val intent = Intent(context, CollectionDetail::class.java)
    intent.putExtra(COLLECTION_ID, collectionId)
    intent.putExtra(COLLECTION_TITLE, collectionString)
    context.startActivity(intent)
  }
  
}