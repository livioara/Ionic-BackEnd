package com.livio.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.livio.cursomc.domain.Categoria;
import com.livio.cursomc.domain.Cidade;
import com.livio.cursomc.domain.Cliente;
import com.livio.cursomc.domain.Endereco;
import com.livio.cursomc.domain.Estado;
import com.livio.cursomc.domain.Produto;
import com.livio.cursomc.domain.enums.TipoCliente;
import com.livio.cursomc.repositories.CategoriaRepository;
import com.livio.cursomc.repositories.CidadeRepository;
import com.livio.cursomc.repositories.ClienteRepository;
import com.livio.cursomc.repositories.EnderecoRepository;
import com.livio.cursomc.repositories.EstadoRepository;
import com.livio.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository; 
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private EstadoRepository esatdoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1)); 
		
			
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
		
		
		Estado est1 = new Estado (null, "Minas Gerais");
		Estado est2 = new Estado (null, "São Paulo");
		
		Cidade cid1 = new Cidade (null, "Uberlândia",est1);
		Cidade cid2 = new Cidade (null, "São Paulo",est2);
		Cidade cid3 = new Cidade (null, "Campinas",est2);
		
		est1.getCidades().addAll(Arrays.asList(cid1));
		est2.getCidades().addAll(Arrays.asList(cid2, cid3));
		
		
		esatdoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(cid1, cid2, cid3));
		
		Cliente cli1 = new Cliente(null,"Maria Silva", "maria@gmail.com","55555555588",TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("111111111","22222222222"));
		
		Endereco e1 = new Endereco(null,"Rua Flores","300", "Apt 202", "Jardim","55555555555",cli1,cid1);
		Endereco e2 = new Endereco(null,"Av MAtos","105", "Casa", "Centro","66666666666",cli1,cid2);
		cli1.getEnderecos().addAll(Arrays.asList(e1,e2));
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1,e2));
		
				
	}

}
