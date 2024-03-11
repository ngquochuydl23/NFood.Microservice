package com.nsolution.nfood.Adapter.RecyclerView.Adapter

import android.content.Intent
import android.view.ViewGroup
import com.nsolution.nfood.Adapter.RecyclerView.Holder.VoucherHolder
import com.nsolution.nfood.Models.ItemVoucherDto
import com.nsolution.nfood.R
import com.nsolution.nfood.Ui.Voucher.VoucherDetail

open class VoucherAdapter(val listVoucher: ArrayList<ItemVoucherDto>?) : BaseAdapter<VoucherHolder>() {
  
  private val VOUCHER_ID = "voucher_id"
  
  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VoucherHolder {
    val view = getView(parent,viewType, R.layout.item_voucher)
    return VoucherHolder(view)
  }
  
  override fun onBindViewHolder(holder: VoucherHolder, position: Int) {
    val itemVoucher = listVoucher?.get(position)
    
    holder.voucherTitle.text = itemVoucher?.voucherTitle
    holder.voucherSubtitle.text = itemVoucher?.voucherSubtitle
    holder.voucherMinOrderPrice.text = itemVoucher?.voucherMinOrderPrice
    holder.voucherStatus.text = itemVoucher?.voucherStatus
    
    holder.voucherDetailButton.setOnClickListener {
      navigateToDetailVoucher(itemVoucher?.voucherId)
    }
    
    holder.containerLayout.setOnClickListener {
      voucherClick(itemVoucher)
    }
  }
  
  override fun getItemCount(): Int {
    return getSizeList(listVoucher)
  }
  
  open fun voucherClick(itemVoucher : ItemVoucherDto?) {
  
  }
  
  private fun navigateToDetailVoucher(id : Int?) {
    val intent = Intent(context, VoucherDetail::class.java)
    intent.putExtra(VOUCHER_ID,id)
    context.startActivity(intent)
  }
}