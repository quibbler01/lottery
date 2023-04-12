package cn.quibbler.lottery.ui.activity

import android.os.Bundle
import cn.quibbler.lottery.databinding.ActivityFollowAndFansBinding
import cn.quibbler.lottery.model.RouterCenter
import cn.quibbler.lottery.ui.adapter.pageadapter.FollowAndFansPagerAdapter
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.facade.annotation.Route

@Route(path = RouterCenter.activity_follow_and_fans)
class FollowAndFansActivity : BaseActivity() {

    companion object {
        const val SELECT_PAGE = "select_page"

        const val FOLLOW_PAGE = 0
        const val FANS_PAGE = 1
    }

    private lateinit var binding: ActivityFollowAndFansBinding

    @Autowired(name = SELECT_PAGE)
    @JvmField
    var selectPosition: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFollowAndFansBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.elevation = 0f

        initView()
    }

    private fun initView() {
        binding.viewPager.adapter = FollowAndFansPagerAdapter()
        binding.tabLayout.setupWithViewPager(binding.viewPager)

        binding.viewPager.setCurrentItem(selectPosition, false)
    }

}