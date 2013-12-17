<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core" %>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html" %>

<html>
	<head>
    	<title>Error Page</title>
       	<link rel="stylesheet" type="text/css" href="stylesheet.css"/>
    </head>
    <body>
    	<f:view>
    		<%@ include file="header.jsp" %>
    		<table align="center" class="box">
            	<tr><td style="padding:20">
    				<table align="center" width="300">
            			<tr>
            				<td  align="center">
            					<h:outputText value="Error" styleClass="errorMessage"/>
            				</td>
            			</tr>
            			<tr>
            				<td  align="center">
 								<h:messages layout="table" styleClass="errorMessage"/>
 							</td>
 						</tr>
 					</table>
 				</td></tr>
 			</table>
 		</f:view>
        <%@ include file="footer.jsp" %> 		
    </body>
</html>