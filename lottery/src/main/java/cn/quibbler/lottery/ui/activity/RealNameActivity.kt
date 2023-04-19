package cn.quibbler.lottery.ui.activity

import android.os.Bundle
import cn.quibbler.lottery.R
import cn.quibbler.lottery.databinding.ActivityRealNameBinding
import cn.quibbler.lottery.model.RouterCenter
import cn.quibbler.lottery.utils.setEditTextHintSize
import com.alibaba.android.arouter.facade.annotation.Route

@Route(path = RouterCenter.settings_activity_pay_realname)
class RealNameActivity : BaseActivity() {

    private lateinit var binding: ActivityRealNameBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRealNameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.elevation = 0f

        initView()
    }

    private fun initView(){
        setEditTextHintSize(binding.edittextPhoneNumber, getString(R.string.hint_input_phone_number), 16)
        setEditTextHintSize(binding.edittextName, getString(R.string.hint_input_real_name), 16)
        setEditTextHintSize(binding.edittextNumber, getString(R.string.hint_input_id_number), 16)
    }

}