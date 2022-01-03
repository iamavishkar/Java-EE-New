<%@ taglib uri="/struts-tags" prefix="s" %>

<table border="2">
<tr>
<th>ID</th>
<th>Name</th>
<th>Price</th>
<th colspan="2">Action</th>
</tr>
<s:iterator value="list">
<tr>
<td><s:property value="id"/></td>
<td><s:property value="name"/></td>
<td><s:property value="price"/></td>
<td><a href="edit?id=<s:property value='id'/>">Edit</a></td>
<td><a href="delete?id=<s:property value='id'/>">Delete</a></td>
</tr>
</s:iterator>

</table>