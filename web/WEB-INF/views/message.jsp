<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<c:forEach items="${messageList}" var="message" >
    <li id="message_<c:out value="message.name"/>">
        <div class="messageOwner">
            <c:out value="${message.name}" />
        </div>
        <div>
            <span class="messageTime"><c:out value="${message.message}" /></span>
            <span class="spittleLocation"><c:out value="${message.time}" /></span>
        </div>
    </li>
</c:forEach>
</body>
</html>

