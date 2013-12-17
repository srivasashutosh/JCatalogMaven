<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core" %>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html" %>

<html>
	<head>
    	<title>Product Summary Page</title>
       	<link rel="stylesheet" type="text/css" href="stylesheet.css"/>
    </head>
    <body style="{background-color:#FFFFFF; margin-top:0px}">
    	<f:view>
    	<h:form id="summaryProductForm">
			<table width="280" border="0" cellpadding="0" cellspacing="0">
			    <tr>
          			<td  valign="top">
          				<h:outputText value="#{productBean.name}" styleClass="headerText2"/>   
          				</br></br> 
    				</td>
    			</tr>
    			<tr>
    				<td>
						<h:outputText value="##{productBean.id}"/>&nbsp;&nbsp;
						<h:outputText value="Size: #{productBean.width}W"/>&nbsp;
						<h:outputText value="#{productBean.height}H"/>&nbsp;&nbsp;
						<h:outputText value="#{productBean.price}"  styleClass="highLightText">
							<f:convertNumber type="currency"/>
						</h:outputText>
						</br></br>
					</td>
				</tr>
  				<tr>
         			<td align="center">
          				<h:graphicImage url="images/products/#{productBean.id}.jpg" width="138" height="138"/>
          				</br></br></br>
          			</td>
          		</tr>
          		<tr>
          			<td style="padding-right:15; padding-top:10">
          				<h:outputText id="description" value="[short description] #{productBean.shortDescription}  "/>		
						<h:outputLink value="viewProduct.jsf?productId=#{productBean.id}" styleClass="highLightLink2" target="_parent">
								<f:verbatim> [more]</f:verbatim>
						</h:outputLink> 
					</td>
				</tr>
			</table>
		</h:form>	
		</f:view>
	</body>
</html>