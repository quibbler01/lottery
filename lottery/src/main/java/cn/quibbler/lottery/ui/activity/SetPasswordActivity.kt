package cn.quibbler.lottery.ui.activity

import android.content.Context
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import cn.quibbler.lottery.R
import cn.quibbler.lottery.databinding.ActivityPasswordBinding
import cn.quibbler.lottery.model.RouterCenter
import cn.quibbler.lottery.utils.setEditTextHintSize
import com.alibaba.android.arouter.facade.annotation.Route

@Route(path = RouterCenter.settings_activity_pay_set_password)
class SetPasswordActivity : BaseActivity() {

    private lateinit var binding: ActivityPasswordBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.elevation = 0f

        initView()
    }

    private fun initView() {
        setEditTextHintSize(binding.edittextPassword, getString(R.string.password_set_hint), 15)
        setEditTextHintSize(binding.edittextPasswordConfirm, getString(R.string.password_confirm_hit), 15)

        val inputMethodManager = (getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager)
        binding.edittextPassword.requestFocus()
        inputMethodManager.showSoftInput(binding.edittextPassword, 0)
    }

}