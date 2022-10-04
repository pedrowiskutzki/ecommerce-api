package com.ecommerce.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.domain.categoria.Categoria;
import com.ecommerce.domain.repository.CategoriaRepository;
import com.ecommerce.domain.service.CategoriaService;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private CategoriaService categoriaService;

	/**
	 * <p>
	 * Metodo que retorna uma <em>lista de categorias.<em>
	 * 
	 * @author Gabriel Gonçalves
	 */
	@GetMapping
	public List<Categoria> listar() {
		return categoriaRepository.findAll();
	}

	/**
	 * <p>
	 * Metodo que retorna uma <em>categoria por Id.<em>
	 * 
	 * @param categoriaId não deve ser {@literal null}.
	 * @return a entidade com o ID fornecido ou {@literal Optional#empty()} se
	 *         nenhum for encontrado.
	 * @author Gabriel Gonçalves
	 * 
	 */
	@GetMapping("/{categoriaId}")
	public Optional<Categoria> buscar(@PathVariable Long categoriaId) {

		return categoriaRepository.findById(categoriaId);
	}

	/**
	 * <p>
	 * Metodo que adiciona uma <em>nova categoria.<em>
	 * 
	 * @author Gabriel Gonçalves
	 */
	@PostMapping
	public Categoria adicionar(@RequestBody Categoria categoriaId) {
		return categoriaService.salvar(categoriaId);
	}

	@PutMapping("/{categoriaId}")
	public Categoria atualizar(@PathVariable Long categoriaId) {
		Categoria categoria = categoriaService.buscarOuFalhar(categoriaId);

		return categoria = categoriaService.salvar(categoria);
	}

	/**
	 * <p>
	 * Metodo que deleta uma <em>categoria.<em>
	 * 
	 * @author Gabriel Gonçalves
	 */
	@DeleteMapping("/{categoriaId}")
	public void remover(@PathVariable Long categoriaId) {
		categoriaService.excluir(categoriaId);
	}
}
