package com.homoce.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.homoce.enums.Sexo;
import com.homoce.enums.TipoSanguineo;
import com.homoce.models.Candidato;
import com.homoce.repository.HemoceRepository;

@Service
public class HemoceService {

	@Autowired 
	private HemoceRepository hr;
	
	@Autowired 
	private EntityManager em;
	
	@Transactional
	public List<Candidato> saveAll(List<Candidato> listaCandidato) {
		return hr.saveAll(listaCandidato);
	}

	public List<Candidato> findAll() {
		return hr.findAll();
	}

	public Candidato save(@Valid Candidato candidato) {
		return hr.save(candidato);
	}

	public void delete(Candidato candidato) {
		hr.delete(candidato);
	}
	
	public long retornaQauntidadeCandidadoPorEstado(String estado) {
		return hr.quantidadeCandidatoPorEstado(estado, em);
	}
	
	public Double retornaIMCMedioPorIdade(int idadeInicial, int idadeFinal) {
		return hr.retornaIMCMedioPorIdade(idadeInicial, idadeFinal, em);
	}
	
	public Double percentualObesos(Sexo sexo) {
		return hr.percentualObesos(sexo, em);
	}
	
	public ResponseEntity<Integer> mediaIdadeTipoSanguineo(TipoSanguineo ts) {
		return hr.mediaIdadeTipoSanguineo(ts);
	}
	
	public Integer quantidadePossiveisDoadores(TipoSanguineo ts) {
		return hr.quantidadePossiveisDoadores(ts, em);
	}
}
