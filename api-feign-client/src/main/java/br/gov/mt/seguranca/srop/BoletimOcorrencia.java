package br.gov.mt.seguranca.srop;

import java.util.Date;

//@Value
public interface BoletimOcorrencia {

	Long getId();

	String getNumero();

	Date getDataFato();

	Date getHoraFato();

	String getVitimas();

	String getComunicante();

	String getSuspeitos();

	String getDescNatureza();

}