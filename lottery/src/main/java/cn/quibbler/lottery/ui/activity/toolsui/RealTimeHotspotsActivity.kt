package cn.quibbler.lottery.ui.activity.toolsui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import cn.quibbler.lottery.databinding.ActivityRealTimeHotspotsBinding
import cn.quibbler.lottery.model.RouterCenter
import cn.quibbler.lottery.ui.activity.BaseActivity
import com.alibaba.android.arouter.facade.annotation.Route

@Route(path = RouterCenter.real_time_hotspots_activity)
class RealTimeHotspotsActivity : BaseActivity() {

    private lateinit var binding: ActivityRealTimeHotspotsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRealTimeHotspotsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.elevation = 0f
    }
}