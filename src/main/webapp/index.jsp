<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Student Portal</title>
</head>
<body style="font-family: Arial; margin: 40px;">
    <h1>Student Portal</h1>
    <p>This is a simple Maven Web Application packaged as a WAR.</p>

    <form action="hello" method="get">
        <label>Enter your name:</label>
        <input type="text" name="name" required>
        <button type="submit">Submit</button>
    </form>

    <p>Try opening <code>/hello?name=YourName</code> directly.</p>
</body>
</html>
