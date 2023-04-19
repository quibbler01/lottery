package cn.quibbler.lottery.ui.activity.toolsui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import cn.quibbler.lottery.databinding.ActivityMovingAverageAnalysisBinding
import cn.quibbler.lottery.model.RouterCenter
import cn.quibbler.lottery.ui.activity.BaseActivity
import com.alibaba.android.arouter.facade.annotation.Route

@Route(path = RouterCenter.moving_average_analysis_activity)
class MovingAverageAnalysisActivity : BaseActivity() {

    private lateinit var binding:ActivityMovingAverageAnalysisBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMovingAverageAnalysisBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.elevation = 0f
    }
}