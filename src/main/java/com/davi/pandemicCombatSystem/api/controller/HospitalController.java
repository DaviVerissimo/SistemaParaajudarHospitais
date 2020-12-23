package com.davi.pandemicCombatSystem.api.controller;

import java.util.ArrayList;

import com.davi.pandemicCombatSystem.domain.model.Hospital;
import com.davi.pandemicCombatSystem.domain.model.Recurso;

public class HospitalController {
	
	public Hospital addHospital(String nome, String cnpj, float latitude, float longitude,
			String cidade, String rua, int numero, ArrayList<Recurso> recursos, float percentualDeOcupacao) {
		Hospital hospital = new Hospital(nome, cnpj, latitude, longitude, cidade, rua, numero, recursos, percentualDeOcupacao);
		// implementar persistencia para adcionar hospital ao banco
		return hospital;
	}

}
