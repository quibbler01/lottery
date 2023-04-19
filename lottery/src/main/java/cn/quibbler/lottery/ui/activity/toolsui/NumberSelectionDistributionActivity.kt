package cn.quibbler.lottery.ui.activity.toolsui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import cn.quibbler.lottery.databinding.ActivityNumberSelectionDistributionBinding
import cn.quibbler.lottery.model.RouterCenter
import cn.quibbler.lottery.ui.activity.BaseActivity
import com.alibaba.android.arouter.facade.annotation.Route

@Route(path = RouterCenter.number_selection_distribution_activity)
class NumberSelectionDistributionActivity : BaseActivity() {

    private lateinit var binding:ActivityNumberSelectionDistributionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNumberSelectionDistributionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.elevation = 0f
    }
}