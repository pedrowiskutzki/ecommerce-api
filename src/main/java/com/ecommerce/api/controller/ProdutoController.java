package com.ecommerce.api.controller;


import com.ecommerce.domain.model.Produto;
import com.ecommerce.domain.repository.ProdutoRepository;
import com.ecommerce.domain.service.ProdutoService;
import java.util.List;
<<<<<<< HEAD
import java.util.Optional;
=======

>>>>>>> 5d75d6a (feat(fix):Controllers)
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

<<<<<<< HEAD
=======
import com.ecommerce.domain.model.dtos.ProdutoRequestDTO;
import com.ecommerce.domain.model.dtos.ProdutoResponseDTO;
import com.ecommerce.domain.service.ProdutoService;
>>>>>>> 5d75d6a (feat(fix):Controllers)

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

  @Autowired
  private ProdutoRepository produtoRepository;

<<<<<<< HEAD
  @Autowired
  private ProdutoService produtoService;

  /**
   * <p>
   * Metodo que retorna uma <em>lista de produtos.<em>
   *
   * @author Gabriel Gonçalves
   */
  @GetMapping
  public List<Produto> listar() {
    return produtoRepository.findAll();
  }

  /**
   * <p>
   * Metodo que retorna uma <em>produto por Id.<em>
   *
   * @param produtoId não deve ser {@literal null}.
   * @return a entidade com o ID fornecido ou {@literal Optional#empty()} se
   *         nenhum for encontrado.
   * @author Gabriel Gonçalves
   *
   */
  @GetMapping("/{produtoId}")
  public Optional<Produto> buscar(@PathVariable Long produtoId) {
    return produtoRepository.findById(produtoId);
  }

  /**
   * <p>
   * Metodo que adiciona uma <em>nova produto.<em>
   *
   * @author Gabriel Gonçalves
   */
  @PostMapping
  public Produto adicionar(@RequestBody Produto produtoId) {
    return produtoService.salvar(produtoId);
  }

  @PutMapping("/{produtoId}")
  public Produto atualizar(@PathVariable Long produtoId) {
    Produto produto = produtoService.buscarOuFalhar(produtoId);

    return produto = produtoService.salvar(produto);
  }

  /**
   * <p>
   * Metodo que deleta uma <em>produto.<em>P
   *
   * @author Gabriel Gonçalves
   */
  @DeleteMapping("/{produtoId}")
  public void remover(@PathVariable Long produtoId) {
    produtoService.excluir(produtoId);
  }
=======
	@GetMapping
	public ResponseEntity<List<ProdutoResponseDTO>> listar() {
		return ResponseEntity.ok(produtoService.listarTodos());
	}
	
	@GetMapping("/{produtoId}")
	public ResponseEntity<ProdutoResponseDTO> listarPorId(@PathVariable Long produtoId)  {
		ProdutoResponseDTO produtoDTO = produtoService.listarPorId(produtoId);
		return ResponseEntity.ok(produtoDTO);
	}

	@PostMapping
	public ResponseEntity<ProdutoResponseDTO> adicionar(@RequestBody ProdutoRequestDTO produto) {
		ProdutoResponseDTO produtoDTO = produtoService.salvar(produto);
		return ResponseEntity.status(HttpStatus.CREATED).body(produtoDTO);
	}

	@PutMapping("/{produtoId}")
	public ResponseEntity<ProdutoResponseDTO> atualizar(@PathVariable Long produtoId, @RequestBody ProdutoRequestDTO produto) {
		ProdutoResponseDTO produtoDTO = produtoService.substituir(produtoId, produto);
		return ResponseEntity.ok(produtoDTO);
	}
>>>>>>> 5d75d6a (feat(fix):Controllers)

}
