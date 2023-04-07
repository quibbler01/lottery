package cn.quibbler.lottery.ui.activity

import android.os.Bundle
import cn.quibbler.lottery.R
import cn.quibbler.lottery.databinding.ActivityFeedbackBinding
import cn.quibbler.lottery.model.RouterCenter
import cn.quibbler.lottery.ui.adapter.PictureChooseRecyclerAdapter
import cn.quibbler.lottery.utils.setEditTextHintSize
import com.alibaba.android.arouter.facade.annotation.Route

@Route(path = RouterCenter.feed_back_page)
class FeedbackActivity : BaseActivity() {

    private lateinit var binding: ActivityFeedbackBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFeedbackBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.elevation = 0f

        initViews()
    }

    private fun initViews() {
        setEditTextHintSize(binding.questionInput, getString(R.string.question_description_hit), 14)

        binding.imageChooseRecyclerView.adapter = PictureChooseRecyclerAdapter()
    }

}