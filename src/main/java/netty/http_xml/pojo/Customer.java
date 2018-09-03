package netty.http_xml.pojo;

import java.util.List;

/**
 * Created by yh on 2018/7/20.
 */
public class Customer {
    private long customerNumber;
    /**
     * Personal name.
     */
    private String firstName;
    /**
     * Family name.
     */
    private String lastName;
    /**
     * Middle name(s), if any.
     */
    private List middleNames;

    public long getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(long customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List getMiddleNames() {
        return middleNames;
    }

    public void setMiddleNames(List middleNames) {
        this.middleNames = middleNames;
    }
}
