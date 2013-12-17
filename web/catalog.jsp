<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core" %>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

<html>
	<head>
    	<title>Catalog Page</title>
       	<link rel="stylesheet" type="text/css" href="stylesheet.css"/>
       	<script>
			function showItem(url) {
				// Update the contents of the product IFRAME with the specified url
				document.getElementById("product").src = url;
			}
		</script>
    </head>
    <body>
		<f:view>
            <%@ include file="header.jsp" %>
            <h:form id="productListCustomerViewForm">
			<table width="800" border="0" align="center" bgcolor="#FFFFFF">
				<tr>
					<td height="40">&nbsp;</td>
				</tr>
            	<tr valign="top">
            		<td width="460" height="410">
            			<table>
            				<tr>
            					<td colspan="3" align="right" valign="top" height="85">
            						<h:outputText value="#{productListBean.currentCategoryName}" styleClass="headerText"/>
            					</td>
            				</tr>
            				<tr valign="top" height="162">
            				<c:forEach items="${productListBean.currentProductBeans}" var="productBean" varStatus="status">
            					<c:if test="${status.index%3 == 0}">
            						<tr valign="top" height="162">
            					</c:if>   
            					<td align="middle" width="150">
            						<c:if test="${productBean.id != null}">
            							<a href="javascript:showItem('productSummary.jsf?productId=<c:out value="${productBean.id}"/>')">
            								<image src="images/products/<c:out value="${productBean.id}"/>.jpg" width="100" height="100" border="0"/>  
            							</a>
            						</c:if>
            						<c:if test="${productBean.id == null}">&nbsp;</c:if>
            					</td>
            					<c:if test="${status.index%3 == 2}"></tr></c:if>  
            				</c:forEach> 
            			</table>
            		</td>
            		<td width="340" height="410">
            			<table>
            				<tr>
            					<td height="390" valign="top">
            					    <c:if test="${productListBean.totalPages > 0}">
            							<iframe width="340"  height="390" id="product" frameborder="0" scrolling="auto" src="productSummary.jsf?productId=<c:out value="${productListBean.currentProductBeans[0].id}"/>">
            						</c:if>
		  							</iframe>  
		  						</td>
		  					</tr>
		  					<tr>
		  						<td align="center" height="20" valign="bottom">
		  						<c:if test="${productListBean.totalPages > 0}">
		  							<h:commandLink action="#{productListBean.searchByCategoryAction}" rendered="#{productListBean.totalPages > 1 && productListBean.pageNo > 1}" styleClass="highLightLink2">
										<h:outputText value="<<"/>
										<f:param name="categoryId" value="#{productListBean.currentCategoryId}"/>
										<f:param name="pageNo" value="#{productListBean.pageNo - 1}"/>
									</h:commandLink>
		  							<h:outputText value="page #{productListBean.pageNo} of #{productListBean.totalPages}" styleClass="highLightText2"/>
		  							<h:commandLink action="#{productListBean.searchByCategoryAction}" styleClass="highLightLink2">
										<h:outputText value=">>" rendered="#{productListBean.totalPages > 1 && productListBean.pageNo < productListBean.totalPages}"/>
										<f:param name="categoryId" value="#{productListBean.currentCategoryId}"/>
										<f:param name="pageNo" value="#{productListBean.pageNo + 1}"/>
									</h:commandLink>
								</c:if>
		  						</td>
		  					</tr>
		  				</table>
		  			</td>
		  		</tr>
  				<tr>
    				<td colspan="2"><hr width="760" color="#CCCCCC"/></td>
  				</tr>		  		
      			<tr>
      				<td colspan="2">
      					<table width="800" height="50">
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
	
