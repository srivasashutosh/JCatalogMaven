<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core" %>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html" %>

<html>
	<head>
    	<title>Upload Product Imaqge Page</title>
       	<link rel="stylesheet" type="text/css" href="stylesheet.css"/>
    </head>
    <body>
    	<f:view>
    		<%@ include file="header.jsp" %>
    		<form enctype="multipart/form-data" method="POST" action="upload.file">
            <table align="center" class="box">
            	<tr><td style="padding:20">
            		<table>
            			<tr>
            				<td align="center">
                				<h:outputText value="Product with id of #{sessionBean.currentProductId} was created successfully." />
                			</td>
                		</tr>
                		<tr>
                			<td align="center">
                				<h:outputText value="Please upload product image." />
                			</td>
                		</tr>
                		<tr>
                			<td align="center">
								<input type="file" name="productImageFile"/>
							</td>
						</tr>
						<tr>
							<td align="center">
								<input type="submit" value="Upload"/>
							</td>
						</tr>
					</table>
				</td></tr>
			</table>
			</form>
            <%@ include file="footer.jsp" %>			
		</f:view>
   	</body>
</html>