package cn.quibbler.lottery.ui.activity

import android.os.Bundle
import cn.quibbler.lottery.databinding.ActivityPersonHomeBinding
import cn.quibbler.lottery.model.RouterCenter
import com.alibaba.android.arouter.facade.annotation.Route

@Route(path = RouterCenter.self_person_home_page)
class PersonHomeActivity : BaseActivity() {

    private lateinit var binding: ActivityPersonHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPersonHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

}