package com.web.jdbi.mapper;

import com.web.jdbi.dto.ContactDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

public class ContactMapper implements ResultSetMapper<ContactDTO> {

    @Override
    public ContactDTO map(int index, ResultSet r, StatementContext ctx)
            throws SQLException {
        return new ContactDTO(
                r.getInt("id"), r.getString("firstName"),
                r.getString("lastName"), r.getString("phone"));
    }
}
