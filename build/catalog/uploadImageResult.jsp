<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core" %>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html" %>

<html>
	<head>
    	<title>Upload Product Image Result Page</title>
       	<link rel="stylesheet" type="text/css" href="stylesheet.css"/>
    </head>
    <body>
    	<f:view>
    		<%@ include file="header.jsp" %>
            <table align="center" class="box">
            	<tr><td style="padding:20">
            		<table>
            			<tr>
            				<td>
  								<h:outputText value="Product image was uploaded successfully!"/>
 							</td>
 						</tr>
 						<tr>
 							<td align="center">
 								<h:form id="uploadImageResultForm">
 									<h:commandButton value="Back" action="success"/>
 								</h:form>
 							</td>
 						</tr>
 					</table>
 				</td></tr>
 			</table>
            <%@ include file="footer.jsp" %>			
 		</f:view>
    </body>
</html>