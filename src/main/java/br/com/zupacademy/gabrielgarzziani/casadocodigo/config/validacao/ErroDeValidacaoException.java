package br.com.zupacademy.gabrielgarzziani.casadocodigo.config.validacao;

public class ErroDeValidacaoException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private String campo;
	private String erro;
	
	public ErroDeValidacaoException(String campo, String erro) {
		this.campo = campo;
		this.erro = erro;
	}

	public String getCampo() {
		return campo;
	}

	public String getErro() {
		return erro;
	}
}
