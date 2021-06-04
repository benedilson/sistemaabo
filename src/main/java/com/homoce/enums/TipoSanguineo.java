package com.homoce.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum TipoSanguineo {
	APOTIVO("A+"),
	ANEGATIVO("A-"),
	BPOSITIVO("B+"),
	BNEGATIVO("B-"),
	ABPOSITIVO("AB+"),
	ABNEGATIVO("AB-"),
	OPOSITIVO("O+"),
	ONEGATIVO("O-");

	private String descricao;
	
	TipoSanguineo(String descricao) {
		this.descricao = descricao;
	}

	@JsonValue
	public String getDescricao() {
		return descricao;
	}
	
}
