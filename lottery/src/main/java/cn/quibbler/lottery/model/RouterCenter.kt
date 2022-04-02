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

    const val self_person_home_page = "$self_group/person_home"

    const val news_detail_activity = "/news/detail"
    const val argument_news_url = "url"

    const val message_activity = "$self_group/message"
    const val settings_activity = "$self_group/settings"
    const val settings_activity_account = "$settings_activity/account"
    const val settings_activity_pay = "$settings_activity/pay"
    const val settings_activity_upgrade = "$settings_activity/upgrade"
    const val settings_activity_about = "$settings_activity/about"
    const val settings_activity_about_user_agreement = "$settings_activity/about/privacy_common_view"
    const val settings_activity_about_privacy = settings_activity_about_user_agreement
    const val settings_activity_about_socity = settings_activity_about_user_agreement
    const val settings_activity_pay_password = "$settings_activity_pay/password"
    const val settings_activity_pay_bankcard = "$settings_activity_pay/bankcard"
    const val settings_activity_pay_realname = "$settings_activity_pay/realname"

    private const val card_group = "/card"
    const val function_recommend_activity = "$card_group/recommend"
    const val function_open_bounce_activity = "$card_group/open_bounce"
    const val function_game_center_activity = "$card_group/game_center"
    const val function_trend_activity = "$card_group/trend"
    const val function_scan_activity = "$card_group/scan"
    const val function_choose_activity = "$card_group/choose"
    const val function_analyze_activity = "$card_group/analyze"
    const val function_pick_activity = "$card_group/pick"
    const val function_rainbow_activity = "$card_group/rainbow"
    const val function_simulate_activity = "$card_group/simulate"

    /*argument*/
    const val argument_title = "title"
    const val argument_file_name = "file_name"

}