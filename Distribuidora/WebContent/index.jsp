<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta charset="utf-8">
    
    <link rel="stylesheet" href="style.css">
<title>Inicio</title>
</head>
<body>
 <div class="center">
      <h1>Login</h1>
      <form action="Validar" method="POST">
        <div class="txt_field">
          <input type="text" required name="txtusuario">
          <span></span>
          <label>Username</label>
        </div>
        <div class="txt_field">
          <input type="password" required name="txtpassword">
          <span></span>
          <label>Password</label>
        </div>
        <div class="pass">Forgot Password?</div>
        <input type="submit" name="accion" value="Ingresar">
        <br></br>
        <!--  
        <div class="signup_link">
          Not a member? <a href="#">Signup</a>
        </div>-->
      </form>
    </div>

</body>
</html>