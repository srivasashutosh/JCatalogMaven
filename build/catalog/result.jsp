<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core" %>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html" %>

<html>
	<head>
    	<title>Response Page</title>
       	<link rel="stylesheet" type="text/css" href="stylesheet.css"/>
    </head>
    <body>
    	<f:view>
    		<%@ include file="header.jsp" %>
    		<table align="center" class="box">
            	<tr><td style="padding:20">
            		<table align="center">
            			<tr>
            				<td align="center">
 								<h:messages layout="table"/>
 							</td>
 						</tr>
 					</table>
 				</td></tr>
 			</table>
            <%@ include file="footer.jsp" %> 			
 		</f:view>
    </body>
</html>