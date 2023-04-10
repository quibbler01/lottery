package cn.quibbler.lottery.ui.activity

import android.content.Context
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import cn.quibbler.lottery.R
import cn.quibbler.lottery.databinding.ActivityAddBankCardBinding
import cn.quibbler.lottery.model.RouterCenter
import com.alibaba.android.arouter.facade.annotation.Route

@Route(path = RouterCenter.activity_add_bank_card)
class AddBankCardActivity : BaseActivity() {

    private lateinit var binding: ActivityAddBankCardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddBankCardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.elevation = 0f

        initView()
    }

    private fun initView() {
        binding.bindCardNow.setOnClickListener {
            Toast.makeText(this, "${getString(R.string.bind_bank_card)}:${binding.inputBankcardNumber.text}", Toast.LENGTH_SHORT).show()
        }
        val inputMethodManager = (getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager)
        binding.inputBankcardNumber.apply {
            requestFocus()
            inputMethodManager.showSoftInput(this, 0)
            addTextChangedListener {
                if (it?.isNotEmpty() == true) {
                    binding.bindCardNow.setBackgroundResource(R.drawable.submit_enable_bg)
                    binding.bindCardNow.isEnabled = true
                } else {
                    binding.bindCardNow.setBackgroundResource(R.drawable.submit_disable_bg)
                    binding.bindCardNow.isEnabled = false
                }
            }
        }
    }

}