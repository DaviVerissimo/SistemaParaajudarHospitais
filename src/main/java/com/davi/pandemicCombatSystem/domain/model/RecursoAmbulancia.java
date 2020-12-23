package com.davi.pandemicCombatSystem.domain.model;

public class RecursoAmbulancia implements Recurso {

	@Override
	public String getEspercialidade() {
		
		return EspercialidadeDoRecurso.AMBULANCIA.toString();
	}

	@Override
	public int getPontos() {
		
		return 10;
	}

}
