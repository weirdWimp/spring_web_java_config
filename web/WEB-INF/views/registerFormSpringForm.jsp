<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>

<style type="text/css">
    .diverror {
        background-color: #ffcccc;
        border: 2px solid red;
    }
    .inputerror {
        background-color: #ffcccc;
    }
    .labelerror {
        color: red;
    }
</style>
<s:url value="/homepage" var="homeUrl"/>

<s:url value="/blog/{username}" var="userInfoUrl">
    <s:param name="username" value="Tom"/>
</s:url>


<a href="<s:url value="/homepage"/>">Home</a>
<a href="${userInfoUrl}">Tom's page</a>
<s:url value="/bolg/messageList/" htmlEscape="true">
    <s:param name="count" value="10"/>
</s:url>

<s:escapeBody htmlEscape="true">
    <h1>Hello</h1>
</s:escapeBody>

<h1><s:message code="register.text" /></h1>
<sf:form method="POST" commandName="user">
    <sf:errors path="*" element="div" cssClass="diverror" />
    <sf:label path="firstName" cssErrorClass="labelerror"><s:message code="first.name.text" /></sf:label>:<sf:input path="firstName" cssErrorClass="inputerror"/> <br/>
    <sf:label path="lastName" cssErrorClass="labelerror"><s:message code="last.name.text" /></sf:label>:<sf:input path="lastName" cssErrorClass="inputerror"/> <br/>
    <sf:label path="username" cssErrorClass="labelerror"><s:message code="username.text" /></sf:label>:<sf:input path="username" cssErrorClass="inputerror"/> <br/>
    <sf:label path="email" cssErrorClass="labelerror"><s:message code="email.text" /></sf:label>:<sf:input path="email" type="email" cssErrorClass="inputerror"/> <br/>
    <sf:label path="password" cssErrorClass="labelerror"><s:message code="password.text" /></sf:label>:<sf:password path="password" cssErrorClass="inputerror"/> <br/>
    <input type="submit" value="Register"/>
</sf:form>

