package com.dio.santander.bankline.services;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dio.santander.bankline.dto.NovaMovimentacao;
import com.dio.santander.bankline.model.Correntista;
import com.dio.santander.bankline.model.Movimentacao;
import com.dio.santander.bankline.model.MovimentacaoTipo;
import com.dio.santander.bankline.repository.correntistaRepository;
import com.dio.santander.bankline.repository.movimentacaoRepository;

@Service
public class movimentacaoService {
	@Autowired
	private movimentacaoRepository repository;
	
	@Autowired
	private correntistaRepository CorrentistaRepository;
	public void save(NovaMovimentacao novaMovimentacao) {
		Movimentacao movimentacao = new Movimentacao();
		
		//Double valor = novaMovimentacao.getTipo()==MovimentacaoTipo.Receita ? novaMovimentacao.getValor() : novaMovimentacao.getValor() * -1;
		Double valor = novaMovimentacao.getValor();
		if(novaMovimentacao.getTipo() == MovimentacaoTipo.Despesa)
			valor = valor * -1;
		
		movimentacao.setDataHora(LocalDateTime.now());
		movimentacao.setDescricao(novaMovimentacao.getDescricao());
		movimentacao.setIdConta(novaMovimentacao.getIdConta());
		movimentacao.setTipo(novaMovimentacao.getTipo());
		//movimentacao.setValor(novaMovimentacao.getValor());
		movimentacao.setValor(valor);
		
		Correntista correntista = CorrentistaRepository.findById(novaMovimentacao.getIdConta()).orElse(null);
		if(correntista != null) {
			correntista.getConta().setSaldo(correntista.getConta().getSaldo() + valor);
			CorrentistaRepository.save(correntista);
		};
		repository.save(movimentacao);
	}
}
