<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core" %>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html" %>

<html>
	<head>
    	<title>Front Page</title>
       	<link rel="stylesheet" type="text/css" href="stylesheet.css"/>
    </head>
    <body>
    	<f:view>
        	<%@ include file="header.jsp" %>	
                <h:form id="selectCategoryForm">
					<table width="800" height="400" border="0" align="center" bgcolor="#FFFFFF">
  						<tr>
    						<td colspan="2" width="400">
      							<table width="800" border="0">
        							<tr>
          								<td width="500" align="center">
          									<h:graphicImage url="images/headerImage.jpg"/>
          								</td>
          								<td width="300" valign="top">
          									<table border="0">
        										<tr height="40">
          											<td>&nbsp;</td>
        										</tr>
       											<tr>
          											<td>    
          												<p class="headerText">             	
          													<h:commandLink action="#{productListBean.searchByCategoryAction}">
																<h:outputText value="Category One"/>
																<f:param name="categoryId" value="1"/>
															</h:commandLink>
														</p>
         												<p class="headerText">             	
          													<h:commandLink action="#{productListBean.searchByCategoryAction}">
																<h:outputText value="Category Two"/>
																<f:param name="categoryId" value="2"/>
															</h:commandLink>
														</p>  
        												<p class="headerText">             	
          													<h:commandLink action="#{productListBean.searchByCategoryAction}">
																<h:outputText value="Category Three"/>
																<f:param name="categoryId" value="3"/>
															</h:commandLink>
														</p> 
														<p class="headerText">             	
          													<h:commandLink action="#{productListBean.searchByCategoryAction}">
																<h:outputText value="Category Four"/>
																<f:param name="categoryId" value="4"/>
															</h:commandLink>
														</p> 	
													</td>				        			
        										</tr>
        										<tr>
          											<td>
          												<p>&nbsp;</p>
          												<p class="highLightText">Wholesale</p>
          											</td>
        										</tr>
      										</table>
      									</td>
     								</tr>
   								</table>
    						</td>
  						</tr>
  						<tr>
    						<td colspan="2" bg><hr width="760" color="#CCCCCC"/></td>
  						</tr>
  						<tr align="center">
    						<td colspan="2">
	 							<table width="800" border="0">
      								<tr>
        								<td><div align="center" class="headerText">         				
        									<h:commandLink action="#{productListBean.searchByCategoryAction}">
												<h:outputText value="Category One"/>
												<f:param name="categoryId" value="1"/>
											</h:commandLink></div></td>
        								<td><div align="center" class="headerText">         				
        									<h:commandLink action="#{productListBean.searchByCategoryAction}">
												<h:outputText value="Category Two"/>
												<f:param name="categoryId" value="2"/>
											</h:commandLink></div></td>
        								<td><div align="center" class="headerText">
        									<h:commandLink action="#{productListBean.searchByCategoryAction}">
												<h:outputText value="Category Three"/>
												<f:param name="categoryId" value="3"/>
											</h:commandLink></div></td>
        								<td><div align="center" class="headerText">
        									<h:commandLink action="#{productListBean.searchByCategoryAction}">
												<h:outputText value="Category Four"/>
												<f:param name="categoryId" value="4"/>
											</h:commandLink>
										</div></td>
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