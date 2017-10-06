package com.route.test.mybluetooth.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by my301s on 2017/8/25.
 */

public class SplendBean {

    /**
     * videoset : {"0":{"vsid":"VSET100167216881","relvsid":"","name":"熊猫频道-精彩一刻","img":"http://p5.img.cctvpic.com/fmspic/vms/image/2013/06/21/VSET_1371809214479325.jpg","enname":"其他","url":"http://tv.cntv.cn/videoset/VSET100167216881","cd":"","zy":"","bj":"","dy":"","js":"","nf":"","yz":"","fl":"","sbsj":"2013-05-01","sbpd":"其他","desc":"精彩一刻栏目关注人气较高的熊猫个体，精选每日直播中最吸引人的画面，呈现熊猫生活中最精彩的状态。","playdesc":"","zcr":"","fcl":""},"count":"4748"}
     * video : [{"vsid":"VSET100167216881","order":"4751","vid":"9a776f8518824d70bd61d445305e9686","t":"《精彩一刻》 20170824 泰山：你经历过绝望吗~","url":"http://tv.cntv.cn/video/VSET100167216881/9a776f8518824d70bd61d445305e9686","ptime":"2017-08-24 15:44:59","img":"http://p5.img.cctvpic.com/fmspic/2017/08/24/9a776f8518824d70bd61d445305e9686-33.jpg?p=2&h=120","len":"00:00:45","em":"CM01"},{"vsid":"VSET100167216881","order":"4748","vid":"f2da39846ee343029d7fe00d4e23af1c","t":"《精彩一刻》 20170824 \u201c猪儿子\u201d雄起","url":"http://tv.cntv.cn/video/VSET100167216881/f2da39846ee343029d7fe00d4e23af1c","ptime":"2017-08-24 15:41:46","img":"http://p3.img.cctvpic.com/fmspic/2017/08/24/f2da39846ee343029d7fe00d4e23af1c-22.jpg?p=2&h=120","len":"00:00:24","em":"CM01"},{"vsid":"VSET100167216881","order":"4745","vid":"f86db6d62fec4f58b8ce4ea9bf18962d","t":"《精彩一刻》 20170824 积极配合的\u201c奇一\u201d","url":"http://tv.cntv.cn/video/VSET100167216881/f86db6d62fec4f58b8ce4ea9bf18962d","ptime":"2017-08-24 15:41:16","img":"http://p3.img.cctvpic.com/fmspic/2017/08/24/f86db6d62fec4f58b8ce4ea9bf18962d-32.jpg?p=2&h=120","len":"00:00:43","em":"CM01"},{"vsid":"VSET100167216881","order":"4749","vid":"bded4c3430c84c7b814093c1c6b61a82","t":"《精彩一刻》 20170824 熊牌脚垫，至尊享受~","url":"http://tv.cntv.cn/video/VSET100167216881/bded4c3430c84c7b814093c1c6b61a82","ptime":"2017-08-24 15:39:00","img":"http://p4.img.cctvpic.com/fmspic/2017/08/24/bded4c3430c84c7b814093c1c6b61a82-9.jpg?p=2&h=120","len":"00:00:19","em":"CM01"},{"vsid":"VSET100167216881","order":"4752","vid":"1ffa64e03f0e42888d0b4beea90e9ba5","t":"《精彩一刻》 20170824 \u201c宝宝\u201d四岁啦~","url":"http://tv.cntv.cn/video/VSET100167216881/1ffa64e03f0e42888d0b4beea90e9ba5","ptime":"2017-08-24 15:36:31","img":"http://p1.img.cctvpic.com/fmspic/2017/08/24/1ffa64e03f0e42888d0b4beea90e9ba5-25.jpg?p=2&h=120","len":"00:00:45","em":"CM01"},{"vsid":"VSET100167216881","order":"4747","vid":"d34253be3d4947d9b7e6f6124e040363","t":"《精彩一刻》 20170824 宝宝：镜头君，你看我美吗~","url":"http://tv.cntv.cn/video/VSET100167216881/d34253be3d4947d9b7e6f6124e040363","ptime":"2017-08-24 15:35:34","img":"http://p5.img.cctvpic.com/fmspic/2017/08/24/d34253be3d4947d9b7e6f6124e040363-9.jpg?p=2&h=120","len":"00:00:18","em":"CM01"},{"vsid":"VSET100167216881","order":"4746","vid":"5046cf2bca9d4205afbc35a2a2a03c7e","t":"《精彩一刻》 20170824 一只手开始你的表演","url":"http://tv.cntv.cn/video/VSET100167216881/5046cf2bca9d4205afbc35a2a2a03c7e","ptime":"2017-08-24 15:34:02","img":"http://p4.img.cctvpic.com/fmspic/2017/08/24/5046cf2bca9d4205afbc35a2a2a03c7e-43.jpg?p=2&h=120","len":"00:01:06","em":"CM01"}]
     */

    private VideosetBean videoset;
    private List<VideoBean> video;

    public VideosetBean getVideoset() {
        return videoset;
    }

    public void setVideoset(VideosetBean videoset) {
        this.videoset = videoset;
    }

    public List<VideoBean> getVideo() {
        return video;
    }

    public void setVideo(List<VideoBean> video) {
        this.video = video;
    }

    public static class VideosetBean {
        /**
         * 0 : {"vsid":"VSET100167216881","relvsid":"","name":"熊猫频道-精彩一刻","img":"http://p5.img.cctvpic.com/fmspic/vms/image/2013/06/21/VSET_1371809214479325.jpg","enname":"其他","url":"http://tv.cntv.cn/videoset/VSET100167216881","cd":"","zy":"","bj":"","dy":"","js":"","nf":"","yz":"","fl":"","sbsj":"2013-05-01","sbpd":"其他","desc":"精彩一刻栏目关注人气较高的熊猫个体，精选每日直播中最吸引人的画面，呈现熊猫生活中最精彩的状态。","playdesc":"","zcr":"","fcl":""}
         * count : 4748
         */

        @SerializedName("0")
        private DetailBean _$0;
        private String count;

        public DetailBean get_$0() {
            return _$0;
        }

        public void set_$0(DetailBean _$0) {
            this._$0 = _$0;
        }

        public String getCount() {
            return count;
        }

        public void setCount(String count) {
            this.count = count;
        }

        public static class DetailBean {
            /**
             * vsid : VSET100167216881
             * relvsid :
             * name : 熊猫频道-精彩一刻
             * img : http://p5.img.cctvpic.com/fmspic/vms/image/2013/06/21/VSET_1371809214479325.jpg
             * enname : 其他
             * url : http://tv.cntv.cn/videoset/VSET100167216881
             * cd :
             * zy :
             * bj :
             * dy :
             * js :
             * nf :
             * yz :
             * fl :
             * sbsj : 2013-05-01
             * sbpd : 其他
             * desc : 精彩一刻栏目关注人气较高的熊猫个体，精选每日直播中最吸引人的画面，呈现熊猫生活中最精彩的状态。
             * playdesc :
             * zcr :
             * fcl :
             */

            private String vsid;
            private String relvsid;
            private String name;
            private String img;
            private String enname;
            private String url;
            private String cd;
            private String zy;
            private String bj;
            private String dy;
            private String js;
            private String nf;
            private String yz;
            private String fl;
            private String sbsj;
            private String sbpd;
            private String desc;
            private String playdesc;
            private String zcr;
            private String fcl;

            public String getVsid() {
                return vsid;
            }

            public void setVsid(String vsid) {
                this.vsid = vsid;
            }

            public String getRelvsid() {
                return relvsid;
            }

            public void setRelvsid(String relvsid) {
                this.relvsid = relvsid;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }

            public String getEnname() {
                return enname;
            }

            public void setEnname(String enname) {
                this.enname = enname;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getCd() {
                return cd;
            }

            public void setCd(String cd) {
                this.cd = cd;
            }

            public String getZy() {
                return zy;
            }

            public void setZy(String zy) {
                this.zy = zy;
            }

            public String getBj() {
                return bj;
            }

            public void setBj(String bj) {
                this.bj = bj;
            }

            public String getDy() {
                return dy;
            }

            public void setDy(String dy) {
                this.dy = dy;
            }

            public String getJs() {
                return js;
            }

            public void setJs(String js) {
                this.js = js;
            }

            public String getNf() {
                return nf;
            }

            public void setNf(String nf) {
                this.nf = nf;
            }

            public String getYz() {
                return yz;
            }

            public void setYz(String yz) {
                this.yz = yz;
            }

            public String getFl() {
                return fl;
            }

            public void setFl(String fl) {
                this.fl = fl;
            }

            public String getSbsj() {
                return sbsj;
            }

            public void setSbsj(String sbsj) {
                this.sbsj = sbsj;
            }

            public String getSbpd() {
                return sbpd;
            }

            public void setSbpd(String sbpd) {
                this.sbpd = sbpd;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public String getPlaydesc() {
                return playdesc;
            }

            public void setPlaydesc(String playdesc) {
                this.playdesc = playdesc;
            }

            public String getZcr() {
                return zcr;
            }

            public void setZcr(String zcr) {
                this.zcr = zcr;
            }

            public String getFcl() {
                return fcl;
            }

            public void setFcl(String fcl) {
                this.fcl = fcl;
            }
        }
    }

    public static class VideoBean {
        /**
         * vsid : VSET100167216881
         * order : 4751
         * vid : 9a776f8518824d70bd61d445305e9686
         * t : 《精彩一刻》 20170824 泰山：你经历过绝望吗~
         * url : http://tv.cntv.cn/video/VSET100167216881/9a776f8518824d70bd61d445305e9686
         * ptime : 2017-08-24 15:44:59
         * img : http://p5.img.cctvpic.com/fmspic/2017/08/24/9a776f8518824d70bd61d445305e9686-33.jpg?p=2&h=120
         * len : 00:00:45
         * em : CM01
         */

        private String vsid;
        private String order;
        private String vid;
        private String t;
        private String url;
        private String ptime;
        private String img;
        private String len;
        private String em;

        public String getVsid() {
            return vsid;
        }

        public void setVsid(String vsid) {
            this.vsid = vsid;
        }

        public String getOrder() {
            return order;
        }

        public void setOrder(String order) {
            this.order = order;
        }

        public String getVid() {
            return vid;
        }

        public void setVid(String vid) {
            this.vid = vid;
        }

        public String getT() {
            return t;
        }

        public void setT(String t) {
            this.t = t;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getPtime() {
            return ptime;
        }

        public void setPtime(String ptime) {
            this.ptime = ptime;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public String getLen() {
            return len;
        }

        public void setLen(String len) {
            this.len = len;
        }

        public String getEm() {
            return em;
        }

        public void setEm(String em) {
            this.em = em;
        }
    }
}
