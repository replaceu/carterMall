package com.mall4j.cloud.firmware.constant;

public class MsgConstants {
    public final static String	errCode			= "-1";
    public final static String	missingToken	= "84";

    /**
     * code 00
     * @return
     */
    public static String requestSuccess() {
        return "成功！";
    }

    /**
     * code 99
     * @return
     */
    public static String throwException() {
        return "服务器异常！";
    }

    /**
     * code 98
     * @return
     */
    public static String errorRequestParam() {
        return "请求参数错误！";
    }

    /**
     * code 89
     * @return
     */
    public static String missingHomeGreeting() {
        return "无智能关怀信息！";
    }

    /**
     * code 88
     * @return
     */
    public static String missingBanner() {
        return "无Banner信息！";
    }

    /**
     * code 87
     * @return
     */
    public static String missingUser() {
        return "无此用户信息！";
    }

    /**
     * code 86
     * @return
     */
    public static String errorMD5() {
        return "MD5编码异常！";
    }

    /**
     * code 85
     * @return
     */
    public static String errorPassword() {
        return "密码错误！";
    }

    /**
     * code 84
     * @return
     */
    public static String missingToken() {
        return "无此token，请重新登陆！";
    }

    /**
     * code 83
     * @return
     */
    public static String notFirstScan() {
        return "该SN码已被扫描！";
    }

    /**
     * code 82
     * @return
     */
    public static String userExisted() {
        return "该用户已存在！";
    }

    /**
     * code 81
     * @return
     */
    public static String updateRoundError() {
        return "参数格式错误，圆盘更新失败！";
    }

    /**
     * code 80
     * @return
     */
    public static String missingPointGift() {
        return "无可兑换的礼物！";
    }

    /**
     * code 79
     * @return
     */
    public static String missingCodeGift() {
        return "无效的礼品兑换码！";
    }

    /**
     * code 78
     * @return
     */
    public static String missingMembership() {
        return "无此会员！";
    }

    /**
     * code 76
     * @return
     */
    public static String notEnoughUserPoints() {
        return "魅力值不足！";
    }

    /**
     * code 75
     * @return
     */
    public static String notBindingUser() {
        return "该用户未绑定任何设备！";
    }

    /**
     * code 74
     * @return
     */
    public static String notPositionUFO() {
        return "该设备绑定用户已满、需解绑其他用户再进行绑定！";
    }

    /**
     * code 73
     * @return
     */
    public static String userBindingExisted() {
        return "该用户已绑定其他设备、请解绑后再进行绑定！";
    }

    /**
     * code 72
     * @return
     */
    public static String verificationCodeExpired() {
        return "验证码已过期、请重新申请！";
    }

    /**
     * code 71
     * @return
     */
    public static String errorVerificationCode() {
        return "验证码错误！";
    }

    /**
     * code 70
     * @return
     */
    public static String errorSN() {
        return "无效的SN！";
    }

    /**
     * code 69
     * @return
     */
    public static String missingMaskPackage() {
        return "您的面膜无法识别，请购买FOREO正品面膜";
    }

    /**
     * code 68
     * @return
     */
    public static String missingMaskType() {
        return "您的面膜无法识别，请购买FOREO正品面膜";
    }

    /**
     * code 67
     * @return
     */
    public static String uploadFail() {
        return "上传失败！";
    }

    /**
     * code 66
     * @return
     */
    public static String errorPasswordBinding() {
        return "绑定失败、密码错误！";
    }

    /**
     * code 65
     * @return
     */
    public static String thirdpartyBindingExisted() {
        return "您的手机号已绑定其他账号。请确认是否更换绑定？"; //手机号已经绑定了 微信ID 或 微博ID
    }

    /**
     * code 64
     * @return
     */
    public static String missingThirdpartyBinding() {
        return "未传入第三方id！";
    }

    /**
     * code 63
     * @return
     */
    public static String ufoRegisterExisted() {
        return "此设备已被注册！";
    }

    /**
     * code 62
     * @return
     */
    public static String notRegisterUserUFO() {
        return "该用户未注册过任何设备！";
    }

    /**
     * code 61
     * @return
     */
    public static String usedGiftCode() {
        return "该礼品券已被使用！";
    }

    /**
     * code 60
     * @return
     */
    public static String waitingUseGiftCode() {
        return "该礼品券等待使用！";
    }

    /**
     * code 59
     * @return
     */
    public static String missingAppVersion() {
        return "无APP版本！";
    }

    /**
     * code 58
     * @return
     */
    public static String missingMaskPackagePart() {
        return "无此面膜子包装！";
    }

    /**
     * code 57
     * @return
     */
    public static String existReasonUserPoints(String reason) {
        return reason + "魅力值已增加过！";
    }

    /**
     * code 56
     * @return
     */
    public static String missingProductDevice() {
        return "无此产品设备信息！";
    }

    /**
     * code 55
     * @return
     */
    public static String maskPackagePartByPackageIdExisted() {
        return "该包装下此子包装已存在！";
    }

    /**
     * code 54
     * @return
     */
    public static String notNullPassword() {
        return "密码不能为空！";
    }

    /**
     * code 53
     * @return
     */
    public static String notOnlineFunction() {
        return "该功能暂未上线、敬请期待！";
    }

    /**
     * code 52
     * @return
     */
    public static String notNullMobile() {
        return "手机号码不能为空";
    }

    /**
     * 51
     * @return
     */
    public static String str2jsonException() {

        return "JSON字符串异常";
    }

    /**
     * 50
     * @return
     */
    public static String notExistID(Integer id) {

        return "不存在ID为：" + id + "的收货地址";
    }

    /**
     * 49
     * @return
     */
    public static String notExistOrder(String id) {

        return "不存在Parent_order_id为：" + id + "的订单";
    }

    /**
     * 48
     * @return
     */
    public static String scanMaskAddPointExisted() {

        return "本盒面膜已经令您魅力加成，无需重复扫入";
    }

    /**
     * 47
     * @return
     */
    public static String notExistedMaskSN() {

        return "您的面膜无法识别，请购买FOREO正品面膜";
    }

    /**
     * 46
     * @return
     */
    public static String notExistedActivity(Integer id) {

        return "不存在id为：" + id + " 的优惠券";
    }

    /**
     * 45
     * @return
     */
    public static String notExistedUserPoints(String usrname) {

        return "用户【" + usrname + "】 没有分数";
    }

    /**
     * 44
     * @return
     */
    public static String notExistedAvailableCoupons() {

        return "本次订单暂时没有可用的优惠券";
    }

    /**
     * 43
     * @return
     */
    public static String alreadyExchangeGift() {

        return "你已经有一份未使用的该礼品";
    }

    /**
     * 42
     * @return
     */
    public static String beyondLimitVol() {

        return "超出领取次数限制";
    }

    /**
     * 41
     * @return
     */
    public static String firmwareNotExist() {

        return "固件不存在";
    }

    /**
     * 40
     * @return
     */
    public static String boxEan() {
        return "您确定扫入的是盒装面膜的序列号吗？";
    }

    /**
     * 39
     * @return
     */
    public static String fofoError(String resultCode) {
        return "肌肤检测结果：" + resultCode + ",无法对应上R1-R8";
    }

    /**
     * 38
     * @return
     */
    public static String deviceRegisterError() {
        return "设备异常，请联系客服";
    }

    /**
     * 37
     * @return
     */
    public static String deviceVerifyError() {
        return "您的设备无法识别，请在FOREO正规销售渠道购买设备";
    }

    /**
     * 36
     * @return
     */
    public static String deviceVerifyError2() {
        return "FOREO 接口无法链接上";
    }

    /**
     * 35
     * @return
     */
    public static String deviceVerifyError3() {
        return "FOREO 接口返回值异常";
    }

    /**
     * 34
     * @return
     */
    public static String roleIsDelete() {
        return "该角色已被删除，不能操作";
    }

    /**
     * 33
     * @return
     */
    public static String noBaseImg() {
        return "没有改类型的基底图";
    }

    /**
     * 32
     * @return
     */
    public static String noSuccessImg() {
        return "分享图生成失败";
    }

    /**
     * 31
     * @return
     */
    public static String serverBusy() {
        return "服务器繁忙，请稍后再试";
    }

    /**
     * 30
     * @return
     */
    public static String registerFatal() {
        return "注册遇到困难，请联系客服";
    }

    /**
     * 29
     * @return
     */
    public static String notExistedAppMedia() {
        return "媒体信息不存在";
    }

    /**
     * 28
     * @return
     */
    public static String idInvalid() {
        return "错误的id";
    }

    /**
     * 27
     * @return
     */
    public static String snActivatedErr() {
        return "该设备已被激活";
    }

    /**
     * 26
     * @return
     */
    public static String noNeedFqcHotfix() {
        return "不需要走fqc异常流程";
    }

    /**
     * 25
     * @return
     */
    public static String userInvalidErr() {
        return "您的账号存在异常,请联系客服再次激活账号";
    }

    public static String ErrorMAC() {
        return "错误的mac";
    }

    public static String stoppedPoint() {
        return "已停止发放魅力值";
    }
}
