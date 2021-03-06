package com.cursospringboot.spring_boot;

import com.cursospringboot.spring_boot.domain.*;
import com.cursospringboot.spring_boot.domain.enums.EstadoPagamento;
import com.cursospringboot.spring_boot.domain.enums.TipoCliente;
import com.cursospringboot.spring_boot.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;
import java.util.Arrays;

@SpringBootApplication
public class Application implements CommandLineRunner {
	//criando dependencias
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private PedidoRepository pedidoRepository;
	@Autowired
	private PagamentoRepository pagamentoRepository;
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;


	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 =new Categoria(null,"Informatica");
		Categoria cat2 =new Categoria(null, "Escritorio");

		Produto p1= new Produto(null,"Computer",2000.00);
		Produto p2= new Produto(null,"Impressora",800.00);
		Produto p3= new Produto(null,"Mouse",80.00);

		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));

		p1.getCategorias().addAll(Arrays.asList(cat1));
		p1.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));


		categoriaRepository.saveAll(Arrays.asList(cat1,cat2));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));

		Estado est1= new Estado(null,"Parana");
		Estado est2= new Estado(null,"Ceara");

		//cidades conhecer o estado
		Cidade c1= new Cidade(null,"Foz do Iguaco",est1);
		Cidade c2= new Cidade(null,"Medianeira",est1);
		Cidade c3= new Cidade(null, "Fortaleza",est2);

		//estado conhecer suas cidades
		est1.getCidades().addAll(Arrays.asList(c1,c2));
		est2.getCidades().addAll(Arrays.asList(c3));

		//primeiro salva o estado
		estadoRepository.saveAll(Arrays.asList(est1,est2));
		cidadeRepository.saveAll(Arrays.asList(c1,c2,c3));

		//estanciado obj cliente
		Cliente cl1= new Cliente(null,"adelio","adeliogemail.com","225444800144", TipoCliente.PESSOAFISICA);
		//para por os telefones
		cl1.getTelefones().addAll(Arrays.asList("35757777","988878888"));
		//endereco conhece o cliente e cidade
		Endereco e1= new Endereco(null,"rua das vidas","254","apto 101","vila A","3554777",cl1,c1);
		Endereco e2= new Endereco(null,"rua sem fim","171","invasao","Centro","987877",cl1,c2);

		//cliente conhecer o endereco
		cl1.getEnderecos().addAll(Arrays.asList(e1,e2));
		//para salvar no bd tem criar o repository
		//quem tem q salvar primeiro
		clienteRepository.saveAll(Arrays.asList(cl1));
		enderecoRepository.saveAll(Arrays.asList(e1,e2));


		SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy HH:mm");
		Pedido ped1=new Pedido(null,sdf.parse("30/09/2017 10:32"),cl1,e1);//estanciado o primeiro pedido
		Pedido ped2=new Pedido(null,sdf.parse("22/12/1980  18:01"),cl1,e2);//estanciado o segundo pedido

		//estanciar os pagamentos

		Pagamento pagto1= new PagamentoComCartao(null, EstadoPagamento.QUITADO,ped1,6);
		ped1.setPagamento(pagto1);

		Pagamento pagto2=new PagamentoComBoleto(null, EstadoPagamento.PENDENTE,ped2,sdf.parse("20/12/2017 00:20"),null);
		ped2.setPagamento(pagto2);

		//associar o cliente cliente1 com os pedidos dele
		cl1.getPedidos().addAll(Arrays.asList(ped1,ped2));

		//nao e necessario criar repository para subclasses

		// pedido tem ser salvo primeiro para depois o pagamento
		pedidoRepository.saveAll(Arrays.asList(ped1,ped2));
		pagamentoRepository.saveAll(Arrays.asList(pagto1,pagto2));

		ItemPedido ip1 =new ItemPedido(ped1,p1,0.00, 1,2000.00);
		ItemPedido ip2= new ItemPedido(ped1,p3,0.00,2,80.00);
		ItemPedido ip3=new ItemPedido(ped2,p2,100.00,1,800.00);

		//pedido conhecer os seus itens
		ped1.getItens().addAll(Arrays.asList(ip1,ip2));
		ped2.getItens().addAll(Arrays.asList(ip3));

		//produto conhecer o seus itens
		p1.getItens().addAll(Arrays.asList(ip1));
		p2.getItens().addAll(Arrays.asList(ip3));
		p3.getItens().addAll(Arrays.asList(ip2));

		//para salvar temos que criar os repository
		itemPedidoRepository.saveAll(Arrays.asList(ip1,ip2,ip3));







	}
}
