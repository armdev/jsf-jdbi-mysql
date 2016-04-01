package com.web.jdbi.init;

import com.web.jdbi.dao.ContactDAO;
import com.web.jdbi.dto.ContactDTO;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import org.skife.jdbi.v2.DBI;
import org.skife.jdbi.v2.Handle;

@ManagedBean(eager = true, name = "databaseBean")
@ApplicationScoped
public class DatabaseBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private final DBI dbi = new DBI(DatabaseBean.getDataSource());

    private ContactDAO contactDao = null;
    private Handle handle;
//http://jdbi.org/fluent_queries/
    //http://jdbi.org/

    public DatabaseBean() {

    }

    @PostConstruct
    public void init() {
        contactDao = dbi.open(ContactDAO.class);
    }

    public ContactDTO getContact(Integer id) {
        ContactDTO contact = contactDao.getContactById(id);
        return contact;
    }

    public List<ContactDTO> getAllContacts() {

        List<ContactDTO> list = contactDao.findAll();
        return list;
    }

    public Integer createContact(ContactDTO contact) {
        int newContactId = contactDao.createContact(contact.getFirstName(), contact.getLastName(), contact.getPhone());
        return newContactId;
    }

    public void deleteContact(Integer id) {
        contactDao.deleteContact(id);

    }

    public void updateContact(ContactDTO contact) {
        contactDao.updateContact(contact.getId(), contact.getFirstName(),
                contact.getLastName(), contact.getPhone());

    }

    private static DataSource getDataSource() {
        DataSource ds = null;
        InitialContext contex;
        try {
            contex = new InitialContext();

            ds = (DataSource) contex.lookup("java:comp/env/jdbc/mysql");

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return ds;
    }
}
