package bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import business.PessoaBusiness;
import entity.PessoaFisica;
import entity.PessoaJuridica;
import utils.FiltroDTO;
import utils.TipoPessoaEnum;

@ViewScoped
@ManagedBean
public class PessoaBean {
	
	private String tipoPessoa;
	
	private List<PessoaFisica> listaPessoaFisica;
	private List<PessoaJuridica> listaPessoaJuridica;
	
	private FiltroDTO filtroDTO = new FiltroDTO();
	
	private PessoaBusiness pessoaBusiness = new PessoaBusiness();
	
	@PostConstruct
	public void inicializar() {
		tipoPessoa = getPessoaFisica();
		consultarPessoasFisicas();
		consultarPessoasJuridicas();
	}
	
	public String cadastrarNovaPessoa() {
		if (tipoPessoa.equals(TipoPessoaEnum.FISICA.getDescricao())) {
			return "pessoa-fisica.xhtml?faces-redirect=true";
		}
		
		return "pessoa-juridica.xhtml?faces-redirect=true";
	}
	
	public void removerPessoaFisica(PessoaFisica pessoaFisica) {
		pessoaBusiness.removerPessoaFisica(pessoaFisica);
		consultarPessoasFisicas();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Pessoa Física foi removida"));
	}
	
	public void removerPessoaJuridica(PessoaJuridica pessoaJuridica) {
		pessoaBusiness.removerPessoaJuridica(pessoaJuridica);
		consultarPessoasJuridicas();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Pessoa Jurídica foi removida"));
	}
	
	public String editarPessoaJuridica(PessoaJuridica pessoaJuridica) {
		return "pessoa-juridica?faces-redirect=true&idPessoa=" + pessoaJuridica.getIdPessoa();
	}
	
	public String editarPessoaFisica(PessoaFisica pessoaFisica) {
		return "pessoa-fisica?faces-redirect=true&idPessoa=" + pessoaFisica.getIdPessoa();
	}
	
	public void consultarPessoasFisicas() {
		listaPessoaFisica = pessoaBusiness.getListaPessoaFisica(filtroDTO);
	}
	
	public void consultarPessoasJuridicas() {
		listaPessoaJuridica = pessoaBusiness.getListaPessoaJuridica(filtroDTO);
	}
	
	public String getTipoPessoa() {
		return tipoPessoa;
	}
	
	public void setTipoPessoa(String tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}
	
	public String getPessoaFisica() {
		return TipoPessoaEnum.FISICA.getDescricao();
	}
	
	public String getPessoaJuridica() {
		return TipoPessoaEnum.JURIDICA.getDescricao();
	}
	
	public List<PessoaFisica> getListaPessoaFisica() {
		return listaPessoaFisica;
	}
	
	public void setListaPessoaFisica(List<PessoaFisica> listaPessoaFisica) {
		this.listaPessoaFisica = listaPessoaFisica;
	}
	
	public List<PessoaJuridica> getListaPessoaJuridica() {
		return listaPessoaJuridica;
	}
	
	public void setListaPessoaJuridica(List<PessoaJuridica> listaPessoaJuridica) {
		this.listaPessoaJuridica = listaPessoaJuridica;
	}
	
	public FiltroDTO getFiltroDTO() {
		return filtroDTO;
	}
	
	public void setFiltroDTO(FiltroDTO filtroDTO) {
		this.filtroDTO = filtroDTO;
	}

}
