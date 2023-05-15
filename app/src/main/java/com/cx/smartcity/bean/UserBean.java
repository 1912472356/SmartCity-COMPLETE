package com.cx.smartcity.bean;

public class UserBean {
    /**
     * msg : 操作成功
     * code : 200
     * user : {"userId":1112696,"userName":"dream","nickName":"大卫2","email":"23892398@163.com","phonenumber":"15180019632","sex":"0","avatar":"/profile/2020/10/26/27e7fd58-0972-4dbf-941c-590624e6a886.png","idCard":"101120200202075471","balance":535,"score":1010}
     */

    private String msg;
    private int code;
    private UserDTO user;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public static class UserDTO {
        /**
         * userId : 1112696
         * userName : dream
         * nickName : 大卫2
         * email : 23892398@163.com
         * phonenumber : 15180019632
         * sex : 0
         * avatar : /profile/2020/10/26/27e7fd58-0972-4dbf-941c-590624e6a886.png
         * idCard : 101120200202075471
         * balance : 535.0
         * score : 1010
         */

        private int userId;
        private String userName;
        private String nickName;
        private String email;
        private String phonenumber;
        private String sex;
        private String avatar;
        private String idCard;
        private double balance;
        private int score;

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getNickName() {
            return nickName;
        }

        public void setNickName(String nickName) {
            this.nickName = nickName;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPhonenumber() {
            return phonenumber;
        }

        public void setPhonenumber(String phonenumber) {
            this.phonenumber = phonenumber;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public String getIdCard() {
            return idCard;
        }

        public void setIdCard(String idCard) {
            this.idCard = idCard;
        }

        public double getBalance() {
            return balance;
        }

        public void setBalance(double balance) {
            this.balance = balance;
        }

        public int getScore() {
            return score;
        }

        public void setScore(int score) {
            this.score = score;
        }
    }
}
