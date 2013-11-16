package com.hijinks.comms.dao;

import java.util.List;
import com.hijinks.comms.models.Announcement;

public interface AnnouncementDAO {
	boolean makeAnnouncement(String title, String text, int communityId, int createdBy);
	List<Announcement> getAnnouncements(int communityId);
}
