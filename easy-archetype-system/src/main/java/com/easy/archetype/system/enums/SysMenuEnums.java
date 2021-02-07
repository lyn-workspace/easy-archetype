package com.easy.archetype.system.enums;

/**
 * 菜单枚举
 *
 * @author luyanan
 * @since 2021/2/7
 **/
public enum SysMenuEnums {


    TYPE_DIR("M", "目录"),
    TYPE_MENU("C", "菜单"),
    TYPE_BUTTON("F", "按钮"),

    STATUS_NORMAL(0, "显示"),
    STATUS_EXCEPTION(1, "隐藏"),

    YES_FRAME(0, "是"),
    NO_FRAME(1, "否"),
    LAYOUT("Layout", "Layout组件标识"),

    PARENT_VIEW("ParentView", "ParentView组件标识");
    private String code;

    private String desp;

    SysMenuEnums(String code, String desp) {
        this.code = code;
        this.desp = desp;
    }

    SysMenuEnums(Integer code, String desp) {
        this.code = code + "";
        this.desp = desp;
    }

    public String getCode() {
        return code;
    }

    public Integer getCodeInt() {
        return Integer.valueOf(code);
    }

    public String getDesp() {
        return desp;
    }
}
