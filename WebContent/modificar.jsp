<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h2>Modificar Articulo</h2>

		<form action="" method="POST" autocomplete="off">
		
			<input id="id" name="id" type="hidden" />

			<p>
				Id:
				<input id="codigo" name="codigo" type="text" />
			</p>
			
			<p>
				Precio:
				<input id="precio" name="precio" type="text" />
			</p>
			
			<p>
				Nombre:
				<input id="nombre" name="nombre" type="text" />
			</p>
			
			<p>
				Stock:
				<input id="stock" name="stock" type="text" />
			</p>
			
			<button id="guardar" name="guardar" type="submit"> Guardar </button>


		</form>

</body>
</html>