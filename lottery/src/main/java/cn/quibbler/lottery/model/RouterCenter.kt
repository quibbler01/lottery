package cn.quibbler.lottery.model

object RouterCenter {

    /*argument*/
    const val argument_title = "title"
    const val argument_file_name = "file_name"

    private const val self_group = "/self"
    const val self_activity_center = "$self_group/activity_center"
    const val self_activity_wechat = "$self_group/activity_wechat"
    const val self_activity_share = "$self_group/activity_share"
    const val self_activity_task = "$self_group/activity_task"
    const val self_activity_information = "$self_group/activity_information"
    const val self_activity_bought = "$self_group/activity_bought"
    const val self_activity_simulate = "$self_group/activity_simulate "
    const val self_activity_help = "$self_group/activity_help"
    const val self_activity_system_notification = "$self_group/system_notification"

    private const val message_group = "/message"
    const val self_activity_message_settings = "$message_group/message_settings"
    const val message_activity_comment = "$message_group/comment"
    const val message_activity_thumbs = "$message_group/thumbs"
    const val message_activity_dot = "$message_group/dot"
    const val message_activity_fans = "$message_group/fans"

    const val self_person_home_page = "$self_group/person_home"
    const val self_buy_record = "$self_group/buy_record"

    const val custom_service_home_page = "/custom_service/home_page"
    const val feed_back_page = "/feed_back/page"

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

    const val activity_add_bank_card = "/add/bank_card"
}