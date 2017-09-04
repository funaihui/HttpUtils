package com.example.wizardev.retrofitandrxjava.bean;

import java.util.List;

/**
 * author : wizardev
 * e-mail : wizarddev@163.com
 * time   : 2017/08/21
 * desc   :
 * version: 1.0
 */
public class NewsList {

    /**
     * msg : 获取公告列表成功
     * newsList : [{"id":4,"title":"ceshi","type":1,"url":"http://osjlnflyg.bkt.clouddn.com/1501052259742.html","createTime":1501052260000,"isDelete":0},{"id":3,"title":"mlml","type":1,"url":"http://osjlnflyg.bkt.clouddn.com/1501051148555.html","createTime":1501051149000,"isDelete":0},{"id":2,"title":"nini","type":1,"url":"http://osjlnflyg.bkt.clouddn.com/1501051094914.html","createTime":1501051096000,"isDelete":0},{"id":1,"title":null,"type":1,"url":"https://b2c.icbc.com.cn/servlet/ICBCINBSReqServlet","createTime":null,"isDelete":0}]
     * total : 4
     * code : 100
     */

    private int total;

    private List<NewsListBean> newsList;


    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<NewsListBean> getNewsList() {
        return newsList;
    }

    public void setNewsList(List<NewsListBean> newsList) {
        this.newsList = newsList;
    }

    public static class NewsListBean {
        /**
         * id : 4
         * title : ceshi
         * type : 1
         * url : http://osjlnflyg.bkt.clouddn.com/1501052259742.html
         * createTime : 1501052260000
         * isDelete : 0
         */

        private int id;
        private String title;
        private int type;
        private String url;
        private long createTime;
        private int isDelete;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(long createTime) {
            this.createTime = createTime;
        }

        public int getIsDelete() {
            return isDelete;
        }

        public void setIsDelete(int isDelete) {
            this.isDelete = isDelete;
        }
    }
}
