package cn.quibbler.lottery.ui.activity

import android.os.Bundle
import cn.quibbler.lottery.databinding.ActivityExpiredCouponBinding
import cn.quibbler.lottery.model.RouterCenter
import com.alibaba.android.arouter.facade.annotation.Route

@Route(path = RouterCenter.self_activity_expired_coupon)
class ExpiredCouponActivity : BaseActivity() {

    private lateinit var binding: ActivityExpiredCouponBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExpiredCouponBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.elevation = 1f
    }

}