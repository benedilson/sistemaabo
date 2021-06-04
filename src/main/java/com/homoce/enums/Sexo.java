package com.homoce.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Sexo {

	MASCULINO(1, "Masculino"), FEMININO(2, "Feminino");

	private int codigo;
	private String descricao;

	Sexo(int codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public int getCodigo() {
		return codigo;
	}

	@JsonValue
	public String getDescricao() {
		return descricao;
	}

	public static Sexo toEnum(Integer cod) {

		if (cod == null) {
			return null;
		}

		for (Sexo x : Sexo.values()) {
			if (cod.equals(x.getCodigo())) {
				return x;
			}
		}

		throw new IllegalArgumentException("Id de enum inválido: " + cod);
	}
}
