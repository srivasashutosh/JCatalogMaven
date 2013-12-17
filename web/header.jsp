<%@ page contentType="text/html" language="java" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core" %>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

<f:subview id="header">
    <h:form id="headerForm">
    <h:outputText value="#{applicationBean.dummyVariable}" rendered="true"/>
	<h:outputText value="#{userBean.dummyVariable}" rendered="true"/>
    <table width="800" height="50" align="center" border="0">
		<tr>
			<td align="right">
				<h:commandLink styleClass="highLightLink" action="#{productListBean.searchByCategoryAction}" rendered="#{userBean.loggedIn=='true'}">
					<h:outputText value="product list"/>
				</h:commandLink>
				<h:outputText value=" | " styleClass="highLightText" rendered="#{userBean.loggedIn=='true'}"/>
				<h:commandLink  styleClass="highLightLink" action="createProduct" rendered="#{userBean.loggedIn=='true'}">
					<h:outputText value="new product"/>
				</h:commandLink>
				<h:outputText value=" | " styleClass="highLightText" rendered="#{userBean.loggedIn=='true'}"/>
   				<h:commandLink  styleClass="highLightLink" action="#{userBean.logoutAction}" rendered="#{userBean.loggedIn=='true'}">
     				<h:outputText value="logout"/>
     			</h:commandLink>
			</td>
		</tr>
		<tr>
			<td align="right">
     			<h:outputLink  styleClass="highLightLink" value="login.jsf" rendered="#{userBean.loggedIn=='false'}">
					<f:verbatim>login</f:verbatim>
				</h:outputLink>
     		</td>
     	</tr>
		<tr>
			<td>
            	<table>
              		<tr>
						<td width="210">
							<p class="headerText"><a href="front.jsf">JCatalog Project</a></p>
						</td>
						<td width="590"><div align="right">
							<h:outputLink value="front.jsf"  styleClass="highLightLink">
								<f:verbatim>home</f:verbatim>
							</h:outputLink>&nbsp;&nbsp;
							<h:outputText value="|" styleClass="highLightText"/>&nbsp;
							<h:outputLink value="message.jsf"  styleClass="highLightLink">
								<f:verbatim>contact us</f:verbatim>
							</h:outputLink>&nbsp;&nbsp;
							<h:outputText value="|" styleClass="highLightText"/>&nbsp;
							<h:outputLink value="message.jsf" styleClass="highLightLink">
								<f:verbatim>place order</f:verbatim>
							</h:outputLink> 
						</div></td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
	</h:form>
</f:subview>