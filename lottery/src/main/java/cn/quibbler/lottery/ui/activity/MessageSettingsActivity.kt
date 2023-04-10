package cn.quibbler.lottery.ui.activity

import android.os.Bundle
import android.widget.CompoundButton
import android.widget.RadioGroup
import cn.quibbler.lottery.databinding.ActivityMessageSettingsBinding
import cn.quibbler.lottery.model.RouterCenter
import com.alibaba.android.arouter.facade.annotation.Route

@Route(path = RouterCenter.self_activity_message_settings)
class MessageSettingsActivity : BaseActivity() {

    private lateinit var binding: ActivityMessageSettingsBinding

    private val checkChangeListener = object : CompoundButton.OnCheckedChangeListener {
        override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
            when (buttonView?.id) {
                binding.allMessageRadioButton.id -> {
                    binding.onlySubscribeMessageRadioButton.isChecked = !isChecked
                }
                binding.onlySubscribeMessageRadioButton.id -> {
                    binding.allMessageRadioButton.isChecked = !isChecked
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMessageSettingsBinding.inflate(layoutInflater)

        supportActionBar?.elevation = 0f

        setContentView(binding.root)

        initView()
    }

    private fun initView() {
        binding.allMessageRadioButton.setOnCheckedChangeListener(checkChangeListener)
        binding.onlySubscribeMessageRadioButton.setOnCheckedChangeListener(checkChangeListener)
    }

}