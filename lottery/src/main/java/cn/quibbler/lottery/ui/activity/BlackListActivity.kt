package cn.quibbler.lottery.ui.activity

import android.os.Bundle
import cn.quibbler.lottery.databinding.ActivityBlackListBinding
import cn.quibbler.lottery.model.RouterCenter
import com.alibaba.android.arouter.facade.annotation.Route

@Route(path = RouterCenter.black_list_page)
class BlackListActivity : BaseActivity() {

    private lateinit var binding: ActivityBlackListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBlackListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.elevation = 0f
    }

}