<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core" %>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html" %>

<html>
	<head>
    	<title>Product Detail Page</title>
       	<link rel="stylesheet" type="text/css" href="stylesheet.css"/>
    </head>
    <body>
    	<f:view>
    		<%@ include file="header.jsp" %>
    		<h:form id="viewProductForm">
			<table width="800" border="0" align="center" bgcolor="#FFFFFF" cellpadding="0" cellspacing="0">
				<tr>
					<td colspan="2">&nbsp;</td>
				</tr>
  				<tr>
         			<td width="460">
         				<table width="460">
         					<tr height="80">
            					<td align="right" valign="top">
            						<h:outputText value="#{productListBean.currentCategoryName}" styleClass="headerText"/>
            					</td>
            				</tr>
           					<tr>
           						<td align="center">
          							<h:graphicImage url="images/products/#{productBean.id}.jpg"/>
          						</td>
          					</tr>
          				</table>
          			</td>
          			<td width="340" valign="top">
          				<table border="0" bgcolor="#FFFFFF">
			    			<tr>
          						<td  valign="top">
          							<h:outputText value="#{productBean.name}" styleClass="headerText2"/>    
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
								</td>
							</tr>
							<tr>
								<td>&nbsp;</td>
							<tr>
								<td style="padding-right:30; padding-top:20">
									<h:outputText id="description" value="#{productBean.description}"/>
								</td>
							</tr>
						</table>
					</td>
				</tr>
  				<tr>
    				<td colspan="2" bordercolor="#FFFFFF" bgcolor="#FFFFFF"><hr width="760" color="#CCCCCC"/></td>
  				</tr>		  		
      			<tr>
      				<td colspan="2">
      					<table width="800"  height="50">
      						<tr>
        						<td>
        							<div align="center" class="headerText">         				
 										<h:commandLink action="#{productListBean.searchByCategoryAction}">
											<h:outputText value="Category One"/>
											<f:param name="categoryId" value="1"/>
										</h:commandLink>
									</div>
								</td>
        						<td>
        							<div align="center" class="headerText">         				          	
          								<h:commandLink action="#{productListBean.searchByCategoryAction}">
											<h:outputText value="Category Two"/>
											<f:param name="categoryId" value="2"/>
										</h:commandLink>
									</div>
								</td>
        						<td>
        							<div align="center" class="headerText">
        								<h:commandLink action="#{productListBean.searchByCategoryAction}">
											<h:outputText value="Category Three"/>
											<f:param name="categoryId" value="3"/>
										</h:commandLink>
									</div>
								</td>
        						<td>
        							<div align="center" class="headerText">
        								<h:commandLink action="#{productListBean.searchByCategoryAction}">
											<h:outputText value="Category Four"/>
											<f:param name="categoryId" value="4"/>
										</h:commandLink>
									</div>
								</td>
      						</tr>		  		
		  				</table> 
		  			</td>
		  		</tr>       
			</table>
			</h:form>
            <%@ include file="footer.jsp" %>			
		</f:view>
	</body>
</html>
