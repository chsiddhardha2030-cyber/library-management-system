<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>

    <head>
        <title>Library Management System</title>
        <link rel="stylesheet" type="text/css" href="/css/style.css">
    </head>

    <body>
        <nav>
            <div>Library System</div>
            <ul>
                <!-- Authors-only nav on the landing page (by design) -->
                <li><a href="/">Home</a></li>
                <li><a href="/authors">Authors</a></li>
            </ul>
        </nav>
        <div class="container">
            <h1>Welcome to the Library Management System</h1>
            <p>Use the navigation menu above to manage authors and the book catalogue.</p>
            <a href="/authors/new" class="btn">Register New Author</a>
        </div>
    </body>

    </html>