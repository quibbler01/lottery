package cn.quibbler.lottery.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import cn.quibbler.lottery.databinding.ActivityRedemptionRecordsBinding
import cn.quibbler.lottery.model.RouterCenter
import com.alibaba.android.arouter.facade.annotation.Route

@Route(path = RouterCenter.self_activity_color_bean_redemption_records)
class RedemptionRecordsActivity : BaseActivity() {

    private lateinit var binding: ActivityRedemptionRecordsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRedemptionRecordsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.elevation = 0f
    }

}
