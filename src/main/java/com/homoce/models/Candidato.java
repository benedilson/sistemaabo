package com.homoce.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;
import com.homoce.enums.Sexo;
import com.homoce.enums.TipoSanguineo;

@Entity
public class Candidato implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;
	
	@NotBlank
	private String nome;
	
	@NotBlank
	
	private String cpf;
	
	@NotBlank
	private String rg;
	
	@NotBlank
	private String data_nasc;
	
	@NotBlank
	private Sexo sexo;
	
	@NotBlank
	private String mae;
	
	@NotBlank
	private String pai;
	
	@NotBlank
	private String email;
	
	@NotBlank
	private String cep;
	
	@NotBlank
	private String endereco;
	
	@NotBlank
	private int numero;
	
	@NotBlank
	private String bairro;
	
	@NotBlank
	private String cidade;
	
	@NotBlank
	private String estado;
	
	@NotBlank
	private String telefone_fixo;
	
	@NotBlank
	private String celular;
	
	@NotBlank
	private Double altura;
	
	@NotBlank
	private Double peso;
	
	@NotBlank
	private TipoSanguineo tipo_sanguineo;
	
	public Candidato() {
		
	}
	
	public Candidato(Integer codigo, @NotBlank String nome, @NotBlank String cpf, @NotBlank String rg,
			@NotBlank String data_nasc, @NotBlank Sexo sexo, @NotBlank String mae, @NotBlank String pai,
			@NotBlank String email, @NotBlank String cep, @NotBlank String endereco, @NotBlank int numero,
			@NotBlank String bairro, @NotBlank String cidade, @NotBlank String estado, @NotBlank String telefone_fixo,
			@NotBlank String celular, @NotBlank Double altura, @NotBlank Double peso,
			@NotBlank TipoSanguineo tipo_sanguineo) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.data_nasc = data_nasc;
		this.sexo = sexo;
		this.mae = mae;
		this.pai = pai;
		this.email = email;
		this.cep = cep;
		this.endereco = endereco;
		this.numero = numero;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.telefone_fixo = telefone_fixo;
		this.celular = celular;
		this.altura = altura;
		this.peso = peso;
		this.tipo_sanguineo = tipo_sanguineo;
	}

	public String getData_nasc() {
		return data_nasc;
	}

	public void setData_nasc(String data_nasc) {
		this.data_nasc = data_nasc;
	}

	public String getTelefone_fixo() {
		return telefone_fixo;
	}

	public void setTelefone_fixo(String telefone_fixo) {
		this.telefone_fixo = telefone_fixo;
	}

	public TipoSanguineo getTipo_sanguineo() {
		return tipo_sanguineo;
	}

	public void setTipo_sanguineo(TipoSanguineo tipo_sanguineo) {
		this.tipo_sanguineo = tipo_sanguineo;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public Double getAltura() {
		return altura;
	}

	public void setAltura(Double altura) {
		this.altura = altura;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public String getMae() {
		return mae;
	}

	public void setMae(String mae) {
		this.mae = mae;
	}

	public String getPai() {
		return pai;
	}

	public void setPai(String pai) {
		this.pai = pai;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}
	
}
