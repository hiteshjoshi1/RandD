<%@page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<HTML>
<HEAD>
<TITLE>Result</TITLE>
</HEAD>
<BODY>
<H1>Result</H1>

<jsp:useBean id="sampleContatctServiceProxyid" scope="session" class="net.hitesh.webservice.service.ContatctServiceProxy" />
<%
if (request.getParameter("endpoint") != null && request.getParameter("endpoint").length() > 0)
sampleContatctServiceProxyid.setEndpoint(request.getParameter("endpoint"));
%>

<%
String method = request.getParameter("method");
int methodID = 0;
if (method == null) methodID = -1;

if(methodID != -1) methodID = Integer.parseInt(method);
boolean gotMethod = false;

try {
switch (methodID){ 
case 2:
        gotMethod = true;
        java.lang.String getEndpoint2mtemp = sampleContatctServiceProxyid.getEndpoint();
if(getEndpoint2mtemp == null){
%>
<%=getEndpoint2mtemp %>
<%
}else{
        String tempResultreturnp3 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getEndpoint2mtemp));
        %>
        <%= tempResultreturnp3 %>
        <%
}
break;
case 5:
        gotMethod = true;
        String endpoint_0id=  request.getParameter("endpoint8");
            java.lang.String endpoint_0idTemp = null;
        if(!endpoint_0id.equals("")){
         endpoint_0idTemp  = endpoint_0id;
        }
        sampleContatctServiceProxyid.setEndpoint(endpoint_0idTemp);
break;
case 10:
        gotMethod = true;
        net.hitesh.webservice.service.ContatctService getContatctService10mtemp = sampleContatctServiceProxyid.getContatctService();
if(getContatctService10mtemp == null){
%>
<%=getContatctService10mtemp %>
<%
}else{
        if(getContatctService10mtemp!= null){
        String tempreturnp11 = getContatctService10mtemp.toString();
        %>
        <%=tempreturnp11%>
        <%
        }}
break;
case 13:
        gotMethod = true;
        String contactId_1id=  request.getParameter("contactId24");
            java.lang.Integer contactId_1idTemp = null;
        if(!contactId_1id.equals("")){
         contactId_1idTemp  = java.lang.Integer.valueOf(contactId_1id);
        }
        net.hitesh.webservice.service.ContactServiceResponse getContactById13mtemp = sampleContatctServiceProxyid.getContactById(contactId_1idTemp);
if(getContactById13mtemp == null){
%>
<%=getContactById13mtemp %>
<%
}else{
%>
<TABLE>
<TR>
<TD COLSPAN="3" ALIGN="LEFT">returnp:</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">telephone:</TD>
<TD>
<%
if(getContactById13mtemp != null){
java.lang.String typetelephone16 = getContactById13mtemp.getTelephone();
        String tempResulttelephone16 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typetelephone16));
        %>
        <%= tempResulttelephone16 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">email:</TD>
<TD>
<%
if(getContactById13mtemp != null){
java.lang.String typeemail18 = getContactById13mtemp.getEmail();
        String tempResultemail18 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeemail18));
        %>
        <%= tempResultemail18 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">lastname:</TD>
<TD>
<%
if(getContactById13mtemp != null){
java.lang.String typelastname20 = getContactById13mtemp.getLastname();
        String tempResultlastname20 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typelastname20));
        %>
        <%= tempResultlastname20 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">firstname:</TD>
<TD>
<%
if(getContactById13mtemp != null){
java.lang.String typefirstname22 = getContactById13mtemp.getFirstname();
        String tempResultfirstname22 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typefirstname22));
        %>
        <%= tempResultfirstname22 %>
        <%
}%>
</TD>
</TABLE>
<%
}
break;
case 26:
        gotMethod = true;
        String contactName_2id=  request.getParameter("contactName29");
            java.lang.String contactName_2idTemp = null;
        if(!contactName_2id.equals("")){
         contactName_2idTemp  = contactName_2id;
        }
        net.hitesh.webservice.service.ContactServiceResponse[] getContactByName26mtemp = sampleContatctServiceProxyid.getContactByName(contactName_2idTemp);
if(getContactByName26mtemp == null){
%>
<%=getContactByName26mtemp %>
<%
}else{
        String tempreturnp27 = null;
        if(getContactByName26mtemp != null){
        java.util.List listreturnp27= java.util.Arrays.asList(getContactByName26mtemp);
        tempreturnp27 = listreturnp27.toString();
        }
        %>
        <%=tempreturnp27%>
        <%
}
break;
}
} catch (Exception e) { 
%>
Exception: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.toString()) %>
Message: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.getMessage()) %>
<%
return;
}
if(!gotMethod){
%>
result: N/A
<%
}
%>
</BODY>
</HTML>