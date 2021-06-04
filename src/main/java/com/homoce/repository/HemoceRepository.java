package com.homoce.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;

import com.homoce.enums.Sexo;
import com.homoce.enums.TipoSanguineo;
import com.homoce.models.Candidato;
import com.homoce.resources.utils.Utils;

public interface HemoceRepository extends JpaRepository<Candidato, Integer> {
	
	default long quantidadeCandidatoPorEstado(String estado, EntityManager em) {

		Query query = em.createQuery("select count(*) from Candidato c where c.estado=:estado ");
		query.setParameter("estado", estado);

		return (long) query.getSingleResult();
	}

	default Double retornaIMCMedioPorIdade(int idadeInicial, int idadeFim, EntityManager em) {
		List<Candidato> listaDeCandidatos = findAll();

		int idade;
		int quantidade = 0;
		Double soma = 0.0;

		for (Candidato c : listaDeCandidatos) {
			idade = Utils.calculaIdade(c.getData_nasc(), "dd/MM/yyyy");
			if (idade >= idadeInicial && idade <= idadeFim) {
				soma = soma + (c.getPeso() / (c.getAltura() * c.getAltura()));
				quantidade++;
			} else {
				continue;
			}
		}

		return soma / quantidade;
	}

	default Double percentualObesos(Sexo sexo, EntityManager em) {

		List<Candidato> listaDeCandidatos = findAll();
		
		Double quantidadeHomemObeso = 0.0;
		Double quantidadeMulherObeso = 0.0;

		for (Candidato c : listaDeCandidatos) {
			if (Sexo.MASCULINO == c.getSexo()) {
				if((c.getPeso() / (c.getAltura() * c.getAltura())) > 30) {
					quantidadeHomemObeso++;
				} 
			} else {
				if((c.getPeso() / (c.getAltura() * c.getAltura())) > 30) {
					quantidadeMulherObeso++;
				} 
			}
		}

		if(sexo == Sexo.MASCULINO) {
			return (quantidadeHomemObeso * 100) / listaDeCandidatos.size();
		}
		
		return (quantidadeMulherObeso * 100) / listaDeCandidatos.size();
	}
	
	default ResponseEntity<Integer> mediaIdadeTipoSanguineo(TipoSanguineo ts) {
		int quantidadeIdade = 0;
		
		List<Candidato> listaDeCandidatos = findAll();
		
		for(Candidato c : listaDeCandidatos) {
			if(ts == c.getTipo_sanguineo()) {
				quantidadeIdade += Utils.calculaIdade(c.getData_nasc(), "dd/MM/yyyy");
			}
		}
		
		return ResponseEntity.ok().body(quantidadeIdade / listaDeCandidatos.size());
	}
	
	default Integer quantidadePossiveisDoadores(TipoSanguineo ts, EntityManager em) {
		Query query = em.createQuery("from Candidato c where c.peso > 50" );
		List<Candidato> listaDeCandidatos = query.getResultList();
		
		int idade = 0;
		int quantiddadeDoadores = 0;
		
		for(Candidato c : listaDeCandidatos) {
			idade = Utils.calculaIdade(c.getData_nasc(), "dd/MM/yyyy");
			if(idade >= 16 && idade <= 69) {
				switch(String.valueOf(ts.getDescricao())) {
					case "A-" :
						if(c.getTipo_sanguineo().getDescricao().equals("A-") || c.getTipo_sanguineo().equals("O-")) {
							quantiddadeDoadores++;
						}
						break;
					case "A+" :
						if(c.getTipo_sanguineo().getDescricao().equals("A+") || 
						   c.getTipo_sanguineo().getDescricao().equals("A-") ||
						   c.getTipo_sanguineo().getDescricao().equals("O+") ||
						   c.getTipo_sanguineo().getDescricao().equals("O-")) {
							quantiddadeDoadores++;
						}
						break;
					case "B+" :
						if(c.getTipo_sanguineo().getDescricao().equals("B+") ||
						   c.getTipo_sanguineo().getDescricao().equals("B-") ||
						   c.getTipo_sanguineo().getDescricao().equals("O+") ||
						   c.getTipo_sanguineo().getDescricao().equals("O-")) {
							quantiddadeDoadores++;
						}
						break;
					case "B-" :
						if(c.getTipo_sanguineo().getDescricao().equals("B-") || c.getTipo_sanguineo().getDescricao().equals("O-")) {
							quantiddadeDoadores++;
						}
						break;
					case "AB+" :
						if(c.getTipo_sanguineo().getDescricao().equals("A+") || 
						   c.getTipo_sanguineo().getDescricao().equals("B+") ||
						   c.getTipo_sanguineo().getDescricao().equals("O+") ||
						   c.getTipo_sanguineo().getDescricao().equals("AB+") ||
						   c.getTipo_sanguineo().getDescricao().equals("A-") ||
						   c.getTipo_sanguineo().getDescricao().equals("B-") ||
						   c.getTipo_sanguineo().getDescricao().equals("O-") ||
						   c.getTipo_sanguineo().getDescricao().equals("AB-")) {
							quantiddadeDoadores++;
						}
						break;
					case "AB-" :
						if(c.getTipo_sanguineo().getDescricao().equals("A-") ||
						   c.getTipo_sanguineo().getDescricao().equals("B-") ||
						   c.getTipo_sanguineo().getDescricao().equals("O-") ||
						   c.getTipo_sanguineo().getDescricao().equals("AB-")) {
							quantiddadeDoadores++;
						}
						break;
					case "O+" :
						if(c.getTipo_sanguineo().getDescricao().equals("O+") || c.getTipo_sanguineo().getDescricao().equals("O-")) {
							quantiddadeDoadores++;
						}
						break;
					case "O-" :
						if(c.getTipo_sanguineo().getDescricao().equals("O-")) {
							quantiddadeDoadores++;
						}
						break;
					default:
						break;
					
				}
			}
		}
		
		return quantiddadeDoadores;
	}

}
