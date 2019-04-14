        <%@ page contentType="text/html;charset=UTF-8" language="java" %>
                <%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
                <%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
                <html>
                <head>
                <title>Spittr</title>
                </head>
                <body>
                <div id="header">
                <tiles:insertAttribute name="header"></tiles:insertAttribute>
                </div>
                <div id="body">
                <tiles:insertAttribute name="body"></tiles:insertAttribute>
                </div>
                <div id="footer">
                <tiles:insertAttribute name="footer"></tiles:insertAttribute>
                </div>
                </body>
                </html>