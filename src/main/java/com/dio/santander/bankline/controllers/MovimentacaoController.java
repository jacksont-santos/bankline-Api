package com.dio.santander.bankline.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dio.santander.bankline.dto.NovaMovimentacao;
import com.dio.santander.bankline.dto.NovoCorrentista;
import com.dio.santander.bankline.model.Correntista;
import com.dio.santander.bankline.model.Movimentacao;
import com.dio.santander.bankline.repository.correntistaRepository;
import com.dio.santander.bankline.repository.movimentacaoRepository;
import com.dio.santander.bankline.services.correntistaService;
import com.dio.santander.bankline.services.movimentacaoService;

@RestController
@RequestMapping("/movitacoes")
public class MovimentacaoController {
	
	@Autowired
	private movimentacaoRepository repository;
	
	@Autowired
	private movimentacaoService service;
	
	@GetMapping
	public List<Movimentacao> findAll(){
		return repository.findAll();
	}
	
	@PostMapping
	public void save(@RequestBody NovaMovimentacao movimentacao) {
		service.save(movimentacao);
	}
}
