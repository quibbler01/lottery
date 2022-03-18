package cn.quibbler.lottery.ui.adapter

import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import cn.quibbler.lottery.LotteryApplication.Companion.getInflater
import cn.quibbler.lottery.R
import cn.quibbler.lottery.databinding.SelfCardItemBinding
import cn.quibbler.lottery.model.RouterCenter
import cn.quibbler.lottery.model.bean.CardItem
import cn.quibbler.lottery.utils.getAppDrawable
import cn.quibbler.lottery.utils.getAppString

class MyCardAdapter : BaseAdapter() {

    private val cardList = ArrayList<CardItem>()

    init {
        cardList.add(CardItem(getAppString(R.string.my_card_activity_center), getAppDrawable(R.drawable.my_card_activity_center), RouterCenter.self_activity_center))
        cardList.add(CardItem(getAppString(R.string.my_card_wechat), getAppDrawable(R.drawable.my_card_wechat), RouterCenter.self_activity_wechat))
        cardList.add(CardItem(getAppString(R.string.my_card_task), getAppDrawable(R.drawable.my_card_task), RouterCenter.self_activity_task))
        cardList.add(CardItem(getAppString(R.string.my_card_news), getAppDrawable(R.drawable.my_card_news), RouterCenter.self_activity_information))
        cardList.add(CardItem(getAppString(R.string.my_card_buy), getAppDrawable(R.drawable.my_card_buy), RouterCenter.self_activity_bought))
        cardList.add(CardItem(getAppString(R.string.my_card_smiulate_record), getAppDrawable(R.drawable.my_card_smiulate_record), RouterCenter.self_activity_simulate))
        cardList.add(CardItem(getAppString(R.string.my_card_help), getAppDrawable(R.drawable.my_card_help), RouterCenter.self_activity_help))
        cardList.add(CardItem(getAppString(R.string.my_card_game_center), getAppDrawable(R.drawable.my_card_game_center), RouterCenter.self_activity_game_center))
        cardList.add(CardItem(getAppString(R.string.my_card_bounce), getAppDrawable(R.drawable.my_card_bounce), RouterCenter.self_activity_bounce))
    }

    override fun getCount(): Int = cardList.size

    override fun getItem(position: Int): CardItem = cardList[position]

    override fun getItemId(position: Int): Long = 0

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val binding: SelfCardItemBinding
        if (convertView == null) {
            binding = SelfCardItemBinding.inflate(getInflater(), parent, false)
            binding.root.tag = binding
        } else {
            binding = convertView.tag as SelfCardItemBinding
        }

        val item = getItem(position)
        binding.cardLabel.text = item.label
        binding.cardIcon.setImageDrawable(item.icon)

        return binding.root
    }

}