package com.hijinks.comms.dao;

import javax.sql.DataSource;
import com.hijinks.comms.models.Menu;

public interface MenuDAO {
	public void setDataSource(DataSource ds);
	Menu getMenu(int userId);
}
