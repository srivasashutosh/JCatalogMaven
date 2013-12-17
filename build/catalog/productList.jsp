<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core" %>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html" %>

<html>
	<head>
    	<title>Product List Page</title>
       	<link rel="stylesheet" type="text/css" href="stylesheet.css"/>
    </head>
    <body>
		<f:view>
            	<%@ include file="header.jsp" %>
                <h:form id="productListForm">
                	<table align="center"><tr><td>
					<h:dataTable id="table" value="#{productListBean.currentProductBeans}" var="productBean">   
  						<h:column>
    						<f:facet name="header">
      							<h:outputText  value="Product Id"/>
    						</f:facet>
     						<h:outputText value="#{productBean.id}"/>
  						</h:column>
  						<h:column>
    						<f:facet name="header">
      							<h:outputText  value="Product Name"/>
    						</f:facet>
     						<h:outputText value="#{productBean.name}"/>
  						</h:column>
  						<h:column>
    						<f:facet name="header">
      							<h:outputText  value="Product Price ($)"/>
    						</f:facet>
     						<h:outputText value="#{productBean.price}"/>
  						</h:column>
  						<h:column>
    						<f:facet name="header">
      							<h:outputText  value="Product Width (Inch)"/>
    						</f:facet>
     						<h:outputText value="#{productBean.width}"/>
  						</h:column>
  						<h:column>
    						<f:facet name="header">
      							<h:outputText  value="Product Height (Inch)"/>
    						</f:facet>
     						<h:outputText value="#{productBean.height}"/>
  						</h:column>
  						 <h:column>
    						<f:facet name="header">
      							<h:outputText  value=""/>
    						</f:facet>
 							<h:commandLink action="viewProduct" styleClass="highLightLink">
								<h:outputText value="view"/>
								<f:param name="productId" value="#{productBean.id}"/>
							</h:commandLink>
  						</h:column>
  						<h:column>
  							<h:outputText value=" | " styleClass="highLightText"/>
  						</h:column>
  						<h:column>
  							<f:facet name="header">
  								<h:outputText value=""/>
  							</f:facet>
 							<h:commandLink action="editProduct" styleClass="highLightLink">
								<h:outputText value="edit"/>
								<f:param name="productId" value="#{productBean.id}"/>
							</h:commandLink>
     					</h:column>
  						<h:column>
  							<h:outputText value=" | " styleClass="highLightText"/>
  						</h:column>
  						<h:column>
  							<f:facet name="header">
  								<h:outputText value=""/>
  							</f:facet>
  							<h:commandLink action="#{productBean.deleteAction}" styleClass="highLightLink">
								<h:outputText value="delete"/>
								<f:param name="productId" value="#{productBean.id}"/>
							</h:commandLink>
     					</h:column>
					</h:dataTable> 
					</td></tr></table>
               </h:form>
             <%@ include file="footer.jsp" %>              
		</f:view>
	</body>
</html>
	
