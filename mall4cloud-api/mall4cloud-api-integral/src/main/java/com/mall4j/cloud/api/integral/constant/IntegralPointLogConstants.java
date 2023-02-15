package com.mall4j.cloud.api.integral.constant;

public interface IntegralPointLogConstants {
    String subtract = "-";

    String integralPointLog = "/integralPointLog";

    String backendIntegralPointLog = "/backendIntegralPointLog";

    interface RefType {
        //活动签到
        String a_activity_checkin = "a_activity_checkin";
        //关注微信公众号
        String a_wechat_subscribe = "a_wechat_subscribe";
        //邀请有礼
        String a_invitation = "a_invitation";
        //添加企微
        String a_wechat_company_add = "a_wechat_company_add";
        //添加我的小程序
        String a_wechat_miniApp_add = "a_wechat_miniApp_add";
        //积分抽奖
        String c_lucky_draw = "c_lucky_draw";
        //活动奖励
        String a_activity_add = "a_activity_add";
        //积分兑换(优惠券)
        String c_redeem_online_coupon = "c_redeem_online_coupon";
        //积分兑换(lann体验)
        String c_redeem_offline_lann = "c_redeem_offline_lann";
        //人工调整-增加
        String a_custom = "a_custom";
        //人工调整-减少
        String c_custom = "c_custom";
        //购物积分
        String a_order_payment = "a_order_payment";
        //每日签到
        String a_daily_checkin = "a_daily_checkin";
        //完善个人信息
        String a_complete_profile = "a_complete_profile";
        //注册仪器
        String a_product_registration = "a_product_registration";
        //使用仪器
        String a_product_use = "a_product_use";
        //黑卡生礼4选1
        String a_black_gift = "a_black_gift";
        //人工调整-历史积分结算
        String a_order_payment_accumulation = "a_order_payment_accumulation";
        //退货积分
        String c_order_payament = "c_order_payament";
        //积分到期
        String c_point_expired = "c_point_expired";
        //积分兑换(环球影城)-积分兑换
        String c_redeem_offline_uni_studios = "c_redeem_offline_uni_studios";
        //礼品卡兑换（视频会员，星巴克）-积分兑换
        String c_redeem_online_giftCard = "c_redeem_online_giftCard";
        //收货增加积分
        String a_order_complete = "a_order_complete";
        //退货减少积分
        String c_order_refund = "c_order_refund";
    }

    interface MappingConstants {
        String	backendListIntegralPointLog		= "/backendListIntegralPointLog";
        String	backendAddIntegralPointLogList	= "/backendAddIntegralPointLogList";
        String	backendEditIntegralPointLog		= "/backendEditIntegralPointLog";
        String	backendDelIntegralPointLog		= "/backendDelIntegralPointLog/{id}";
        String	backendGetByIdIntegralPointLog	= "/backendGetByIdIntegralPointLog/{id}";
        String	userIntegralPointLogList		= "/userIntegralPointLogList";
        String	backendMarkIntegralPointLog		= "/backendMarkIntegralPointLog";
        String	addPoint						= "/addPoint";
        String	balancePoint					= "/balancePoint";
    }

    interface RspCode {
        String	dataIsEmptyErr				= "dataIsEmptyErr|需要更改的积分该字段不能为空";
        String	userNotExistErr				= "userNotExistErr|用户不存在";
        String	paramsIsEmptyErr			= "paramsIsEmptyErr|上传的参数不能为空";
        String	userIntegralPointNotEnough	= "userIntegralPointNotEnough|用户会员积分不够调整";
        String	batchInsertLogErr			= "batchInsertLogErr|批量插入用户积分错误";
        String	batchUpdateLogErr			= "batchUpdateLogErr|批量更新用户积分错误";
    }

    interface RefValue {
        String	a_activity_checkin			= "2022情人节活动每日签到积分";
        String	a_wechat_subscribe			= "2021中秋国庆活动关注公众号加50积分";
        String	a_invitation				= "2021中秋国庆活动邀请新会员加20积分";
        String	a_wechat_company_add		= "2021中秋国庆活动次添加企微客服100分";
        String	a_wechat_miniApp_add		= "2021中秋国庆活动添加小程序加20积分";
        String	c_lucky_draw				= "2021中秋国庆活动抽奖减20积分";
        String	a_activity_add				= "2022双十一活动增加积分";
        String	a_daily_checkin				= "2022情人节活动每日签到积分";
        String	a_activity_double			= "2022情人节活动签到积分翻倍";
        String	a_daily_checkin_womanDay	= "2022妇女节活动每日签到积分";
        String	a_daily_checkin_configPrize	= "连续签到发放奖励积分";
        String	a_daily_checkin_activity	= "日常签到发放积分";
        String	a_black_birth_gift			= "黑卡生日礼4选1";

    }

    interface UpdatePointErrType {
        String	dataIsEmptyErr		= "需要更改的积分该字段不能为空";
        String	userNotExistErr		= "用户不存在";
        String	pointNotEnoughErr	= "用户会员积分不够调整";
    }

    interface UserPointErrType {
        String dataIsRepeatErr = "dataIsRepeatErr";
    }

    /**
     * refValue和refType的枚举
     */
    enum RefValueRefTypeEnum {
        a_activity_add(RefValue.a_activity_add, "a_activity_add"), a_daily_checkin(RefValue.a_daily_checkin, "a_daily_checkin"), a_activity_double(RefValue.a_activity_double, "a_activity_add"), a_daily_checkin_womanDay(RefValue.a_daily_checkin_womanDay, "a_activity_add"), a_daily_checkin_configPrize(RefValue.a_daily_checkin_configPrize, "a_activity_add"), a_black_birth_gift(RefValue.a_black_birth_gift, "a_black_gift"), a_daily_checkin_activity(RefValue.a_daily_checkin_activity, "a_activity_add");

        String	refType;
        String	refValue;

        RefValueRefTypeEnum(String refValue, String refType) {
            this.refValue = refValue;
            this.refType = refType;

        }

        public static RefValueRefTypeEnum getByRefValue(String refValue) {
            RefValueRefTypeEnum[] values = RefValueRefTypeEnum.values();
            for (RefValueRefTypeEnum refType : values) {
                if (refType.getRefValue().equals(refValue)) { return refType; }
            }
            return null;
        }

        public String getRefType() {
            return refType;
        }

        public void setRefType(String refType) {
            this.refType = refType;
        }

        public String getRefValue() {
            return refValue;
        }

        public void setRefValue(String refValue) {
            this.refValue = refValue == null ? null : refValue.trim();
        }
    }

    /**
     * refType对应logTitle枚举
     */
    enum RefTypeLogTitleEnum {
        a_activity_checkin(RefType.a_activity_checkin, "活动签到"), a_wechat_subscribe(RefType.a_wechat_subscribe, "关注公众号"), a_invitation(RefType.a_invitation, "邀请有礼"), a_wechat_company_add(RefType.a_wechat_company_add, "添加企微"), a_wechat_miniApp_add(RefType.a_wechat_miniApp_add, "添加我的小程序"), c_lucky_draw(RefType.c_lucky_draw, "积分抽奖"), a_activity_add(RefType.a_activity_add, "活动奖励"), c_redeem_online_coupon(RefType.c_redeem_online_coupon, "积分兑换"), c_redeem_offline_lann(RefType.c_redeem_offline_lann, "积分兑换"), c_redeem_online_giftCard(RefType.c_redeem_online_giftCard, "积分兑换"), a_custom(RefType.a_custom, "人工调整"), c_custom(RefType.c_custom, "人工调整"), a_order_payment(RefType.a_order_payment, "购物积分"), a_daily_checkin(RefType.a_daily_checkin, "每日签到"), a_complete_profile(RefType.a_complete_profile, "完善个人信息"), a_product_registration(RefType.a_product_registration, "注册仪器"), a_product_use(RefType.a_product_use, "使用仪器"), a_order_payment_accumulation(RefType.a_order_payment_accumulation, "人工调整"),
        c_order_payament(RefType.c_order_payament, "退货积分"), c_point_expired(RefType.c_point_expired, "积分到期"), c_redeem_offline_uni_studios(RefType.c_redeem_offline_uni_studios, "积分兑换"), a_order_complete(RefType.a_order_complete, "收货增加积分"), a_black_birth_gift(RefType.a_black_gift, "黑卡礼"), c_order_refund(RefType.c_order_refund, "退货减少积分");

        String	refType;
        String	logTitle;

        RefTypeLogTitleEnum(String refType, String logTitle) {
            this.refType = refType;
            this.logTitle = logTitle;
        }

        public static RefTypeLogTitleEnum getByRefType(String refType) {
            RefTypeLogTitleEnum[] values = RefTypeLogTitleEnum.values();
            for (RefTypeLogTitleEnum rtlte : values) {
                if (rtlte.getRefType().equals(refType)) { return rtlte; }
            }
            return null;
        }

        public String getRefType() {
            return refType;
        }

        public void setRefType(String refType) {
            this.refType = refType;
        }

        public String getLogTitle() {
            return logTitle;
        }

        public void setLogTitle(String logTitle) {
            this.logTitle = logTitle;
        }

    }
}
