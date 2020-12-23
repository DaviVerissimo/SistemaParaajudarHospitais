package com.davi.pandemicCombatSystem.domain.model;

public class RecursoTomografo implements Recurso {

	@Override
	public String getEspercialidade() {
		
		return EspercialidadeDoRecurso.TOMOGRAFO.toString();
	}

	@Override
	public int getPontos() {
		
		return 12;
	}

}
