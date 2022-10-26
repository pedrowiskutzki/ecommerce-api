// package com.ecommerce.api.controller;


// import com.ecommerce.domain.model.Produto;
// import com.ecommerce.domain.repository.ProdutoRepository;
// import com.ecommerce.domain.service.ProdutoService;
// import java.util.List;
// import java.util.Optional;
// import org.springframework.beans.factory.annotation.Autowired;

// import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;


// @RestController
// @RequestMapping("/produtos")
// public class ProdutoController {

//   @Autowired
//   private ProdutoRepository produtoRepository;

//   @Autowired
//   private ProdutoService produtoService;

//   /**
//    * <p>
//    * Metodo que retorna uma <em>lista de produtos.<em>
//    *
//    * @author Gabriel Gonçalves
//    */
//   @GetMapping
//   public List<Produto> listar() {
//     return produtoRepository.findAll();
//   }

//   /**
//    * <p>
//    * Metodo que retorna uma <em>produto por Id.<em>
//    *
//    * @param produtoId não deve ser {@literal null}.
//    * @return a entidade com o ID fornecido ou {@literal Optional#empty()} se
//    *         nenhum for encontrado.
//    * @author Gabriel Gonçalves
//    *
//    */
//   @GetMapping("/{produtoId}")
//   public Optional<Produto> buscar(@PathVariable Long produtoId) {
//     return produtoRepository.findById(produtoId);
//   }

//   /**
//    * <p>
//    * Metodo que adiciona uma <em>nova produto.<em>
//    *
//    * @author Gabriel Gonçalves
//    */
//  /*  @PostMapping
//   public Produto adicionar(@RequestBody Produto produtoId) {
//     return produtoService.salvar(produtoId);
//   }

//   @PutMapping("/{produtoId}")
//   public Produto atualizar(@PathVariable Long produtoId) {
//     Produto produto = produtoService.buscarOuFalhar(produtoId);

//     return produto = produtoService.salvar(produto);
//   } */

//   /**
//    * <p>
//    * Metodo que deleta uma <em>produto.<em>P
//    *
//    * @author Gabriel Gonçalves
//    */
//   @DeleteMapping("/{produtoId}")
//   public void remover(@PathVariable Long produtoId) {
//     produtoService.excluir(produtoId);
//   }

// }
