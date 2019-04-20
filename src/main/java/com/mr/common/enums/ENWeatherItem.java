package com.mr.common.enums;

/**
 * @author zhanxp
 * @version 1.0  2019/2/10
 * @Description todo
 */
public enum ENWeatherItem implements LabelAndValue<String> {
    SUNNY("SUNNY", "晴"),

    CLOUDY("CLOUDY", "多云"),

    RAIN("RAIN", "雨天");

    private String value;
    private String label;

    ENWeatherItem(String value, String label) {
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
