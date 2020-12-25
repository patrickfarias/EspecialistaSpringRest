package com.algaworks.algafood.domain.service;

import com.algaworks.algafood.domain.exception.EntidadeEmUsoException;
import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafood.domain.model.Cidade;
import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.model.Estado;
import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.CidadeRepository;
import com.algaworks.algafood.domain.repository.CozinhaRepository;
import com.algaworks.algafood.domain.repository.EstadoRepository;
import com.algaworks.algafood.domain.repository.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class CadastroCidadeService {

	@Autowired
	private EstadoRepository estadoRepository;

	@Autowired
	private CidadeRepository cidadeRepository;
	
	public Cidade salvar(Cidade cidade) {
		Long estadoId = cidade.getEstado().getId();
		Estado estado = estadoRepository.buscar(estadoId);

		if (estado == null){
			throw new EntidadeNaoEncontradaException(String.format("Nao existe cadastro de estado com o codigo %d", estadoId));
		}
		cidade.setEstado(estado);

		return cidadeRepository.salvar(cidade);
	}
	
//	public void excluir(Long cidadeId) {
//		try {
//			cidadeRepository.remover(cidadeId);
//
//		} catch (EmptyResultDataAccessException e) {
//			throw new EntidadeNaoEncontradaException(
//				String.format("Não existe um cadastro de cozinha com código %d", cozinhaId));
//
//		} catch (DataIntegrityViolationException e) {
//			throw new EntidadeEmUsoException(
//				String.format("Cozinha de código %d não pode ser removida, pois está em uso", cozinhaId));
//		}
//	}
	
}
