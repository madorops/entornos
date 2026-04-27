import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Select {

	/*
	Prueba select con base de datos
	*/
	
	private static final String URL_BD = "jdbc:mysql://localhost:3306/libros";
	private static final String CONTRASENNA = "";
	private static final String USUARIO = "root";
	

	public static void main(String[] args) {
		/*
		Probar conexion
		*/
		try (Connection conexion = DriverManager.getConnection(URL_BD, USUARIO, CONTRASENNA);
				Statement sentencia = conexion.createStatement();) {

			consultaAutores(sentencia);

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

	}

	private static void consultaAutores(Statement sentencia) throws SQLException {
		ResultSet resultadoQuery;
		resultadoQuery = sentencia.executeQuery("select * from Autor");

		while (resultadoQuery.next()) {
			System.out.print("Id autor:" + resultadoQuery.getString("Id_Autor"));
			System.out.print(" Nombre:" + resultadoQuery.getString("Nombre"));
			System.out.println(" Nacionalidad:" + resultadoQuery.getString("Nacionalidad"));
		}

		resultadoQuery.close();
	}

	

}
