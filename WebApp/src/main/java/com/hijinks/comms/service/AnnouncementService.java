package com.hijinks.comms.service;

import java.util.List;
import com.hijinks.comms.models.Announcement;

public interface AnnouncementService {
	void makeAnnouncement(String title, String text, int communityId, int createdBy);
	List<Announcement> getAnnouncements(int communityId);
}
