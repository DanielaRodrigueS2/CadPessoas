
package com.cp.data.crud;

import com.cp.data.crud.interfaces.EMNames;
import com.cp.data.crud.interfaces.AbstractCrud;
import com.cp.data.model.Cidade;
import com.cp.util.AppLog;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

/**
 *
 * @author utfpr
 */
@Stateless
public class BeanCrudCidade extends AbstractCrud<Cidade> {

    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        if (em == null) {
            em = Persistence.createEntityManagerFactory(EMNames.EMN1, EMNames.getEMN1Props()).createEntityManager();
            AppLog.getInstance().info("Entity manager gerado com êxito");
        }
        return em;
    }

    @Override
    protected void close() {
            if(em!=null){
                getEntityManager().close();
            }
    }


    public BeanCrudCidade() {
        super(Cidade.class);
    }

}
