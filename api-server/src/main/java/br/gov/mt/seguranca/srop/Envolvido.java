package br.gov.mt.seguranca.srop;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author denyshetzel
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Envolvido {

	public enum TipoEnvolvido {
		COMUNICANTE, SUSPEITO, VITIMA, TESTEMUNHA, TODOS
	}

	private String nome;

	private @Default TipoEnvolvido tipoEnvolvido = TipoEnvolvido.TODOS;

	private Telefone telefone;

	public boolean tipoEnvolvidoDiferenteTodos() {
		return !TipoEnvolvido.TODOS.equals(tipoEnvolvido);
	}

}
