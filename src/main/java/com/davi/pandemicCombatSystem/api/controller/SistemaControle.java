package com.davi.pandemicCombatSystem.api.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.davi.pandemicCombatSystem.domain.model.EspercialidadeDoRecurso;
import com.davi.pandemicCombatSystem.domain.model.Hospital;
import com.davi.pandemicCombatSystem.domain.model.Recurso;

/**
 * Esta classe (TEMPORARIA) foi criada para o cliente comunica-se com a API.
 * Funciona como uma fachada. 
 * Ela foi implementada desta forma em virtude da ausencia de um banco de dados.
 * Por isso nao sgue as boas praticas utilizadas no resto doprojeto.
 * @author davi
 *
 */
@RestController
public class SistemaControle {
	//O arnazenamento temporario esta sendo feito nesta variavel.
	private ArrayList<Hospital> listaDeHospitais;
	
	public SistemaControle() {
		listaDeHospitais = new ArrayList<Hospital>();
	}
	
	/**
	 * para add um hospital utilize o seguinte verbo HTTP GET localhost:8080/adcionarospital
	 * @param nome Nome do Hospital.
	 * @param cnpj CNPJ do hospital
	 * @param latitude Latitude do hospital para formar a localização.
	 * @param longitude Longitude do hospital para formar a localização.
	 * @param cidade Cidade que o hospital esta localizado.
	 * @param rua Rua do hospital utilizada para compor endereço.
	 * @param numero Numero do predio do Hospital.
	 * @param recursos Recursos que o hospital possui.
	 * @param percentualDeOcupacao Percentual de ocupação que o hospital encontra-se.
	 * @return Hospital adcionado.
	 */
	@GetMapping("/adcionarospital")
	public Hospital addcionarHospital(String nome, String cnpj, float latitude, float longitude,
			String cidade, String rua, int numero, ArrayList<Recurso> recursos,float percentualDeOcupacao) {
		HospitalController hospitalcontroler = new HospitalController();
		Hospital hospital = hospitalcontroler.addHospital(nome, cnpj, 
				latitude, longitude, cidade, rua, numero, recursos, percentualDeOcupacao);
		listaDeHospitais.add(hospital);
			return hospital;	
	}
	
	/**
	 * Busca um hospital. para buscar utilize o seguinte verbo HTTP GET localhost:8080/buscahospital
	 * (Este metodo deveria esta em na classe HospitalController.)
	 * @param cnpj
	 * @return Hospital encontrado.
	 */
	@GetMapping("/buscahospital")
	public Hospital buscarHospital(String cnpj) {
		Hospital hospital = null;
		for (int i = 0; i <= listaDeHospitais.size(); i++) {
			if (listaDeHospitais.get(i).getCnpj().equals(cnpj)) {
				hospital = listaDeHospitais.get(i);
			}
		}
		return hospital;
	}
	
	/**utilize o seguinte verbo HTTP GET localhost:8080/realizarinrercambioderecursos
	 * Realizar o intercambio de recursos
	 * @param cnpjHospitalDoador
	 * @param cnpjHospitalReceptor
	 * @param necessidade
	 * @return
	 */
	@GetMapping("/realizarinrercambioderecursos")
	public Recurso RealizarIntercâmbioDeRecurso(String cnpjHospitalDoador,String cnpjHospitalReceptor, String necessidade) {
		Hospital hospitalDoador = this.buscarHospital(cnpjHospitalDoador);
		Hospital hospitalreceptor = this.buscarHospital(cnpjHospitalDoador);
		RecursoController recursoController = new RecursoController();
		Recurso recurso = null;
		recurso = recursoController.IntercambioDeRecurso(hospitalDoador, hospitalreceptor, necessidade);
		return recurso;
		}
	/**
	 * Retorna todos os tipos de recurso que poderão serem cadrastados
	 * @return
	 */
	@GetMapping("/recursos")
	public ArrayList<String> listarTiposDeRecurso(){
		List<EspercialidadeDoRecurso> list = Arrays.asList(EspercialidadeDoRecurso.values());
		ArrayList<String> recursos = new ArrayList<String>();
		for (int i = 0; i<list.size();i++) {
			recursos.add(list.get(i).toString());
		}
		return recursos;
	}
	

}
