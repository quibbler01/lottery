package cn.quibbler.lottery.ui.activity

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.inputmethod.InputMethodManager
import cn.quibbler.lottery.R
import cn.quibbler.lottery.databinding.ActivityEditNickNameBinding
import cn.quibbler.lottery.model.RouterCenter
import com.alibaba.android.arouter.facade.annotation.Route

@Route(path = RouterCenter.change_nickname_page)
class EditNickNameActivity : BaseActivity() {

    companion object {
        const val MAX_NICKNAME_LENGTH = 15
    }

    private lateinit var binding: ActivityEditNickNameBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditNickNameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.elevation = 0f

        showRightTitleText(getString(R.string.save)) {
            finish()
        }

        initView()
    }

    private fun initView() {
        updateNicknameLengthIndicatorText()

        binding.inputNicknameEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                updateNicknameLengthIndicatorText()
            }

            override fun afterTextChanged(s: Editable?) {
            }
        })

        binding.inputNicknameEditText.requestFocus()
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.showSoftInput(binding.inputNicknameEditText, 0)
    }

    private fun updateNicknameLengthIndicatorText() {
        binding.nickNameLengthIndicatorText.text = "${binding.inputNicknameEditText.text.length}/$MAX_NICKNAME_LENGTH"
    }

}