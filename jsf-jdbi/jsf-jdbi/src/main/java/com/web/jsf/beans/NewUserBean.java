package com.web.jsf.beans;

import com.web.jdbi.dto.ContactDTO;
import com.web.jdbi.init.DatabaseBean;
import java.io.Serializable;
import java.util.PropertyResourceBundle;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Home
 */
@ManagedBean(name = "newUserBean")
@ViewScoped
public class NewUserBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @ManagedProperty(value = "#{databaseBean}")
    private DatabaseBean databaseBean;

    private ContactDTO contact = new ContactDTO();

    public NewUserBean() {

    }

    @PostConstruct
    public void init() {

    }

    public String addNewContact() {
        databaseBean.createContact(contact);
        return "index";

    }

    public ContactDTO getContact() {
        return contact;
    }

    public void setContact(ContactDTO contact) {
        this.contact = contact;
    }

    public void setDatabaseBean(DatabaseBean databaseBean) {
        this.databaseBean = databaseBean;
    }

  
    public PropertyResourceBundle getBundle() {
        FacesContext context = FacesContext.getCurrentInstance();
        return context.getApplication().evaluateExpressionGet(context, "#{i18n}", PropertyResourceBundle.class);
    }

}
