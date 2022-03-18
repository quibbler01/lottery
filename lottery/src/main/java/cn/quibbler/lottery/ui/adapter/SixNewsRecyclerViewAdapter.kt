package cn.quibbler.lottery.ui.adapter

import android.text.Html
import android.util.Log
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import cn.quibbler.lottery.LotteryApplication.Companion.getContext
import cn.quibbler.lottery.LotteryApplication.Companion.getInflater
import cn.quibbler.lottery.databinding.NewsItemLayoutBinding
import cn.quibbler.lottery.databinding.NewsRecyclerViewBinding
import cn.quibbler.lottery.model.RouterCenter
import cn.quibbler.lottery.model.bean.NewsChannels
import cn.quibbler.lottery.model.bean.NewsLists
import cn.quibbler.lottery.repository.network.retrofit.NewsService
import cn.quibbler.lottery.repository.network.retrofit.RetrofitHelper
import com.alibaba.android.arouter.launcher.ARouter
import com.bumptech.glide.Glide
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SixNewsRecyclerViewAdapter : RecyclerView.Adapter<SixNewsRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = NewsRecyclerViewBinding.inflate(getInflater(), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val layoutManager = LinearLayoutManager(getContext())
        layoutManager.isAutoMeasureEnabled = true
        holder.binding.recyclerView.layoutManager = layoutManager
        holder.binding.recyclerView.adapter = NewsRecyclerViewAdapter()
    }

    override fun getItemCount(): Int = 1

    class ViewHolder(val binding: NewsRecyclerViewBinding) : RecyclerView.ViewHolder(binding.root)


    private class NewsRecyclerViewAdapter : RecyclerView.Adapter<NewsRecyclerViewAdapter.ViewHolder>() {

        private val list = ArrayList<NewsLists.Item>()

        init {
            val service = RetrofitHelper.retrofit.create(NewsService::class.java)
            val call: Call<NewsLists> = service.getNewsLists()
            call.enqueue(object : Callback<NewsLists> {
                override fun onResponse(call: Call<NewsLists>, response: Response<NewsLists>) {
                    response.body()?.result?.result?.list?.let {
                        val start = list.size
                        list.addAll(it)
                        notifyItemRangeInserted(start, it.size)
                    }
                }

                override fun onFailure(call: Call<NewsLists>, t: Throwable) {

                }
            })
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val binding = NewsItemLayoutBinding.inflate(getInflater(), parent, false)
            return ViewHolder(binding)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.binding.root.setOnClickListener {
                val item = list[position]
                ARouter.getInstance().build(RouterCenter.news_detail_activity)
                        .withString(RouterCenter.argument_news_url, item.url)
                        .withString(RouterCenter.argument_title, item.title)
                        .navigation()
            }

            if (position != 0) holder.binding.topIcon.visibility = View.GONE
            if (position > 2) holder.binding.topic.visibility = View.GONE

            val item = list[position]
            holder.binding.title.text = Html.fromHtml(item.content, Html.FROM_HTML_MODE_COMPACT)
            holder.binding.time.text = item.time
            holder.binding.src.text = item.src
            Glide.with(holder.binding.image).load(item.pic).into(holder.binding.image)
        }

        override fun getItemCount(): Int = list.size

        class ViewHolder(val binding: NewsItemLayoutBinding) : RecyclerView.ViewHolder(binding.root)

    }

}