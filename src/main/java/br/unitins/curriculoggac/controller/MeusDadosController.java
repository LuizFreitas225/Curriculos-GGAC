package br.unitins.curriculoggac.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.file.UploadedFile;

import br.unitins.curriculoggac.Repository.UsuarioRepository;
import br.unitins.curriculoggac.application.RepositoryException;
import br.unitins.curriculoggac.application.Session;
import br.unitins.curriculoggac.application.Util;

import br.unitins.curriculoggac.controller.listing.UsuarioListing;
import br.unitins.curriculoggac.model.Perfil;
import br.unitins.curriculoggac.model.Usuario;

@Named
@ViewScoped
public class MeusDadosController extends Controller<Usuario> implements Serializable {

	private static final long serialVersionUID = -5242237200720059655L;
	String confirmarSenha = "";
	String senha = "";
	UsuarioRepository usuarioRepository;
	private InputStream fotoInputStream = null;

	public MeusDadosController() {
		super();
		getEntity();
	}

	public String alterarUsuario() {

		if (getConfirmarSenha().equals(getSenha())) {
			try {

				if (!getSenha().isEmpty()) {
					String hash = Util.hash(entity.getEmail() + entity.getSenha());
					entity.setSenha(hash);
					entity.setSenha(getSenha());

				}

				getUsuarioRepository().save(entity);

				if (getFotoInputStream() != null) {
					// salvando a imagem
					if (!Util.saveImageUsuario(fotoInputStream, "png", getEntity().getEmail())) {
						Util.addErrorMessage("Erro ao salvar. Não foi possivel salvar a imagem do usuario.");
						return null;
					}
				}

				Util.addInfoMessage("Alteração realizada com sucesso.");
			} catch (RepositoryException e) {
				Util.addErrorMessage("Problema ao salvar, tente novamente ou entre em contato com a TI.");
				return null;
			}
		} else {

			Util.addErrorMessage("Verifique a confirmação de senha e tente novamente.");
			return null;
		}

		limpar();
		setSenha("");
		setConfirmarSenha("");
		return "login.xhtml?faces-redirect=true";
	}

	@Override
	public Usuario getEntity() {
		// obtendo o usuario da sessao
		if (entity == null) {
			entity = (Usuario) Session.getInstance().get("usuarioLogado");
		}
		return entity;

	}

	public void excluirEncerrarSessao() {
		excluir();
		encerrarSessao();

	}

	public String encerrarSessao() {
		Session.getInstance().invalidateSession();
		return "/faces/login.xhtml?faces-redirect=true";
	}

	public void abrirUsuarioListing() {
		UsuarioListing listing = new UsuarioListing();
		listing.open();

		System.out.println("Abrir Usuario List");
	}

	public void obterUsuarioListing(SelectEvent<Usuario> event) {
		setEntity(event.getObject());
	}

	public UsuarioRepository getUsuarioRepository() {
		if (usuarioRepository == null) {
			usuarioRepository = new UsuarioRepository();
		}
		return usuarioRepository;
	}

	public void setUsuarioRepository(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
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

	public Perfil[] getListPerfil() {
		return Perfil.values();
	}

	// ------------------Imagens Perfil -------------

	public InputStream getFotoInputStream() {
		return fotoInputStream;
	}

	public void setFotoInputStream(InputStream fotoInputStream) {
		this.fotoInputStream = fotoInputStream;
	}

	public void upload(FileUploadEvent event) {
		UploadedFile uploadFile = event.getFile();
		System.out.println("nome arquivo: " + uploadFile.getFileName());
		System.out.println("tipo: " + uploadFile.getContentType());
		System.out.println("tamanho: " + uploadFile.getSize());

		if (uploadFile.getContentType().equals("image/png")) {
			try {
				fotoInputStream = uploadFile.getInputStream();
				System.out.println("inputStream: " + uploadFile.getInputStream().toString());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Util.addInfoMessage("Upload realizado com sucesso.");
		} else {
			Util.addErrorMessage("O tipo da image deve ser png.");
		}

	}

}
