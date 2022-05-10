package com.dio.santander.bankline.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dio.santander.bankline.dto.NovoCorrentista;
import com.dio.santander.bankline.model.Conta;
import com.dio.santander.bankline.model.Correntista;
import com.dio.santander.bankline.repository.correntistaRepository;

@Service
public class correntistaService {
	
	@Autowired
	private correntistaRepository repository;

	public void save(NovoCorrentista NovoCorrentista) {
		Correntista correntista = new Correntista();
		correntista.setCpf(NovoCorrentista.getCpf());
		correntista.setNome(NovoCorrentista.getNome());
		
		Conta conta = new Conta();
		conta.setSaldo(0.0);
		conta.setNumero(new Date().getTime());
		correntista.setConta(conta);
		
		repository.save(correntista);
	}
}
