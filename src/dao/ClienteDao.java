package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import factory.DbConnection;
import model.Cliente;

public class ClienteDao {

	public void addCliente(Cliente cliente) {
		
		//Create
		String sql = "INSERT INTO cliente (nome,email,telefone) VALUES (?,?,?)";
		try(Connection conn = DbConnection.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql)){
				stmt.setString(1,cliente.getNome());
				stmt.setString(2, cliente.getEmail());
				stmt.setString(3,cliente.getTelefone());
				stmt.executeUpdate();
			}
		catch(SQLException e){
			throw new RuntimeException("Erro ao adicionar cliente",e);
		}
				
	}
	
	
}
