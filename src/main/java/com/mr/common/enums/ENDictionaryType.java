package com.mr.common.enums;

/**
 * @author zhanxp
 * @version 1.0  2019/2/10
 * @Description todo
 */
public enum ENDictionaryType implements LabelAndValue<String> {
    CITY("1", "城市");
    private String value;
    private String label;

    ENDictionaryType(String value, String label) {
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
