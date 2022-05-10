package com.dio.santander.bankline.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dio.santander.bankline.model.Movimentacao;

public interface movimentacaoRepository extends JpaRepository<Movimentacao, Integer>{

}
