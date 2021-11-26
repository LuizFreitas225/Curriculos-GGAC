package br.unitins.curriculoggac.controller;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.Random;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.curriculoggac.Repository.RecuperarSenhaRepository;
import br.unitins.curriculoggac.Repository.UsuarioRepository;
import br.unitins.curriculoggac.application.Email;
import br.unitins.curriculoggac.application.RepositoryException;
import br.unitins.curriculoggac.application.Util;
import br.unitins.curriculoggac.model.Curriculo;
import br.unitins.curriculoggac.model.RecuperarSenha;
import br.unitins.curriculoggac.model.Usuario;

@Named
@ViewScoped
public class EsqueceuSenhaController extends Controller<RecuperarSenha> implements Serializable {

	private static final long serialVersionUID = 1397581706694686021L;

	private String email;
	private String codigo;
	private String senha;
	private String confirmarSenha;

	public void enviarEmail() {

		UsuarioRepository repo = new UsuarioRepository();
		Usuario usuario = null;
		try {
			usuario = (Usuario) repo.findById(email);
		} catch (RepositoryException e) {
			Util.addErrorMessage("Email não encontrado.");
			e.printStackTrace();
			return;
		}
		// gerando codigo aleatorio
		Random r = new Random();
		DecimalFormat format = new DecimalFormat("T-000000");
		String codigo = format.format(r.nextInt(1000000));

		getEntity().setCodigo(codigo);
		getEntity().setUsuario(usuario);
		getEntity().setUtilizado(false);
		// definindo 24 horas de tempo limite
		getEntity().setDataLimite(LocalDateTime.now().plusDays(1));

		RecuperarSenhaRepository repoRecuperar = new RecuperarSenhaRepository();
		try {
			setEntity(repoRecuperar.save(getEntity()));
			Email email = new Email(usuario.getEmail(), "Esqueceu a Senha",
					codigo + " é seu código de recuperação de senha.");
			email.enviar();
			Util.addInfoMessage("O código foi enviado para o seu email.");
		} catch (RepositoryException e) {
			e.printStackTrace();
			Util.addErrorMessage("Falha ao enviar o código.");
		}

	}

	public void alterarSenha() throws RepositoryException {
		if (getSenha().equals(getConfirmarSenha())) {
			if (validarCodigo()) {
				if (getEntity().getUsuario() != null) {
					getEntity().getUsuario().setSenha(senha);
					UsuarioRepository repo = new UsuarioRepository();
					try {
						repo.save(getEntity().getUsuario());
						Util.addInfoMessage("Senha alterada com sucesso.");
						getEntity().setUtilizado(true);
					} catch (RepositoryException e) {
						e.printStackTrace();
						Util.addErrorMessage("Erro ao alterar o senha.");
					}

				} else {
					Util.addErrorMessage("Erro ao encontrar o usuário.");
				}
			} else {
				Util.addErrorMessage("A revalidação recusou o código.");
			}
		} else {
			Util.addErrorMessage("As senhas devem ser iguais.");
		}
	}

	public Boolean validarCodigo() {
		if (getEntity().getId() != null) {
			if (getEntity().getDataLimite().isAfter(LocalDateTime.now()) && getEntity().getUtilizado() == false) {
				if (getEntity().getCodigo().equals(codigo)) {
					Util.addInfoMessage("Código validado com sucesso.");
					return true;
				} else {
					Util.addErrorMessage("Verifique se o código usado na verifição é válido e tente novamente.");
				}
			} else {
				Util.addErrorMessage("Esse código não é válido.");
			}
		} else {
			Util.addErrorMessage("Gere um código na sessão anterior.");
		}
		return false;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getConfirmarSenha() {
		return confirmarSenha;
	}

	public void setConfirmarSenha(String confirmarSenha) {
		this.confirmarSenha = confirmarSenha;
	}

	@Override
	public RecuperarSenha getEntity() {
		if (entity == null)
			entity = new RecuperarSenha();
		return entity;
	}

}
