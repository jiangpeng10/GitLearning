package domain;

public class Installation {
    private String XLCId;
    private String XLCKey;
    private Object obj;

    public Installation() {
    }

    public String getXLCId() {
        return XLCId;
    }

    public void setXLCId(String XLCId) {
        this.XLCId = XLCId;
    }

    public String getXLCKey() {
        return XLCKey;
    }

    public void setXLCKey(String XLCKey) {
        this.XLCKey = XLCKey;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    @Override
    public String toString() {
        return "Installation{" +
                "XLCId='" + XLCId + '\'' +
                ", XLCKey='" + XLCKey + '\'' +
                ", obj=" + obj +
                '}';
    }
}
