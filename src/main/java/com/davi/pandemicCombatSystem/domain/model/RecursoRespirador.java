package com.davi.pandemicCombatSystem.domain.model;

public class RecursoRespirador implements Recurso {

	@Override
	public String getEspercialidade() {
		
		return EspercialidadeDoRecurso.RESPIRADOR.toString();
	}

	@Override
	public int getPontos() {
		
		return 5;
	}

}
