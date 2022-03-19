package cn.quibbler.lottery.model

object RouterCenter {

    private const val self_group = "/self"
    const val self_activity_center = "$self_group/activity_center"
    const val self_activity_wechat = "$self_group/activity_wechat"
    const val self_activity_task = "$self_group/activity_task"
    const val self_activity_information = "$self_group/activity_information"
    const val self_activity_bought = "$self_group/activity_bought"
    const val self_activity_simulate = "$self_group/activity_simulate "
    const val self_activity_help = "$self_group/activity_help"
    const val self_activity_game_center = "$self_group/activity_game_center"
    const val self_activity_bounce = "$self_group/activity_bounce"

    const val news_detail_activity = "/news/detail"
    const val argument_news_url = "url"

    const val message_activity = "$self_group/message"
    const val settings_activity = "$self_group/settings"

    /*argument*/
    const val argument_title = "title"

}