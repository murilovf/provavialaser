package repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import entity.PessoaFisica;
import entity.PessoaJuridica;
import entity.PessoaJuridicaTelefone;
import utils.FiltroDTO;
import utils.JPAUtil;

public class PessoaRepository {
	
	private EntityManager entityManager;

	public void salvarPessoaFisica(PessoaFisica pessoaFisica) {
		entityManager = new JPAUtil().getEntityManager();
		entityManager.getTransaction().begin();
		entityManager.merge(pessoaFisica);
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	public void salvarPessoaJuridica(PessoaJuridica pessoaJuridica) {
		entityManager = new JPAUtil().getEntityManager();
		entityManager.getTransaction().begin();
		entityManager.merge(pessoaJuridica);
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	public List<PessoaFisica> getListaPessoaFisica(FiltroDTO filtroDTO) {
		entityManager = new JPAUtil().getEntityManager();
		String sql = getSqlListaPessoaFisica(filtroDTO);
		Query query = entityManager.createQuery(sql);
		
		if (filtroDTO.getNome() != null) {
			query.setParameter("nome", filtroDTO.getNome());
		}
		
		if (filtroDTO.getCpf() != null) {
			query.setParameter("cpf", filtroDTO.getCpf());
		}
		
		List<PessoaFisica> listaPessoaFisica = query.getResultList();

		entityManager.close();
		return listaPessoaFisica;
	}

	private String getSqlListaPessoaFisica(FiltroDTO filtroDTO) {
		String sql = "SELECT p FROM PessoaFisica p WHERE 1=1 ";
		if (filtroDTO.getNome() != null) {
			sql += " AND lower(p.nome) LIKE ('%'||:nome||'%') ";
		}
		
		if (filtroDTO.getCpf() != null) {
			sql += " AND lower(p.cpf) LIKE ('%'||:cpf||'%') ";
		}
		return sql;
	}

	public List<PessoaJuridica> getListaPessoaJuridica(FiltroDTO filtroDTO) {
		entityManager = new JPAUtil().getEntityManager();
		String sql = getSqlListaPessoaJuridica(filtroDTO);
		
		Query query = entityManager.createQuery(sql);
		
		if (filtroDTO.getRazaoSocial() != null) {
			query.setParameter("razaoSocial", filtroDTO.getRazaoSocial());
		}
		
		if (filtroDTO.getNomeFantasia() != null) {
			query.setParameter("nomeFantasia", filtroDTO.getNomeFantasia());
		}
		
		if (filtroDTO.getCnpj() != null) {
			query.setParameter("cnpj", filtroDTO.getCnpj());
		}
		
		List<PessoaJuridica> listaPessoaJuridica = query.getResultList();

		entityManager.close();
		return listaPessoaJuridica;
	}
	
	private String getSqlListaPessoaJuridica(FiltroDTO filtroDTO) {
		String sql = "SELECT p FROM PessoaJuridica p WHERE 1=1 ";
		if (filtroDTO.getRazaoSocial() != null) {
			sql += " AND lower(p.razaoSocial) LIKE ('%'||:razaoSocial||'%') ";
		}
		
		if (filtroDTO.getNomeFantasia() != null) {
			sql += " AND lower(p.nomeFantasia) LIKE ('%'||:nomeFantasia||'%') ";
		}
		
		if (filtroDTO.getCnpj() != null) {
			sql += " AND lower(p.cnpj) LIKE ('%'||:cnpj||'%') ";
		}
		return sql;
	}

	public void removerPessoaFisica(PessoaFisica pessoaFisica) {
		entityManager = new JPAUtil().getEntityManager();
		entityManager.getTransaction().begin();
		entityManager.remove(entityManager.find(PessoaFisica.class, pessoaFisica.getIdPessoa()));
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	public void removerPessoaJuridica(PessoaJuridica pessoaJuridica) {
		entityManager = new JPAUtil().getEntityManager();
		entityManager.getTransaction().begin();
		entityManager.remove(entityManager.find(PessoaJuridica.class, pessoaJuridica.getIdPessoa()));
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	public PessoaJuridica getPessoaJuridica(Integer idPessoa) {
		entityManager = new JPAUtil().getEntityManager();
		entityManager.getTransaction().begin();
		PessoaJuridica pessoaJuridica = entityManager.find(PessoaJuridica.class, idPessoa);
		entityManager.close();
		return pessoaJuridica;
	}
	
	public PessoaFisica getPessoaFisica(Integer idPessoa) {
		entityManager = new JPAUtil().getEntityManager();
		entityManager.getTransaction().begin();
		PessoaFisica pessoaFisica = entityManager.find(PessoaFisica.class, idPessoa);
		entityManager.close();
		return pessoaFisica;
	}

	public void salvarPessoaJuridicaTelefone(PessoaJuridicaTelefone pessoaJuridicaTelefone) {
		entityManager = new JPAUtil().getEntityManager();
		entityManager.getTransaction().begin();
		entityManager.merge(pessoaJuridicaTelefone);
		entityManager.getTransaction().commit();
		entityManager.close();
	}

}
