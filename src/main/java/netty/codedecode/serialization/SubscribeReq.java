package netty.codedecode.serialization;

import com.google.common.base.MoreObjects;

import java.io.Serializable;

/**
 * Created by yh on 2018/6/14.
 */
public class SubscribeReq implements Serializable {
    private static final long serialVersionUID = 8401203894933274525L;
    private int subReqID;
    private String userName;
    private String productName;
    private String phoneNumber;
    private String address;

    public int getSubReqID() {
        return subReqID;
    }

    public void setSubReqID(int subReqID) {
        this.subReqID = subReqID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("subReqID", subReqID)
                .add("userName", userName)
                .add("productName", productName)
                .add("phoneNumber", phoneNumber)
                .add("address", address).toString();

    }
}
