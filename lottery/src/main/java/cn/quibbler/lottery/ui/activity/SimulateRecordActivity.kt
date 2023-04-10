package cn.quibbler.lottery.ui.activity

import android.os.Bundle
import android.view.View
import cn.quibbler.lottery.R
import cn.quibbler.lottery.databinding.ActivitySimulateRecordBinding
import cn.quibbler.lottery.model.RouterCenter
import cn.quibbler.lottery.ui.adapter.pageadapter.SimulateRecordViewPagerAdapter
import com.alibaba.android.arouter.facade.annotation.Route

@Route(path = RouterCenter.self_activity_simulate)
class SimulateRecordActivity : BaseActivity() {

    private lateinit var binding: ActivitySimulateRecordBinding

    private var deleteState = false

    private val clickListener = View.OnClickListener {
        if (deleteState) {
            binding.deleteLayout.visibility = View.VISIBLE
            setRightTitleText(getString(R.string.complete))
        } else {
            binding.deleteLayout.visibility = View.GONE
            setRightTitleText(getString(R.string.operation))
        }
        deleteState = !deleteState
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySimulateRecordBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.elevation = 0f

        showRightTitleText(getString(R.string.operation), clickListener)

        initView()
    }

    private fun initView() {
        binding.tabLayout.setupWithViewPager(binding.viewPager)
        binding.viewPager.adapter = SimulateRecordViewPagerAdapter()
    }

}