package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import factory.DbConnection;
import model.Cliente;

public class ClienteDao {

	public void addCliente(Cliente cliente) throws IOException {
		
		//Create
		//Insert operation using prepared statement and parametrization to not create sql injection
		String sql = "INSERT INTO cliente (nome,email,telefone) VALUES (?,?,?)";
		try(Connection conn = DbConnection.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql)){
				stmt.setString(1,cliente.getNome());
				stmt.setString(2, cliente.getEmail());
				stmt.setString(3,cliente.getTelefone());
				stmt.executeUpdate();
				conn.close();
			}
		catch(SQLException e){
			throw new RuntimeException("Erro ao adicionar cliente",e);
		}
				
	}
	
	public List<Cliente> getAllCliente () throws IOException{
		String sql = "SELECT * FROM cliente";
		List<Cliente> clientes = new ArrayList<>();
		
		try(Connection conn = DbConnection.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery()){
			//recebendo a lista de clientes
			while(rs.next()) {
				Cliente cliente = new Cliente();
				cliente.setId(rs.getInt("id"));
				cliente.setNome(rs.getString("nome"));
				cliente.setEmail(rs.getString("email"));
				cliente.setTelefone(rs.getString("telefone"));
				clientes.add(cliente);
			}
		}
		catch(SQLException e) {
			throw new RuntimeException("Erro ao buscar clientes",e);
		}
		return clientes;		
	}
	
	
}
