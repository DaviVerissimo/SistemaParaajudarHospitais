package com.davi.pandemicCombatSystem.domain.model;

public class RecursoMedico implements Recurso{

	@Override
	public String getEspercialidade() {
		
		return EspercialidadeDoRecurso.MEDICO.toString();
	}

	@Override
	public int getPontos() {
		
		return 3;
	}

}
