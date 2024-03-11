package com.nsolution.nfood.Ui.Voucher

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.nsolution.nfood.Adapter.RecyclerView.Adapter.VoucherAdapter
import com.nsolution.nfood.Models.ItemVoucherDto
import com.nsolution.nfood.R
import com.nsolution.nfood.Ui.Base.BaseActivity
import com.nsolution.nfood.Ui.Base.BaseSwipeRefreshActivity

class SelectVoucher : BaseSwipeRefreshActivity() {
  
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_select_voucher)
    initialView()
    getListVoucher()
  }
  
  private fun initialView(){
//    getBackActionBar(header,getString(R.string.select_voucher))
//    getSwipeRefreshView(swipeRefreshLayout)
//
//    listVoucher.layoutManager = LinearLayoutManager(this)
  }
  
  override fun onRefreshListener() {
    getListVoucher()
  }
  
  private fun getListVoucher(){
    val voucher = ItemVoucherDto().apply {
      voucherId = 1
      voucherTitle = "50$ NWork Discount"
      voucherSubtitle = "Ưu đãi giảm ngay 40$ tối đa 40k cho dịch vụ NWork"
      voucherMinOrderPrice = "Giá trị đơn hàng tối thiểu 100.000đ"
      voucherStatus = "Hết hạn : Th9 27, 2020"
      voucherIsAlmostOverData = true
    }
  
    val list =
      arrayListOf(voucher,voucher,voucher,voucher,voucher,voucher)
  //  listVoucher.adapter = VoucherAdapter(list)
    completeSwipeRefresh()
  }
}
