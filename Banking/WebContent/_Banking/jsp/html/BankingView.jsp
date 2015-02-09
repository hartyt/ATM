<%@page import="com.ibm.banking.BankingPortlet"%>
<%@page import="com.ibm.banking.AccountBean"%>
<%@page session="false" contentType="text/html"
	pageEncoding="ISO-8859-1" import="java.util.*,javax.portlet.*"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<portlet:defineObjects />

<%
    final AccountBean accountBean = (AccountBean)renderRequest.getAttribute(BankingPortlet.ACCOUNT_DETAILS_BEAN);
    if (!accountBean.isDefaultAccount()) {
%>
<table>
	<tr class="wpsTableHead">
		<td>Account ID</td>
		<td>Account Balance</td>
	</tr>
	<tr class="wpsTableShdRow">
		<td><%=accountBean.getAccountId()%></td>
		<td><%=accountBean.getBalance()%>
	</tr>
</table>
<%
    }
%>

<div class="wpsPortletText">
	<form method="POST" action="<%=accountBean.getActionURL()%>" enctype="application/x-www-form-urlencoded" name="AccountDetails">
		<label class="wpsLabelText" for="<%=BankingPortlet.ACCOUNT_ID%>">Enter Account id:</label>
		<br />
		<input class="wpsEditField" name="<%=BankingPortlet.ACCOUNT_ID%>" type="text" />
		<br /> 
		<input class="wpsButtonText" name="submit" type="submit" value="Submit" />
	</form>
</div>