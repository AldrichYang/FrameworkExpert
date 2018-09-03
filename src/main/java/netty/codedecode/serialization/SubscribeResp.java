package netty.codedecode.serialization;

import com.google.common.base.MoreObjects;

import java.io.Serializable;

/**
 * Created by yh on 2018/6/14.
 */
public class SubscribeResp implements Serializable {
    private static final long serialVersionUID = -5092013012616213773L;
    private int subReqID;
    private int respCode;
    private String desc;

    public int getSubReqID() {
        return subReqID;
    }

    public void setSubReqID(int subReqID) {
        this.subReqID = subReqID;
    }

    public int getRespCode() {
        return respCode;
    }

    public void setRespCode(int respCode) {
        this.respCode = respCode;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("subReqId", subReqID)
                .add("respCode", respCode)
                .add("desc", desc).toString();
    }
}
