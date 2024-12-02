package main;

import java.io.IOException;
import java.util.List;

import dao.ClienteDao;
import model.Cliente;

public class Main {

	public static void main(String[] args) throws IOException {
		ClienteDao clienteDao = new ClienteDao();
		
		//CREATE
		Cliente novoCliente = new Cliente();
		novoCliente.setNome("João Silva");
		novoCliente.setEmail("joao@gmail.com");
		novoCliente.setTelefone("12345678");
		clienteDao.addCliente(novoCliente);
		
		
		
		List<Cliente> clientes = clienteDao.getAllCliente();
		for(Cliente cliente : clientes) {
			System.out.println("ID: " + cliente.getId() + ", Nome: " +cliente.getNome());
		}
	}

}
