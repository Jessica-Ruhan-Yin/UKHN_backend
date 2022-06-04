package com.UKHN.server.enums;

/**
 * @Description
 * @Author Jessica
 * @Version v
 * @Date 2021/9/11
 */
public enum CategoryEnum {

    HOME("00000100", "首页"),
    HOME_ADVERTISEMENT("00000101", "通告"),
    HOME_ACTIVITY("00000102", "广告"),
    HOME_COLLABORATION("00000103", "合作机构"),

    TRADE("00000200", "自贸港专栏"),
    TRADE_POLICY("00000201", "政策福利"),
    TRADE_INVESTMENT("00000202", "招商引资"),
    TRADE_COLLABORATION("00000203", "项目合作"),
    TRADE_PROMOTION("00000204", "宣传推广"),

    COLLABORATION("00000300", "产业合作"),
    COLLABORATION_CHINA("00000301", "国内企业合作"),
    COLLABORATION_UK_IRELAND("00000302", "英国及爱尔兰企业合作"),
    COLLABORATION_CHINA_UK_IRELAND("00000303", "中英、中爱企业合作"),

    ACADEMIC("00000400", "学术交流"),
    ACADEMIC_FORUM("00000401", "学术论坛"),
    ACADEMIC_SEMINAR("00000402", "研讨会"),
    ACADEMIC_REPORT("00000403", "学术报告"),
    ACADEMIC_STUDY_ABROAD("00000404", "留学申请"),

    ASSOCIATION("00000500", "同乡会介绍"),
    ASSOCIATION_ACTIVITY("00000501", "同乡会活动"),
    ASSOCIATION_INTRO("00000502", "简介"),
    ASSOCIATION_COUNCIL("00000503", "理事会"),
    ASSOCIATION_ENROLL("00000504", "招新");

    private String code;

    private String desc;

    CategoryEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    /**
     * 根据code得到枚举类型
     */
    public static CategoryEnum getByCode(String code) {
        for (CategoryEnum e : CategoryEnum.values()) {
            if (code.equals(e.getCode())) {
                return e;
            }
        }
        return null;
    }
}