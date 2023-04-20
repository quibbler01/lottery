package cn.quibbler.lottery.ui.activity

import android.graphics.Color
import android.graphics.Rect
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.TextPaint
import android.text.method.LinkMovementMethod
import android.text.style.AbsoluteSizeSpan
import android.text.style.ClickableSpan
import android.text.style.ForegroundColorSpan
import android.text.style.TextAppearanceSpan
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import cn.quibbler.lottery.R
import cn.quibbler.lottery.databinding.ActivityChargeBinding
import cn.quibbler.lottery.model.RouterCenter
import cn.quibbler.lottery.ui.adapter.ChoosePayChargeRecyclerAdapter
import cn.quibbler.lottery.utils.dip2px
import cn.quibbler.lottery.utils.getAppString
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter

@Route(path = RouterCenter.self_activity_charge)
class ChargeActivity : BaseActivity() {

    private lateinit var binding: ActivityChargeBinding

    private val adapter = ChoosePayChargeRecyclerAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChargeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.elevation = 0f

        showRightTitleText(getString(R.string.detailed)) {
            ARouter.getInstance()
                .build(RouterCenter.self_activity_charge_detail)
                .withString(RouterCenter.argument_title, getString(R.string.detailed))
                .navigation()
        }

        initView()
    }

    private fun initView() {
        setBannerTipsText()
        initTipsText()
        setAgreementTipsText()

        setPayNumber(adapter.listOfCharge[adapter.currentChoosePos])

        adapter.clickListener = object : View.OnClickListener {
            override fun onClick(v: View) {
                val pos = v.tag as Int
                if (adapter.currentChoosePos == pos) return

                val preChoose = adapter.currentChoosePos
                adapter.currentChoosePos = pos

                setPayNumber(adapter.listOfCharge[pos])

                adapter.notifyItemChanged(preChoose)
                adapter.notifyItemChanged(pos)
            }
        }
        val layoutManager = GridLayoutManager(this, 3)
        binding.chargeChooseList.layoutManager = layoutManager
        binding.chargeChooseList.addItemDecoration(object : RecyclerView.ItemDecoration() {
            override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
                val pos = parent.getChildAdapterPosition(view)
                val row = pos / layoutManager.spanCount
                if (row > 0) {
                    outRect.set(0, 30, 0, 0)
                }
            }
        })
        binding.chargeChooseList.adapter = adapter
    }

    private fun setPayNumber(count: Int) {
        val spannableStringBuilder = SpannableStringBuilder()
        spannableStringBuilder.append("${getString(R.string.should_pay_money_count)}$count")

        val pos = spannableStringBuilder.lastIndexOf("：")
        val colorSpan = ForegroundColorSpan(getColor(R.color.red_num))
        spannableStringBuilder.setSpan(colorSpan, pos + 1, spannableStringBuilder.length, Spannable.SPAN_EXCLUSIVE_INCLUSIVE)

        binding.shouldPayMoneyCount.text = spannableStringBuilder
    }

    private fun setBannerTipsText() {
        val spannableStringBuilder = SpannableStringBuilder()
        spannableStringBuilder.apply {
            append(SpannableStringBuilder().apply {
                append(SpannableStringBuilder().apply {
                    append(getAppString(R.string.charge_banner_tips_1))
                    setSpan(ForegroundColorSpan(Color.parseColor("#a63231")), 0, length, Spannable.SPAN_INCLUSIVE_INCLUSIVE)
                    setSpan(AbsoluteSizeSpan(dip2px(this@ChargeActivity, 15f)), 0, length, Spannable.SPAN_INCLUSIVE_INCLUSIVE)
                })
                append(SpannableStringBuilder().apply {
                    append("288${getAppString(R.string.yuan)}")
                    setSpan(ForegroundColorSpan(getColor(R.color.red_num)), 0, length, Spannable.SPAN_INCLUSIVE_INCLUSIVE)
                    setSpan(AbsoluteSizeSpan(dip2px(this@ChargeActivity, 18f)), 0, length, Spannable.SPAN_INCLUSIVE_INCLUSIVE)
                })
            })
            append("\n")
            append(SpannableStringBuilder().apply {
                append(SpannableStringBuilder().apply {
                    append(getAppString(R.string.charge_banner_tips_2))
                    setSpan(ForegroundColorSpan(Color.parseColor("#a63231")), 0, length, Spannable.SPAN_INCLUSIVE_INCLUSIVE)
                    setSpan(AbsoluteSizeSpan(dip2px(this@ChargeActivity, 15f)), 0, length, Spannable.SPAN_INCLUSIVE_INCLUSIVE)
                })
                append(SpannableStringBuilder().apply {
                    append("118${getAppString(R.string.yuan)}")
                    setSpan(ForegroundColorSpan(getColor(R.color.red_num)), 0, length, Spannable.SPAN_INCLUSIVE_INCLUSIVE)
                    setSpan(AbsoluteSizeSpan(dip2px(this@ChargeActivity, 18f)), 0, length, Spannable.SPAN_INCLUSIVE_INCLUSIVE)
                })
            })
        }

        binding.bannerTextView.text = spannableStringBuilder
    }

    private fun setAgreementTipsText() {
        val spannableStringBuilder = SpannableStringBuilder()
        spannableStringBuilder.append(getString(R.string.charge_agree_text))

        val startPos = spannableStringBuilder.indexOf("《")
        val endPos = spannableStringBuilder.lastIndexOf("》")

        //val colorSpan = ForegroundColorSpan(Color.parseColor("#3876ff"))
        //spannableStringBuilder.setSpan(colorSpan, startPos, endPos + 1, Spannable.SPAN_INCLUSIVE_INCLUSIVE)

        val clickableSpan = object : ClickableSpan() {
            override fun updateDrawState(ds: TextPaint) {
                super.updateDrawState(ds)

                ds.bgColor = Color.TRANSPARENT
                ds.color = Color.parseColor("#3876ff")
                ds.linkColor = Color.parseColor("#3876ff")
                ds.isUnderlineText = false
            }

            override fun onClick(widget: View) {
                ARouter.getInstance().build(RouterCenter.settings_activity_about_user_agreement)
                    .withString(RouterCenter.argument_title, getAppString(R.string.settings_charge_agreement))
                    .withString(RouterCenter.argument_file_name, PrivacyCommonViewActivity.chargeAgreement).navigation()
            }
        }
        spannableStringBuilder.setSpan(clickableSpan, startPos, endPos + 1, Spannable.SPAN_INCLUSIVE_INCLUSIVE)

        binding.chargeAgreeText.movementMethod = LinkMovementMethod.getInstance()
        binding.chargeAgreeText.text = spannableStringBuilder
    }

    private fun initTipsText() {
        val spannableStringBuilder = SpannableStringBuilder()

        spannableStringBuilder.append(getString(R.string.charge_tips_text))
        val highlightStr = getString(R.string.charge_tips_text_highlight)
        val startPos = spannableStringBuilder.indexOf(highlightStr)
        spannableStringBuilder.setSpan(ForegroundColorSpan(Color.RED), startPos, startPos + highlightStr.length, Spannable.SPAN_INCLUSIVE_EXCLUSIVE)

        binding.chargeTips.text = spannableStringBuilder
    }

}