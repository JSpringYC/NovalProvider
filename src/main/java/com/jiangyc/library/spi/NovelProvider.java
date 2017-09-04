package com.jiangyc.library.spi;

import java.net.URL;

/** 书籍信息提供者 */
public interface NovelProvider {

    // ********************************
    //  网站信息
    // ********************************
    /**
     * 网站的主机，不区分大小写
     *   将根据此属性确定{@code NovelProvider}的唯一性。该属性不区分大小写。
     * @return 网站Host，是不加协议的网站，如：www.baidu.com。
     */
    String getHost();

    /**
     *  获取网站名称
     * @return 网站名称，如：百度
     */
    String getName();

    /**
     * 根据类别ID和书籍ID获取书籍详情页网址
     * @param categoryId 类别ID
     * @param bookId 书籍ID
     * @return 书籍详情页网址
     */
    URL getBookAddress(String categoryId, String bookId);

    /**
     * 根据类别ID和书籍ID获取书籍目录页网址
     * @param categoryId 类别ID
     * @param bookId 书籍ID
     * @return 书籍目录页网址
     */
    URL getCatalogAddress(String categoryId, String bookId);

    /**
     * 根据类别ID、书籍ID和章节ID获取书籍目录页网址
     * @param categoryId 类别ID
     * @param bookId 书籍ID
     * @param chapterId 章节ID
     * @return 书籍目录页网址
     */
    URL getChapterAddress(String categoryId, String bookId, String chapterId);
}
