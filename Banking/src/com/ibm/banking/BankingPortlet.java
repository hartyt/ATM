package com.ibm.banking;

import java.io.*;

import javax.portlet.*;

/**
 * BankingPortlet Portlet
 */
public class BankingPortlet extends javax.portlet.GenericPortlet {

    private static final String PREFIX = "";

    public static final String ACTION_NAME = PREFIX + "actionName";

    public static final String ACCTION_DETAILS = PREFIX + "actionDetails";

    public static final String ACTION_NAME_PARAM = "ACTION_NAME";

    public static final String ACCOUNT_DETAILS_BEAN = PREFIX + "accountDetailsBean";

    public static final String ACCOUNT_ID = PREFIX + "accountId";

    public static final String ACCOUNT_BALANCE = PREFIX + "balance";

    @Override
    public void init() throws PortletException {
        super.init();
    }

    @Override
    public void doView(final RenderRequest request, final RenderResponse response) throws PortletException, IOException {
        response.setContentType(request.getResponseContentType());
        //response.getWriter().write("<div>Hello</div>");
        final String action = (String)request.getPortletSession().getAttribute(ACTION_NAME);
        getPortletContext().log("OrderDetailPortlet doView ActionName=" + action);
        final AccountBean postBean;
        if (action == null) {
            postBean = new AccountBean();
        }
        else {
            final String accountId = (String)request.getPortletSession().getAttribute(ACCOUNT_ID);
            final Long accountBalance = (Long)request.getPortletSession().getAttribute(ACCOUNT_BALANCE);
            postBean = new AccountBean(accountBalance, accountId);
        }
        request.setAttribute(ACCOUNT_DETAILS_BEAN, postBean);
        final PortletURL portletURL = response.createActionURL();
        portletURL.setParameter(ACTION_NAME_PARAM, ACCTION_DETAILS);
        postBean.setActionURL(portletURL);

        final PortletRequestDispatcher rd = getPortletContext().getRequestDispatcher("/_Banking/jsp/html/BankingView.jsp");
        rd.include(request, response);
    }

    @Override
    public void doEdit(final RenderRequest request, final RenderResponse response) throws PortletException, IOException {
    }

    @Override
    protected void doHelp(final RenderRequest request, final RenderResponse response) throws PortletException, IOException {
    }

    @Override
    public void processAction(final ActionRequest request, final ActionResponse response) throws PortletException, java.io.IOException {
        final String actionName = request.getParameter(ACTION_NAME_PARAM);
        System.out.println(ACTION_NAME_PARAM + "=" + actionName);
        final String accountID = request.getParameter(ACCOUNT_ID);
        System.out.println(ACCOUNT_ID + "=" + accountID);
        request.getPortletSession().setAttribute(ACCOUNT_ID, accountID);
        if (accountID.equals("10")) {
            request.getPortletSession().setAttribute(ACCOUNT_BALANCE, new Long(10230));
            request.getPortletSession().setAttribute(ACCOUNT_ID, accountID);
            request.getPortletSession().setAttribute(ACTION_NAME, actionName);
        }
        else{
            request.getPortletSession().removeAttribute(ACTION_NAME);
        }
    }

}
