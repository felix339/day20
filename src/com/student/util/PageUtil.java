package com.student.util;

/**
 * @author JOKRE
 * 分页工具
 */
public class PageUtil {
    //页码
    private int page;
    //显示条数
    private int rows;
    //偏移量
    private int index;
    //总条数
    private int countRows;
    //总页数
    private int countPage;
    //上一页
    private int prevPage;
    //下一页
    private int nextPage;


    public PageUtil(String page, int countRows) {
        this.rows = 5;
        this.countRows = countRows;
        init_page(page);
        init_index();
        init_countPage();
        init_prevPage();
        init_nextPage();
    }

    //初始化页码
    private void init_page(String page){
        if (page == null || "".equals(page)){
            this.page = 1;
        }else {
            this.page = Integer.valueOf(page);
        }
    }
    //初始化偏移量
    private void init_index(){
        this.index = (this.page - 1) * this.rows;
    }
    //初始化总页数
    private void init_countPage(){
        int mod = this.countRows % this.rows;
        if (mod == 0){
            this.countPage = this.countRows / this.rows;
        }else {
            this.countPage = this.countRows / this.rows + 1;
        }
    }
    //初始化当前页的上一页
    private void init_prevPage(){
        if (this.page == 1){
            this.prevPage = 1;
        }else {
            this.prevPage = this.page - 1;
        }
    }
    //初始化当前页的下一页
    private void init_nextPage(){
        if (this.page == this.countPage){
            this.nextPage = this.countPage;
        }else {
            this.nextPage = this.page + 1;
        }
    }

    public int getPage() {
        return page;
    }

    public int getRows() {
        return rows;
    }

    public int getIndex() {
        return index;
    }

    public int getCountRows() {
        return countRows;
    }

    public int getCountPage() {
        return countPage;
    }

    public int getPrevPage() {
        return prevPage;
    }

    public int getNextPage() {
        return nextPage;
    }
}
