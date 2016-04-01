
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.jdbi.dao;

import com.web.jdbi.dto.ContactDTO;
import java.util.List;
import org.skife.jdbi.v2.*;
import org.skife.jdbi.v2.util.StringMapper;

/**
 *
 * @author armen arzumanyan
 */
public class JDBIUtil {
//https://gist.github.com/davepkennedy/724345eed1d4e550bc9b
    //http://jdbi.org/sql_object_api_batching/
    //http://jdbi.org/fluent_queries/
    //just for test
    public static void main(String args[]) {
        DBI dbi = new DBI("jdbc:mysql://localhost:3306/mydb",
                "root",
                "root");
        Handle h = dbi.open();
        if (!dbi.open().isInTransaction()) {
            System.out.println("Not Hello World!");
        }
        h.begin();
        // h.execute("create table usver (id integer primary key, name text)");
        // h.execute("select *  from contact");
        //h.execute("create table something (id integer primary key, name text)");
        String name = h.createQuery("select firstname from contact where id = :id")
                .bind("id", 3)
                .map(StringMapper.FIRST)
                .first();

        List<ContactDTO> list = h.createQuery("select * from contact").map(ContactDTO.class)
                .list(List.class);

        System.out.println("list size " + list.size());

        for (ContactDTO dto : list) {
            System.out.println("Firstname " + dto.getFirstName());
        }

        System.out.println("Name is " + name);
        h.commit();
        h.close();
    }
}
