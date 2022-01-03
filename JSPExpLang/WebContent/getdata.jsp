<html>
<head>
<title>JSP Expression Language Example!</title>
</head>
<body>

<h1>GetData Page!</h1>
<br />

<h2>This is normal EL</h2>
<hr />
Name: ${param.name}<br />
Email: ${param.email}<br />
Mobile: ${param.mobile}<br />

<br />
<h2>This is Session EL</h2>
<hr />
Your username is ${sessionScope.username}

<br />
<h2>This is Cookie EL</h2>
<hr />
Your course year is ${cookie.course_year.value}

</body>
</html>