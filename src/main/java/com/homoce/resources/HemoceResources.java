package com.homoce.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.homoce.enums.Sexo;
import com.homoce.enums.TipoSanguineo;
import com.homoce.models.Candidato;
import com.homoce.service.HemoceService;

@CrossOrigin
@RestController
@RequestMapping(value = "/candidatos")
public class HemoceResources {

	@Autowired
	private HemoceService hs;
	
	@GetMapping(produces = "application/json")
	public @ResponseBody ResponseEntity<Iterable<Candidato>> listaHemoce() {
		return ResponseEntity.ok().body(hs.findAll());
	}
	
	@PostMapping(value = "/one", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Candidato> cadastraCandidato(@RequestBody @Valid Candidato candidato) {
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
		.path("/{id}").buildAndExpand(candidato.getCodigo()).toUri();
		return ResponseEntity.created(uri).body(hs.save(candidato));
	}
	
	@PostMapping(value = "/all", consumes = "application/json", produces = "application/json")
	public ResponseEntity<List<Candidato>> cadastraCandidatos(@RequestBody @Valid List<Candidato> candidatoLista) {
		return ResponseEntity.ok().body(hs.saveAll(candidatoLista));
	}
	
	@DeleteMapping()
	public ResponseEntity<Candidato> deletaCandidato(@RequestBody Candidato candidato) {
		hs.delete(candidato);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/filterquantidadeporestado")
	public long findCandidatoPorEstado(@RequestParam("estado") String estado) {
		return hs.retornaQauntidadeCandidadoPorEstado(estado);
	}
	
	@GetMapping("/filteridade")
	public Double retornaIMCMedioPorIdade(@RequestParam("idadeinicial") int idadeInicial, @RequestParam("idadefinal") int idadeFinal) {
		return hs.retornaIMCMedioPorIdade(idadeInicial, idadeFinal);
	}
	
	@GetMapping("/filterpercentualobesos")
	public Double percentualObesos(@RequestParam("sexo") Sexo sexo) {
		return hs.percentualObesos(sexo);
	}
	
	@GetMapping("/filtermediaidadetiposanguineo")
	public ResponseEntity<Integer> mediaIdadeTipoSanguineo(@RequestParam("tiposanguineo") TipoSanguineo ts) {
		return hs.mediaIdadeTipoSanguineo(ts);
	}
	
	@GetMapping("/filterquantidadepossiveisdoadores")
	public Integer quantidadePossiveisDoadores(@RequestParam("tiposanguineo") TipoSanguineo ts) {
		return hs.quantidadePossiveisDoadores(ts);
	}
}
