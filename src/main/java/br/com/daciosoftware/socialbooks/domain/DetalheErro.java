package br.com.daciosoftware.socialbooks.domain;

public class DetalheErro {

	private String titulo;

	private Long status;

	private Long timestamp;

	private String mensagemDesenvolvedor;

	public String getTitulo() {
		return titulo;
	}

	public Long getStatus() {
		return status;
	}

	public Long getTimestamp() {
		return timestamp;
	}

	public String getMensagemDesenvolvedor() {
		return mensagemDesenvolvedor;
	}

	public static Builder builder() {
		return new Builder();
	}

	public static class Builder {

		private DetalheErro erro;

		Builder() {
			this.erro = new DetalheErro();
		}

		public Builder addTitulo(String titulo) {
			this.erro.titulo = titulo;
			return this;
		}

		public Builder addStatus(Long status) {
			this.erro.status = status;
			return this;
		}

		public Builder addTimestamp(Long timestamp) {
			this.erro.timestamp = timestamp;
			return this;
		}

		public Builder addMensagemDesenvolvedor(String mensagemDesenvolvedor) {
			this.erro.mensagemDesenvolvedor = mensagemDesenvolvedor;
			return this;
		}

		public DetalheErro build() {
			return this.erro;
		}

	}

}
