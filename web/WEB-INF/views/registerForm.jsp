<%@ page session="false" %>
<html>
<head>
    <title>Register Blog</title>
</head>
<body>
<h1>Register</h1>
<form method="POST" enctype="multipart/form-data">
    Email: <input type="text" name="email" /><br/>
    First Name: <input type="text" name="firstName"/><br/>
    Last Name: <input type="text" name="lastName"/><br/>
    Username: <input type="text" name="username"/><br/>
    Password: <input type="password" name="password"/><br/>
    <label>Profile Picture</label>:
    <input type="file" name="profilePicture" accept="image/jpeg,image/png"/><br/>
    <input type="submit" value="Register"/>
</form>
</body>
</html>