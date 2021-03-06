<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:out value="hello jsp"></c:out>
<br>
<c:forEach var="i" begin="1" end="10">
<c:out value="${i}"></c:out>
<br>
</c:forEach>
<br />

<c:set var="name" scope="session" value="My name is Aman" />
${fn:toUpperCase(name)}
<br />
${fn:toLowerCase(name)}
<br />
${fn:length(name)}
<br>
<a href="getdata.jsp">GetData page</a>
<br />
<c:out value="${name}" />

<c:if test="${fn:endsWith(name, 'Aman')}">
<p>Name ending with Aman keyword</p>
</c:if>

<c:set var="income" scope="session" value="100" />

<c:if test="${income!=100}">
<p>If executed.</p>
</c:if>

<c:if test="${income==100}">
<p>Second if executed</p>
</c:if>

<c:set var="dt" value="<%= new java.util.Date() %>" />
<p>Formatted Date time:
<fmt:formatDate type="both" dateStyle="long" timeStyle="long" value="${dt}" />
</p>

<c:set var="tt" value="<%= java.util.TimeZone.getAvailableIDs() %>"/>
<c:out value="${tt}" />