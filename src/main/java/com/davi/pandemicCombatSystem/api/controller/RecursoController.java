package com.davi.pandemicCombatSystem.api.controller;

import java.util.ArrayList;

import com.davi.pandemicCombatSystem.domain.model.EspercialidadeDoRecurso;
import com.davi.pandemicCombatSystem.domain.model.Hospital;
import com.davi.pandemicCombatSystem.domain.model.Recurso;

/**
 * Classe responsavel por controlar a gestão de recursos entre hospitais.
 * @author davi
 *
 */
public class RecursoController {
	
	/**
	 * Realiza o intercabio de recursos entre hospitais.
	 * @param hospitalDoador = Hospital que enviara um recurso.
	 * @param HospitalReceptor = Hospital que receberá o recurso.
	 * @return o recurso enviado.
	 */
	public Recurso IntercambioDeRecurso(Hospital hospitalDoador, Hospital HospitalReceptor, String necessidade) {
		Recurso recurso = null;
		if (this.isPontuacoesIguais(hospitalDoador, HospitalReceptor)) {
			if (!ocupadoEmExcesso(hospitalDoador)) {
				recurso = buscarRecurso(hospitalDoador, necessidade);
				ArrayList<Recurso> recursosDoDoador = hospitalDoador.getRecursos();
				int indice = buscaIndiceDoRecurso(hospitalDoador, recurso);
				recursosDoDoador.remove(indice);
				hospitalDoador.setRecursos(recursosDoDoador);
				ArrayList<Recurso> recursosDoReceptor = HospitalReceptor.getRecursos();
				recursosDoReceptor.add(recurso);
				HospitalReceptor.setRecursos(recursosDoReceptor);
				// adcionar ao historico de negociaçoes
				// salvar no banco de dados
			}
		}
		
		return recurso;
	}
	
	/**
	 * Calcula e retorna a soma das pontuações dos recursos de um hospital.
	 * @param hospital Hospital que é calculado os pontos.
	 * @return numero de pontos
	 */
	public int calcularPontuacao(Hospital hospital) {
		int pontuacao = 0;
		for (int i = 0; i < hospital.getRecursos().size(); i++) {
			pontuacao += hospital.getRecursos().get(i).getPontos();
		}
		return pontuacao;
	}
	
	/**
	 * Retorna true caso dois hospitais tenham a mesma quantidade de pontos.
	 * @param hospitalDoador 
	 * @param HospitalReceptor
	 * @return resultado
	 */
	public boolean isPontuacoesIguais(Hospital hospitalDoador, Hospital HospitalReceptor) {
		boolean resultado = false;
		if (this.calcularPontuacao(hospitalDoador) == this.calcularPontuacao(HospitalReceptor)) {
			resultado = true;
		}
		return resultado;
	}
	
	/**
	 * Retorna true caso um hospital esterja com ocupado em excesso.
	 * @param hospitalDoador Hospital verificado.
	 * @return
	 */
	private boolean ocupadoEmExcesso(Hospital hospitalDoador) {
		if (hospitalDoador.getPercentualDeOcupacao() >= Hospital.OCUPACAO_EXCESSIVA) {
			return true;
		}
		return false;
	}
	
	/**
	 * Busca e retorna o recurso encontrado.
	 * @param hospital Hospital em que será buscado o recurso.
	 * @param recursoProcurado Espercialidade que o recurso procurado contem.
	 * @return recurso encontrado.
	 */
	public Recurso buscarRecurso(Hospital hospital, String recursoProcurado) {
		Recurso recurso = null;
		for (int i = 0; i < hospital.getRecursos().size(); i++ ) {
			if (hospital.getRecursos().get(i).getEspercialidade().equals(recursoProcurado)) {
				recurso = hospital.getRecursos().get(i);
				break;
			}
		}
		return recurso;
	}
	
	/**
	 * Busca e retorna o indice de um recurso.
	 * @param hospital Hospital onde será feita a busca do recurso.
	 * @param recurso Recurso que será buscado.
	 * @return indice do recurso
	 */
	public int buscaIndiceDoRecurso(Hospital hospital,Recurso recurso) {
		int indice = 0;
		for (int i = 0; i <= hospital.getRecursos().size(); i++) {
			if (hospital.getRecursos().get(i).equals(recurso)) {
				indice = i;
				break;
			}
		}
		return indice;
	}

}
