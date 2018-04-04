/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Karan
 */
public class Shipment {
    private int sid;
    private int pid;
    private float internalcost;
    private float customerCost;

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public float getInternalcost() {
        return internalcost;
    }

    public void setInternalcost(float internalcost) {
        this.internalcost = internalcost;
    }

    public float getCustomerCost() {
        return customerCost;
    }

    public void setCustomerCost(float customerCost) {
        this.customerCost = customerCost;
    }

   
           
    
}
