package cn.quibbler.lottery.ui.activity

import android.os.Bundle
import android.view.View
import cn.quibbler.lottery.databinding.ActivityAccountBinding
import cn.quibbler.lottery.model.RouterCenter
import com.alibaba.android.arouter.facade.annotation.Route

@Route(path = RouterCenter.settings_activity_account)
class AccountActivity : BaseActivity(), View.OnClickListener {

    private lateinit var binding: ActivityAccountBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAccountBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViews()
    }

    private fun initViews() {

    }

    override fun onClick(v: View?) {

    }

}