package com.route.test.mybluetooth.entity;

import java.util.List;

/**
 * 作者：哇牛Aaron
 * 作者简书文章地址: http://www.jianshu.com/users/07a8b5386866/latest_articles
 * 时间: 2016/11/23
 * 功能描述:
 */
public class WeatherEntity {
    /**
     * desc : OK
     * status : 1000
     * data : {"wendu":"28","ganmao":"各项气象条件适宜，无明显降温过程，发生感冒机率较低。","forecast":[{"fengxiang":"南风","fengli":"3-4级","high":"高温 29℃","type":"小雨","low":"低温 25℃","date":"6日星期五"},{"fengxiang":"无持续风向","fengli":"微风级","high":"高温 30℃","type":"多云","low":"低温 26℃","date":"7日星期六"},{"fengxiang":"无持续风向","fengli":"微风级","high":"高温 29℃","type":"小雨","low":"低温 25℃","date":"8日星期天"},{"fengxiang":"无持续风向","fengli":"微风级","high":"高温 29℃","type":"阵雨","low":"低温 23℃","date":"9日星期一"},{"fengxiang":"无持续风向","fengli":"微风级","high":"高温 26℃","type":"雷阵雨","low":"低温 22℃","date":"10日星期二"}],"yesterday":{"fl":"微风","fx":"无持续风向","high":"高温 30℃","type":"多云","low":"低温 25℃","date":"5日星期四"},"aqi":"38","city":"深圳"}
     */

    private String desc;
    private int status;
    /**
     * wendu : 28
     * ganmao : 各项气象条件适宜，无明显降温过程，发生感冒机率较低。
     * forecast : [{"fengxiang":"南风","fengli":"3-4级","high":"高温 29℃","type":"小雨","low":"低温 25℃","date":"6日星期五"},{"fengxiang":"无持续风向","fengli":"微风级","high":"高温 30℃","type":"多云","low":"低温 26℃","date":"7日星期六"},{"fengxiang":"无持续风向","fengli":"微风级","high":"高温 29℃","type":"小雨","low":"低温 25℃","date":"8日星期天"},{"fengxiang":"无持续风向","fengli":"微风级","high":"高温 29℃","type":"阵雨","low":"低温 23℃","date":"9日星期一"},{"fengxiang":"无持续风向","fengli":"微风级","high":"高温 26℃","type":"雷阵雨","low":"低温 22℃","date":"10日星期二"}]
     * yesterday : {"fl":"微风","fx":"无持续风向","high":"高温 30℃","type":"多云","low":"低温 25℃","date":"5日星期四"}
     * aqi : 38
     * city : 深圳
     */

    private DataBean data;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private String wendu;
        private String ganmao;
        /**
         * fl : 微风
         * fx : 无持续风向
         * high : 高温 30℃
         * type : 多云
         * low : 低温 25℃
         * date : 5日星期四
         */

        private YesterdayBean yesterday;
        private String aqi;
        private String city;
        /**
         * fengxiang : 南风
         * fengli : 3-4级
         * high : 高温 29℃
         * type : 小雨
         * low : 低温 25℃
         * date : 6日星期五
         */

        private List<ForecastBean> forecast;

        public String getWendu() {
            return wendu;
        }

        public void setWendu(String wendu) {
            this.wendu = wendu;
        }

        public String getGanmao() {
            return ganmao;
        }

        public void setGanmao(String ganmao) {
            this.ganmao = ganmao;
        }

        public YesterdayBean getYesterday() {
            return yesterday;
        }

        public void setYesterday(YesterdayBean yesterday) {
            this.yesterday = yesterday;
        }

        public String getAqi() {
            return aqi;
        }

        public void setAqi(String aqi) {
            this.aqi = aqi;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public List<ForecastBean> getForecast() {
            return forecast;
        }

        public void setForecast(List<ForecastBean> forecast) {
            this.forecast = forecast;
        }

        public static class YesterdayBean {
            private String fl;
            private String fx;
            private String high;
            private String type;
            private String low;
            private String date;

            public String getFl() {
                return fl;
            }

            public void setFl(String fl) {
                this.fl = fl;
            }

            public String getFx() {
                return fx;
            }

            public void setFx(String fx) {
                this.fx = fx;
            }

            public String getHigh() {
                return high;
            }

            public void setHigh(String high) {
                this.high = high;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getLow() {
                return low;
            }

            public void setLow(String low) {
                this.low = low;
            }

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }
        }

        public static class ForecastBean {
            private String fengxiang;
            private String fengli;
            private String high;
            private String type;
            private String low;
            private String date;

            public String getFengxiang() {
                return fengxiang;
            }

            public void setFengxiang(String fengxiang) {
                this.fengxiang = fengxiang;
            }

            public String getFengli() {
                return fengli;
            }

            public void setFengli(String fengli) {
                this.fengli = fengli;
            }

            public String getHigh() {
                return high;
            }

            public void setHigh(String high) {
                this.high = high;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getLow() {
                return low;
            }

            public void setLow(String low) {
                this.low = low;
            }

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            @Override
            public String toString() {
                return "ForecastBean{" +
                        "fengxiang='" + fengxiang + '\'' +
                        ", fengli='" + fengli + '\'' +
                        ", high='" + high + '\'' +
                        ", type='" + type + '\'' +
                        ", low='" + low + '\'' +
                        ", date='" + date + '\'' +
                        '}';
            }
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "wendu='" + wendu + '\'' +
                    ", ganmao='" + ganmao + '\'' +
                    ", yesterday=" + yesterday +
                    ", aqi='" + aqi + '\'' +
                    ", city='" + city + '\'' +
                    ", forecast=" + forecast +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "WeatherEntity{" +
                "desc='" + desc + '\'' +
                ", status=" + status +
                ", data=" + data +
                '}';
    }




}
