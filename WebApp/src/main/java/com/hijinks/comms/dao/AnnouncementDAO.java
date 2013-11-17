package com.hijinks.comms.dao;

import java.util.List;
import javax.sql.DataSource;
import com.hijinks.comms.models.Announcement;

public interface AnnouncementDAO {
	public void setDataSource(DataSource ds);
	void makeAnnouncement(String title, String text, int communityId, int createdBy);
	List<Announcement> getAnnouncements(int communityId);
}
