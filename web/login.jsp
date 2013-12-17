<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core" %>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html" %>

<html>
	<head>
    	<title>Login Page</title>
       	<link rel="stylesheet" type="text/css" href="stylesheet.css"/>
    </head>
    <body>
        <f:view>
        	<%@ include file="header.jsp" %>
            <h:form id="loginForm">
            	<table align="center" class="box">
            		<tr><td style="padding:20">
            			<table>
            				<tr>
            					<td align="right">
            						<h:outputText value="Username"/>
 								</td>
 								<td align="left">
                   					<h:inputText value="#{userBean.username}" id="username" required="true"/>
                   					<h:message styleClass="errorMessage" for="username"/>
                   				</td>
                   			</tr>
                			<tr>
                   				<td align="right">
                   	    			<h:outputText value="Password"/>
 								</td>
 								<td align="left">
                    				<h:inputSecret value="#{userBean.password}" id="password" required="true"/>
                    				<h:message styleClass="errorMessage" for="password"/>
                    			</td>
              				</tr>
              				<tr>
              					<td colspan="2" align="center">
                    				<h:commandButton value="Login" action="#{userBean.loginAction}"/>
                  				</td>
              				</tr>
              				<tr >
              					<td colspan="2" align="center">
                    				<h:messages errorClass="errorMessage" globalOnly="true"/>
                    			</td>
                			</tr>
          				</table>
          			</td></tr>
          		</table>
            </h:form>
            <%@ include file="footer.jsp" %>            
     	</f:view>
   	</body>
</html>