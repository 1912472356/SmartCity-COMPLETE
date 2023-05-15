package com.cx.smartcity.bean;

import java.io.Serializable;
import java.util.List;

public class SubwaySizeBean implements Serializable {
    /**
     * msg : 操作成功
     * code : 200
     * data : [{"lineId":31,"lineName":"2号线","preStep":{"name":"朝阳门","lines":[{"lineId":21,"lineName":"6号线"},{"lineId":24,"lineName":"6号线"},{"lineId":31,"lineName":"2号线"},{"lineId":38,"lineName":"2号线"}]},"nextStep":{"name":"北京站","lines":[{"lineId":31,"lineName":"2号线"},{"lineId":38,"lineName":"2号线"}]},"currentName":"建国门","reachTime":2},{"lineId":33,"lineName":"1号线","preStep":{"name":"东单","lines":[{"lineId":33,"lineName":"1号线"},{"lineId":34,"lineName":"5号线"},{"lineId":35,"lineName":"1号线"},{"lineId":39,"lineName":"5号线"}]},"nextStep":{"name":"永安里","lines":[{"lineId":33,"lineName":"1号线"},{"lineId":35,"lineName":"1号线"}]},"currentName":"建国门","reachTime":2},{"lineId":35,"lineName":"1号线","preStep":{"name":"永安里","lines":[{"lineId":33,"lineName":"1号线"},{"lineId":35,"lineName":"1号线"}]},"nextStep":{"name":"东单","lines":[{"lineId":33,"lineName":"1号线"},{"lineId":34,"lineName":"5号线"},{"lineId":35,"lineName":"1号线"},{"lineId":39,"lineName":"5号线"}]},"currentName":"建国门","reachTime":8},{"lineId":38,"lineName":"2号线","preStep":{"name":"北京站","lines":[{"lineId":31,"lineName":"2号线"},{"lineId":38,"lineName":"2号线"}]},"nextStep":{"name":"朝阳门","lines":[{"lineId":21,"lineName":"6号线"},{"lineId":24,"lineName":"6号线"},{"lineId":31,"lineName":"2号线"},{"lineId":38,"lineName":"2号线"}]},"currentName":"建国门","reachTime":9}]
     */

    private String msg;
    private int code;
    private List<DataDTO> data;

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

    public List<DataDTO> getData() {
        return data;
    }

    public void setData(List<DataDTO> data) {
        this.data = data;
    }

    public static class DataDTO implements Serializable{
        /**
         * lineId : 31
         * lineName : 2号线
         * preStep : {"name":"朝阳门","lines":[{"lineId":21,"lineName":"6号线"},{"lineId":24,"lineName":"6号线"},{"lineId":31,"lineName":"2号线"},{"lineId":38,"lineName":"2号线"}]}
         * nextStep : {"name":"北京站","lines":[{"lineId":31,"lineName":"2号线"},{"lineId":38,"lineName":"2号线"}]}
         * currentName : 建国门
         * reachTime : 2
         */

        private int lineId;
        private String lineName;
        private PreStepDTO preStep;
        private NextStepDTO nextStep;
        private String currentName;
        private int reachTime;

        public int getLineId() {
            return lineId;
        }

        public void setLineId(int lineId) {
            this.lineId = lineId;
        }

        public String getLineName() {
            return lineName;
        }

        public void setLineName(String lineName) {
            this.lineName = lineName;
        }

        public PreStepDTO getPreStep() {
            return preStep;
        }

        public void setPreStep(PreStepDTO preStep) {
            this.preStep = preStep;
        }

        public NextStepDTO getNextStep() {
            return nextStep;
        }

        public void setNextStep(NextStepDTO nextStep) {
            this.nextStep = nextStep;
        }

        public String getCurrentName() {
            return currentName;
        }

        public void setCurrentName(String currentName) {
            this.currentName = currentName;
        }

        public int getReachTime() {
            return reachTime;
        }

        public void setReachTime(int reachTime) {
            this.reachTime = reachTime;
        }

        public static class PreStepDTO implements Serializable{
            /**
             * name : 朝阳门
             * lines : [{"lineId":21,"lineName":"6号线"},{"lineId":24,"lineName":"6号线"},{"lineId":31,"lineName":"2号线"},{"lineId":38,"lineName":"2号线"}]
             */

            private String name;
            private List<LinesDTO> lines;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public List<LinesDTO> getLines() {
                return lines;
            }

            public void setLines(List<LinesDTO> lines) {
                this.lines = lines;
            }

            public static class LinesDTO implements Serializable{
                /**
                 * lineId : 21
                 * lineName : 6号线
                 */

                private int lineId;
                private String lineName;

                public int getLineId() {
                    return lineId;
                }

                public void setLineId(int lineId) {
                    this.lineId = lineId;
                }

                public String getLineName() {
                    return lineName;
                }

                public void setLineName(String lineName) {
                    this.lineName = lineName;
                }
            }
        }

        public static class NextStepDTO implements Serializable{
            /**
             * name : 北京站
             * lines : [{"lineId":31,"lineName":"2号线"},{"lineId":38,"lineName":"2号线"}]
             */

            private String name;
            private List<LinesDTO> lines;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public List<LinesDTO> getLines() {
                return lines;
            }

            public void setLines(List<LinesDTO> lines) {
                this.lines = lines;
            }

            public static class LinesDTO implements Serializable{
                /**
                 * lineId : 31
                 * lineName : 2号线
                 */

                private int lineId;
                private String lineName;

                public int getLineId() {
                    return lineId;
                }

                public void setLineId(int lineId) {
                    this.lineId = lineId;
                }

                public String getLineName() {
                    return lineName;
                }

                public void setLineName(String lineName) {
                    this.lineName = lineName;
                }
            }
        }
    }
}
