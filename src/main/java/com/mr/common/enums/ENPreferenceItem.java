package com.mr.common.enums;

/**
 * @author zhanxp
 * @version 1.0  2019/2/10
 * @Description todo
 */
public enum ENPreferenceItem implements LabelAndValue<String> {
    ENTERTAINMENT("ENTERTAINMENT", "娱乐"),
    QUIET("QUIET", "安静"),
    NATURAL("NATURAL", "自然"),
    HISTORY("HISTORY", "历史"),
    LIVELY("LIVELY", "热闹"),
    STIMULATE("STIMULATE", "刺激"),
    CONCEALMENT("CONCEALMENT", "隐蔽");
    private String value;
    private String label;

    ENPreferenceItem(String value, String label) {
        this.value = value;
        this.label = label;
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public String getLabel() {
        return label;
    }
}
