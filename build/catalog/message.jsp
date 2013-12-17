<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core" %>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

<html>
	<head>
    	<title>Message Page</title>
       	<link rel="stylesheet" type="text/css" href="stylesheet.css"/>
    </head>
    <body>
		<f:view>
		<%@ include file="header.jsp" %>
		<h:form id="messageForm">
            <table align="center" width="500">
            	    <tr >
            	        <td></td>
              			<td align="left">
                    		<h:outputText value="Message" styleClass="headerText"/>
                    	</td>
                	</tr>
            		<tr>
            			<td align="right" width="100">
            				<h:outputText value="First Name"/>
            			</td>
            			<td align="left" width="400">
                   			<h:inputText value="#{messageBean.firstName}" id="firstName" required="true"/>
                   			<h:message styleClass="errorMessage" for="firstName"/>
                   		</td>
                   	</tr>
                	<tr>
             			<td align="right" width="100">
            				<h:outputText value="Last Name"/>
            			</td>
            			<td align="left" width="400">
                   			<h:inputText value="#{messageBean.lastName}" id="lastName" required="true"/>
                   			<h:message styleClass="errorMessage" for="lastName"/>
                   		</td>
              		</tr>
               		<tr>
            			<td align="right" width="100">
            				<h:outputText value="Email Address"/>
            			</td>
            			<td align="left" width="400">
                   			<h:inputText value="#{messageBean.emailAddress}" id="emailAddress" required="true"/>
                   			<h:message styleClass="errorMessage" for="emailAddress"/>
                   		</td>
              		</tr>
                	<tr>
            			<td align="right" width="100" valign="bottom">
            				<h:outputText value="Content"/>
            			</td>
            			<td align="left" width="400">
                   			<h:inputTextarea value="#{messageBean.content}" id="content" rows="18" cols="28"/>
                   			<h:message styleClass="errorMessage" for="content"/>
                   		</td>
              		</tr>        		             		
              		<tr>
              			<td></td>
              			<td align="left">
                    		<h:commandButton value="Submit" action="#{messageBean.submitAction}"/>
                  		</td>
              		</tr>              		
          		</table>        
            </h:form>
            <%@ include file="footer.jsp" %>
        </f:view>
  	</body>
</html>