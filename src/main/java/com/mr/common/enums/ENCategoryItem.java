package com.mr.common.enums;

/**
 * @author zhanxp
 * @version 1.0  2019/2/10
 * @Description todo
 */
public enum ENCategoryItem implements LabelAndValue<String> {
    NATURE("NATURE", "自然风光"),
    HISTORY("HISTORY", "历史遗迹"),
    FORMER_RESIDENCE("FORMER_RESIDENCE", "名人故居"),
    PARK("PARK", "公园乐园"),
    ARCHITECTURE("ARCHITECTURE", "人文建筑"),
    SPECIAL_BLOCK("SPECIAL_BLOCK", "特色街区"),
    MOVIE_CITY("MOVIE_CITY", "影视城"),
    RELIGION("RELIGION", "宗教场所"),
    SOCIAL_CUSTOM("SOCIAL_CUSTOM", "民风民俗");
    private String value;
    private String label;

    ENCategoryItem(String value, String label) {
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
