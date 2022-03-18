package cn.quibbler.lottery.ui.activity

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import cn.quibbler.lottery.LotteryApplication.Companion.getInflater
import cn.quibbler.lottery.databinding.ActivityWelfareTaskBinding
import cn.quibbler.lottery.databinding.SiginDayGridViewItemBinding
import cn.quibbler.lottery.model.RouterCenter
import com.alibaba.android.arouter.facade.annotation.Route

@Route(path = RouterCenter.self_activity_task)
class WelfareTaskActivity : BaseActivity() {

    private lateinit var binding: ActivityWelfareTaskBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Android remove shadow line under ActionBar
        supportActionBar?.elevation = 0f

        binding = ActivityWelfareTaskBinding.inflate(getInflater())
        setContentView(binding.root)

        initView()
    }

    private fun initView() {
        binding.gridView.adapter = GridAdapter()
    }

    private class GridAdapter : BaseAdapter() {

        override fun getCount(): Int = 7

        override fun getItem(position: Int): Int = (position + 1)

        override fun getItemId(position: Int): Long = 1L

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val binding: SiginDayGridViewItemBinding
            if (convertView == null) {
                binding = SiginDayGridViewItemBinding.inflate(getInflater(), parent, false)
                binding.root.tag = binding
            } else {
                binding = convertView.tag as SiginDayGridViewItemBinding
            }
            when (position) {
                0 -> {
                    binding.bounce.visibility = View.INVISIBLE
                    binding.money.text = "30"
                    binding.day.text = "1天"
                }
                1 -> {
                    binding.bounce.visibility = View.INVISIBLE
                    binding.money.text = "50"
                    binding.day.text = "2天"
                }
                2 -> {
                    binding.bounce.visibility = View.VISIBLE
                    binding.bounce.text = "+30"
                    binding.money.text = "70"
                    binding.day.text = "3天"
                }
                3 -> {
                    binding.bounce.visibility = View.INVISIBLE
                    binding.money.text = "100"
                    binding.day.text = "4天"
                }
                4 -> {
                    binding.bounce.visibility = View.VISIBLE
                    binding.bounce.text = "+50"
                    binding.money.text = "120"
                    binding.day.text = "5天"
                }
                5 -> {
                    binding.bounce.visibility = View.INVISIBLE
                    binding.money.text = "150"
                    binding.day.text = "6天"
                }
                6 -> {
                    binding.bounce.visibility = View.VISIBLE
                    binding.bounce.text = "+100"
                    binding.money.text = "200"
                    binding.day.text = "7天"
                }
            }
            return binding.root
        }

    }

}