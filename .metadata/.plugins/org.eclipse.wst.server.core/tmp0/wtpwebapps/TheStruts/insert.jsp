<%@ taglib uri="/struts-tags" prefix="s" %>

<s:form action="insert">

<s:textfield name="id" label="Product Id"></s:textfield>
<s:textfield name="name" label="Product Name"></s:textfield>
<s:textfield name="price" label="Product Price"></s:textfield>
<s:submit value="Submit Data"></s:submit>

</s:form>