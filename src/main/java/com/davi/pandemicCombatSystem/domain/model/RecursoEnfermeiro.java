package com.davi.pandemicCombatSystem.domain.model;

public class RecursoEnfermeiro implements Recurso{

	@Override
	public String getEspercialidade() {
		
		return EspercialidadeDoRecurso.ENFERMEIRO.toString();
	}

	@Override
	public int getPontos() {
		
		return 3;
	}

}
