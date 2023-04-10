package cn.quibbler.lottery.ui.activity

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import cn.quibbler.lottery.LotteryApplication.Companion.getInflater
import cn.quibbler.lottery.R
import cn.quibbler.lottery.databinding.ActivityBankCardBinding
import cn.quibbler.lottery.databinding.BankCardAddLayoutBinding
import cn.quibbler.lottery.databinding.BankCardDetailLayoutBinding
import cn.quibbler.lottery.model.RouterCenter
import cn.quibbler.lottery.utils.getAppString
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter

@Route(path = RouterCenter.settings_activity_pay_bankcard)
class BankCardActivity : BaseActivity() {

    private lateinit var binding: ActivityBankCardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBankCardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.elevation = 0f

        initViews()
    }

    private fun initViews() {
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = BankCardAdapter()
    }

    class BankCardAdapter : RecyclerView.Adapter<BankCardAdapter.ViewHolder>() {

        private val card_type_bank = 0
        private val card_type_add_bank = 1

        private val list = ArrayList<Any>()

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = when (viewType) {
            card_type_bank -> {
                val binding = BankCardDetailLayoutBinding.inflate(getInflater(), parent, false)
                ViewHolder(binding.root)
            }
            else -> {
                val binding = BankCardAddLayoutBinding.inflate(getInflater(), parent, false)
                binding.addBankCard.setOnClickListener {
                    ARouter.getInstance()
                        .build(RouterCenter.activity_add_bank_card)
                        .withString(RouterCenter.argument_title, getAppString(R.string.bind_bank_card))
                        .navigation()
                }
                ViewHolder(binding.root)
            }
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        }

        override fun getItemViewType(position: Int): Int = when (position < list.size) {
            true -> card_type_bank
            false -> card_type_add_bank
        }

        override fun getItemCount(): Int = list.size + 1    //bank card size + add bank button

        class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        }

    }

}