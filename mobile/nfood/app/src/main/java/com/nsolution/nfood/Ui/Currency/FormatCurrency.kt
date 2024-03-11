package com.nsolution.nfood.Ui.Currency

import java.text.NumberFormat
import java.util.*

class FormatCurrency {
  companion object {
    fun FormatCurrencyVietNam(money: Double?): String {
      val locale = Locale("vi", "VN")
      val format: NumberFormat = NumberFormat.getCurrencyInstance(locale)
      return format.format(money)
    }
  }
}