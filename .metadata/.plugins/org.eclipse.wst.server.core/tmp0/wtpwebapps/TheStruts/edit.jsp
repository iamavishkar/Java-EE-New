<%@ taglib uri="/struts-tags" prefix="s" %>

<s:form action="update">
<s:iterator value="list">
<s:textfield name="id" label="Product Id"/>
<s:textfield name="name" label="Product Name"/>
<s:textfield name="price" label="Product Price"/>

<s:submit value="Edit Data"></s:submit>
</s:iterator>

</s:form>