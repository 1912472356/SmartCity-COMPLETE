package com.cx.smartcity.bean;

import java.util.List;

public class LawCommentBean {
    /**
     * total : 49
     * rows : [{"fromUserName":"admin","fromUserAvatar":"/profile/avatar/2022/05/01/d61dfc84-4103-4c62-b60b-cb69d2de4b9c.jpeg","createTime":"2022-03-12T19:54:16.000+0800","evaluateContent":"非常专业","score":0,"likeCount":13,"myLikeState":false,"adviceId":17},{"fromUserName":"Yandel","fromUserAvatar":"/profile/upload/2022/12/15/c3baee32-faac-42ce-adc9-72331fbcee0d.png","createTime":"2022-10-09T18:48:04.000+0800","evaluateContent":null,"score":0,"likeCount":4,"myLikeState":false,"adviceId":54},{"fromUserName":"test0927","fromUserAvatar":"","createTime":"2022-10-15T10:42:14.000+0800","evaluateContent":null,"score":0,"likeCount":2,"myLikeState":false,"adviceId":58},{"fromUserName":"test0927","fromUserAvatar":"","createTime":"2022-10-15T10:42:55.000+0800","evaluateContent":null,"score":0,"likeCount":3,"myLikeState":false,"adviceId":59},{"fromUserName":"xiaowei","fromUserAvatar":"/profile/upload/2022/11/23/4df9637d-81a8-47f7-a911-ba09f46a35ce.png","createTime":"2022-10-15T17:00:53.000+0800","evaluateContent":null,"score":0,"likeCount":1,"myLikeState":false,"adviceId":64},{"fromUserName":"xiaowei","fromUserAvatar":"/profile/upload/2022/11/23/4df9637d-81a8-47f7-a911-ba09f46a35ce.png","createTime":"2022-10-16T10:18:11.000+0800","evaluateContent":null,"score":0,"likeCount":2,"myLikeState":false,"adviceId":66},{"fromUserName":"xiaowei","fromUserAvatar":"/profile/upload/2022/11/23/4df9637d-81a8-47f7-a911-ba09f46a35ce.png","createTime":"2022-10-16T10:32:47.000+0800","evaluateContent":null,"score":0,"likeCount":0,"myLikeState":false,"adviceId":67},{"fromUserName":"2","fromUserAvatar":"/profile/upload/2022/10/23/4e91cc3c-57d5-4204-927d-53dce36be0a9.jpg","createTime":"2022-10-17T18:46:50.000+0800","evaluateContent":null,"score":0,"likeCount":0,"myLikeState":false,"adviceId":71},{"fromUserName":"小黑子是我","fromUserAvatar":"/profile/upload/2022/11/30/0e0d6072-217e-428a-baf3-a447c3e4e3ec.jpg","createTime":"2022-10-22T23:52:57.000+0800","evaluateContent":null,"score":0,"likeCount":0,"myLikeState":false,"adviceId":94},{"fromUserName":"小黑子是我","fromUserAvatar":"/profile/upload/2022/11/30/0e0d6072-217e-428a-baf3-a447c3e4e3ec.jpg","createTime":"2022-10-22T23:54:52.000+0800","evaluateContent":null,"score":0,"likeCount":0,"myLikeState":false,"adviceId":95},{"fromUserName":"小黑子是我","fromUserAvatar":"/profile/upload/2022/11/30/0e0d6072-217e-428a-baf3-a447c3e4e3ec.jpg","createTime":"2022-10-22T23:56:14.000+0800","evaluateContent":null,"score":0,"likeCount":0,"myLikeState":false,"adviceId":96},{"fromUserName":"小黑子是我","fromUserAvatar":"/profile/upload/2022/11/30/0e0d6072-217e-428a-baf3-a447c3e4e3ec.jpg","createTime":"2022-10-23T00:00:57.000+0800","evaluateContent":null,"score":0,"likeCount":0,"myLikeState":false,"adviceId":97},{"fromUserName":"c","fromUserAvatar":"/profile/upload/2022/12/13/7e509a2b-f61f-4d16-9216-07e4629d2c20.jpg","createTime":"2022-10-28T15:43:47.000+0800","evaluateContent":null,"score":0,"likeCount":0,"myLikeState":false,"adviceId":104},{"fromUserName":"QAQ","fromUserAvatar":"/profile/upload/2022/11/01/bc3e538c-09d5-4b08-8fcd-e402b9f51312.jpg","createTime":"2022-10-29T09:28:10.000+0800","evaluateContent":null,"score":0,"likeCount":0,"myLikeState":false,"adviceId":105},{"fromUserName":"29797","fromUserAvatar":"/prod-api/profile/upload/2022/12/01/f98b8561-c03f-4e05-84a0-d17142d235b4.jpg","createTime":"2022-11-02T16:41:10.000+0800","evaluateContent":null,"score":0,"likeCount":0,"myLikeState":false,"adviceId":107},{"fromUserName":"pwc","fromUserAvatar":"/profile/upload/2022/11/28/e1bdc612-7a73-4f19-a86e-706f494ba12f.jpg","createTime":"2022-11-04T09:26:08.000+0800","evaluateContent":null,"score":0,"likeCount":0,"myLikeState":false,"adviceId":113},{"fromUserName":"pwc","fromUserAvatar":"/profile/upload/2022/11/28/e1bdc612-7a73-4f19-a86e-706f494ba12f.jpg","createTime":"2022-11-04T09:26:31.000+0800","evaluateContent":null,"score":0,"likeCount":0,"myLikeState":false,"adviceId":114},{"fromUserName":"cuixishuai","fromUserAvatar":"/profile/upload/2022/12/16/3ab57783-7c14-41ac-9c26-26d71b08e303.png","createTime":"2022-11-11T11:22:02.000+0800","evaluateContent":null,"score":0,"likeCount":0,"myLikeState":false,"adviceId":146},{"fromUserName":"zld","fromUserAvatar":"/prod-apiundefined","createTime":"2022-11-11T15:41:33.000+0800","evaluateContent":null,"score":0,"likeCount":1,"myLikeState":false,"adviceId":149},{"fromUserName":"zld","fromUserAvatar":"/prod-apiundefined","createTime":"2022-11-11T15:43:45.000+0800","evaluateContent":null,"score":0,"likeCount":0,"myLikeState":false,"adviceId":151},{"fromUserName":"cuixishuai","fromUserAvatar":"/profile/upload/2022/12/16/3ab57783-7c14-41ac-9c26-26d71b08e303.png","createTime":"2022-11-11T17:24:50.000+0800","evaluateContent":null,"score":0,"likeCount":0,"myLikeState":false,"adviceId":157},{"fromUserName":"cuixishuai","fromUserAvatar":"/profile/upload/2022/12/16/3ab57783-7c14-41ac-9c26-26d71b08e303.png","createTime":"2022-11-11T17:26:08.000+0800","evaluateContent":null,"score":0,"likeCount":0,"myLikeState":false,"adviceId":158},{"fromUserName":"cuixishuai","fromUserAvatar":"/profile/upload/2022/12/16/3ab57783-7c14-41ac-9c26-26d71b08e303.png","createTime":"2022-11-11T17:26:33.000+0800","evaluateContent":null,"score":0,"likeCount":0,"myLikeState":false,"adviceId":159},{"fromUserName":"test2","fromUserAvatar":"/profile/2020/10/26/27e7fd58-0972-4dbf-941c-590624e6a886.png","createTime":"2022-11-18T19:49:50.000+0800","evaluateContent":null,"score":0,"likeCount":0,"myLikeState":false,"adviceId":337},{"fromUserName":"test2","fromUserAvatar":"/profile/2020/10/26/27e7fd58-0972-4dbf-941c-590624e6a886.png","createTime":"2022-11-18T19:55:02.000+0800","evaluateContent":null,"score":0,"likeCount":0,"myLikeState":false,"adviceId":340},{"fromUserName":"march","fromUserAvatar":"/profile/upload/2022/11/24/fb9aaf60-236b-4337-9542-cf2343e7725f.jpg","createTime":"2022-11-19T20:00:54.000+0800","evaluateContent":null,"score":0,"likeCount":0,"myLikeState":false,"adviceId":350},{"fromUserName":"YMX","fromUserAvatar":"content://com.amaze.filemanager.FILE_PROVIDER/storage_root/1.png","createTime":"2022-11-24T21:36:25.000+0800","evaluateContent":null,"score":0,"likeCount":0,"myLikeState":false,"adviceId":385},{"fromUserName":"lgy","fromUserAvatar":"/prod-api/profile/upload/2022/11/19/ffeb7771-a418-4742-a16f-0ca34c3734b7.jpg","createTime":"2022-11-26T20:48:48.000+0800","evaluateContent":null,"score":0,"likeCount":1,"myLikeState":false,"adviceId":422},{"fromUserName":"lgy","fromUserAvatar":"/prod-api/profile/upload/2022/11/19/ffeb7771-a418-4742-a16f-0ca34c3734b7.jpg","createTime":"2022-11-27T15:21:38.000+0800","evaluateContent":null,"score":0,"likeCount":0,"myLikeState":false,"adviceId":430},{"fromUserName":"lgy","fromUserAvatar":"/prod-api/profile/upload/2022/11/19/ffeb7771-a418-4742-a16f-0ca34c3734b7.jpg","createTime":"2022-11-27T16:58:29.000+0800","evaluateContent":null,"score":0,"likeCount":0,"myLikeState":false,"adviceId":439},{"fromUserName":"149131","fromUserAvatar":"/prod-api/profile/upload/2022/11/12/4e6334af-7f02-482c-adfb-92b8ef4ab976.jpg","createTime":"2022-11-27T21:44:54.000+0800","evaluateContent":null,"score":0,"likeCount":0,"myLikeState":false,"adviceId":460},{"fromUserName":"xiaoyu11","fromUserAvatar":"/prod-api/profile/upload/2022/12/08/47fc12c4-f4ab-4c8a-a92c-959393b0b58b.png","createTime":"2022-11-29T11:52:12.000+0800","evaluateContent":null,"score":0,"likeCount":0,"myLikeState":false,"adviceId":489},{"fromUserName":"xiaoyu11","fromUserAvatar":"/prod-api/profile/upload/2022/12/08/47fc12c4-f4ab-4c8a-a92c-959393b0b58b.png","createTime":"2022-11-29T12:01:31.000+0800","evaluateContent":null,"score":0,"likeCount":0,"myLikeState":false,"adviceId":490},{"fromUserName":"cxycxy","fromUserAvatar":"/profile/2020/10/26/27e7fd58-0972-4dbf-941c-590624e6a886.png","createTime":"2022-11-30T16:50:56.000+0800","evaluateContent":null,"score":0,"likeCount":0,"myLikeState":false,"adviceId":503},{"fromUserName":"LSC","fromUserAvatar":"https://img1.baidu.com/it/u=2746501002,199343430&fm=253&fmt=auto&app=138&f=JPEG?w=459&h=459","createTime":"2022-12-01T09:50:24.000+0800","evaluateContent":null,"score":0,"likeCount":0,"myLikeState":false,"adviceId":711},{"fromUserName":"8848","fromUserAvatar":"/profile/upload/2022/12/08/c6b734d5-cd48-46de-9c6e-bde62b011734.jpg","createTime":"2022-12-01T10:53:52.000+0800","evaluateContent":null,"score":0,"likeCount":0,"myLikeState":false,"adviceId":713},{"fromUserName":"hewei","fromUserAvatar":"/profile/2020/10/26/27e7fd58-0972-4dbf-941c-590624e6a886.png","createTime":"2022-12-02T15:00:28.000+0800","evaluateContent":null,"score":0,"likeCount":0,"myLikeState":false,"adviceId":720},{"fromUserName":"lch","fromUserAvatar":"","createTime":"2022-12-05T09:34:12.000+0800","evaluateContent":null,"score":0,"likeCount":0,"myLikeState":false,"adviceId":750},{"fromUserName":"lch","fromUserAvatar":"","createTime":"2022-12-05T10:41:20.000+0800","evaluateContent":null,"score":0,"likeCount":0,"myLikeState":false,"adviceId":752},{"fromUserName":"czzz","fromUserAvatar":"/profile/upload/2022/12/15/b55158c5-d118-4c59-b6c1-d4f4298b2cdf.gif","createTime":"2022-12-07T17:45:06.000+0800","evaluateContent":null,"score":0,"likeCount":0,"myLikeState":false,"adviceId":770},{"fromUserName":"czzz","fromUserAvatar":"/profile/upload/2022/12/15/b55158c5-d118-4c59-b6c1-d4f4298b2cdf.gif","createTime":"2022-12-07T17:45:52.000+0800","evaluateContent":null,"score":0,"likeCount":0,"myLikeState":false,"adviceId":771},{"fromUserName":"jnds","fromUserAvatar":"/profile/upload/2022/12/03/5cfd1550-db1b-42a4-986e-6f56cb92e614.jpg","createTime":"2022-12-08T19:59:26.000+0800","evaluateContent":null,"score":0,"likeCount":0,"myLikeState":false,"adviceId":792},{"fromUserName":"z2976747720","fromUserAvatar":"","createTime":"2022-12-10T19:45:47.000+0800","evaluateContent":null,"score":0,"likeCount":0,"myLikeState":false,"adviceId":800},{"fromUserName":"z2976747720","fromUserAvatar":"","createTime":"2022-12-11T22:22:55.000+0800","evaluateContent":null,"score":0,"likeCount":0,"myLikeState":false,"adviceId":808},{"fromUserName":"z2976747720","fromUserAvatar":"","createTime":"2022-12-12T15:28:28.000+0800","evaluateContent":null,"score":0,"likeCount":0,"myLikeState":false,"adviceId":809},{"fromUserName":"ooo01","fromUserAvatar":"/profile/2020/10/26/27e7fd58-0972-4dbf-941c-590624e6a886.png","createTime":"2022-12-15T09:42:27.000+0800","evaluateContent":null,"score":0,"likeCount":0,"myLikeState":false,"adviceId":819},{"fromUserName":"ooo01","fromUserAvatar":"/profile/2020/10/26/27e7fd58-0972-4dbf-941c-590624e6a886.png","createTime":"2022-12-15T09:49:27.000+0800","evaluateContent":null,"score":0,"likeCount":0,"myLikeState":false,"adviceId":820},{"fromUserName":"c","fromUserAvatar":"/profile/upload/2022/12/13/7e509a2b-f61f-4d16-9216-07e4629d2c20.jpg","createTime":"2022-12-17T14:51:43.000+0800","evaluateContent":null,"score":0,"likeCount":0,"myLikeState":false,"adviceId":837},{"fromUserName":"c","fromUserAvatar":"/profile/upload/2022/12/13/7e509a2b-f61f-4d16-9216-07e4629d2c20.jpg","createTime":"2022-12-17T16:01:36.000+0800","evaluateContent":null,"score":0,"likeCount":1,"myLikeState":false,"adviceId":849}]
     * code : 200
     * msg : 查询成功
     */

    private int total;
    private int code;
    private String msg;
    private List<RowsDTO> rows;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<RowsDTO> getRows() {
        return rows;
    }

    public void setRows(List<RowsDTO> rows) {
        this.rows = rows;
    }

    public static class RowsDTO {
        /**
         * fromUserName : admin
         * fromUserAvatar : /profile/avatar/2022/05/01/d61dfc84-4103-4c62-b60b-cb69d2de4b9c.jpeg
         * createTime : 2022-03-12T19:54:16.000+0800
         * evaluateContent : 非常专业
         * score : 0
         * likeCount : 13
         * myLikeState : false
         * adviceId : 17
         */

        private String fromUserName;
        private String fromUserAvatar;
        private String createTime;
        private String evaluateContent;
        private int score;
        private int likeCount;
        private boolean myLikeState;
        private int adviceId;

        public String getFromUserName() {
            return fromUserName;
        }

        public void setFromUserName(String fromUserName) {
            this.fromUserName = fromUserName;
        }

        public String getFromUserAvatar() {
            return fromUserAvatar;
        }

        public void setFromUserAvatar(String fromUserAvatar) {
            this.fromUserAvatar = fromUserAvatar;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getEvaluateContent() {
            return evaluateContent;
        }

        public void setEvaluateContent(String evaluateContent) {
            this.evaluateContent = evaluateContent;
        }

        public int getScore() {
            return score;
        }

        public void setScore(int score) {
            this.score = score;
        }

        public int getLikeCount() {
            return likeCount;
        }

        public void setLikeCount(int likeCount) {
            this.likeCount = likeCount;
        }

        public boolean isMyLikeState() {
            return myLikeState;
        }

        public void setMyLikeState(boolean myLikeState) {
            this.myLikeState = myLikeState;
        }

        public int getAdviceId() {
            return adviceId;
        }

        public void setAdviceId(int adviceId) {
            this.adviceId = adviceId;
        }
    }
}
