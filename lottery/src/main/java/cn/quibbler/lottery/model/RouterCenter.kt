package cn.quibbler.lottery.model

object RouterCenter {

    /*argument*/
    const val argument_title = "activity_title"
    const val argument_file_name = "privacy_asset_file_name"
    const val argument_news_url = "news_web_url"

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
    const val self_activity_violation_notification = "$self_group/violation_notification"
    const val self_activity_other_notification = "$self_group/other_notification"
    const val self_activity_charge = "$self_group/charge"
    const val self_activity_charge_detail = "$self_group/charge_detail"
    const val self_activity_color_bean = "$self_group/color_bean"
    const val self_activity_color_bean_detail = "$self_group/bean_detail"
    const val self_activity_color_bean_redemption_records = "$self_group/redemption_records"
    const val self_activity_incentive_money = "$self_group/incentive_money"
    const val self_activity_incentive_money_detail = "$self_group/self_activity_incentive_money_detail"
    const val self_activity_coupon = "$self_group/coupon"
    const val self_activity_expired_coupon = "$self_group/expired_coupon"
    const val self_person_home_page = "$self_group/person_home"
    const val self_personal_setting_page = "$self_group/personal_setting"
    const val self_buy_record = "$self_group/buy_record"
    const val edit_personal_profile_page = "$self_group/edit_personal_profile"
    const val black_list_page = "$self_group/black_list"
    const val change_nickname_page = "$self_group/change_nickname"
    const val decorate_center_page = "$self_group/decorate_center"

    private const val message_group = "/message"
    const val message_activity = "$self_group/message"
    const val self_activity_message_settings = "$message_group/message_settings"
    const val message_activity_comment = "$message_group/comment"
    const val message_activity_thumbs = "$message_group/thumbs"
    const val message_activity_dot = "$message_group/dot"
    const val message_activity_new_fans = "$message_group/new_fans"
    const val activity_follow_and_fans = "$message_group/follow_and_fans"

    const val settings_activity = "$self_group/settings"
    const val settings_activity_account = "$settings_activity/account"
    const val settings_activity_upgrade = "$settings_activity/upgrade"
    const val settings_activity_about = "$settings_activity/about"
    const val settings_activity_about_user_agreement = "$settings_activity/about/privacy_common_view"
    const val settings_activity_pay = "$settings_activity/pay"
    const val settings_activity_pay_set_password = "$settings_activity_pay/set_password"
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

    const val custom_service_home_page = "/custom_service/home_page"
    const val feed_back_page = "/feed_back/page"
    const val activity_add_bank_card = "/add/bank_card"
    const val news_detail_activity = "/news/detail"

    private const val expert_group = "/expert"
    const val about_smart_recommend_activity = "$expert_group/about_smart_recommend"

    private const val tools_group = "/tools"
    const val historical_lottery_activity = "$tools_group/historical_lottery"
    const val trend_chart_activity = function_trend_activity
    const val simulated_number_selection_activity = function_simulate_activity
    const val bonus_calculator_activity = "$tools_group/bonus_calculator"
    const val vip_membership_activity = "$tools_group/vip_membership"
    const val data_statistics_activity = "$tools_group/data_statistics"
    const val trend_analysis_activity = "$tools_group/trend_analysis"
    const val real_time_hotspots_activity = "$tools_group/real_time_hotspots"
    const val moving_average_analysis_activity = function_analyze_activity
    const val number_selection_distribution_activity = function_choose_activity
    const val omitted_treasure_activity = function_pick_activity
}