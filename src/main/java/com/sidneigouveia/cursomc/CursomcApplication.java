package com.sidneigouveia.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sidneigouveia.cursomc.domain.Categoria;
import com.sidneigouveia.cursomc.domain.Cidade;
import com.sidneigouveia.cursomc.domain.Cliente;
import com.sidneigouveia.cursomc.domain.Endereco;
import com.sidneigouveia.cursomc.domain.Estado;
import com.sidneigouveia.cursomc.domain.Produto;
import com.sidneigouveia.cursomc.domain.enums.TipoCliente;
import com.sidneigouveia.cursomc.repositories.CategoriaRepository;
import com.sidneigouveia.cursomc.repositories.CidadeRepository;
import com.sidneigouveia.cursomc.repositories.ClienteRepository;
import com.sidneigouveia.cursomc.repositories.EnderecoRepository;
import com.sidneigouveia.cursomc.repositories.EstadoRepository;
import com.sidneigouveia.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {
	
	
    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    private ProdutoRepository produtoRepository;
    private final EstadoRepository estadoRepository;
    @Autowired
    private CidadeRepository cidadeRepository;
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;

    CursomcApplication(EstadoRepository estadoRepository) {
        this.estadoRepository = estadoRepository;
    }

    
    
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		
		
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impresorra", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
	
		
		
		
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
		
		
		
		
		
		
		Estado est1= new Estado(null, "Minas Gerais");
		Estado est2= new Estado(null, "São Paulo");
		
		Cidade c1 = new Cidade(null, "Uberlandia", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);
		
		
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2,c3));
		
		
		
		
		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1,c2,c3));
		
		
		
		
		
		Cliente cli1= new Cliente(null,"Maria Silva", "maria@gmail.com", "46029944827", TipoCliente.PESSOAFISICA);
	    cli1.getTelefones().addAll(Arrays.asList("561556","56562"));
	    
	    Endereco e1 = new Endereco(null, "Rua flores", "1", "perto da rua", "caetano", "13920364", cli1, c1);
	    Endereco e2 = new Endereco(null, "Rua marta", "2", "prto da rua", "são caetano", "13920364", cli1, c2);
	    
	    cli1.getEnderecos().addAll(Arrays.asList(e1,e2));

	    
	    clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1,e2));
		
		
		
      
	
	}



	public ClienteRepository getClienteRepository() {
		return clienteRepository;
	}



	public void setClienteRepository(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}



	public EnderecoRepository getEnderecoRepository() {
		return enderecoRepository;
	}



	public void setEnderecoRepository(EnderecoRepository enderecoRepository) {
		this.enderecoRepository = enderecoRepository;
	}

}
