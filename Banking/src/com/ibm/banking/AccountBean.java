package com.ibm.banking;

import javax.portlet.PortletURL;

public class AccountBean {

    private final String accountId;

    private PortletURL actionURL;

    private final long balance;
    
    private final boolean defaultAccount;

    protected AccountBean() {
        this.balance = 0;
        this.accountId = "";
        defaultAccount = true;
    }

    protected AccountBean(final long balance, final String accountId) {
        this.balance = balance;
        this.accountId = accountId;
        defaultAccount = false;
    }

    public String getAccountId() {
        return accountId;
    }

    public PortletURL getActionURL() {
        return actionURL;
    }

    public String getBalance() {
        return "" + balance;
    }
    
    public boolean isDefaultAccount(){
        return defaultAccount;
    }

    public void setActionURL(PortletURL actionURL) {
        this.actionURL = actionURL;
    }

}
