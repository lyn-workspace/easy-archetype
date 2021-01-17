package com.easy.archetype.core.core;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * <p>请求分页封装</p>
 *
 * @author luyanan
 * @since 2021/1/12
 **/
public class PageRequestParams<T> implements Serializable {
    private static final long serialVersionUID = 6188894345996272641L;


    /**
     * <p>首页的pageIndex为1</p>
     *
     * @since 2021/1/12
     */
    public static int FIRST_PAGE_INDEX = 1;
    /**
     * <p>当前页数</p>
     *
     * @since 2021/1/12
     */
    @Getter
    @Setter
    private Integer page;

    /**
     * <p>每页条数</p>
     *
     * @since 2021/1/12
     */
    @Getter
    @Setter
    private Integer size;

    /**
     * <p>下标</p>
     *
     * @since 2021/1/12
     */
    @Getter
    @Setter
    private Integer offset;

    /**
     * <p>请求参数</p>
     *
     * @since 2021/1/12
     */
    @Getter
    @Setter
    private T params;

    /**
     * <p>获取下标</p>
     *
     * @return {@link Integer}
     * @since 2021/1/12
     */
    public Integer getOffset() {
        if (this.offset == null) {
            if (this.page <= 0) {
                return this.page * this.size;
            } else {
                return (this.page - 1) * this.size;
            }
        } else {
            return this.offset;
        }
    }

    /**
     * <p>获取当前页数</p>
     *
     * @return {@link Integer}
     * @since 2021/1/12
     */
    public Integer getPage() {
        if (offset != null && page == null) {
            return offset / size + FIRST_PAGE_INDEX;
        }
        return page;
    }

    /**
     * <p>构建</p>
     *
     * @param params 参数
     * @param offset 下标
     * @param limit  每页条数
     * @return {@link PageRequestParams}
     * @since 2021/1/12
     */
    public static <T> PageRequestParams<T> build(T params, Integer offset, Integer limit) {

        PageRequestParams<T> pageRequestParams = new PageRequestParams<>();
        pageRequestParams.setOffset(offset);
        pageRequestParams.setSize(limit);
        pageRequestParams.setParams(params);
        return pageRequestParams;
    }
}
